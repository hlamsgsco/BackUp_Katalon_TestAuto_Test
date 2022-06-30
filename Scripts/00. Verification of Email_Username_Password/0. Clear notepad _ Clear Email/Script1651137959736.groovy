import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import java.io.File as File

//MODIFY // 
/*
THIS TESTCASE SHOULD BE RUN BEFORE EXECUTING THE OTHER TEST SUITE

EMAIL USED:
mediaboxtest.creation@gmail.com / Diadeis*1
TestMediabox.modif@gmail.com / Diadeis*1
 */


//////////////////////////////////////////////////////////////////////TEST START ///////////////////////////////////////////////////

//CLEARING EMAIL
String password_mediaboxCreation = 'Diadeis*1'
String password_mediaboxmodif = 'Diadeis*1'

//BROWSE & MAXIMIZE BROWSER
WebUI.openBrowser('')
WebUI.maximizeWindow()

'Delay 5'
WebUI.delay(5)

//SCENARIO 1 : EMAIL 1 > Mediabox.creation@gmail.com
'GMAIL: Login as mediaboxtest.creation@gmail.com '
functions.I.Login_gmail('mediaboxtest.creation@gmail.com ', password_mediaboxCreation)


'Delay 1'
WebUI.delay(1)

//TEXT THAT SHOULD BE PRESENT
String text = 'Your Primary tab is empty.'

//CONDITION IF THE TEXT IS EMPTY, EMPTY EMAIL. ELSE PRINT EMTPY
if (WebUI.verifyTextNotPresent(text, false, FailureHandling.OPTIONAL)) {
	
	'Click on select all button'
    WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[7]/div[3]/div/div[2]/div[1]/div[2]/div/div/div/div/div[1]/div/div[1]/div[1]/div/div/div[1]/div/div[1]/span']))

    assert true
	
	'Delay 5'
    WebUI.delay(5)

	'Click on delete all button'
    WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id=":4"]/div/div[1]/div[1]/div/div/div[2]/div[3]']), 
        FailureHandling.CONTINUE_ON_FAILURE)

    assert true
	
	'Delay 5'
    WebUI.delay(5)

    'Close Browser'
WebUI.closeBrowser()

} 

else {
	'Print Empty'
    functions.I.print('Empty')
}
//END CONDITION

'Delay 1'
WebUI.delay(1)


//SCENARIO 2 : EMAIL 2 > Mediabox.modif@gmail.com

//BROWSE & MAXIMIZE BROWSER

WebUI.openBrowser('')
WebUI.maximizeWindow()

'Delay 5'
WebUI.delay(5)

'GMAIL: Login as mediaboxmodif'
functions.I.Login_gmail('TestMediabox.modif@gmail.com', password_mediaboxmodif)

'Delay 1'
WebUI.delay(1)

//CONDITION IF THE TEXT IS EMPTY, EMPTY EMAIL. ELSE PRINT EMTPY
if (WebUI.verifyTextNotPresent(text, false, FailureHandling.OPTIONAL)) {
	
	'Click on select all button'
    WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[7]/div[3]/div/div[2]/div[1]/div[2]/div/div/div/div/div[1]/div/div[1]/div[1]/div/div/div[1]/div/div[1]/span']), 
        FailureHandling.CONTINUE_ON_FAILURE)

    assert true
	
	'Delay 5'
    WebUI.delay(5)
	
	'Click on delete all button'
     WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id=":4"]/div/div[1]/div[1]/div/div/div[2]/div[3]']), 
        FailureHandling.CONTINUE_ON_FAILURE)

    assert true
	
	'Delay 5'
	 WebUI.delay(5)

   'Close Browser'
WebUI.closeBrowser()

} 

else {
	'Print Empty'
    functions.I.print('Empty')

    'Close Browser'
WebUI.closeBrowser()
}



//END CONDITION


//////////////////////////////////////////////////////////////////////END TEST  ///////////////////////////////////////////////////