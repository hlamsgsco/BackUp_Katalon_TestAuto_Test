import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.google.common.base.Functions as Functions
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
import com.kms.katalon.core.webui.keyword.internal.WebUIAbstractKeyword as WebUIAbstractKeyword
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory

/* icoindeau / alafon - task 0 before starting
 *
 * TO CONTINUE WITH 3405
 * SCENARIO TESTED: FULLL LIFECYCLE : 0 - Common Brief only
 

VERIFICATION OF TASK
SCENARIO 1: CREATION OF REF > TASK ADDED & REMOVED - STANDARD PHASE
SCENARIO 2: QUESTION PHASE > TASK ADDED & REMOVED - TAKING ROADS
SCENARIO 3 : QUESTION PHASE > PROCEED TO NEXT PHASE
 
*/
//DATA FIELD USERNAME_PASSWORD (TAG)
def data_Tag = TestDataFactory.findTestData('Data Files/Username_Password/Test_Tag')

String password_jedun = data_Tag.getValue(3, 1 //R
    )

String password_daguirre = data_Tag.getValue(3, 30 //R
    )

String password_aomoto = data_Tag.getValue(3, 31 //R
    )

String password_apetit = data_Tag.getValue(3, 32 // R
    )

String password_mcazeaux = data_Tag.getValue(3, 34 //R
    )

//DATA FIELD URL
def data_urlTESTAUTO = TestDataFactory.findTestData('Data Files/URL/URL_testauto')

String Url_Tag = data_urlTESTAUTO.getValue(2, 3)


String Project_No = functions.I.readnotepad('D:\\Upoad_File\\zTest_Auto\\Test_Projet_Login\\Tag\\302.06 Tag_Project\\302.06_Tag_ProjectNo.txt')

String refID = functions.I.readnotepad('D:\\Upoad_File\\zTest_Auto\\Test_Projet_Login\\Tag\\302.06 Tag_Project\\302.06_Tag_refID1.txt')

String refID1 = functions.I.readnotepad('D:\\Upoad_File\\zTest_Auto\\Test_Projet_Login\\Tag\\302.06 Tag_Project\\302.06_Tag_refID2.txt')

///////////////////////////// TEST BEGIN /////////////////////////////////////////
//BROWSE & MAXIMIZE BROWSER
'Navigate to URL Tag'
WebUI.openBrowser(Url_Tag)

WebUI.maximizeWindow()

'Login as aomoto '
functions.I.Login_password('aomoto', password_aomoto)

'Screenshot: Dashboard page '
WebUI.takeScreenshot()

Double task5_aomoto = functions.I.Get_Task_No('//*[@id="kt_header"]/div/div[2]/div[1]/div[1]')

'Click on to do more'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="widg_20211104_014000_1667WDS1D"]/div/div[1]/div[2]/a[2]']))

'Screenshot: Task Page'
WebUI.takeScreenshot()

WebUI.delay(1)

'Task no'
String t1 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_content"]/div[3]/div/div/div[1]/div[1]/h3/span']))

int t11 = Integer.parseInt(t1)

int u = 1

//DASHBOARD
'verify the projectno'
while (u <= t11) {
    result1 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : ('/html/body/div[1]/div[2]/div[8]/div[3]/div/div/div[2]/div/table/tbody/tr[' + 
                u) + ']/td[1]/a']))

    if (result1.contains(Project_No)) {
        WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : ('/html/body/div[1]/div[2]/div[8]/div[3]/div/div/div[2]/div/table/tbody/tr[' + 
                    u) + ']/td[1]/a']))

        u = (u + 1)

        break
    } else {
        u = (u + 1)
    }
}

WebUI.delay(1)

////*[@id="source_24428"]/td[15]/a[2]
'26 Click on submit'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID1) + '"]/td[15]/a[2]']))

'Screenshot: ref modif page '
WebUI.takeScreenshot()

'Select Local artwork agency - Loreal creation'
functions.I.SelectFromList_Value('//*[@id="var_67"]', '16548')

