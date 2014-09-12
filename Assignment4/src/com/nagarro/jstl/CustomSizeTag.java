package com.nagarro.jstl;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTagSupport;

import com.nagarro.util.SizeConverter;

public class CustomSizeTag extends BodyTagSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String finalSize;

	private int size;

	public String getFinalSize() {
		return finalSize;
	}

	public void setFinalSize(String finalSize) {
		this.finalSize = finalSize;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int doAfterBody() throws JspException {
		try {
			BodyContent bc = getBodyContent();
			String body = bc.getString();
			JspWriter out = bc.getEnclosingWriter();
			if (body != null) {
				String finalSize = SizeConverter.convertSize(Long
						.parseLong(body));
				out.print(finalSize);
			}
		} catch (IOException ioe) {
			throw new JspException("Error: " + ioe.getMessage());
		}
		return SKIP_BODY;
	}

}
