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

String password_aamiot = data_Tag.getValue(3, 29)

String password_daguirre = data_Tag.getValue(3, 30 //R
    )

String password_aomoto = data_Tag.getValue(3, 31 //R
    )

String password_apetit = data_Tag.getValue(3, 32 //R
    )

//DATA FIELD URL
def data_urlTESTAUTO = TestDataFactory.findTestData('Data Files/URL/URL_testauto')

String Url_Tag = data_urlTESTAUTO.getValue(2, 3)


//CLEAR NOTEPAD
functions.I.clearnotepad('D:\\Upoad_File\\zTest_Auto\\Test_Projet_Login\\Tag\\302.06 Tag_Project\\302.06_Tag_ProjectNo.txt')

functions.I.clearnotepad('D:\\Upoad_File\\zTest_Auto\\Test_Projet_Login\\Tag\\302.06 Tag_Project\\302.06_Tag_refID1.txt')

functions.I.clearnotepad('D:\\Upoad_File\\zTest_Auto\\Test_Projet_Login\\Tag\\302.06 Tag_Project\\302.06_Tag_refID2.txt')

///////////////////////////// TEST BEGIN /////////////////////////////////////////
//BROWSE & MAXIMIZE BROWSER
'Navigate to URL Tag Release'
WebUI.openBrowser(Url_Tag)

WebUI.maximizeWindow()

WebUI.waitForPageLoad(30)

'Screenshot: Navigate to URL Tag Release'
WebUI.takeScreenshot()

'Login as aomoto '
functions.I.Login_password('aomoto', password_aomoto)

'Get task no - Aomoto'
Double task1_aomoto = functions.I.Get_Task_No('//*[@id="kt_header"]/div/div[2]/div[1]/div[1]')

if (task1_aomoto >= 5) {
    WebUI.verifyEqual(task1_aomoto, '4', false)
} else {
    WebUI.verifyEqual(task1_aomoto, task1_aomoto)
}

'Logout as aomoto'
functions.I.Logout()

'Login as apetit '
functions.I.Login_password('apetit', password_apetit)

'Get task no - apetit'
Double task1_apetit = functions.I.Get_Task_No('//*[@id="kt_header"]/div/div[2]/div[1]/div[1]')

if (task1_apetit >= 4) {
    WebUI.verifyEqual(task1_apetit, '5', false)
} else {
    WebUI.verifyEqual(task1_apetit, task1_apetit)
}

'Logout as apetit'
functions.I.Logout()

// DMI ACE CEREAVE CREATION OF PROJECT
'Login as dmi_acd_cerave : daguirre '
functions.I.Login_password('daguirre', password_daguirre)

'Click on the lhs menu - project tab'
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

///CREATION OF PROJECT
'Click on + to create project'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_content"]/div[3]/div/div/div[1]/div[2]/a[1]']))

WebUI.delay(1)

'Screenshot: Modify  a project'
WebUI.takeScreenshot()

def Project_name = (('AutoTag_FullLifecyle_' + org.apache.commons.lang.RandomStringUtils.randomAlphanumeric(3)) + '_') + 
functions.I.gettimedate()

'Enter Project name'
WebUI.setText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_141"]']), Project_name)

'Project type - LAUNCH: New range, new product'
functions.I.SelectFromList_Value('//*[@id="var_12"]', '1025')

'Verify that domain is Packaging'
functions.I.VerifyMatchText('//*[@id="select2-var_116-container"]', ('×' + '\n') + 'Packaging')

'Development zone - Zone Europe'
functions.I.SelectFromList_Value('//*[@id="var_262"]', '16352')

'Enter PAD date 10/10/2020'
WebUI.setText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_14"]']), '10/10/2020')

WebUI.delay(2)

'Verify that Division - ACD'
functions.I.VerifyMatchText('//*[@id="select2-var_15-container"]', ('×' + '\n') + 'ACD')

WebUI.delay(2)

' Verify that Signature - CeraVe'
functions.I.VerifyMatchText('//*[@id="select2-var_16-container"]', ('×' + '\n') + 'CeraVe')

WebUI.delay(2)

'VErify that Franchise  - CeraVe'
functions.I.VerifyMatchText('//*[@id="select2-var_17-container"]', ('×' + '\n') + 'CeraVe')