'Select - English'
functions.I.select_multiplelist('//*[@id="selSource_10"]', '//*[@id="btnAdd_10"]', '26')

functions.I.Pagedown()

'Click Submit'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[3]/div/button[2]']))

'Screenshot: ref List page '
WebUI.takeScreenshot()

functions.I.Logout()

'Login as jedun '
functions.I.Login_password('jedun', password_jedun)

'LHS click the project tab'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="menu_2"]/a']))

'Search project no'
functions.I.SearchProjectNo_xpath(Project_No, '//*[@id="keynum_project"]', '//*[@id="form_filters"]/div[7]/button')

WebUI.delay(1)

'Screenshot: ref List page '
WebUI.takeScreenshot()

'Upload doc'
String color1 = WebUI.getCSSValue(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID1) + '"]/td[17]/a[3]']), 
    'color', FailureHandling.OPTIONAL)

'148'
while (color1 == 'rgba(255, 255, 255, 1)') {
    WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID1) + '"]/td[17]/a[3]']))

    'Supplier Upload doc for production phase'
    WebUI.takeScreenshot()

    //UPLOAD A DOC
    functions.I.UploadDoc_sendkey_Prod(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_body"]/input[2]']), 
        'D:\\Upoad_File\\Upload doc\\testdataaddition1.jpg', 'testdataaddition1.jpg')

    'Screenshot: Production phase Field Upload doc'
    WebUI.takeScreenshot()

    WebUI.delay(10)

    //REF PAGE: CLICK ON PROCEED TO NEXT PHASE
    functions.I.click_button_javascript(findTestObject('Object Repository/HL Full Lifecycle/12 ReferncePage_Button_Updatensenddoc'))

    WebUI.delay(5)

    if (WebUI.verifyElementPresent(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID1) + '"]/td[17]/a[3]']), 
        10, FailureHandling.OPTIONAL)) {
        color1 = WebUI.getCSSValue(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID1) + '"]/td[17]/a[3]']), 
            'color', FailureHandling.OPTIONAL)
    } else {
        color1 = 'white'
    }
}

WebUI.delay(1)


'Logout'
functions.I.Logout()

'Login as aomoto '
functions.I.Login_password('aomoto', password_aomoto)

Double task1_aomoto = functions.I.Get_Task_No('//*[@id="kt_header"]/div/div[2]/div[1]/div[1]')

'Click on task'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_header"]/div/div[2]/div[1]/div[1]/div']))

WebUI.delay(1)

int a = 1

while (a <= task1_aomoto) {
    result1 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="kt_header"]/div/div[2]/div[1]/div[2]/form/div[2]/a[' + 
                a) + ']']))

    if (result1.contains('REVIEW Artwork document: TC18_AUTO_MOTHERREF_Fake_Beauty Seal_100CM2___EN___')) {
        WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="kt_header"]/div/div[2]/div[1]/div[2]/form/div[2]/a[' + 
                    a) + ']']))

        a = (a + 1)

        break
    } else {
        a = (a + 1)
    }
}

WebUI.delay(1)

'Screenshot: doc tab '
WebUI.takeScreenshot()

'Click on task'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_header"]/div/div[2]/div[1]/div[1]/div']))

//REFUSE WITHOUT ANY REASON
'Click on viewer'
WebUI.click(findTestObject('HL Full Lifecycle/Function_Access to viewer'))

WebUI.delay(2)

'Screenshot: Viewver '
WebUI.takeScreenshot()

////*[@id="BtnrefusalButton"]
'101 On greenlight viewer: Click on request ammendments'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="BtnrefusalButton"]']))

WebUI.delay(1)

'click refuse'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="disable_rejectionButton"]']))

'Verify toastr'
functions.I.VerifyMatchToastrmsg('//*[@id="toast-container"]/div/div[2]', 'Rejection reason required')

'Screenshot: toastr'
WebUI.takeScreenshot()

WebUI.delay(1)

//REFUSE WITH REASON
' Select - reason DMI new brief/...'
functions.I.SelectFromList_Value('//*[@id="listbox_rejection_doc"]', '2')

