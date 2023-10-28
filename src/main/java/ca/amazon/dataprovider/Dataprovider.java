package ca.amazon.dataprovider;

import org.testng.annotations.DataProvider;

import ca.amazon.utility.Excellibrary;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Dataprovider {

	
	Excellibrary obj= new Excellibrary();
	
	@DataProvider(name = "Differentsearch")
	public Object[][] getproductname() throws Exception {
		// Totals rows count
		int rows = obj.getRowCount("Differentproduct");
		// Total Columns
		int column = obj.getColumnCount("Differentproduct");
		int actRows = rows - 1;

		Object[][] data = new Object[actRows][column];

		for (int i = 0; i < actRows; i++) {
			for (int j = 0; j < column; j++) {
				data[i][j] = obj.getCellData("Differentproduct", j, i + 2);
			}
		}
		return data;
	}

//Class --> AccountCreationPage  Test Case--> verifyCreateAccountPageTest	
	@DataProvider(name = "email")
	public Object[][] getEmail() throws Exception {
		// Totals rows count
		int rows = obj.getRowCount("Email");
		// Total Columns
		int column = obj.getColumnCount("Email");
		int actRows = rows - 1;

		Object[][] data = new Object[actRows][column];

		for (int i = 0; i < actRows; i++) {
			for (int j = 0; j < column; j++) {
				data[i][j] = obj.getCellData("Email", j, i + 2);
			}
		}
		return data;
	}

//Class --> AddToCartPageTest, EndToEndTest,  Test Case--> addToCartTest, endToEndTest	
	@DataProvider(name = "getProduct")
	public Object[][] getProduct() throws Exception {
		// Totals rows count
		int rows = obj.getRowCount("ProductDetails");
		// Total Columns
		int column = obj.getColumnCount("ProductDetails");
		int actRows = rows - 1;

		Object[][] data = new Object[actRows][column];

		for (int i = 0; i < actRows; i++) {
			for (int j = 0; j < column; j++) {
				data[i][j] = obj.getCellData("ProductDetails", j, i + 2);
			}
		}
		return data;
	}

	// Class --> SearchResultPageTest, Test Case--> productAvailabilityTest
	@DataProvider(name = "searchProduct")
	public Object[][] getProductPrice() throws Exception {
		// Totals rows count
		int rows = obj.getRowCount("Productname");
		// Total Columns
		int column = obj.getColumnCount("Productname");
		int actRows = rows - 1;

		Object[][] data = new Object[actRows][column];

		for (int i = 0; i < actRows; i++) {
			for (int j = 0; j < column; j++) {
				data[i][j] = obj.getCellData("Productname", j, i + 2);
			}
		}
		return data;
	}
	
	@DataProvider(name = "Logindata ")
	public Object[][] accountCreation() throws Exception {

		// Totals rows count
		int rows = obj.getRowCount("AccountCreationData");
		// Total Columns
		int column = obj.getColumnCount("AccountCreationData");
		int actRows = rows - 1;
		//Created an object of array to store data
		Object[][] data = new Object[actRows][1];
		
		for (int i = 0; i < actRows; i++) {
			Map<String, String> hashMap = new HashMap<String, String>();
			for (int j = 0; j < column; j++) {
				hashMap.put(obj.getCellData("AccountCreationData", j, 1),
						obj.getCellData("AccountCreationData", j, i + 2));
			}
			data[i][0]=hashMap;
		}
		return data;
	}

}