WebUI.delay(2)

'Select Brand - Acne'
functions.I.SelectFromList_Value('//*[@id="var_18"]', '14527')

'Select SubBrand - Acne Body Wash'
functions.I.SelectFromList_Value('//*[@id="var_19"]', '15641')

'Select Axis - Fragrance'
functions.I.SelectFromList_Value('//*[@id="var_20"]', '3773')

'Select SubAxis - Men Fragrance'
functions.I.SelectFromList_Value('//*[@id="var_21"]', '246')

'Select Metier - Men fragrances '
functions.I.SelectFromList_Value('//*[@id="var_22"]', '3854')

'Verify DMI contact is selected - David Aguirre'
functions.I.VerifyMatchText('//*[@id="selDest_23"]', 'David Aguirre')

'Select another dmi - aomoto'
functions.I.select_multiplelist('//*[@id="selSource_23"]', '//*[@id="btnAdd_23"]', 'aomoto')

WebUI.delay(1)

'Select C&A contacts - apetit'
functions.I.select_multiplelist('//*[@id="selSource_24"]', '//*[@id="btnAdd_24"]', 'apetit')

WebUI.delay(5)

'Click on update project'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[3]/div/button']))

WebUI.delay(2)

'Get project no.'
String Project_No = functions.I.ProjectNo()

'Screenshot: Ref List page '
WebUI.takeScreenshot()

WebUI.delay(2)

'Click on + create ref'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="create_ref_btn"]/button']))

WebUI.delay(1)

'Click on 1st option: create ref'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="create_ref_btn"]/div/a[1]']))

WebUI.delay(1)

'Screenshot: Ref creation page '
WebUI.takeScreenshot()

'Select Reference Template - Multiple artwork without master design '
functions.I.SelectFromList_Value('//*[@id="ref_type"]', '8')

'Click on save'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="createRefBottom"]']))

'Screenshot: Ref modif page '
WebUI.takeScreenshot()

'Enter mkt product name'
WebUI.setText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_117"]']), 'TC18_AUTO_MOTHERREF')

'Select Product category -Fake '
functions.I.SelectFromList_Value('//*[@id="var_57"]', '134')

'Select Packaging Family - Beauty Seal '
functions.I.SelectFromList_Value('//*[@id="var_28"]', '1194')

'Select Packaging type -  Secondary'
functions.I.SelectFromList_Value('//*[@id="var_228"]', '15723')

'Enter Capacity: 100'
WebUI.setText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_54"]']), '100')

'Select Capacity Unit - CM2'
functions.I.SelectFromList_Value('//*[@id="var_55"]', '122')

'Get the Ref id'
String refID = functions.I.RefID_tag()

WebUI.delay(2)

WebUI.scrollToElement(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_91"]']), 2)

'Click on save'
functions.I.click_button_javascriptS('/html/body/div[1]/div[2]/div[4]/div[3]/div/div[2]/form/div[3]/div[1]/button')

WebUI.delay(2)

'Screenshot: Ref List page '
WebUI.takeScreenshot()

'Logout as daguirre'
functions.I.Logout()

//ADMIN SUPER EDIT
'Login as jedun '
functions.I.Login_password('jedun', password_jedun)

'LHS click the project tab'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="menu_2"]/a']))

'Search project no'
functions.I.SearchProjectNo_xpath(Project_No, '//*[@id="keynum_project"]', '//*[@id="form_filters"]/div[7]/button')

WebUI.delay(2)

'super edit'
functions.I.superedit_ref(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID) + '"]/td[15]/div[2]/button']), 
    findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID) + '"]/td[15]/div[2]/div/a[4]']))

'Screenshot: ref modif page '
WebUI.takeScreenshot()

'Select 00002309 - AUTAJON LABELS | FRA, Clermont-Ferrand'
functions.I.SelectFromList_Value('//*[@id="var_48"]', '925')

'Enter Printer : 200192562A'
WebUI.setText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_27"]']), '200192562A')

'124 Click update'
functions.I.click_button_javascriptS('//*[@id="ModifFiche"]/div[1]/div/button')

'Logout as jedun'
functions.I.Logout()

///STEP 1  Brief only  >  PHASE 1 DMI: Brief completion
// LOG IN AS DEMI ACD 
'Login as aomoto '
functions.I.Login_password('aomoto', password_aomoto)

