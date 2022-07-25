package functions
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.logging.KeywordLogger
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.webui.keyword.internal.WebUIAbstractKeyword
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import java.util.Date


import java.awt.Toolkit as Toolkit
import java.awt.datatransfer.StringSelection as StringSelection
import java.awt.event.KeyEvent as KeyEvent

import org.openqa.selenium.Keys as Keys
import java.awt.Robot as Robot
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper

import org.openqa.selenium.WebElement as WebElement

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.lang.String
import static java.util.Calendar.*
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory


import java.text.SimpleDateFormat

import org.apache.commons.io.FileUtils

import org.openqa.selenium.By as By

import org.openqa.selenium.WebDriver as WebDriver



import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory


public class I {

	///////////////////////////////////////////ACTION USED IN MEDIABOX //////////////////////////////////////


	///////////////////////////////////////1. LOGIN PAGE & LOGOUT/////////////////////////////////////////


	///////////////////////////////////////1. LOGIN PAGE & LOGOUT/////////////////////////////////////////

	//BU1: ***FUNCTION TO LOG IN ***//
	public static void Login_password(String username, String password){

		WebUI.setText(findTestObject('1. Constant/xpath', [('xpath') : "//input[@id='MDB_WebUserCode']"]), username)
		WebUI.delay(1)
		WebUI.setText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="formLogin"]/div[3]/div/input']), password)
		WebUI.delay(1)
		WebUI.click(findTestObject('1. Constant/xpath', [('xpath') :"//button[@type='submit']"]), FailureHandling.STOP_ON_FAILURE)
	}

	//***FUNCTION TO LOG IN PART 2***//
	public static void Login_password_2(String username, String password){


		functions.I.Login_password(username, password)


		if (WebUI.verifyTextPresent('Change your password - '+username, false, FailureHandling.CONTINUE_ON_FAILURE)) {


			WebUI.setText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="new_password"]']),
			password)

			WebUI.delay(1)

			WebUI.setText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="passwordConfirm"]']),
			password)

			WebUI.delay(1)

			WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifPassword"]/div[4]/button']))
			functions.I.Logout()
		}

		else{
			functions.I.Logout()
		}
	}


	//BU: ***FUNCTION TO LOG OUT ***//
	public static void Logout()
	{
		WebUI.delay(3)
		WebUI.click(findTestObject('1. Constant/xpath', [('xpath') :"//div[@id='kt_header']/div/div[2]/div[2]/div/div/span/img"]))
		WebUI.delay(3)
		WebUI.click(findTestObject('1. Constant/xpath', [('xpath') :"//div[@id='kt_header']/div/div[2]/div[2]/div[2]/a[3]"]))
		WebUI.delay(3)

	}

	//**TAG FUNCTION TO LOGOUT IN TAG

	public static void Logout_xpath(String xpath1 , String xpath2)
	{
		WebUI.click(findTestObject('1. Constant/xpath',[('xpath'): xpath1]))
		WebUI.delay(1)
		WebUI.click(findTestObject('1. Constant/xpath',[('xpath'): xpath2]))
		WebUI.delay(1)
		WebUI.waitForPageLoad(10)
	}

	//***FUNCTION TO CLEAR PASSWORD AND LOGIN FIELD

	public static void ClearLoginandPasswordField()
	{
		WebUI.clearText(findTestObject('1. Constant/xpath', [('xpath') : "//input[@id='MDB_WebUserCode']"]), FailureHandling.STOP_ON_FAILURE)
		WebUI.delay(1)
		WebUI.clearText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="formLogin"]/div[3]/div/input']), FailureHandling.STOP_ON_FAILURE)
	}



	//***FUNCTION TO PASSWORD PAGE
	public static void Change_password (String password, String confirmpassword){

		WebUI.setText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="new_password"]']), password)
		WebUI.delay(1)
		WebUI.setText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="passwordConfirm"]']), confirmpassword)
		WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifPassword"]/div[4]/button']))
	}



	/////////////////////////////////////// MEDIABOX: GO TO THE PAGE ///////////////////////////////////////////////////

	//***FUNCTION TO GO TO MY PROFILE

	public static void Go_to_MyProfile()
	{
		WebUI.click(findTestObject('1. Constant/xpath',[('xpath'): '//*[@id="kt_header"]/div/div[2]/div[2]/div[1]/div/span']))
		WebUI.delay(1)
		WebUI.click(findTestObject('1. Constant/xpath',[('xpath'): '//*[@id="kt_header"]/div/div[2]/div[2]/div[2]/a[1]']))
		WebUI.delay(1)
	}


	//***FUNCTION TO GO TO SETTING >  USER MANAGEMENT

	public static GoToUserManagement(){
		'Click on the Menu > Settings'
		WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_aside_menu"]/ul/li[11]/a/span[2]']))

		WebUI.delay(2)

		'Click user management'
		WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_aside_menu"]/ul/li[11]/div/ul/li[2]/a/span']))

		WebUI.waitForPageLoad(30)



	}
	/*
	 //SELECT AN OPTION FORM SAS LIST
	 public static Select_Click_SAS(String Expected_SAS_Selected ,String xpath_SAS){
	 'no of option present '
	 int x = 20 // I HAVE PUT ANY NUMBER
	 int i = 1 //START WITH 1
	 while ( i <=x)
	 {
	 String Actual_SAS = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : xpath_SAS]))
	 functions.I.print(i)
	 if (Actual_SAS.contains(Expected_SAS_Selected))
	 {
	 WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : xpath_SAS]))
	 break
	 }
	 i =i+1
	 }
	 }*/

	/////////////////////////////////////// GET THE PROJECT NO AND REFID VIA URL///////////////////////////////////////////////////

	//***FUNCTION TO GET REF ID

	public static String RefID(){
		WebUI.delay(5)
		// GET URL AND THEN REF ID
		String urlref= WebUI.getUrl()
		String myrefId = urlref.split("id_ref=")[1]
		String refID = myrefId.substring(0,4)
		return refID	}


	//***FUNCTION TO GET REF ID FOR TAG

	public static String RefID_tag(){
		WebUI.delay(5)
		// GET URL AND THEN REF ID
		String urlref= WebUI.getUrl()
		String myrefId = urlref.split("id_ref=")[1]
		String refID = myrefId.substring(0,5)
		return refID	}


	public static String RefID_Npp(){
		WebUI.delay(5)
		// GET URL AND THEN REF ID
		String urlref= WebUI.getUrl()
		String myrefId = urlref.split("id_ref=")[1]
		String refID = myrefId.substring(0,7)
		return refID	}

	//***FUNCTION TO GET PROJECT NO IN MODIF PAGE
	public static String ProjectNo(){
		WebUI.delay(5)
		// GET URL AND THEN PROJECT NO
		String url = WebUI.getUrl()

		String Project_No = url.substring(url.length() - 8)

		return Project_No

	}




	//GET THE STEP NAME OF THE LIFECYCLE
	public static String Get_Stepname(String xpath){
		WebUI.delay(5)
		String Name_StepA_1 = WebUI.getAttribute(findTestObject('1. Constant/xpath', [('xpath') : xpath]), 'href')
		String Slit_SA1 = Name_StepA_1.split("tab_lifecycle_")[1]
		String StepA_11 = Slit_SA1.substring(0,8)
		return StepA_11	}




	////////////////////////////////PROJECT LIST PAGE : SEARCH A REF / PROJECT ///////////////////////////////////


	//***FUNCTION TO SEARCH PROJECT NO. ***//
	public static String SearchProjectNo(String Project_No, Object ButtonApply){

		WebUI.setText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="keynum_project"]']), Project_No)
		WebUI.delay(3)
		WebUI.click(ButtonApply)
		WebUI.delay(5)

	}

	//***FUNCTION TO SEARCH PROJECT NO. XPATH ***//
	public static String SearchProjectNo_xpath(String Project_No, String xpath1, String xpath2){
		WebUI.delay(1)
		WebUI.setText(findTestObject('1. Constant/xpath', [('xpath') : xpath1 ]), Project_No)
		WebUI.delay(3)
		WebUI.scrollToElement(findTestObject('1. Constant/xpath', [('xpath') : xpath2 ]), 10)
		WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : xpath2 ]))
		WebUI.delay(5)

	}

	//***FUNCTION TO SEARC REF XPATH ***//
	public static String SearchRefNo_xpath(String Project_No, String xpath1, String xpath2){
		WebUI.delay(1)
		WebUI.setText(findTestObject('1. Constant/xpath', [('xpath') : xpath1 ]), Project_No)
		WebUI.delay(3)
		WebUI.scrollToElement(findTestObject('1. Constant/xpath', [('xpath') : xpath2 ]), 10)
		WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : xpath2 ]))
		WebUI.delay(5)

	}












	///////////////////////////////////// VERIFICATION  ///////////////////////////////////////////////////

	//***FUNCTION TO VERIFY TOOLTIP
	public static void Verify_tooltip(Object path_button, Expected_tooltip)
	{
		WebUI.mouseOver(path_button)

		WebUI.delay(2)

		String Atooltip = WebUI.getText(path_button)

		String Etooltip  =  Expected_tooltip
		WebUI.delay(1)
		WebUI.takeScreenshot()

		WebUI.delay(1)

		WebUI.verifyMatch(Atooltip, Etooltip, false)
	}

	//***FUNCTION TO VERIFY TEXT TOOLTIP
	public static void Verify_Mouse_Over_tooltip(String xpath_obj, String xpath_tooltip, Expected_tooltip)
	{
		WebUI.mouseOver(findTestObject('1. Constant/xpath', [('xpath') : xpath_obj]))

		WebUI.delay(2)

		String Atooltip = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : xpath_tooltip]))


		String Etooltip  =  Expected_tooltip

		functions.I.print(Atooltip )

		WebUI.delay(1)
		WebUI.takeScreenshot()

		WebUI.delay(1)

		WebUI.verifyMatch(Atooltip, Etooltip, false)
	}

	//CHECKBOX
	//***VERIFY THAT CHECKBOX IS CHECKED
	public static String VerifyCheckboxChecked( String field_name,Object path){
		if (WebUI.verifyElementChecked(path, 10))
		{


			functions.I.print(' - Checkbox is checked')
		}

		else
		{
			functions.I.print(' - FAIL - No verication (checked)')
		}


	}

	//***VERIFY THAT CHECKBOX IS UNCHECKED
	public static String VerifyCheckboxUnchecked( String field_name,Object path){

		if ( WebUI.verifyElementNotChecked(path, 10))
		{
			functions.I.print( ' - Checkbox is unchecked checked')
		}
		else
		{
			functions.I.print(' - FAIL - No verication (Unchecked)')
		}


	}


	//***FUNCTION VERIFY THAT LIST IS SELECTED BY VALUE
	public static String VerifyListSelected_byValue( String field_name, Object path,Expected_value){

		if ( WebUI.verifyOptionSelectedByValue(path, Expected_value, false, 10)) {
			functions.I.print(' - Checkbox is unchecked checked')
		}
		else
		{
			functions.I.print( ' - FAIL - No verication (Unchecked)')
		}


	}

	//***FUNCTION TO VERIFY IF MESSAGE EXACT WORD
	public static verifymsg(Object path, String Expected_Errormsg,KeywordLogger log ){


		String CT_msg = WebUI.getText(path)


		if (CT_msg.contains(Expected_Errormsg))

			System.out.println( 'Message is '+ Expected_Errormsg+' - Test OK' )


		else

			log.logFailed('Warning! Incorrect message'+CT_msg+ '- Test KO')

	}

	//***FUNCTION TO VERIFY IF attribute value
	public static verifytext( String field_name, Object path, String Expected_Errormsg,KeywordLogger log ){


		WebUI.verifyEqual(WebUI.getAttribute(path, 'value'), Expected_Errormsg)

	}

	//***FUNCTION TO VERIFY THAT FIELDS ARE FILLED CORRECTLY
	public static VerifyMatchText( String xpath, String Expected_Text ){

		//GET TEXT
		String AText =WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') :xpath]))

		//DELAY
		WebUI.delay(1)

		//VERIFY TEXT
		WebUI.verifyMatch(AText, Expected_Text, false)

	}

	//***FUNCTION TO VERIFY THAT TOASTR MSG IS CORRECT
	public static VerifyMatchToastrmsg( String xpath, String Expected_Text ){

		//WAIT FOR ELEMENT
		WebUI.waitForElementVisible(findTestObject('1. Constant/xpath', [('xpath') : xpath]),5 )

		//GET TEXT OF TOASTR
		String alert_ERROR = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : xpath]))

		//SCREENSHOT
		WebUI.takeScreenshot()

		//VERIFY TEXT
		WebUI.verifyMatch(alert_ERROR,  Expected_Text,
				false)



	}


	//***FUNCTION TO VERIFY THAT FIELDS ARE FILLED CORRECTLY
	public static Get_Task_No( String xpath ){


		String task = WebUI.getText(findTestObject('1. Constant/xpath',[('xpath') : xpath]))

		double user1_b4

		if (task == '') {
			user1_b4 = 0
		} else {
			user1_b4 = Double.parseDouble(task)
		}
		return user1_b4

	}



	//***FUNCTION TO VERIFY THAT DAUGHTER REF IS CREATEDVerify Daughter reference is created


	public static verifyDaughterrefCreated(Object path, String field_content, KeywordLogger log ){

		String value = WebUI.getText(path)
		System.out.println( value)

		if (value == field_content) {


			System.out.println( 'Daughter Reference is created >   '+ value+ ' - Test ok')
			assert true

		}


		else
		{log.logFailed('Warning! Daughter Reference is NOT created ' +value +'- Test KO. It should be > '+field_content)
			System.out.println( 'Warning! Daughter Reference is NOT created ' +value +'- Test KO. It should be > '+field_content)
			assert false
		}


	}



	//***FUNCTION TO VERIFY THAT FOLDER IS DOWNLOADED

	public static isFileDownloaded(String downloadPath, String fileName) {

		File dir = new File(downloadPath);

		File[] dirContents = dir.listFiles();

		for (int i = 0; i < dirContents.length; i++) {

			if (dirContents[i].getName().equals(fileName)) {

				// File has been found, it can now be deleted:

				dirContents[i].delete();


				return true;

			}


		}

		return false;

	}

	//////////////////////////////ACTION //////////////////////////////////////////////////

	/*//***FUNTIONS TO CLICK
	 public static String Click( String xpath){
	 WebUI.click('Object Repository/xpath', [('xpath') : xpath])
	 }
	 */

	//***FUNCTION TO PRINT

	public static void print( String text)
	{

		System.out.println(text)

	}



	//***FUNCTION TO SELECT FORM LIST VALUE

	public static void SelectFromList_Value( String xpath, String value)
	{

		WebUI.selectOptionByValue(findTestObject('1. Constant/xpath', [('xpath') : xpath]),  value, false)

		WebUI.delay(2)


	}


	//***FUNCTION TO SELECT FORM LIST LABEL

	public static void SelectFromList_Label(String xpath, String label)
	{

		WebUI.selectOptionByLabel(findTestObject('1. Constant/xpath', [('xpath') : xpath]),  label, false)

		WebUI.delay(2)


	}


	//***FUNCTION TO SELECT DATE

	//PREVIOUS MONTH

	public static void Delegate_Select_date_PreviousMonth( String xpath)
	{


		'Click on the date picker '
		WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : xpath]))

		'Delay 2'
		WebUI.delay(2)

		'Click on previous '
		WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[7]/div[1]/table/thead/tr[2]/th[1]']))

		'Delay 1'
		WebUI.delay(1)


		'Click on date '
		WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[7]/div[1]/table/tbody/tr[4]/td[5]']))

	}

	//NEXT MONTH

	public static void Delegate_Select_date_NextMonth( String xpath)
	{


		'Click on the date picker '
		WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : xpath]))

		'Delay 2'
		WebUI.delay(2)

		'Click on next '
		WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[7]/div[1]/table/thead/tr[2]/th[3]']))

		'Delay 1'
		WebUI.delay(1)


		'Click on date '
		WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[7]/div[1]/table/tbody/tr[4]/td[5]']))

	}

	//USERMANAGEMENT


	public static void UserManagement_Delegate_Select_date_PreviousMonth( String xpath)
	{


		'Click on the date picker '
		WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : xpath]))

		'Delay 2'
		WebUI.delay(32)

		'Click on next '
		WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[4]/div[1]/table/thead/tr[2]/th[1]']))

		'Delay 1'
		WebUI.delay(3)


		'Click on date '
		WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[4]/div[1]/table/tbody/tr[3]/td[5]']))

	}


	public static void UserManagement_Delegate_Select_date_PReviousPreviousMonth( String xpath)
	{


		'Click on the date picker '
		WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : xpath]))

		'Delay 2'
		WebUI.delay(32)

		'Click on previous '
		WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[4]/div[1]/table/thead/tr[2]/th[1]']))

		'Delay 1'
		WebUI.delay(3)

		'Click on previous '
		WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[4]/div[1]/table/thead/tr[2]/th[1]']))
		'Delay 1'
		WebUI.delay(3)

		'Click on date '
		WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[4]/div[1]/table/tbody/tr[3]/td[5]']))

	}


	public static void UserManagement_Delegate_Select_date_NextMonth( String xpath)
	{


		'Click on the date picker '
		WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : xpath]))

		'Delay 2'
		WebUI.delay(3)

		'Click on next '
		WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[4]/div[1]/table/thead/tr[2]/th[3]']))

		'Delay 1'
		WebUI.delay(3)


		'Click on date '
		WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_body"]/div[4]/div[1]/table/tbody/tr[5]/td[3]']))

	}





	//***FUNCTION TO SELECT FROM LIST USING KEYBOARD
	public static  SelectList(){
		WebUI.delay(3)
		Robot robot1 = new Robot()
		robot1.keyPress(KeyEvent.VK_DOWN)
		robot1.keyRelease(KeyEvent.VK_DOWN)
		WebUI.delay(3)
		robot1.keyPress(KeyEvent.VK_ENTER)
		robot1.keyRelease(KeyEvent.VK_ENTER)
		WebUI.delay(2)
		return robot1
	}


	//***FUNCTION TO SELECT MULTIPLE LIST

	public static select_multiplelist(String xpath1, String xpath2, String textselected){
		WebUI.delay(3)
		WebUI.selectOptionByValue(findTestObject('1. Constant/xpath',[('xpath'): xpath1]), textselected, false)
		WebUI.delay(2)
		WebUI.click(findTestObject('1. Constant/xpath',[('xpath'): xpath2]))

		WebUI.delay(3)


	}


	/////////////////////ACTION FOR MEDIABOX
	//***FUNCTION TO SUPER EDIT
	public static superedit_ref(Object path1, Object path2){


		WebUI.click(path1)
		WebUI.delay(3)
		WebUI.click(path2)

	}


	//***FUNCTION TO SUBMIT QUESTION PHASE
	public static submitquesiton_ref(Object path1, Object path2){


		WebUI.click(path1)
		WebUI.delay(3)
		WebUI.click(path2)

	}






	/////////////////////UPLOAD DOC  FOR MEDIABOX
	//***FUNCTION TO UPPLOAD DOC USING KEYBOARD

	public static void UploadDoc(String filePath, Object fieldPath){

		WebUI.scrollToElement(fieldPath,2)
		WebUI.click(fieldPath)

		WebUI.delay(3) //Delay after click on Browser Button

		StringSelection ss = new StringSelection(filePath)

		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss,null)
		WebUI.delay(3) //Delay after paste the text

		Robot robot = new Robot()
		robot.keyPress(KeyEvent.VK_ENTER)
		robot.keyRelease(KeyEvent.VK_ENTER)
		WebUI.delay(1)
		robot.keyPress(KeyEvent.VK_CONTROL)
		robot.keyPress(KeyEvent.VK_V)
		robot.keyRelease(KeyEvent.VK_V)
		robot.keyRelease(KeyEvent.VK_CONTROL)
		WebUI.delay(1)
		robot.keyPress(KeyEvent.VK_ENTER)
		robot.keyRelease(KeyEvent.VK_ENTER)

		WebUI.delay(3)

	}

	//***FUNCTION TO UPPLOAD DOC USING KEYBOARD

	public static void UploadDoc_P(String filePath, Object fieldPath, String filename){

		WebUI.scrollToElement(fieldPath,2)
		WebUI.click(fieldPath)

		WebUI.delay(3) //Delay after click on Browser Button

		StringSelection ss = new StringSelection(filePath)

		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss,null)
		WebUI.delay(3) //Delay after paste the text

		Robot robot = new Robot()
		robot.keyPress(KeyEvent.VK_ENTER)
		robot.keyRelease(KeyEvent.VK_ENTER)
		WebUI.delay(1)
		robot.keyPress(KeyEvent.VK_CONTROL)
		robot.keyPress(KeyEvent.VK_V)
		robot.keyRelease(KeyEvent.VK_V)
		robot.keyRelease(KeyEvent.VK_CONTROL)
		WebUI.delay(1)
		robot.keyPress(KeyEvent.VK_ENTER)
		robot.keyRelease(KeyEvent.VK_ENTER)

		WebUI.delay(3)

		String test12 = WebUI.verifyTextPresent(filename, false, FailureHandling.OPTIONAL)
		while(test12 == 'false')

		{Robot robot2 = new Robot()
			robot2.keyPress(KeyEvent.VK_ESCAPE)
			robot2.keyRelease(KeyEvent.VK_ESCAPE)

			WebUI.click( fieldPath)

			WebUI.delay(3) //Delay after click on Browser Button


			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss,null)
			WebUI.delay(3) //Delay after paste the text


			robot2.keyPress(KeyEvent.VK_ENTER)
			robot2.keyRelease(KeyEvent.VK_ENTER)
			WebUI.delay(2)
			robot2.keyPress(KeyEvent.VK_CONTROL)
			robot2.keyPress(KeyEvent.VK_V)
			robot2.keyRelease(KeyEvent.VK_V)
			robot2.keyRelease(KeyEvent.VK_CONTROL)
			WebUI.delay(2)
			robot2.keyPress(KeyEvent.VK_ENTER)
			robot2.keyRelease(KeyEvent.VK_ENTER)

			WebUI.delay(10)
			test12 = WebUI.verifyTextPresent(filename, false, FailureHandling.OPTIONAL)

		}



	}

	//***FUNCTION TO UPLOAD DOC FOR PROD

	public static void UploadDoc_sendkey_Prod( Object xpath_field, String filePath,String filename){

		//WebUI.scrollToElement(findTestObject('1. Constant/xpath',[('xpath'):xpath_field]),2)
		WebUI.scrollToElement(xpath_field,2)

		def FilePath = filePath
		WebUI.delay(5)
		//WebUI.uploadFile(findTestObject('1. Constant/xpath',[('xpath'):xpath_field]), FilePath)
		WebUI.uploadFile(xpath_field, FilePath)

		WebUI.delay(5)
		String true1 = WebUI.verifyTextPresent(filename, false, FailureHandling.OPTIONAL)
		WebUI.delay(5)
		assert true

		int i = 1
		WebUI.delay(5)
		System.out.println(i + true1)

		while (true1 == 'false') {
			WebUI.delay(5)
			//WebUI.uploadFile(findTestObject('1. Constant/xpath',[('xpath'):xpath_field]),FilePath)
			WebUI.uploadFile(xpath_field,FilePath)

			WebUI.delay(5)
			WebUI.delay(5)

			true1 = WebUI.verifyTextPresent(filename, false, FailureHandling.CONTINUE_ON_FAILURE)
			WebUI.delay(5)
			i = (i + 1)
		}

		System.out.println(i + ' - File uploaded')
	}

	//***FUNCTION TO UPLOAD DOC FOR FIELD
	public static void UploadDoc_sendkey_field( String xpath_field, String filePath,String filename){

		WebUI.delay(2)
		WebUI.sendKeys(findTestObject('1. Constant/xpath',[('xpath'):xpath_field]),  filePath)


		'Capturing the file name after upload and storing it in a variable'

		WebUI.verifyTextPresent(filename, false, FailureHandling.OPTIONAL)
	}


	//***FUNCTION TO APPROVE
	public static void AWF_approve(){

		WebUI.waitForPageLoad(5)

		WebUI.delay(1)
		WebUI.click(findTestObject('Object Repository/HL Full Lifecycle/Function_Doctab'))
		WebUI.delay(2)
		WebUI.click(findTestObject('HL Full Lifecycle/Function_Access to viewer'))
		WebUI.delay(1)
		WebUI.click(findTestObject('HL Full Lifecycle/Function_AppButton'))
		WebUI.delay(1)
		WebUI.click(findTestObject('HL Full Lifecycle/Function_Appbutton2'))
		WebUI.delay(3)
	}

	//***FUNCTION TO APPROVE VIA EXTENTER

	public static void AWF_approve_view(){

		WebUI.waitForPageLoad(5)
		WebUI.delay(10)
		WebUI.mouseOver(findTestObject('Object Repository/HL Full Lifecycle/Function_access Viewer2'))


		WebUI.delay(3)
		WebUI.click(findTestObject('Object Repository/HL Full Lifecycle/Function_access Viewer2'))
		WebUI.delay(5)
		WebUI.click(findTestObject('HL Full Lifecycle/Function_AppButton'))
		WebUI.delay(5)
		WebUI.click(findTestObject('HL Full Lifecycle/Function_Appbutton2'))

	}


	//***FUNCTION TO APPROVE VIA ACTION


	public static void AWF_approve_byaction(Object path){
		WebUI.delay(5)
		WebUI.click(path)
		//WebUI.delay(5)
		//	WebUI.waitForElementClickable(findTestObject('Object Repository/HL Full Lifecycle/Function_hoverimage'),5)

		//WebUI.click(findTestObject('Object Repository/HL Full Lifecycle/Function_Access to viewer'))
		//	WebUI.delay(3)
		//	WebUI.click(findTestObject('HL Full Lifecycle/Function_AppButton'))
		//WebUI.delay(3)
		//	WebUI.click(findTestObject('HL Full Lifecycle/Function_Appbutton2'))
		//	WebUI.delay(3)
		WebUI.mouseOver(findTestObject('Object Repository/HL Full Lifecycle/Function_access Viewer2'))


		WebUI.delay(3)
		WebUI.click(findTestObject('Object Repository/HL Full Lifecycle/Function_access Viewer2'))
		WebUI.delay(5)
		WebUI.click(findTestObject('HL Full Lifecycle/Function_AppButton'))
		WebUI.delay(5)
		WebUI.click(findTestObject('HL Full Lifecycle/Function_Appbutton2'))

	}

	//***FUNCTION TO APPROVE ON BEHALF FOR OTHERS

	public static void Approveforothers(String path_mouseOver, String buttonforothers){


		WebUI.click(findTestObject('1. Constant/xpath',[('xpath') : '//*[@id="kt_content"]/div[3]/div/ul/li[2]/a'])) // open doc tab
		WebUI.delay(1)
		WebUI.click(findTestObject('1. Constant/xpath',[('xpath') : '//*[@id="aff_doc_AW"]'])) // open approval tab

		WebUI.delay(1)
		WebUI.mouseOver(findTestObject('1. Constant/xpath',[('xpath') : path_mouseOver]))


		WebUI.click(findTestObject('1. Constant/xpath',[('xpath') : buttonforothers]))

		WebUI.delay(1)

		WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="btn_appfor"]']))

	}


	//***FUNCTION TO APPROVE PERMANTELY ON BEHALF FOR OTHERS
	public static void Approvepermanentlyforothers(String path_mouseOver, String buttonforothers){

		//Object Repository/xpath
		WebUI.click(findTestObject('1. Constant/xpath',[('xpath') : '//*[@id="kt_content"]/div[3]/div/ul/li[2]/a']))
		WebUI.delay(1)
		WebUI.click(findTestObject('1. Constant/xpath',[('xpath') : '//*[@id="aff_doc_AW"]'])) // open approval tab

		WebUI.delay(1)
		WebUI.mouseOver(findTestObject('1. Constant/xpath',[('xpath') : path_mouseOver]))


		WebUI.click(findTestObject('1. Constant/xpath',[('xpath') : buttonforothers]))

		WebUI.delay(1)
		WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="btn_appfor_permanent"]']))

	}




	/////////////////////VERIFICATION OF STATUS ////////////////////////////////////////////
	//***FUNCTION TO VERIFY IF STATUS IS COMPLETED
	public static void status( Object path)
	{

		def status = WebUI.getText(path)
		if (status.contains('Complete')) {
			KeywordUtil.markPassed('Status contain Complete.')
			assert true
		} else {
			KeywordUtil.markFailed('Status does not contain Complete. But the status is '+ status)


		}

	}

	//***FUNCTION TO VERIFY THE STATUS OF THE LIFECYCLE
	public static void status_lifecycle( Object path, String text)
	{

		def status = WebUI.getText(path)
		if (status.contains(text)) {
			KeywordUtil.markPassed('Status contain '+text+'.')
		} else {
			KeywordUtil.markFailed('Status does not contain'+status+'. But the status is '+ text)

		}

	}






	///////////////////////CONTROL TAG///////////////////////

	//***FUNCTION TO VERIFY THE STAR *


	public static verifystar(String fieldname, Object path, KeywordLogger log){



		if (WebUI.verifyElementVisible(path))

		{System.out.println( 'The star is displayed next to '+ fieldname+ ' - Test ok' )
			'Screenshot: Verification Star is diplayed - OK '
			WebUI.takeScreenshot()}


		else
		{
			System.out.println( 'The star is NOT  displayed next to '+ fieldname+ ' - Test KO' )
			log.logFailed('Warning! The star is NOT  displayed next to '+ fieldname+ ' - Test KO')
			'The star is NOT  displayed - Test KO'
			WebUI.takeScreenshot()
		}


	}

	//***FUNCTION TO VERIFY IF ERROR MESSAGE IN TOASTR IS CORRECT
	public static verifyErrormsg_toastr(String fieldname,Object path, String Expected_Errormsg,KeywordLogger log ){

		WebUI.waitForElementVisible(path, 10)

		String toastr_P_msg = WebUI.getText(path)



		if (toastr_P_msg.contains(Expected_Errormsg))

			System.out.println( 'Toastr message is '+ toastr_P_msg+' - Test OK' )


		else

		{	log.logFailed('Warning! The toastr is not displayed for '+fieldname+' - Test KO. It should be '+toastr_P_msg)
			//WebUI.takeScreenshot()
			assert false


		}}

	//***FUNCTION TO VERIFY IF ERROR MESSAGE EXACT WORD
	public static verifyErrormsg_EXACT(String fieldname,Object path, String Expected_Errormsg,KeywordLogger log ){


		String CT_msg = WebUI.getText(path)


		if (CT_msg.contains(Expected_Errormsg))

			System.out.println( 'Message is '+ Expected_Errormsg+' - Test OK' )


		else

			log.logFailed('Warning! Incorrect message'+CT_msg+ '- Test KO')

	}




	///////////////////////JAVASCRIPT///////////////////////

	//***FUNCTION TO PAGE DOWN


	public static Pagedown(){


		WebUI.executeJavaScript('window.scrollTo(0, document.body.scrollHeight)', [])

	}

	//***FUNCTION TO CLIK BUTTON VIA JS

	public static click_button_javascript(Object path ){


		WebElement element = WebUiCommonHelper.findWebElement(path,30)
		WebUI.executeJavaScript("arguments[0].click()", Arrays.asList(element))

	}

	public static click_button_javascriptS(String xpath ) {


		WebElement element = WebUiCommonHelper.findWebElement(findTestObject('1. Constant/xpath',[('xpath'):xpath]),30)
		WebUI.executeJavaScript("arguments[0].click()", Arrays.asList(element))

	}



	//////////////////////GMAIL///////////////////////
	//***FUNCTION TO  LOGIN GMAIL
	public static Login_gmail(String Email, String password){
		WebUI.navigateToUrl('https://accounts.google.com/signin/v2/identifier?continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&service=mail&sacu=1&rip=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin')
		WebUI.delay(1)
		WebUI.setText(findTestObject('1. Constant/xpath',[('xpath'):'//*[@id="identifierId"]']), Email)
		WebUI.delay(1)
		WebUI.click(findTestObject('1. Constant/xpath',[('xpath'):'//*[@id="identifierNext"]/div/button']))
		WebUI.delay(1)
		WebUI.setText(findTestObject('1. Constant/xpath',[('xpath'):'//*[@id="password"]/div[1]/div/div[1]/input']), password)

		WebUI.delay(1)
		WebUI.click(findTestObject('1. Constant/xpath',[('xpath'):'//*[@id="passwordNext"]/div/button']))
		WebUI.delay(1)
		WebUI.navigateToUrl('https://mail.google.com/mail/u/0/#inbox')


	}



	///////////////////// NOTEPAD///////////////////////
	//*** FUNCTIONS TO READ NOTEPAD

	public static readnotepad (String filepath){

		//create instance
		File file = new File(filepath)
		String text = FileUtils.readFileToString(file)
		return text
	}

	//*** FUNCTIONS TO WRITE NOTEPAD
	public static void writenotepad (String filepath, String text){
		File f = new File(filepath)
		f.append(text)



	}

	//*** FUNCTIONS TO CLEAR NOTEPAD
	public static void clearnotepad (String filepath){

		FileWriter fw = new FileWriter(filepath)
		PrintWriter pw = new PrintWriter(fw)
		pw.write("")
		pw.flush()
		pw.close()


	}


	///////////////////////////////////// FORMATTING ///////////////////////////////////////////////////

	//***FUNCTION TO GET DATE IN THE FORMAT MMMDDYYYY_HHMMSS

	public static String gettimedate(today){

		today = new Date()
		String requestDate = today.format("MMMddyyyy_HHmmss")
		return requestDate

	}

	//***FUNCTION TO GET DATE IN THE FORMAT DD/MM/YYYY
	public static String gettimedate_Format(today){

		today = new Date()
		String requestDate = today.format('dd/MM/yyyy')
		return requestDate

	}

	//***FUNCTION TO GET DATE IN THE FORMAT DD/MM/YYYY
	public static String getnextday_ddmmyyyy(String Date){

		// Input Date String Format

		def date1 = new Date().parse("dd/MM/yyy", Date)



		date1[DATE] = date1[DATE] + 1

		SimpleDateFormat  sdf = new SimpleDateFormat('dd/MM/YYYY')
		String sDate = sdf.format(date1)
		println (sDate)


		return sDate


	}

	//*** FUNCTIONS TO CONVERT STRING TO INTEGER

	public static converttointeger (String xpath){

		String text = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : xpath]))
		functions.I.print('text ' + text)
		double text_to_integer = Double.parseDouble(text)
		return text_to_integer

	}

	//*** FUNCTIONS TO TABLE

	public static Verify_Table_getdata (String xpath, int row_no, int column_no, String ExpectedValue){


		WebDriver driver = DriverFactory.getWebDriver()

		'To locate table'

		WebElement Table = driver.findElement(By.xpath(xpath))

		'To locate rows of table it will Capture all the rows available in the table '

		List<WebElement> Rows = Table.findElements(By.tagName('tr'))

		println('No. of rows: ' + Rows.size())



		'To locate columns(cells) of that specific row'

		List<WebElement> Cols = Rows.get(row_no).findElements(By.tagName('td'))



		'Verifying the expected text in the each cell'

		//VERIFY THAT VALUE IS CORRECT
		WebUI.verifyMatch(Cols.get(column_no).getText(), ExpectedValue, false)

	}

}