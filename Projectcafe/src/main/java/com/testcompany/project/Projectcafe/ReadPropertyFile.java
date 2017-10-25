package com.testcompany.project.Projectcafe;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class ReadPropertyFile {
	
	protected Properties prop = new Properties();
	protected FileInputStream fs;

	public ReadPropertyFile() throws IOException 
	{
		/*Properties prop = new Properties();
		FileInputStream fs;
		String path = System.getProperty("user.dir")+ "//objectRepository.properties";
 	    fs = new FileInputStream(path);*/
		String path = System.getProperty("user.dir")
				+ "//objectRepository.properties";
				fs = new FileInputStream(path);
		prop.load(fs);
		System.out.println("username" + prop.getProperty("username"));
		
	}
	
	public String getUrl()
	{
		return prop.getProperty("url");
	}
	
	public String getUserName()
	{
		return prop.getProperty("username");
	}
	
	public String getPassword()
	{
		return prop.getProperty("password");
	}
	
	public String getValue(String key)
	{
		return prop.getProperty(key);
	}
	
	


}