'Screenshot: Dashboard page '
WebUI.takeScreenshot()

'Get task no'
double task2_aomoto = functions.I.Get_Task_No('//*[@id="kt_header"]/div/div[2]/div[1]/div[1]/span')

'Click on task notif'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_header"]/div/div[2]/div[1]/div[1]/div']))

WebUI.delay(1)

double n = 1

WebUI.delay(2)

'Screenshot: ref modif page '
WebUI.takeScreenshot()

WebUI.delay(1)

while (n <= task2_aomoto) {
    String result = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="kt_header"]/div/div[2]/div[1]/div[2]/form/div[2]/a[' + 
                n) + ']']), FailureHandling.OPTIONAL)

    if (result.contains('COMPLETE & SEND Common Brief: ____ - CeraVe_Acne_2022_AutoTag_FullLifecyle_')) {
        WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="kt_header"]/div/div[2]/div[1]/div[2]/form/div[2]/a[' + 
                    n) + ']']))

        break
    } else {
        n = (n + 1)
    }
}

'Screenshot: Ref List page '
WebUI.takeScreenshot()

'delay'
WebUI.delay(3)

////*[@id="source_24445"]/td[13]/a[3]
'101 ref list page : Click on submit'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="source_' + refID + '"]/td[13]/a[3]']))

' Screenshot: Ref modif page '
WebUI.takeScreenshot()

'ref modif page: submit'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/button[2]']))

'delay'
WebUI.delay(1)

'Screenshot: Control Tag page '
WebUI.takeScreenshot()

//VERIFY CONTROl TAG
'Verify CT msg'
functions.I.VerifyMatchText('//*[@id="kt_content"]/div[3]/div/div[2]/div[2]/div/div/div/p', 'International artwork agency is missing')

'Click on modify ref'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_content"]/div[3]/div/div[2]/div[3]/div/a']))

'delay'
WebUI.delay(1)

'Screenshot: Ref modif page '
WebUI.takeScreenshot()

'Select International artwork agency - L’Oréal Internal Agency (Creative)'
functions.I.SelectFromList_Value('//*[@id="var_50"]', '16548')

'Pagedown'
functions.I.Pagedown()

'Click on save'
functions.I.click_button_javascriptS('//*[@id="type_save"]')

'Screenshot: Ref List page '
WebUI.takeScreenshot()

'ref list page : Click on submit'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID) + '"]/td[13]/a[3]']))

'Screenshot: Ref modif page '
WebUI.takeScreenshot()

'ref modif page: submit'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/button[2]']))

'delay'
WebUI.delay(1)

'Get task no'
Double task3_aomoto = functions.I.Get_Task_No('//*[@id="kt_header"]/div/div[2]/div[1]/div[1]')

WebUI.verifyEqual(task3_aomoto + 1, task2_aomoto)

WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_header"]/div/div[2]/div[1]/div[1]/div']))

WebUI.delay(1)

double k = 1

while (k <= task3_aomoto) {
    result2 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="kt_header"]/div/div[2]/div[1]/div[2]/form/div[2]/a[' + 
                k) + ']']), FailureHandling.OPTIONAL)

    WebUI.verifyNotMatch(result2, 'COMPLETE & SEND Common Brief: ____ - CeraVe_Acne_2022_' + Project_name, false)

    k = (k + 1)
}

WebUI.delay(1)

'Screenshot: Ref List page '
WebUI.takeScreenshot()

//CREATE DAUGHTER REF
'ref  page: click on + button to create a daughter ref'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID) + '"]/td[13]/a']))

'Screenshot:Daughter  Ref creation page '
WebUI.takeScreenshot()

'Select Lifecycle'
functions.I.SelectFromList_Value('//*[@id="lfc_tpl"]', '94')

'Screenshot:Daughter  Ref creation page '
WebUI.takeScreenshot()

'click on create ref'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="createRefTop"]']))

'delay'
WebUI.delay(1)

'Screenshot: Ref modif page '
WebUI.takeScreenshot()

'ref modif page: click save'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div[1]/a']))

'Click on ref link'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[4]/div[3]/div/div[2]/div[2]/div[1]/table/tbody/tr[2]/td[8]/a']))

'get ref id daughter'
String refID_1 = functions.I.RefID_tag()

