package com.consMang.master.controller;

import java.io.PrintWriter;
import java.util.Comparator;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.consMang.master.dao.IDistrictDAO;
import com.consMang.master.model.DistrictModel;
import com.consMang.master.model.StateUtModel;
import com.consMang.master.service.IStateUtService;


@Controller(value="StateUTController")
@Scope("request")
public class StateUTController {

	@Autowired
	IStateUtService<StateUtModel, Long> stateUtService;
	
	@RequestMapping(value="getDistrictByStateID")
	public void getDistrictListByState(@RequestParam("stateID") Long stateId,
			@RequestParam("CID") String cId,
			HttpServletResponse response){
		try{
			response.setContentType("text/xml");
		StateUtModel state=stateUtService.getStateByID(stateId);
		PrintWriter pw=response.getWriter();
		pw.println("<STATE ID='"+state.getStateUtId()+"'>");
		Set<DistrictModel> set=state.getDistrictModelSet();
		SortedSet<DistrictModel> sset=new TreeSet<DistrictModel>(new Comparator<DistrictModel>() {
			@Override
			public int compare(DistrictModel o1, DistrictModel o2) {
				
				return o1.getDistrictName().compareTo(o2.getDistrictName());
			}
		});
		sset.addAll(set);
		for(DistrictModel dm: sset){
			pw.println("<DISTRICT ID='"+dm.getDistrictId()+"' CID='"+cId+"'  NAME='"+dm.getDistrictName()+"' />");
		}
		pw.println("</STATE>");
		pw.flush();
		pw.close();
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
	}
	
	
	
	/*
	@RequestMapping(value="getSubDistrictByDstID")
	public void getSubDistrictListByDist(@RequestParam("DSTID") Long dstId,
			@RequestParam("CID") String cId,
			HttpServletResponse response){
		try{
			response.setContentType("text/xml");
			DistrictModel state=districtDao.getDistirctById(dstId);
		PrintWriter pw=response.getWriter();
		pw.println("<DISTRICT ID='"+state.getDistrictId()+"'>");
		Set<SubDistrictModel> set=state.getSubDistrictModelSet();
		
		for(SubDistrictModel dm: set){
			pw.println("<SUBDISTRICT ID='"+dm.getSubDistrictId()+"' CID='"+cId+"'  NAME='"+dm.getSubDistrictName()+"' />");
		}
		pw.println("</DISTRICT>");
		pw.flush();
		pw.close();
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
	}*/
	
	@Autowired
	IDistrictDAO<DistrictModel, Long> districtDao;
	
}
