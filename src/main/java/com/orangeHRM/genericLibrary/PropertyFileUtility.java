package com.orangeHRM.genericLibrary;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
/**
 * This class is contains property file specific methods
 * @author Niraj
 */
public class PropertyFileUtility {

	Properties property;
	/**
	 * This method is used to open property file
	 * @throws IOException 
	 */
	public void openPropertyFile(String filePath) {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(filePath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		property = new Properties();
		try {
			property.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	/**
	 * This method is used to fetch data from property file
	 * @param key
	 * @return
	 */
	public String getDataFromPropertyFile(String key) {
		String value = property.getProperty(key);
		return value;
	}

}