WebUI.delay(1)

'click refuse'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="disable_rejectionButton"]']))

'77 Verify lifecycle status'
functions.I.VerifyMatchText(('//*[@id="source_' + refID1) + '"]/td[13]/span[1]', 'Creative: Artwork production')

Double task2_aomoto = functions.I.Get_Task_No('//*[@id="kt_header"]/div/div[2]/div[1]/div[1]')

WebUI.verifyEqual(task2_aomoto, task1_aomoto - 1)

'Click on task'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_header"]/div/div[2]/div[1]/div[1]/div']))

WebUI.delay(1)

int b = 1

while (b <= task2_aomoto) {
    String result2 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="kt_header"]/div/div[2]/div[1]/div[2]/form/div[2]/a[' + 
                b) + ']']))

    if (result2.contains('REVIEW Artwork document: TC18_AUTO_MOTHERREF_Fake_Beauty Seal_100CM2___EN___')) {
        WebUI.verifyEqual(1, 2)

        break
    } else {
        b = (b + 1)
    }
}

functions.I.Logout()

'Login as jedun '
functions.I.Login_password('jedun', password_jedun)

'LHS click the project tab'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="menu_2"]/a']))

'Search project no'
functions.I.SearchProjectNo_xpath(Project_No, '//*[@id="keynum_project"]', '//*[@id="form_filters"]/div[7]/button')

WebUI.delay(1)

'Screenshot: ref List page '
WebUI.takeScreenshot()

'Upload doc'
String color2 = WebUI.getCSSValue(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID1) + '"]/td[17]/a[3]']), 
    'color', FailureHandling.OPTIONAL)

while (color2 == 'rgba(255, 255, 255, 1)') {
    WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID1) + '"]/td[17]/a[3]']))

    'Supplier Upload doc for production phase'
    WebUI.takeScreenshot()

    //UPLOAD A DOC
    functions.I.UploadDoc_sendkey_Prod(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_body"]/input[2]']), 
        'D:\\Upoad_File\\Upload doc\\testdataaddition1.pdf', 'testdataaddition1.pdf')

    'Screenshot: Production phase Field Upload doc'
    WebUI.takeScreenshot()

    WebUI.delay(10)

    //REF PAGE: CLICK ON PROCEED TO NEXT PHASE
    functions.I.click_button_javascript(findTestObject('Object Repository/HL Full Lifecycle/12 ReferncePage_Button_Updatensenddoc'))

    WebUI.delay(5)

    ////*[@id="source_24446"]/td[15]/a[2]
    if (WebUI.verifyElementPresent(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID1) + '"]/td[17]/a[3]']), 
        10, FailureHandling.OPTIONAL)) {
        color2 = WebUI.getCSSValue(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID1) + '"]/td[17]/a[3]']), 
            'color', FailureHandling.OPTIONAL)
    } else {
        color2 = 'white'
    }
}

WebUI.delay(1)

'79'
functions.I.Logout()

'Login as daguirre'
functions.I.Login_password('daguirre', password_daguirre)

'LHS click the project tab'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="menu_2"]/a']))

'Search project no'
functions.I.SearchProjectNo_xpath(Project_No, '//*[@id="keynum_project"]', '//*[@id="form_filters"]/div[4]/button')

WebUI.delay(1)

'Screenshot: ref List page '
WebUI.takeScreenshot()

double task1_daguirre = functions.I.Get_Task_No('//*[@id="kt_header"]/div/div[2]/div[1]/div[1]')

'Click on the extender '
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID1) + '"]/td[15]/a[1]']))

functions.I.AWF_approve_view()

'Verify lifecycle status'
functions.I.VerifyMatchText(('//*[@id="source_' + refID1) + '"]/td[14]/span[1]', 'DMI: Artwork Approval')

'Click on the extender '
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID1) + '"]/td[15]/a[1]']))

WebUI.delay(3)

'1044'
functions.I.AWF_approve_view()