'Get task no'
Double task4_aomoto = functions.I.Get_Task_No('//*[@id="kt_header"]/div/div[2]/div[1]/div[1]')

WebUI.verifyEqual(task4_aomoto - 1, task3_aomoto)

WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_header"]/div/div[2]/div[1]/div[1]/div']))

WebUI.delay(1)

int i = 1

while (i <= task4_aomoto) {
    result3 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="kt_header"]/div/div[2]/div[1]/div[2]/form/div[2]/a[' + 
                i) + ']']))

    if (result3.contains('COMPLETE & SEND Artwork Brief: TC18_AUTO_MOTHERREF_Fake_Beauty Seal_100CM2______')) {
        WebUI.verifyMatch('1', '1', false)

        i = (i + 1)

        break
    } else {
        i = (i + 1)
    }
}

'Logout'
functions.I.Logout()

/////////////////////////////QUESTION : Step : Brief only > Phase : C&A: Brief completion
'Login as apetit '
functions.I.Login_password('apetit', password_apetit)

'Screenshot: Ref modif page '
WebUI.takeScreenshot()

'Get task no'
Double task2_apetit = functions.I.Get_Task_No('//*[@id="kt_header"]/div/div[2]/div[1]/div[1]')

WebUI.verifyEqual(task2_apetit - 1, task1_apetit)

int a = 1

//DAshboard 
while (a <= task2_apetit) {
    b = (a + 1)

    result = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="widg_20200728_091929_587E6645P"]/div/div[2]/div/div/table/tbody/tr[' + 
                b) + ']/td[1]/a']), FailureHandling.OPTIONAL)

    if (result.contains('COMPLETE & SEND Common Brief: TC18_AUTO_MOTHERREF_Fake_Beauty Seal_100CM2_ - CeraVe_Acne_2022_' + 
        Project_name)) {
        WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="widg_20200728_091929_587E6645P"]/div/div[2]/div/div/table/tbody/tr[' + 
                    b) + ']/td[1]/a']))

        break
    } else {
        a = (a + 1)
    }
}

'Screenshot: Ref list page '
WebUI.takeScreenshot()

WebUI.delay(1)

'click on submit'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID) + '"]/td[15]/a[2]']))

WebUI.delay(1)

'Screenshot: Ref modif page '
WebUI.takeScreenshot()

'Question: refuse '
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/div/button']))

WebUI.delay(1)

'Click on 2nd option'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/div/div/a[2]']))

WebUI.delay(1)

'Screenshot: Ref modif page '
WebUI.takeScreenshot()

WebUI.delay(1)

'Click on submit'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[3]/div/button[2]']))

//WebUI.waitForElementPresent(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="toast-container"]/div']), 30)

'Toastr: REFERENCE BRIEF VALIDATION ERRORS : AUTO_MOTHERREF_Fake_Beauty Seal_100CM2_ '
String Expected_toastr1 = ((((('×' + '\n') + 'Error') + '\n\n') + 'REFERENCE BRIEF VALIDATION ERRORS : TC18_AUTO_MOTHERREF_Fake_Beauty Seal_100CM2_') + 
'\n') + 'Reason for sending back to MKT is missing'

functions.I.VerifyMatchToastrmsg('//*[@id="toast-container"]/div', Expected_toastr1)

'Screenshot: Toastr '
WebUI.takeScreenshot()

'Click on cancel'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/a']))

WebUI.delay(1)

'Screenshot: Ref list page '
WebUI.takeScreenshot()

'click on submit'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID) + '"]/td[15]/a[2]']))

WebUI.delay(1)

'Screenshot: Ref modif page '
WebUI.takeScreenshot()

'SElect Question: refuse '
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/div/button']))

WebUI.delay(1)

'Click on 2nd option'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/div/div/a[2]']))

WebUI.delay(1)

'Screenshot: Ref modif page '
WebUI.takeScreenshot()

WebUI.delay(1)

'Set text: Reason for sending back to MKT'
WebUI.setText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_151"]']), 'Reason for sending back to MKT > Test')

'Click on submit'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[3]/div/button[2]']))

'Get task no'
Double task3_apetit = functions.I.Get_Task_No('//*[@id="kt_header"]/div/div[2]/div[1]/div[1]')

