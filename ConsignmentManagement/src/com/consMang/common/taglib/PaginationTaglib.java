package com.consMang.common.taglib;

import java.io.Writer;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class PaginationTaglib extends SimpleTagSupport {
	private String uri;
	private int offset;
	private int count;
	private int max =10 ;
	private int steps = 10;
	private String previous = "Previous";
	private String next = "Next";
	private String first = "First";
	private String last = "Last";
	private boolean pageNo=false;

	private Writer getWriter() {
		JspWriter out = getJspContext().getOut();
		return out;
	}

	@Override
	public void doTag() throws JspException {
		steps=max;
		Writer out = getWriter();
		try {
			out.write("<nav>");
			out.write("<ul class=\"pagination\">");
			
			if(offset==0)
				out.write(constructLink(1, first, "disabled", true));
			else
				out.write(constructLink(0, first, null , false));
			
			if(offset<steps)
				out.write(constructLink(1, previous, "disabled", true));
			else
				out.write(constructLink(offset-steps, previous, null, false));
			if(pageNo){
				for(int itr=0,i=1;itr<count;itr+=max,i++) {
					if(offset==itr)
						out.write(constructLink((itr/max+1)-1 *steps, String.valueOf(i), "active", true));
					else
						out.write(constructLink(itr/max*steps, String.valueOf(i), null , false));
				}
			}
			if(offset+steps>=count)
				out.write(constructLink(offset+steps, next, "disabled", true));
			else
				out.write(constructLink(offset+steps, next, null , false));
			
			if(offset+steps>=count)
				out.write(constructLink(1, first, "disabled", true));
			else
				out.write(constructLink(count-max, last, null , false));
			
			
			out.write("</ul>");
			out.write("</nav>");
		} catch (java.io.IOException ex) {
			throw new JspException("Error in Paginator tag", ex);
		}
	}


	private String constructLink(int page, String text, String className, boolean disabled) {
		StringBuilder link = new StringBuilder("<li");
		if (className != null) {
			link.append(" class=\"");
			link.append(className);
			link.append("\"");
		}
		if(disabled)
			link.append(">").append("<a href=\"#\">"+text+"</a></li>");
		else
			link.append(">").append("<a href=\""+uri+"?offset="+page + "&maxResults=" + max + "\">"+text+"</a></li>");
		return link.toString();
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}

	public String getPrevious() {
		return previous;
	}

	public void setPrevious(String previous) {
		this.previous = previous;
	}

	public String getNext() {
		return next;
	}

	public void setNext(String next) {
		this.next = next;
	}

	public int getSteps() {
		return steps;
	}

	public void setSteps(int steps) {
		this.steps = steps;
	}

	public boolean isPageNo() {
		return pageNo;
	}

	public void setPageNo(boolean pageNo) {
		this.pageNo = pageNo;
	}

	public String getFirst() {
		return first;
	}

	public void setFirst(String first) {
		this.first = first;
	}

	public String getLast() {
		return last;
	}

	public void setLast(String last) {
		this.last = last;
	}
	
}
