/**
 * 
 */
package com.consMang.transaction.product.controller;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.consMang.common.util.CommonConstants;
import com.consMang.transaction.product.model.ProductMasterModel;
import com.consMang.transaction.product.service.IProductService;

/**
 * @author Vijay.Chauhan
 *
 */

@Controller("ProductController")
@Scope("request")
public class ProductController {

	private static final Logger LOGGER = Logger.getLogger(ProductController.class);

	@Autowired IProductService productService;
	
	@RequestMapping(value="admin/addNewProduct")
	public ModelAndView createNewProduct(HttpServletRequest request){
		ModelAndView mv=new ModelAndView("admin.addNewProduct");
		mv.addObject("productMasterModel", new ProductMasterModel());
		return mv;
	}
	
	@RequestMapping(value="admin/saveNewProduct")
	public ModelAndView saveNewProduct(@ModelAttribute("productMasterModel") ProductMasterModel productMasterModelObj){
		LOGGER.debug(" ::  saveNewProduct() STARTED");
		try {
			productMasterModelObj.setStatus(CommonConstants.ACTIVE);
			productMasterModelObj.setCreatedOn(Calendar.getInstance());
			productMasterModelObj.setProductName(productMasterModelObj.getProductName().trim());
			productMasterModelObj.setProductCode(productMasterModelObj.getProductCode().trim());
			long id = productService.createNew(productMasterModelObj);
			LOGGER.debug("Saved product and Product Id is :-->> " + id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			LOGGER.error("Exception :: While save new product throwing exception ::");
			LOGGER.error(e);
			return  new ModelAndView("redirect:addNewProduct");
		}
		LOGGER.debug(" ::  saveNewProduct() ENDED");
		return  new ModelAndView("redirect:successTrans");
	}
	
	@RequestMapping(value="admin/successTrans")
	public ModelAndView successTrans(){
		ModelAndView mv = new ModelAndView("admin.successTrans");
		mv.addObject("msg", "Product save successfully!!!!");
		return mv;
	}
	
}