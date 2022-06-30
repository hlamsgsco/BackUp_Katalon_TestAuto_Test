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
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory

//DATA FIELD USERNAME_PASSWORD (TAG)
def data_Tag = TestDataFactory.findTestData('Data Files/Username_Password/Test_Tag')

String password_cbono = data_Tag.getValue(3, 11 //R
    )

String password_suser = data_Tag.getValue(3, 21 //R
    )

//DATA FIELD URL
def data_urlTESTAUTO = TestDataFactory.findTestData('Data Files/URL/URL_testauto')

String Url_Tag = data_urlTESTAUTO.getValue(2, 3)


//NOTEPAD
String Project_No = functions.I.readnotepad('D:\\Upoad_File\\zTest_Auto\\Test_Projet_Login\\Tag\\312.07 Tag _Project_No\\312.07_Tag_ProjectNo.txt')

String refID = functions.I.readnotepad('D:\\Upoad_File\\zTest_Auto\\Test_Projet_Login\\Tag\\312.07 Tag _Project_No\\312.07_Tag_refID1.txt')

///////////////////////////// TEST BEGIN /////////////////////////////////////////
//BROWSE & MAXIMIZE BROWSER
'Navigate to URL Tag Release'
WebUI.openBrowser(Url_Tag)

WebUI.maximizeWindow()

'Delay 2'
WebUI.delay(2)

'Screenshot: Navigate to URL Tag Release'
WebUI.takeScreenshot()

'Login  '
functions.I.Login_password('suser', password_suser)

'Go to LHS menu: Projects'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="menu_2"]/a']))

WebUI.delay(1)

'Search for project'
functions.I.SearchProjectNo_xpath(Project_No, '//*[@id="keynum_project"]', '//*[@id="form_filters"]/div[4]/button')

'Upload doc'
String color1 = WebUI.getCSSValue(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID) + '"]/td[13]/a[3]']), 
    'color', FailureHandling.OPTIONAL)

//WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="source_'+refID+'"]/td[13]/a[3]']))
'Click Upload doc'
functions.I.print(color1)

while (color1 == 'rgba(255, 255, 255, 1)') {
    functions.I.Pagedown()

    WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID) + '"]/td[13]/a[3]']))

    //UPLOAD A DOC - PDF
    functions.I.UploadDoc_sendkey_Prod(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_body"]/input[2]']), 
        'D:\\Upoad_File\\Upload doc\\testdata1.jpg', 'testdata1')

    'Screenshot: Production phase Field Upload doc'
    WebUI.takeScreenshot()

    WebUI.delay(10)

    //REF PAGE: CLICK ON PROCEED TO NEXT PHASE
    WebUI.click(findTestObject('HL Full Lifecycle/12 ReferncePage_Button_Updatensenddoc'))

    WebUI.delay(5)

    if (WebUI.verifyElementVisible(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID) + '"]/td[13]/a[3]']), 
        FailureHandling.OPTIONAL)) {
        //
        color1 = WebUI.getCSSValue(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID) + '"]/td[13]/a[3]']), 
            'color', FailureHandling.OPTIONAL)
    } else {
        color1 = 'white'
    }
}

'Screenshot: '
WebUI.takeScreenshot()

'Click ref link'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID) + '"]/td[6]/a']))

WebUI.delay(1)

'Click doc tab'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_content"]/div[3]/div/ul/li[2]/a']))

'Click apprival workflow tab'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="aff_doc_AW"]']))

functions.I.Pagedown()

'49 Tooltip: Message is displayed'

//functions.I.Verify_Mouse_Over_tooltip('/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[2]/div/div[3]/div/div/div[2]/div[1]/div/div[2]/div/div[2]/div/div[2]/div/div[1]/div[2]/i', 
//  '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[2]/div/div[3]/div/div/div[2]/div[1]/div/div[2]/div/div[2]/div/div[2]/div/div[1]/div[2]/div', 
//  ('Out of the office' + '\n'+'test carole'+'\n') + 'Tasks delegated to : afron and asch and suser')
////*[@id="kt_header"]/div/div[2]/div[2]/div[2]/a[5]
'Logout'
functions.I.Logout_xpath('//*[@id="kt_header"]/div/div[2]/div[2]/div[1]/div/span', '/html/body/div[1]/div[2]/div[1]/div/div[2]/div[2]/div[2]/a[5]')

'27 Login  '
functions.I.Login_password('cbono', password_cbono)

WebUI.delay(1)

'Go to my profile'
functions.I.Go_to_MyProfile()

'Screenshot: MyProfile page '
WebUI.takeScreenshot()

'SEttext'
WebUI.setText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="delegationSettings"]/div[2]/input']), 'test carole')

functions.I.Pagedown()

'click on update'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifierUser"]/div[3]/div/button']))

WebUI.delay(1)

'Logout'
functions.I.Logout_xpath('//*[@id="kt_header"]/div/div[2]/div[2]/div[1]/div/span', '//*[@id="kt_header"]/div/div[2]/div[2]/div[2]/a[3]')

WebUI.delay(1)

'Login  '
functions.I.Login_password('suser', password_suser)

'Go to LHS menu: Projects'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="menu_2"]/a']))

WebUI.delay(1)

'Search for project'
functions.I.SearchProjectNo_xpath(Project_No, '//*[@id="keynum_project"]', '//*[@id="form_filters"]/div[4]/button')

'Click ref link'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID) + '"]/td[6]/a']))

WebUI.delay(1)

'Click doc tab'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_content"]/div[3]/div/ul/li[2]/a']))

'Click approval workflow tab'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="aff_doc_AW"]']))

functions.I.Pagedown()

'69 Tooltip: Message is displayed'
functions.I.Verify_Mouse_Over_tooltip('//*[@id="level_apl_0"]/div[2]/div[2]/div[2]/div/div[1]/img', '/html/body/div[9]/div[2]', 
    ((('Out of the office' + '\n') + 'test carole') + '\n') + 'Tasks delegated to : afron and asch and suser')

'Go to menu'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_header"]/div/div[2]/div[2]/div[1]/div/span/img']))

'Click on cbono'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_header"]/div/div[2]/div[2]/div[2]/a[1]/img']))

WebUI.delay(2)

'Get task No'
double task_b4_cbono = functions.I.Get_Task_No('//*[@id="kt_header"]/div/div[2]/div[2]/div[1]/span')

functions.I.print('task_B4' + task_b4_cbono)

'Go to LHS menu: Projects'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="menu_2"]/a']))

WebUI.delay(1)

'Search for project'
functions.I.SearchProjectNo_xpath(Project_No, '//*[@id="keynum_project"]', '//*[@id="form_filters"]/div[8]/button')

' Click on view doc'
functions.I.AWF_approve_byaction(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID) + '"]/td[14]/a[2]']))

WebUI.delay(2)

'get task -1'
double task_af_cbono = functions.I.Get_Task_No('//*[@id="kt_header"]/div/div[2]/div[2]/div[1]/span')

WebUI.verifyEqual(task_af_cbono, task_b4_cbono - 1)

'Close Browser'
WebUI.closeBrowser()

