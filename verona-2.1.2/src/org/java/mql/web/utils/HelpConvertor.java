package org.java.mql.web.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class HelpConvertor {

	public HelpConvertor() {
		// TODO Auto-generated constructor stub
	}
	
	
	public static String dateToString(Date date , String format) {
			SimpleDateFormat ft = new SimpleDateFormat (format);
			return ft.format(date);
	}
	
	

}