//Control tag on the viewwer
String Expectedd_CT1 = ((((((((('×' + '\n') + 'Error') + '\n\n') + 'REFERENCE BRIEF VALIDATION ERRORS : TC18_AUTO_MOTHERREF_Fake_Beauty Seal_100CM2___EN___') + 
'\n') + 'GTIN code is missing') + '\n') + 'Product to be notified is missing') + '\n') + 'SKU code is missing'

functions.I.VerifyMatchToastrmsg('//*[@id="toast-container"]/div', Expectedd_CT1)

'Fill in required field'

'SKU - MB179800'
WebUI.setText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_106"]']), 'MB179800')

'GTIN- :03337875678094'
WebUI.setText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_126"]']), '03337875678094')

'Product Notified - NO'
functions.I.SelectFromList_Value('//*[@id="var_107"]', '23')

'Click approve'
WebUI.click(findTestObject('HL Full Lifecycle/Function_Appbutton2'))

WebUI.delay(1)

double task2_daguirre = functions.I.Get_Task_No('//*[@id="kt_header"]/div/div[2]/div[1]/div[1]')

'Verify that task has decreased'
WebUI.verifyEqual(task2_daguirre, task1_daguirre - 1)

'Logout'
functions.I.Logout()

'Login as aomoto '
functions.I.Login_password('aomoto', password_aomoto)

'Screenshot: Dashboard page '
WebUI.takeScreenshot()

double task10_aomoto = functions.I.Get_Task_No('//*[@id="kt_header"]/div/div[2]/div[1]/div[1]')

int m = 1

//DASHBOARD
while (m <= task10_aomoto) {
    int n = 0

    n = (m + 1)

    result1 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : ('/html/body/div[1]/div[2]/div[4]/div[3]/div/div[5]/div[2]/div[1]/div/div[2]/div/div/table/tbody/tr[' + 
                n) + ']/td[1]/a']))

    if (result1.contains('REVIEW Artwork document: TC18_AUTO_MOTHERREF_Fake_Beauty Seal_100CM2___EN___')) {
        WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : ('/html/body/div[1]/div[2]/div[4]/div[3]/div/div[5]/div[2]/div[1]/div/div[2]/div/div/table/tbody/tr[' + 
                    n) + ']/td[1]/a']))

        break
    } else {
        m = (m + 1)
    }
}

WebUI.delay(1)

'Screenshot: doc tab '
WebUI.takeScreenshot()

WebUI.delay(1)

functions.I.AWF_approve_view()

WebUI.delay(1)

'Screenshot: ref list '
WebUI.takeScreenshot()

Double task11_aomoto = functions.I.Get_Task_No('//*[@id="kt_header"]/div/div[2]/div[1]/div[1]')

WebUI.verifyEqual(task11_aomoto + 1, task10_aomoto)

functions.I.Logout()

'Login as apetit '
functions.I.Login_password('apetit', password_apetit)

'Screenshot: Dashboard page '
WebUI.takeScreenshot()

Double task10_apetit = functions.I.Get_Task_No('//*[@id="kt_header"]/div/div[2]/div[1]/div[1]')

int x = 1

//Task
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_header"]/div/div[2]/div[1]/div[1]']))

while (x <= task10_apetit) {
    result_task = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="kt_header"]/div/div[2]/div[1]/div[2]/form/div[2]/a[' + 
                x) + ']']))

    if (result_task.contains('REVIEW Artwork document: TC18_AUTO_MOTHERREF_Fake_Beauty Seal_100CM2___EN___')) {
        WebUI.verifyEqual(1, 1)

        break
    } else {
        x = (x + 1)

        if (x > task10_apetit) {
            WebUI.verifyEqual(2, 1)
        }
    }
}

//DASHBOARD
int s = 1

int o = 0

