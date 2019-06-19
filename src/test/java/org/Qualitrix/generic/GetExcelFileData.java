package org.Qualitrix.generic;


import java.io.IOException;

import org.Qualitrix.startup.TestConfigurations;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeClass;

public class GetExcelFileData extends TestConfigurations {
	static Logger log = Logger.getLogger(GetExcelFileData.class.getName());
	
	//Excel documents name as per the OtherConfiguration properties
	static String testExcelDataPath="";
	
		
	//Defining Sheet Name as defined in OtherConfigurations.properties file
	static String  SheetNameUserInfo="",SheetNameCredentials="",SheetNameProfileAddress="",SheetNameCourseDetails="",SheetNameLocation="",SheetNameShiftType="",
	SheetNameProfile="",SheetNameDay="";
				  
	//Defining Column Names as defined in the Excel Sheet 
	static String username="",password="";
	
	//Defining Columns names in Course Sheet
	static String courseName="", courseDescription="", title="", titleDescription="";
	
	//Method retrieves the column header details from the related Properties files and loads the global variables with the values.  
	@BeforeClass
	static void getColumnNames()
	{
		try {
			TestConfigurations.initTestConfiguration();
		} catch (IOException e) {

			log.error("Method: getColumnNames :: exception occured while initializing testconfiguration," +
					" exception = " + e);
		}

		try	{
			//Excel workbook initializing path
			testExcelDataPath = OTHERCONFIGPROP.getProperty("testExcelDataPath");
			
			//SheetNames
			SheetNameUserInfo = OTHERCONFIGPROP.getProperty("SheetNameUserInfo");
			SheetNameCredentials = OTHERCONFIGPROP.getProperty("SheetNameCredentials");


										
			//Column  Names Initializing
			username=COLUMNHEADERSPROP.getProperty("username");
			password=COLUMNHEADERSPROP.getProperty("password");


			//Column Names from Sheet Name - Course
			courseName=COLUMNHEADERSPROP.getProperty("courseName");
			courseDescription=COLUMNHEADERSPROP.getProperty("courseDescription");
			title=COLUMNHEADERSPROP.getProperty("title");
			titleDescription=COLUMNHEADERSPROP.getProperty("titleDescription");
			
		} catch(Exception e) {
			log.error("Method: getColumnNames :: exception occured while retriving values from properties " + 
					"file, exception = " + e+ " Line Number = " +  Thread.currentThread().getStackTrace()[3].getLineNumber());
		}
	}

	static String getTestDataPath(String callingTestScript) {
		String testDataPath = "";
		System.out.println("callingscript = " + callingTestScript);
		
		if (callingTestScript.toLowerCase().startsWith("testdatasheet") == true) 
			testDataPath = testExcelDataPath;
		else{
			System.out.println("Test Data Path: "+testDataPath+"Not Found");
			}
		log.info("Method: getSheetName :: testDataPath = " + testDataPath );
		System.out.println("testDataPath = " + testDataPath );
		return testDataPath;
	}

	static String getSheetName(String callingTestScript) {
		String sheetName = "";
		if (callingTestScript.toLowerCase().contains("userinfo") == true) 
			sheetName = SheetNameUserInfo;
		else if (callingTestScript.toLowerCase().contains("credentials") == true) 
			sheetName =	SheetNameCredentials;

		
		else {
			System.out.println("Data Sheet: "+sheetName+" Not Found");
			}
		log.info("Method: getSheetName :: sheetname = " + sheetName);
		return sheetName;
	}
}

