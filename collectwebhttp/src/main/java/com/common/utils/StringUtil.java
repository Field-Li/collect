package com.common.utils;//package com.common.utils;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//
//public class StringUtil {
//
//	/**
//	 * 空字符串
//	 */
//	public static String Empty="";
//
//	/**
//	 * 判断字符串是否为空
//	 * @param input
//	 * @return
//	 */
//	public static boolean isNullOrEmpty(String input){
//		if(input==null || input.length()==0 || input.trim().length()==0)
//			return true;
//		else
//			return false;
//	}
//
//	public static String convertStreamToString(InputStream is) {
//        /*
//          * To convert the InputStream to String we use the BufferedReader.readLine()
//          * method. We iterate until the BufferedReader return null which means
//          * there's no more data to read. Each line will appended to a StringBuilder
//          * and returned as String.
//          */
//		BufferedReader reader = new BufferedReader(new InputStreamReader(is));
//		StringBuilder sb = new StringBuilder();
//
//		String line = null;
//		try {
//			while ((line = reader.readLine()) != null) {
//				sb.append(line + "\n");
//			}
//		} catch (IOException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				is.close();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
//
//		return sb.toString();
//	}
//}