///html/body/div[1]/div[2]/div[4]/div[3]/div/div[5]/div[2]/div[1]/div/div[2]/div/div/table/tbody/tr[2]/td[1]/a
while (s <= task10_apetit) {
    o = (s + 1)

    result_task = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : ('/html/body/div[1]/div[2]/div[4]/div[3]/div/div[5]/div[2]/div[1]/div/div[2]/div/div/table/tbody/tr[' + 
                o) + ']/td[1]/a']))

    if (result_task.contains('REVIEW Artwork document: TC18_AUTO_MOTHERREF_Fake_Beauty Seal_100CM2___EN___')) {
        WebUI.verifyEqual(1, 1)

        break
    } else {
        s = (s + 1)

        if (s > task10_apetit) {
            WebUI.verifyEqual(2, 1)
        }
    }
}

WebUI.delay(1)

'LHS click the project tab'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="menu_2"]/a']))

'Search project no'
functions.I.SearchProjectNo_xpath(Project_No, '//*[@id="keynum_project"]', '//*[@id="form_filters"]/div[8]/button')

WebUI.delay(1)

'Screenshot: ref List page '
WebUI.takeScreenshot()

WebUI.delay(1)

'Click on the extender '
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID1) + '"]/td[15]/a[1]']))

//approve on viewer
'Wait for page load'
WebUI.waitForPageLoad(5)

'Mouse over viwer'
WebUI.mouseOver(findTestObject('Object Repository/HL Full Lifecycle/Function_access Viewer2'))

WebUI.delay(2)

'Click on viewer'
WebUI.click(findTestObject('Object Repository/HL Full Lifecycle/Function_access Viewer2'))

WebUI.delay(2)

'Screenshot: Viewver '
WebUI.takeScreenshot()

'61 On greenlight viewer: Click on request ammendments'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="BtnrefusalButton"]']))

WebUI.delay(3)

//REFUSE WITH REASON
'154 Select - reason DMI new brief/...'
functions.I.SelectFromList_Value('//*[@id="listbox_rejection_doc"]', '2')

'Click refuse'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="disable_rejectionButton"]']))

'Screenshot: ref list '
WebUI.takeScreenshot()

Double task11_apetit = functions.I.Get_Task_No('//*[@id="kt_header"]/div/div[2]/div[1]/div[1]')

WebUI.verifyEqual(task11_apetit + 1, task10_apetit)

functions.I.Logout()

'Login as jedun '
functions.I.Login_password('jedun', password_jedun)

'LHS click the project tab'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="menu_2"]/a']))

'Search project no'
functions.I.SearchProjectNo_xpath(Project_No, '//*[@id="keynum_project"]', '//*[@id="form_filters"]/div[7]/button')

WebUI.delay(1)

'Screenshot: ref List page '
WebUI.takeScreenshot()

'Upload doc'
String color3 = WebUI.getCSSValue(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID1) + '"]/td[17]/a[3]']), 
    'color', FailureHandling.OPTIONAL)

'148'
while (color3 == 'rgba(255, 255, 255, 1)') {
    WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID1) + '"]/td[17]/a[3]']))

    'Supplier Upload doc for production phase'
    WebUI.takeScreenshot()

    //UPLOAD A DOC
    functions.I.UploadDoc_sendkey_Prod(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_body"]/input[2]']), 
        'D:\\Upoad_File\\Upload doc\\testdata1.pdf', 'testdata1.pdf')

    'Screenshot: Production phase Field Upload doc'
    WebUI.takeScreenshot()

    WebUI.delay(10)

    //REF PAGE: CLICK ON PROCEED TO NEXT PHASE
    functions.I.click_button_javascript(findTestObject('Object Repository/HL Full Lifecycle/12 ReferncePage_Button_Updatensenddoc'))

    WebUI.delay(5)

    ////*[@id="source_24446"]/td[15]/a[2]
    if (WebUI.verifyElementPresent(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID1) + '"]/td[17]/a[3]']), 
        10, FailureHandling.OPTIONAL)) {
        color3 = WebUI.getCSSValue(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID1) + '"]/td[17]/a[3]']), 
            'color', FailureHandling.OPTIONAL)
    } else {
        color3 = 'white'
    }
}

'Screenshot: ref List page '
WebUI.takeScreenshot()

//PART 1
'click on ref link'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID1) + '"]/td[8]/a']))

WebUI.delay(1)

'Click on the doc tab'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_content"]/div[3]/div/ul/li[2]/a']))

