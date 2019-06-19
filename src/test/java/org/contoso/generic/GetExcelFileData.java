package org.contoso.generic;


import java.io.IOException;
import org.apache.log4j.Logger;
import org.contoso.startup.TestConfigurations;
import org.testng.annotations.BeforeClass;

public class GetExcelFileData extends TestConfigurations {
	static Logger log = Logger.getLogger(GetExcelFileData.class.getName());
	
	//Excel documents name as per the OtherConfiguration properties
	static String testExcelDataPath="";
	
		
	//Defining Sheet Name as defined in OtherConfigurations.properties file
	static String  SheetNameUserInfo="",SheetNameCredentials="",SheetNameProfileAddress="",SheetNameCourseDetails="",SheetNameLocation="",SheetNameShiftType="",
	SheetNameProfile="",SheetNameDay="";
				  
	//Defining Column Names as defined in the Excel Sheet 
	static String username="",password="",firstName="",lastName="",phone="",email="",executeTest="",role="",
			addresslane1="",addresslane2="",city="",state="",country="",pincode="",
			summary="",occupation="",designation="",organization="",degree="",percentage="",
			grade="",institution="",board="",skills="",afirstName="",alastName="",currentlocation="",location="",shiftType="",
			profileOne="",day="",profileTwo="";
	
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
			SheetNameProfileAddress = OTHERCONFIGPROP.getProperty("SheetNameProfileAddress");
			SheetNameCourseDetails = OTHERCONFIGPROP.getProperty("SheetNameCourseDetails");
			SheetNameLocation = OTHERCONFIGPROP.getProperty("SheetNameLocation");
			SheetNameShiftType = OTHERCONFIGPROP.getProperty("SheetNameShiftType");
			SheetNameProfile = OTHERCONFIGPROP.getProperty("SheetNameProfile");
			SheetNameDay = OTHERCONFIGPROP.getProperty("SheetNameDay");

										
			//Column  Names Initializing
			username=COLUMNHEADERSPROP.getProperty("username");
			password=COLUMNHEADERSPROP.getProperty("password");
			firstName=COLUMNHEADERSPROP.getProperty("firstName");
			lastName=COLUMNHEADERSPROP.getProperty("lastName");
			phone=COLUMNHEADERSPROP.getProperty("phone");
			email=COLUMNHEADERSPROP.getProperty("email");
			executeTest = COLUMNHEADERSPROP.getProperty("executeTest");
			role = COLUMNHEADERSPROP.getProperty("role");
			addresslane1 = COLUMNHEADERSPROP.getProperty("addresslane1");
			addresslane2 = COLUMNHEADERSPROP.getProperty("addresslane2");
			city = COLUMNHEADERSPROP.getProperty("city");
			state = COLUMNHEADERSPROP.getProperty("state");
			country = COLUMNHEADERSPROP.getProperty("country");
			pincode = COLUMNHEADERSPROP.getProperty("pincode");
			
			summary = COLUMNHEADERSPROP.getProperty("summary");
			occupation = COLUMNHEADERSPROP.getProperty("occupation");
			designation = COLUMNHEADERSPROP.getProperty("designation");
			organization = COLUMNHEADERSPROP.getProperty("organization");
			degree = COLUMNHEADERSPROP.getProperty("degree");
			percentage = COLUMNHEADERSPROP.getProperty("percentage");
			grade = COLUMNHEADERSPROP.getProperty("grade");
			institution = COLUMNHEADERSPROP.getProperty("institution");
			board = COLUMNHEADERSPROP.getProperty("board");
			skills = COLUMNHEADERSPROP.getProperty("skills");
			afirstName = COLUMNHEADERSPROP.getProperty("afirstName");
			alastName = COLUMNHEADERSPROP.getProperty("alastName");
			currentlocation = COLUMNHEADERSPROP.getProperty("currentlocation");
			location = COLUMNHEADERSPROP.getProperty("location");
			shiftType = COLUMNHEADERSPROP.getProperty("shiftType");
			profileOne = COLUMNHEADERSPROP.getProperty("profileOne");
			day = COLUMNHEADERSPROP.getProperty("day");
			profileTwo = COLUMNHEADERSPROP.getProperty("profileTwo");


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
		else if (callingTestScript.toLowerCase().contains("profileaddress") == true)
			sheetName = SheetNameProfileAddress;
		else if (callingTestScript.toLowerCase().contains("course") == true)
			sheetName = SheetNameCourseDetails;
		else if(callingTestScript.toLowerCase().contains("location") == true)
			sheetName = SheetNameLocation;
		else if(callingTestScript.toLowerCase().contains("shifttype") == true)
			sheetName = SheetNameShiftType;
		else if(callingTestScript.toLowerCase().contains("profile") == true)
			sheetName = SheetNameProfile;
		else if(callingTestScript.toLowerCase().contains("day") == true)
			sheetName = SheetNameDay;
		
		else {
			System.out.println("Data Sheet: "+sheetName+" Not Found");
			}
		log.info("Method: getSheetName :: sheetname = " + sheetName);
		return sheetName;
	}
}