WebUI.verifyEqual(task3_apetit + 1, task2_apetit)

'Logout as apeitit'
functions.I.Logout()

///////////////////////////Mother ref > RESFUSE DMI: Brief completion
'Login as aomoto '
functions.I.Login_password('aomoto', password_aomoto)

'Screenshot: Dashboard page '
WebUI.takeScreenshot()

Double task5_aomoto = functions.I.Get_Task_No('//*[@id="kt_header"]/div/div[2]/div[1]/div[1]')

WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_header"]/div/div[2]/div[1]/div[1]/div']))

WebUI.delay(5)

int c = 1

while (c <= task5_aomoto) {
    result10 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="kt_header"]/div/div[2]/div[1]/div[2]/form/div[2]/a[' + 
                c) + ']']))

    if (result10.contains('TC18_')) {
        WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="kt_header"]/div/div[2]/div[1]/div[2]/form/div[2]/a[' + 
                    c) + ']']))

        break
    } else {
        c = (c + 1)
    }
}

'Screenshot: ref list page '
WebUI.takeScreenshot()

'223 Click on submit'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID) + '"]/td[15]/a[3]']))

WebUI.delay(1)

'Screenshot: ref modif page '
WebUI.takeScreenshot()

WebUI.delay(1)

'Click on submit'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/button[2]']))

Double task6_aomoto = functions.I.Get_Task_No('//*[@id="kt_header"]/div/div[2]/div[1]/div[1]')

WebUI.verifyEqual(task6_aomoto + 1, task5_aomoto)

'Logout'
functions.I.Logout()

///////////////////////QUESTION OPTION 1
'Login as apetit '
functions.I.Login_password('apetit', password_apetit)

'Screenshot: Ref modif page '
WebUI.takeScreenshot()

'Get task no'
Double task10_apetit = functions.I.Get_Task_No('//*[@id="kt_header"]/div/div[2]/div[1]/div[1]')

int pl = 1

while (pl <= task10_apetit) {
    zz = (pl + 1)

    result = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : ('/html/body/div[1]/div[2]/div[4]/div[3]/div/div[5]/div[2]/div[1]/div/div[2]/div/div/table/tbody/tr[' + 
                zz) + ']/td[1]/a']), FailureHandling.OPTIONAL)

    if (result.contains('COMPLETE & SEND Common Brief: TC18_AUTO_MOTHERREF_Fake_Beauty Seal_100CM2_ - CeraVe_Acne_2022_' + 
        Project_name)) {
        WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : ('/html/body/div[1]/div[2]/div[4]/div[3]/div/div[5]/div[2]/div[1]/div/div[2]/div/div/table/tbody/tr[' + 
                    zz) + ']/td[1]/a']))

        break
    } else {
        pl = (pl + 1)
    }
}

'Screenshot: Ref list page '
WebUI.takeScreenshot()

WebUI.delay(1)

'click on submit'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID) + '"]/td[15]/a[2]']))

WebUI.delay(1)

'Screenshot: Ref modif page '
WebUI.takeScreenshot()

'Question: Submit '
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/div/button']))

WebUI.delay(1)

'Click on 1st option'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/div/div/a[1]']))

WebUI.delay(1)

'Get task no'
Double task9_apetit = functions.I.Get_Task_No('//*[@id="kt_header"]/div/div[2]/div[1]/div[1]')

WebUI.verifyEqual(task9_apetit, task10_apetit - 1)

WebUI.delay(1)

'Verify lifecycle Stattus'
functions.I.VerifyMatchText(('//*[@id="source_' + refID) + '"]/td[14]/span', 'Complete')

//Write NOTEPAD
functions.I.writenotepad('D:\\Upoad_File\\zTest_Auto\\Test_Projet_Login\\Tag\\302.06 Tag_Project\\302.06_Tag_ProjectNo.txt', Project_No)

functions.I.writenotepad('D:\\Upoad_File\\zTest_Auto\\Test_Projet_Login\\Tag\\302.06 Tag_Project\\302.06_Tag_refID1.txt', refID)

functions.I.writenotepad('D:\\Upoad_File\\zTest_Auto\\Test_Projet_Login\\Tag\\302.06 Tag_Project\\302.06_Tag_refID2.txt', refID_1)

'Close Browser'
WebUI.closeBrowser()