WebUI.delay(1)

'Screenshot: doc tab page '
WebUI.takeScreenshot()

WebUI.delay(3)

'Click on the approval workflow'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="aff_doc_AW"]']))

WebUI.delay(3)

////*[@id="level_apl_2"]/div[2]/div[2]/div/div
'Mouse Over'
WebUI.mouseOver(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="level_apl_0"]/div[2]/div[2]/div[1]/div/div[1]/img']))

'177 Click on ? to approve for others'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="level_apl_0"]/div[2]/div[2]/div[1]/div/div[6]/a[2]/span']))

WebUI.delay(1)

'Click on APPROVE'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="btn_appfor"]']))

/*
//PART 2
'179 click on ref link'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID1) + '"]/td[8]/a']))

WebUI.delay(1)

'Click on the doc tab'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_content"]/div[3]/div/ul/li[2]/a']))

WebUI.delay(1)

'Screenshot: doc tab page '
WebUI.takeScreenshot()

'Click on approval worklfow'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_content"]/div[3]/div/ul/li[2]/a']))

WebUI.delay(1)

'Click on the approval tab'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="aff_doc_AW"]']))
*/
WebUI.delay(3)

'Mouse Over'
WebUI.mouseOver(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="level_apl_1"]/div[2]/div[2]/div[1]/div/div[1]/img']))

////*[@id="level_apl_1"]/div[2]/div[2]/div[1]/div/div[6]/a[2]/span
'Click on ? to approve for others'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="level_apl_1"]/div[2]/div[2]/div[1]/div/div[6]/a[2]/span']))

WebUI.delay(1)

'Click on APPROVE'
functions.I.click_button_javascriptS('//*[@id="btn_appfor"]')

/*
//PART 3
'click on ref link'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID1) + '"]/td[8]/a']))

WebUI.delay(1)

'Click on the doc tab'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_content"]/div[3]/div/ul/li[2]/a']))

WebUI.delay(1)

'Screenshot: doc tab page '
WebUI.takeScreenshot()

'Click on the approval tab'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="aff_doc_AW"]']))

WebUI.delay(1)
*/
WebUI.delay(3)

'Mouse Over'
WebUI.mouseOver(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="level_apl_1"]/div[2]/div[2]/div[2]/div/div[1]/img']))

'Click on ? to approve for others'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="level_apl_1"]/div[2]/div[2]/div[2]/div/div[6]/a[2]/span']))

WebUI.delay(1)

'Click on APPROVE'
functions.I.click_button_javascriptS('//*[@id="btn_appfor"]')

functions.I.Logout()

'Login as apetit '
functions.I.Login_password('apetit', password_apetit)

'Screenshot: Dashboard page '
WebUI.takeScreenshot()

Double task20_apetit = functions.I.Get_Task_No('//*[@id="kt_header"]/div/div[2]/div[1]/div[1]')

'LHS click the project tab'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="menu_2"]/a']))

'Search project no'
functions.I.SearchProjectNo_xpath(Project_No, '//*[@id="keynum_project"]', '//*[@id="form_filters"]/div[8]/button')

WebUI.delay(1)

'Screenshot: ref List page '
WebUI.takeScreenshot()

WebUI.delay(1)

'Click on the extender '
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID1) + '"]/td[15]/a[1]']))

//approve on viewer
'Wait for page load'
WebUI.waitForPageLoad(5)

'Mouse over viwer'
WebUI.mouseOver(findTestObject('Object Repository/HL Full Lifecycle/Function_access Viewer2'))

WebUI.delay(2)

'Click on viewer'
WebUI.click(findTestObject('Object Repository/HL Full Lifecycle/Function_access Viewer2'))

WebUI.delay(1)

'Screenshot: Viewver '
WebUI.takeScreenshot()

'62 On greenlight viewer: Click on approve'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="BtnapproveButton"]']))

WebUI.delay(5)

'206 settext : ACI 200192562A'
WebUI.setText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_68"]']), '200192562A')

WebUI.delay(3)

