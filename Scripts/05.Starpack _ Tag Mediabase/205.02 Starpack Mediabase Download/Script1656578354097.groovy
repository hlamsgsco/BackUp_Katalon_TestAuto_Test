import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
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
import com.kms.katalon.core.logging.KeywordLogger as KeywordLogger
import org.openqa.selenium.JavascriptExecutor as JavascriptExecutor
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper
import org.openqa.selenium.WebElement as WebElement
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory

//USERNAME & PASSWORD FOR LOGIN - STARPACK : 10 June 2021
def data = TestDataFactory.findTestData('Data Files/Username_Password/Test_Starpack')

String password_suser = data.getValue(2, 1)

String password_aherms = data.getValue(2, 2)

String password_agluszczynska = data.getValue(2, 3)

String password_jmaciaszczyk = data.getValue(2, 4)

String password_aterreshernandez = data.getValue(2, 5)

String password_amartin_arbol = data.getValue(2, 6)

String password_adelamatanieves = data.getValue(2, 7)

String password_kcannoosamy_dia = data.getValue(2, 8)

def data_urlTestAUTO = TestDataFactory.findTestData('Data Files/URL/URL_testauto')

String Url_Starpack = data_urlTestAUTO.getValue(2, 2)

///////////////////////////////////////////////////////////////
//Keyword log
KeywordLogger log = new KeywordLogger()

//BROWSE & MAXIMIZE BROWSER
'Navigate to URL Starpack Test'
WebUI.openBrowser(Url_Starpack)

WebUI.maximizeWindow()

//VERIFICATION OF DOWNLOAD RIGHTS
//LOG IN AS Buyer: amartin_arbol	 ~ dchi
'Log in as buyer/ dchi'
functions.I.Login_password('amartin_arbol', password_amartin_arbol)

'Screenshot: Log as buyer'
WebUI.takeScreenshot()

//CLICK ON THE SIDE MENU: Mediabase
//*[@id="menu_medibase_tab_1"]/a
WebUI.click(findTestObject('Object Repository/Starpack Mediabase/Starpack Mediabase id_menu_medibase_tab_1a'))

'Screenshot: Mediabase Page'
WebUI.takeScreenshot()

////*[@id="mediabase-panel-cards"]/div/div[1]/div/div[3]/div/a
//SRP Format
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="mediabase-panel-cards"]/div/div[1]/div/div[3]/div/a']))

//*[@id="mediabase-panel-cards"]/div/div[1]/div/div/div/a
//LID FORMAT
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="mediabase-panel-cards"]/div/div[1]/div/div/div/a']))

'Verify that the download button is not clickable'

//HOVER OVER DOC
'Hover over doc'
WebUI.mouseOver(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="20200422-140327-318-9EBHJIEHAI"]']))

//get attribute
String test0 = WebUI.getAttribute(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="20200422-140327-318-9EBHJIEHAI"]/div[1]/div[2]/div/a[2]']), 
    'href')

//VErify that link is not empty
'Verify link for the download when it is http://mediabase ... '
if (test0 != '') {
    throw new Exception('No Empty value found ' + test0)
    
    assert false
} else {
    functions.I.print('Download link is: ' + test0)

    WebUI.comment('Download link is Empty ')
}

functions.I.Logout()

///////////////////////////////////////////////////////////////////////////////////////
//LOG IN AS Packaging_1: adelamatanieves	 ~ dchi
'Log in as suser/ dchi'
functions.I.Login_password('suser', password_suser)

'Screenshot: Log as suser'
WebUI.takeScreenshot()

//CLICK ON THE SIDE MENU: Mediabase
//*[@id="menu_medibase_tab_1"]/a
WebUI.click(findTestObject('Object Repository/Starpack Mediabase/Starpack Mediabase id_menu_medibase_tab_1a'))

'Screenshot: Mediabase Page'
WebUI.takeScreenshot()

//User Guide
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="mediabase-panel-cards"]/div/div[1]/div/div[4]/div/a']))

