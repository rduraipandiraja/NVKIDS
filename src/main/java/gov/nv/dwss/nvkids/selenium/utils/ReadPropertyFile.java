package gov.nv.dwss.nvkids.selenium.utils;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadPropertyFile 
{
	public static String get(String propertyname) 
	{
		String returnproperty=null;
		Properties property = new Properties();
		try 
		{
			FileInputStream file = new FileInputStream("./Resources/testConfig.properties");
			property.load(file);
			returnproperty = property.getProperty(propertyname);
			if(returnproperty==null) 
			{
				
			}
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		return returnproperty;
	}
}