'click approve'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="approveButton"]']))

'Screenshot: ref list '
WebUI.takeScreenshot()

Double task21_apetit = functions.I.Get_Task_No('//*[@id="kt_header"]/div/div[2]/div[1]/div[1]')

'89'
WebUI.verifyEqual(task21_apetit + 1, task20_apetit)

functions.I.Logout()

'Login as jedun '
functions.I.Login_password('jedun', password_jedun)

'LHS click the project tab'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="menu_2"]/a']))

'Search project no'
functions.I.SearchProjectNo_xpath(Project_No, '//*[@id="keynum_project"]', '//*[@id="form_filters"]/div[7]/button')

WebUI.delay(1)

'Screenshot: ref List page '
WebUI.takeScreenshot()

'click submit'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID1) + '"]/td[17]/a[3]']))

'Upload file'
functions.I.UploadDoc_sendkey_field('//*[@id="var_181"]', 'D:\\Upoad_File\\Upload doc\\testdata1.pdf', 'testdata1.pdf')

'click submit'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[3]/div/button[2]']))

'Screenshot: ref List page '
WebUI.takeScreenshot()

functions.I.Logout()

'Login as mcazeaux '
functions.I.Login_password('mcazeaux', password_mcazeaux)

Double task31_aomoto = functions.I.Get_Task_No('//*[@id="kt_header"]/div/div[2]/div[1]/div[1]')

'Click on task'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_header"]/div/div[2]/div[1]/div[1]/div']))

WebUI.delay(1)

'Click on see all'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_header"]/div/div[2]/div[1]/div[2]/form/div[3]/a']))

WebUI.delay(1)

'Screenshot: task page '
WebUI.takeScreenshot()

'Change pagination'
functions.I.SelectFromList_Value('//*[@id="kt_content"]/div[3]/div/div/div[1]/div[1]/div/form/select', '250')

WebUI.delay(1)

int l = 1

//TASK PAGE
'285'
while (l <= task31_aomoto) {
    String resulta = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : ('/html/body/div[1]/div[2]/div[8]/div[3]/div/div/div[2]/div/table/tbody/tr[' + 
                l) + ']']))

    ///html/body/div[1]/div[2]/div[8]/div[3]/div/div/div[2]/div/table/tbody/tr[13]/td[1]/a
    if (resulta.contains(Project_No)) {
        WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : ('/html/body/div[1]/div[2]/div[8]/div[3]/div/div/div[2]/div/table/tbody/tr[' + 
                    l) + ']/td[1]/a']))

        break
    } else {
        l = (l + 1)
    }
}

////
'Screenshot: ref list pg '
WebUI.takeScreenshot()

WebUI.delay(1)

'Upload doc'
String color4 = WebUI.getCSSValue(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID1) + '"]/td[15]/a[2]']), 
    'color', FailureHandling.OPTIONAL)

'148'
while (color4 == 'rgba(255, 255, 255, 1)') {
    WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID1) + '"]/td[15]/a[2]']))

    'Supplier Upload doc for production phase'
    WebUI.takeScreenshot()

    //UPLOAD A DOC
    functions.I.UploadDoc_sendkey_Prod(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_body"]/input[2]']), 
        'D:\\Upoad_File\\Upload doc\\testdata1.pdf', 'testdata1.pdf')

    'Screenshot: Production phase Field Upload doc'
    WebUI.takeScreenshot()

    WebUI.delay(10)

    //REF PAGE: CLICK ON PROCEED TO NEXT PHASE
    functions.I.click_button_javascript(findTestObject('Object Repository/HL Full Lifecycle/12 ReferncePage_Button_Updatensenddoc'))

    WebUI.delay(5)

    ////*[@id="source_24446"]/td[15]/a[2]
    if (WebUI.verifyElementPresent(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID1) + '"]/td[15]/a[2]']), 
        10, FailureHandling.OPTIONAL)) {
        color4 = WebUI.getCSSValue(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID1) + '"]/td[15]/a[2]']), 
            'color', FailureHandling.OPTIONAL)
    } else {
        color4 = 'white'
    }
}