//HOVER OVER DOC
//*[@id="20200529-132819-643-EDV4X8WTY9"]
'Hover over doc'
WebUI.mouseOver(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div/div[4]/div[3]/div[3]/div[2]/div/div/div[1]/div[1]/div/div[2]/div/div[1]/div']))

'Hover over download'
WebUI.mouseOver(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div/div[4]/div[3]/div[3]/div[2]/div/div/div[1]/div[1]/div/div[2]/div/div[1]/div/div[1]/div[2]/div/a[2]']))

'Screenshot: tooltip download'
WebUI.takeScreenshot()

//tooltip
//*[@id="popover4013"]/div[2]
String value_download = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[2]/div[2]']))

WebUI.verifyEqual(value_download, 'Download')

//VErify if the element is clickable
//*[@id="20201021-155056-923-U1Z0H4HFHQ"]/div[1]/div[2]/div/a[2]
'Verify if the button "download" is clickable'
WebUI.verifyElementClickable(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div/div[4]/div[3]/div[3]/div[2]/div/div/div[1]/div[1]/div/div[2]/div/div[1]/div/div[1]/div[2]/div/a[2]']), 
    FailureHandling.STOP_ON_FAILURE)

//CLICK DOWNLOAD
'Click on download'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div/div[4]/div[3]/div[3]/div[2]/div/div/div[1]/div[1]/div/div[2]/div/div[1]/div/div[1]/div[2]/div/a[2]']), 
    FailureHandling.STOP_ON_FAILURE)



WebUI.delay(1)
//get attribute
'40'
String test = WebUI.getAttribute(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div/div[4]/div[3]/div[3]/div[2]/div/div/div[1]/div[1]/div/div[2]/div/div[1]/div/div[1]/div[2]/div/a[2]']), 
    'href')

//VErify that link is not empty
'Verify link for the download when it is http://mediabase ... '
if (test == '') {
    throw new Exception('Empty value found')
    
    assert false
}

/*else
{
	functions.I.print('Download link is: '+ test)
	WebUI.comment('Download link is: '+ test)
	if (test == 'http://mdb-release.diadeis.lan/Mediabox-independence/Base/ExecAction?action=MbiDownloadDoc&IDSession=MBI!REL_STARPACK!37B63DB1X8T5RTS978HJABHRUG0FN0Y5U2V3Z1VV&num=ODJ7NAT88D&id_document=20201021-155056-923-U1Z0H4HFHQ&id_project=')
{
	functions.I.print('OK. link is same as  http://mdb-release.diadeis.lan/Mediabox-independence/Base/ExecAction?action=MbiDownloadDoc&IDSession=MBI!REL_STARPACK!37B63DB1X8T5RTS978HJABHRUG0FN0Y5U2V3Z1VV&num=ODJ7NAT88D&id_document=20201021-155056-923-U1Z0H4HFHQ&id_project=')
	WebUI.comment('link is same as  http://mdb-release.diadeis.lan/Mediabox-independence/Base/ExecAction?action=MbiDownloadDoc&IDSession=MBI!REL_STARPACK!37B63DB1X8T5RTS978HJABHRUG0FN0Y5U2V3Z1VV&num=ODJ7NAT88D&id_document=20201021-155056-923-U1Z0H4HFHQ&id_project=')
	}


	

else
	{
		functions.I.print('KO. Link is '+ test+'instead of http://mdb-release.diadeis.lan/Mediabox-independence/Base/ExecAction?action=MbiDownloadDoc&IDSession=MBI!REL_STARPACK!37B63DB1X8T5RTS978HJABHRUG0FN0Y5U2V3Z1VV&num=ODJ7NAT88D&id_document=20201021-155056-923-U1Z0H4HFHQ&id_project=' )
		WebUI.comment('KO. Link is '+ test+'instead of http://mdb-release.diadeis.lan/Mediabox-independence/Base/ExecAction?action=MbiDownloadDoc&IDSession=MBI!REL_STARPACK!37B63DB1X8T5RTS978HJABHRUG0FN0Y5U2V3Z1VV&num=ODJ7NAT88D&id_document=20201021-155056-923-U1Z0H4HFHQ&id_project=' )
	
		}
	
	}
*/
WebUI.delay(25)

'Verify that the file is downloaded'
String test3 = functions.I.isFileDownloaded('C:\\Users\\lamhe\\Downloads', 'Userguide_CommercialSupport_v1.pdf')

functions.I.print(test3)

if (test == 'false') {
    assert false
}

//CLICK ON THE SIDE MENU: Mediabase
//*[@id="menu_medibase_tab_1"]/a
////*[@id="menu_mediabase_tab_current"]/a
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="menu_mediabase_tab_current"]/a']))

'Click on folder - PDF PRE IMPRESIÓN'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="mediabase-panel-cards"]/div/div[1]/div/div[2]/div/a']))

//CLICK DOWNLOAD
'Click on download'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div/div[4]/div[3]/div[3]/div[2]/div/div/div[1]/div[1]/div/div[2]/div/div[1]/div/div[1]/div[2]/div/a[2]']), 
    FailureHandling.STOP_ON_FAILURE)

'Screenshot: Doc dowmnloaded'
WebUI.takeScreenshot()

//get attribute
String test1 = WebUI.getAttribute(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div/div[4]/div[3]/div[3]/div[2]/div/div/div[1]/div[1]/div/div[2]/div/div[1]/div/div[1]/div[2]/div/a[2]']), 
    'href')

//VErify that link is not empty
'Verify link for the download when it is javascript  '
if (test1 == '') {
    throw new Exception('Empty value found')
    
    assert false //href="javascript:getDownloadAWS('20201218-125707-862-U27374VQDN','267965 Iceberg Hierbabuena 44g.pdf');"	
    //javascript:getDownloadAWS('20210114-163536-280-NKYK7QOPYX','00. Plano bandeja Dosificador 500 gr.pdf');
} else {
    functions.I.print('Download link is: ' + test1)

    WebUI.comment('Download link is: ' + test1)

    String test2 = 'javascript:getDownloadAWS(\'20201218-125707-862-U27374VQDN\',\'267965 Iceberg Hierbabuena 44g.pdf\');'

    if (test1 == test2) {
        functions.I.print('OK. link is same as ' + test2)

        WebUI.comment('link is same as ' + test2)

        WebUI.switchToWindowIndex(1)

        String urltest = WebUI.getUrl()

        functions.I.print('url > ' + urltest)

        'Screenshot: Doc opened in another tab'
        WebUI.takeScreenshot()
    } else {
        functions.I.print((('KO. Link is ' + test1) + 'instead of ') + test2)

        WebUI.comment((('KO. Link is >' + test1) + 'instead of >') + test2)

        assert false
    }
}

WebUI.closeBrowser()

