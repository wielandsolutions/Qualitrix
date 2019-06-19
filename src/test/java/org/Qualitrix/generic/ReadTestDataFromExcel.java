package org.Qualitrix.generic;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import org.Qualitrix.testdata.TestDataForQualitrix;
import org.apache.log4j.Logger;

public class ReadTestDataFromExcel extends GetExcelFileData {

	static Logger log = Logger.getLogger(ReadTestDataFromExcel.class.getName());
	static Vector<String> headers = new Vector<String>();
	static Vector<String> data = new Vector<String>();
	static int noOfRecordsToBeTestedConfig =0, noOfRecordsToBeTested=0;

	public static List <TestDataForQualitrix>  getTestDataForSunbird(String callingTestScript) 
	{
		List <TestDataForQualitrix> objListOfTestDataForSunbird = new ArrayList<TestDataForQualitrix>();
		int columnIndex = 0, sizeofHeaders = 0; 
		String columnName = "", dataValue = "";
		TestDataForQualitrix objTDForSunBird = new TestDataForQualitrix();
		String testDataPath = "", sheetName = "";
		try	{
			ReadTestDataFromExcel.getColumnNames();
			testDataPath = getTestDataPath(callingTestScript);
			sheetName = getSheetName(callingTestScript);
			log.info("Method:getTestDataForSearch :: equipmentTestDataPath = " + testDataPath 
					+ " sheetname = " + sheetName
					+ " noOfRecordsToBeTestedConfig = " + noOfRecordsToBeTestedConfig);
			noOfRecordsToBeTestedConfig = 100;
			headers = GenericExlMethods.fetchTableHeaderColumn(testDataPath, sheetName);
			data = GenericExlMethods.fetchTableData(testDataPath, sheetName, noOfRecordsToBeTestedConfig);

			noOfRecordsToBeTested = data.size();
			sizeofHeaders = headers.size();

			log.debug("Method:getTestDataForSearch :: no of records to be tested = " + noOfRecordsToBeTested 
					+ "data.size() = " + data.size() + " headers.size() = " + headers.size()
					+ " sizeofHeaders = " + sizeofHeaders );

			if (noOfRecordsToBeTested > 0 && headers.size() > 0 && data.size() > 0 ) {
				for (int row = 0; row < noOfRecordsToBeTested ; row++)	{
					columnName = headers.get(columnIndex).toString().trim();
					dataValue = data.get(row).toString();
					if (columnName != null)		
					{

						if(columnName.equals(username.trim()))	
							objTDForSunBird.setUsername(dataValue);
						else if(columnName.equals(password.trim()))	
							objTDForSunBird.setPassword(dataValue);

					}

					columnIndex = columnIndex + 1;

					if (columnIndex == sizeofHeaders)	{
						if ((objTDForSunBird.getExecuteTest().toLowerCase().contains("yes")) == true)
							objListOfTestDataForSunbird.add(objTDForSunBird);
						columnIndex = 0;
						objTDForSunBird = new TestDataForQualitrix();					
					}
				} 

			} 

		}
		catch(Exception e) {
			log.error("Method:getTestDataForSearch :: exception = " + e.getMessage()  + e.getStackTrace());
			e.printStackTrace();
		}

		log.info("Method:getTestDataForSearch :: returning size of test records = " + objListOfTestDataForSunbird.size());	
		return objListOfTestDataForSunbird;
	}


}