'Screenshot: ref List page '
WebUI.takeScreenshot()

Double task32_aomoto = functions.I.Get_Task_No('//*[@id="kt_header"]/div/div[2]/div[1]/div[1]')

WebUI.verifyEqual(task32_aomoto + 1, task31_aomoto)

functions.I.Logout()

'Login as aomoto '
functions.I.Login_password('aomoto', password_aomoto)

'Screenshot: Dashboard page '
WebUI.takeScreenshot()

Double task9_aomoto = functions.I.Get_Task_No('//*[@id="kt_header"]/div/div[2]/div[1]/div[1]')

'LHS click the project tab'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="menu_2"]/a']))

'Search project no'
functions.I.SearchProjectNo_xpath(Project_No, '//*[@id="keynum_project"]', '//*[@id="form_filters"]/div[8]/button')

WebUI.delay(1)

'Screenshot: ref List page '
WebUI.takeScreenshot()

'Click on the extender '
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID1) + '"]/td[15]/a[1]']))

WebUI.delay(1)

functions.I.AWF_approve_view()

WebUI.delay(1)

'Screenshot: ref list '
WebUI.takeScreenshot()

'Click on the extender '
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID1) + '"]/td[15]/a[1]']))

WebUI.delay(1)

functions.I.AWF_approve_view()

WebUI.delay(1)

'Screenshot: ref list '
WebUI.takeScreenshot()

Double task8_aomoto = functions.I.Get_Task_No('//*[@id="kt_header"]/div/div[2]/div[1]/div[1]')

WebUI.verifyEqual(task8_aomoto + 1, task9_aomoto)

functions.I.Logout()

'Login as aomoto '
functions.I.Login_password('daguirre', password_daguirre)

'Screenshot: Dashboard page '
WebUI.takeScreenshot()

Double task9_daguirre = functions.I.Get_Task_No('//*[@id="kt_header"]/div/div[2]/div[1]/div[1]')

'LHS click the project tab'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="menu_2"]/a']))

'Search project no'
functions.I.SearchProjectNo_xpath(Project_No, '//*[@id="keynum_project"]', '//*[@id="form_filters"]/div[4]/button')

WebUI.delay(1)

'Screenshot: ref List page '
WebUI.takeScreenshot()

'Click on the extender '
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID1) + '"]/td[15]/a[1]']))

WebUI.delay(1)

functions.I.AWF_approve_view()

WebUI.delay(1)

'Screenshot: ref list '
WebUI.takeScreenshot()

Double task8_daguirre = functions.I.Get_Task_No('//*[@id="kt_header"]/div/div[2]/div[1]/div[1]')

WebUI.verifyEqual(task8_daguirre + 1, task9_daguirre)

functions.I.Logout()

'Login as apetit '
functions.I.Login_password('apetit', password_apetit)

'Screenshot: Dashboard page '
WebUI.takeScreenshot()

Double task6_apetit = functions.I.Get_Task_No('//*[@id="kt_header"]/div/div[2]/div[1]/div[1]')

'LHS click the project tab'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="menu_2"]/a']))

'Search project no'
functions.I.SearchProjectNo_xpath(Project_No, '//*[@id="keynum_project"]', '//*[@id="form_filters"]/div[8]/button')

WebUI.delay(1)

'Screenshot: ref List page '
WebUI.takeScreenshot()

WebUI.delay(1)

'Click on the extender '
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID1) + '"]/td[15]/a[1]']))

WebUI.delay(1)

functions.I.AWF_approve_view()

WebUI.delay(1)

'Screenshot: ref list '
WebUI.takeScreenshot()

Double task5_apetit = functions.I.Get_Task_No('//*[@id="kt_header"]/div/div[2]/div[1]/div[1]')

WebUI.verifyEqual(task5_apetit + 1, task6_apetit)

'Verify lifecycle is Complete'
functions.I.VerifyMatchText(('//*[@id="source_' + refID1) + '"]/td[14]/span', 'Complete')

'Close Browser'
WebUI.closeBrowser()

