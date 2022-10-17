package com.crm.Generic_Utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class File_Utility {
	/**
	 * this method is used to launch the application
	 * @param key
	 * @return
	 * @throws IOException
	 * @author surya
	 */
	public String getPropertyKeyValue1(String key) throws IOException
	{
	//	FileInputStream fis=new FileInputStream("./Common_Data.properties.txt");
		FileInputStream fis=new FileInputStream(ipathConstant.PROPERTYFILE_PATH);
		Properties pro=new Properties();
		pro.load(fis);
		String value=pro.getProperty(key);
		return value; 
	}

	

}
