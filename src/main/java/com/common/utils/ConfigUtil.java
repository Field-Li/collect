package com.common.utils;


import java.io.InputStreamReader;
import java.util.Properties;

public final class ConfigUtil {
	final static ConfigUtil instance=new ConfigUtil();
	final static String configPath="/config.properties";
 	static Properties pro = null;
	
	static{
		pro = new Properties ();
		try{
			pro.load(new InputStreamReader( ConfigUtil.class.getResourceAsStream(configPath), "UTF-8"));
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	private ConfigUtil(){
	}
	
	public static ConfigUtil getInstance(){
		return instance;
	}
	
	public String GetConfig(String key){
		String result="";
		try{
			if(pro==null){
				return "";
			}
			return pro.getProperty(key);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
		return result;
	}
}
