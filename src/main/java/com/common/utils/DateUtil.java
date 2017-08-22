package com.common.utils;


import com.mysql.jdbc.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

	/**
	 * yyyy-MM-dd HH:mm:ss 格式
	 */
	public static final String DEFAULT_DATE_TIME_FORMAT_PATTERN = "yyyy-MM-dd HH:mm:ss";
	
	public static Calendar DateToCalendar(Date date){
		Calendar calendar=Calendar.getInstance();
		
		calendar.setTime(date);
		
		return calendar;
	}

	public static Date StringToDate( String date ) throws Exception{
		
		if(StringUtils.isNullOrEmpty(date)){
			throw new Exception("input date string is null");
		}
		
		Date resultDate=new Date();
		
		try{
			SimpleDateFormat format = new SimpleDateFormat(DEFAULT_DATE_TIME_FORMAT_PATTERN);
			resultDate = format.parse(date);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
		return resultDate;
	}

	public static Date TimspanToDate(Long ticks) {
		try {
			SimpleDateFormat format = new SimpleDateFormat(DEFAULT_DATE_TIME_FORMAT_PATTERN);
			String d = format.format(ticks);
			return format.parse(d);
		}catch (ParseException ex) {
			return new Date();
		}
	}
}
