import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import org.junit.After as After
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

//CHANGES DONE ON: 28/04/2022 @13.53
/////////////////////////////SCENARIO NPP : LSS LIFECYCLE (2) /////////////////////
//STEP 1: CREATION
//PHASE 1 : LSS PREFILL
//Step 2 : Approval
//Step 5 : Effective
//Step 6 : Deactive
//String Project_No = 'MI000826'
//String refID = '1057539'
///////////////////////////USERNAME - PASSWORD - URL////////////////////////////////////
//USERNAME & PASSWORD  - NPP
def data_Npp = TestDataFactory.findTestData('Data Files/Username_Password/Test_Npp')

String password_akim = data_Npp.getValue(2, 2 //R
    )

String password_abrazhnikovapx = data_Npp.getValue(2, 4 //R
    )

String password_afrappaz = data_Npp.getValue(2, 5 //R
    )

String password_alarkins = data_Npp.getValue(2, 6 //R
    )

String password_cdemonchy = data_Npp.getValue(2, 7 //R
    )

//URL
def data_urlTESTAUTO = TestDataFactory.findTestData('Data Files/URL/URL_testauto')

String Url_Npp = data_urlTESTAUTO.getValue(2, 5)

////////////////////////////NAVIGATE TO NPP ///////////////////////////////////
'Navigate to NPP'
WebUI.openBrowser(Url_Npp)

WebUI.maximizeWindow()

'Screenshot: Navigate to Npp'
WebUI.takeScreenshot()

////////////////////////////CREATION OF PROJECT - LSS ///////////////////////////////////
'Log in as Product Platform – All users'
functions.I.Login_password('akim', password_akim)

'Go to the project tab'
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

'Click on + to create a project > redirect to the page modify project '
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//div[@id=\'kt_content\']/div[3]/div/div/div/div[2]/a/i']))

////////////////////////////MODIFY PROJECT PAGE- LSS ///////////////////////////////////
'Screenshot: Modify project page'
WebUI.takeScreenshot()

'On the modify project page : Fill in all field'

//LSS GENERAL INFO
'Enter text : LSS number'
def LSSNumber_name = (('TC502.09_AutoTest_Npp_FullLifecycle_' + org.apache.commons.lang.RandomStringUtils.randomAlphanumeric(
    10)) + '_') + functions.I.gettimedate()

WebUI.setText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_70"]']), LSSNumber_name)

WebUI.delay(1)

//RECIPE
'Select from Technology list - Litter'
WebUI.selectOptionByValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_107"]']), '2420', false)

WebUI.delay(3)

'22 Select from Texture multiple list - Corn '
functions.I.select_multiplelist('//*[@id="selSource_108"]', '//*[@id="btnAdd_108"]', '2354')

WebUI.delay(1)

'Enter text: Variety'
WebUI.setText(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="var_110"]']), 'Variety test')

WebUI.delay(1)

'Enter Text: Alternative Format code'
WebUI.setText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_133"]']), 'Alternative Format code test ')

WebUI.delay(1)

'Enter Text: FORMAT Product designation'
WebUI.setText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_65"]']), 'FORMAT Product designation test ')

//PROJECT INFO
'Select from Project type multiple list - HIP'
functions.I.select_multiplelist('//*[@id="selSource_91"]', '//*[@id="btnAdd_91"]', '1023')

'Select date- LSS Planned issue date'
WebUI.setText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_71"]']), '25/08/2021')

'Enter text - Project Information - Comments'
WebUI.setText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_89"]']), 'Project Information - Comments')

'Enter text - Reason for change'
WebUI.setText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_93"]']), 'Reason for change test')

//PRODUCT INFO
'Select from Brands - BRANDS '
functions.I.select_multiplelist('//*[@id="selSource_54"]', '//*[@id="btnAdd_54"]', '1081')

WebUI.delay(5)

'Select from multiple list subbrand - Tidy Cat - CRYSTALS BLEND '
functions.I.select_multiplelist('//*[@id="selSource_106"]', '//*[@id="btnAdd_106"]', '2787')

'Select from Range type - Premium'
WebUI.selectOptionByValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_92"]']), '1298', false)

'Select from multiple list Product descriptor - Superfood '
functions.I.select_multiplelist('//*[@id="selSource_88"]', '//*[@id="btnAdd_88"]', '1303')

'Select from multiple list Presence of colors - No color '
functions.I.select_multiplelist('//*[@id="selSource_86"]', '//*[@id="btnAdd_86"]', '1310')

'Select from multiple list Colors - Not applicable '
functions.I.select_multiplelist('//*[@id="selSource_57"]', '//*[@id="btnAdd_57"]', '2304')

'Select from List Presence of vegetables - yes'
WebUI.selectOptionByValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_87"]']), '971', false)

'Select from List Type of feed - Complete'
WebUI.selectOptionByValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_109"]']), '1325', false)

'Select from List Animal species - Cats & Dogs'
WebUI.selectOptionByValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_52"]']), '1330', false)

'Select from multiple list Lifestage - Superfood '
functions.I.select_multiplelist('//*[@id="selSource_67"]', '//*[@id="btnAdd_67"]', '1624')

'Select from List Lifestyle - Light'
WebUI.selectOptionByValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_140"]']), '2296', false)

'Select from multiple list Animal size - All '
functions.I.select_multiplelist('//*[@id="selSource_51"]', '//*[@id="btnAdd_51"]', '1673')

'Select from multiple list Animal activity level - Acctive '
functions.I.select_multiplelist('//*[@id="selSource_50"]', '//*[@id="btnAdd_50"]', '1681')

//Production
'Line 46: Select from multiple list Factories - 2 options '
WebUI.selectOptionByValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="selSource_64"]']), '1701', false)

functions.I.select_multiplelist('//*[@id="selSource_64"]', '//*[@id="btnAdd_64"]', '1688')

'Select from multiple list Back-up factories - 1 option '
functions.I.select_multiplelist('//*[@id="selSource_53"]', '//*[@id="btnAdd_53"]', '1701')

'Select from multiple list Back-up factories - Comanufacturers '
functions.I.select_multiplelist('//*[@id="selSource_58"]', '//*[@id="btnAdd_58"]', '1704')

'Select from multiple list Copackers - Deuerer '
functions.I.select_multiplelist('//*[@id="selSource_59"]', '//*[@id="btnAdd_59"]', '1706')

'Select from multiple list Manufacturing method - Mousse '
functions.I.select_multiplelist('//*[@id="selSource_73"]', '//*[@id="btnAdd_73"]', '3147')

//Team
'Is Local RSA RU approval required ? - Yes'
WebUI.selectOptionByValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_66"]']), '2401', false)

'Is Local RSA FR approval required ? - Yes'
WebUI.selectOptionByValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_142"]']), '2403', false)

'Is Local RSA UK approval required ? - Yes'
WebUI.selectOptionByValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_143"]']), '2405', false)

//Packaging and distribution
'Select from multiple list Expected commercialisation zone - LATAM '
functions.I.select_multiplelist('//*[@id="selSource_119"]', '//*[@id="btnAdd_119"]', '2165')

'Screenshot: Modify Project filled'
WebUI.takeScreenshot()

WebUI.delay(10)

'Click on update project'
WebUI.click(findTestObject('HL Full Lifecycle/5 ModifyProjPage_button_Update'))

'Get project no.'
String Project_No = functions.I.ProjectNo()

////////////////////////////REF LIST PAGE + creation ref page ///////////////////////////////////
'Click + to create ref'
WebUI.click(findTestObject('HL Full Lifecycle/6 ReferenceListPage_createrefbutton'))

'Click on the create initial LSS version'
WebUI.click(findTestObject('HL Full Lifecycle/6 ReferenceListPaga_Create a component_button'))

'Screenshot: Create Reference Page: creation ref page'
WebUI.takeScreenshot()

WebUI.selectOptionByValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="lfc_tpl"]']), '51', false)

WebUI.delay(1)

WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[3]/div/button']))

WebUI.delay(1)

////////////////////////////MODIFY REF PAGE///////////////////////////////////
'Get the Ref id'
String refID = functions.I.RefID()

'Screenshot: Modify Ref page (1)'
WebUI.takeScreenshot()

//Recipe
'Enter text - SAP Designation'
WebUI.setText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_103"]']), 'SAP Designation test > https://www.google.com/')

'Enter text - Claim Substantiation Project Link'
WebUI.setText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_139"]']), 'Claim Substantiation Project Link > https://www.google.com/')

'Enter text - Grading standard link'
WebUI.setText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_160"]']), 'Grading standard link > test')

//Project Information
WebUI.scrollToElement(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_90"]']), 10, FailureHandling.OPTIONAL)

'Enter text - Project name'
WebUI.setText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_90"]']), 'Project name > test')

'Enter text - DPET'
WebUI.setText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_62"]']), 'DPET > test')

'Select from multiple list Manufacturing method - Mousse '
functions.I.select_multiplelist('//*[@id="selSource_73"]', '//*[@id="btnAdd_73"]', '3147')

'Screenshot: Modify Ref page (2)'
WebUI.takeScreenshot()

//Team
WebUI.scrollToElement(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_82"]']), 10, FailureHandling.OPTIONAL)

'Select from PP Back-up list - AnneLise GAUDIN'
WebUI.selectOptionByValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_82"]']), 'agaudin', false)

'Product Experience Brand Manager - Alexandra FRAPPAZ'
WebUI.selectOptionByValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_74"]']), 'afrappaz', false)

//functions.I.select_multiplelist('//*[@id="selSource_168"]', '//*[@id="btnAdd_168"]', 'cdemonchy')
'Select from multiple list Additional Product Experience Brand Manager(s) - Camille DEMONCHY '
WebUI.selectOptionByValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="selSource_168"]']), 'cdemonchy', false)

//functions.I.select_multiplelist('//*[@id="selSource_168"]', '//*[@id="btnAdd_168"]', 'alarkins')
WebUI.selectOptionByValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="selSource_168"]']), 'alarkins', false)

functions.I.select_multiplelist('//*[@id="selSource_168"]', '//*[@id="btnAdd_168"]', 'abrazhnikovapx')

'Select from Design to Deliver Manager (D2D) - Adam SVEGAARD (D2D)'
WebUI.selectOptionByValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_60"]']), 'asvegaardd2d', false)

'Select from Central RSA - Amelie SERMENT'
WebUI.selectOptionByValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_102"]']), 'aserment', false)

'Select from E2E Project Manager - Alexandra SAVREUX (E2E)'
WebUI.selectOptionByValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_63"]']), 'asavreux', false)

'Select from Nutritionist - Alexandra SAVREUX (E2E)'
WebUI.selectOptionByValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_161"]']), 'achaves', false)

'Screenshot: Modify Ref page (3)'
WebUI.takeScreenshot()

//Packaging & Distribution
WebUI.scrollToElement(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_143"]']), 10, FailureHandling.OPTIONAL)

'Select from multiple list Pack type - bag (1 options) '
functions.I.select_multiplelist('//*[@id="selSource_79"]', '//*[@id="btnAdd_79"]', '1730')

'Select from multiple list Pack format - 1.1kg & 1.2Kg (2 options)'
WebUI.selectOptionByValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="selSource_78"]']), '1752', false)

functions.I.select_multiplelist('//*[@id="selSource_78"]', '//*[@id="btnAdd_78"]', '1753')

'Select from multiple list Selling countries - Albania & Austria (2 options)  '
WebUI.selectOptionByValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="selSource_104"]']), '73', false)

functions.I.select_multiplelist('//*[@id="selSource_104"]', '//*[@id="btnAdd_104"]', '74')

'Screenshot: Modify Ref page (4)'
WebUI.takeScreenshot()

//Version History
WebUI.scrollToElement(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_169"]']), 10, FailureHandling.OPTIONAL)

'Enter text - Version History'
WebUI.setText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_169"]']), 'Version History')

'Click save'
WebUI.click(findTestObject('HL Full Lifecycle/7 ModifyRefPage_button_Save'))

WebUI.delay(1)

'Logout as ana kim'
functions.I.Logout_xpath('//*[@id="kt_header"]/div/div[2]/div[2]/div[1]/div/span/img', '//*[@id="kt_header"]/div/div[2]/div[2]/div[2]/a[2]')

////////////////////////////VERIFY NO. OF TASK FOR  PARTIAL SUBMISSION -BEFORE///////////////////
//Additional Product Experience Brand Manager(s) = 3 users
//user1 - Anastasiia BRAZHNIKOVA PX
//email  = mediaboxss1@gmail.com / Diadeis*1
functions.I.Login_password('abrazhnikovapx', password_abrazhnikovapx)

WebUI.delay(2)

'50'
String abrazhnikovapx_task_b4 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_header"]/div/div[2]/div[1]/div[1]/span']))

functions.I.print('U1 abrazhnikovapx_task_b4 ' + abrazhnikovapx_task_b4)

double user1_b4

if (abrazhnikovapx_task_b4 == '') {
    user1_b4 = 0
} else {
    user1_b4 = Double.parseDouble(abrazhnikovapx_task_b4)
}

'Task before partial submission: user1 - Anastasiia BRAZHNIKOVA PX'
WebUI.takeScreenshot()

WebUI.delay(1)

'Logout as user 1'
functions.I.Logout_xpath('//*[@id="kt_header"]/div/div[2]/div[2]/div[1]/div/span/img', '//*[@id="kt_header"]/div/div[2]/div[2]/div[2]/a[2]')

//user2 - Amelia LARKINS
functions.I.Login_password('alarkins', password_alarkins)

WebUI.delay(2)

//*[@id="kt_header"]/div/div[2]/div[1]/div[1]/span
'104\r\n'
String alarkins_task_b4 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_header"]/div/div[2]/div[1]/div[1]/span']))

double user2_b4

if (alarkins_task_b4 == '') {
    user2_b4 = 0
} else {
    user2_b4 = Double.parseDouble(alarkins_task_b4)
}

functions.I.print('U2 alarkins_task_b4 ' + user2_b4)

'Task before partial submission: user2 - Amelia LARKINS'
WebUI.takeScreenshot()

WebUI.delay(1)

'Logout as user 2'
functions.I.Logout_xpath('//*[@id="kt_header"]/div/div[2]/div[2]/div[1]/div/span/img', '//*[@id="kt_header"]/div/div[2]/div[2]/div[2]/a[2]')

//user3 - Camille DEMONCHY
functions.I.Login_password('cdemonchy', password_cdemonchy)

WebUI.delay(2)

String cdemonchy_task_b4 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_header"]/div/div[2]/div[1]/div[1]/span']))

functions.I.print('U3 cdemonchy_task_b4 ' + cdemonchy_task_b4)

double user3_b4 = Double.parseDouble(cdemonchy_task_b4)

'Task before partial submission: user3 - Camille DEMONCHY'
WebUI.takeScreenshot()

WebUI.delay(1)

'Logout as user 3'
functions.I.Logout_xpath('//*[@id="kt_header"]/div/div[2]/div[2]/div[1]/div/span/img', '//*[@id="kt_header"]/div/div[2]/div[2]/div[2]/a[2]')

//Product Experience Brand Manager = 1 user
//user 4 - Alexandra FRAPPAZ
functions.I.Login_password('afrappaz', password_afrappaz)

WebUI.delay(2)

String afrappaz_task_b4 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_header"]/div/div[2]/div[1]/div[1]/span']))

functions.I.print('U4 afrappaz_task_b4 ' + afrappaz_task_b4)

double user4_b4

'42'
if (afrappaz_task_b4 == '') {
    user4_b4 = 0
} else {
    user4_b4 = Double.parseDouble(afrappaz_task_b4)
}

'Task before partial submission: user 4 - Alexandra FRAPPAZ'
WebUI.takeScreenshot()

WebUI.delay(1)

'Logout as user 4'
functions.I.Logout_xpath('//*[@id="kt_header"]/div/div[2]/div[2]/div[1]/div/span/img', '//*[@id="kt_header"]/div/div[2]/div[2]/div[2]/a[2]')

//PP Specialist - Technical Leader - 1 user
//user 5 - Anna KIM
functions.I.Login_password('akim', password_akim)

WebUI.delay(2)

String akim_task_b4 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_header"]/div/div[2]/div[1]/div[1]/span']))

functions.I.print('U5 akim_task_b4 ' + akim_task_b4)

double user5_b4

if (akim_task_b4 == '') {
    user5_b4 = 0
} else {
    user5_b4 = Double.parseDouble(akim_task_b4)
}

'Task before partial submission: user 5 - Anna KIM'
WebUI.takeScreenshot()

/////////////////////////////////////////////STEP 1 : CREATION //////////////////////////////////
/////////////////////////////////////////////PHASE 1 : PREFILL //////////////////////////////////
'Ana Click on the lhs menu - project tab'
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

//*[@id="form_filters"]/div[19]/button
'144. search for the project number'
functions.I.SearchProjectNo_xpath(Project_No, '//*[@id="keynum_project"]', '//*[@id="form_filters"]/div[20]/button')

WebUI.delay(5)

'Screenshot: Ref list page - Step 1 : Creation / Phase 1: Prefill  '
WebUI.takeScreenshot()

'Verify Status of the lifecycle'
String Lifecycle_LSS_actual = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="fiches"]/table/tbody/tr/td[7]/span[2]']))

WebUI.verifyMatch('LSS Pre-fill', Lifecycle_LSS_actual, false)

'On the ref list page Click on submit'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="fiches"]/table/tbody/tr/td[9]/a']))

WebUI.delay(2)

////////////////
'Select value inn a multiple list - Texture'
functions.I.select_multiplelist('//*[@id="selSource_108"]', '//*[@id="btnAdd_108"]', '2344')

WebUI.delay(2)

//////////////
'On the ref form: Click on submit form'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/button[2]']))

'Screenshot: S1 (Creation) / P2( LSS Pre-fill)'
WebUI.takeScreenshot()

'Verify Status of the lifecycle'
String Lifecycle_LSS_actual1 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="fiches"]/table/tbody/tr/td[7]/span[2]']))

WebUI.verifyMatch('LSS Creation', Lifecycle_LSS_actual1, false)

///////////////////////////////////////////////////VERIFY NO. OF TASK FOR  PARTIAL SUBMISSION - AFTER///////////////////
//USER 5 ANA KIM
//   //*[@id="kt_header"]/div/div[2]/div[1]/div[1]
'User 5 - Anna kim'
String akim_task_af = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_header"]/div/div[2]/div[1]/div[1]']))

functions.I.print('akim_task_af ' + akim_task_af)

'verify task'
double user5_af = Double.parseDouble(akim_task_af)

'Logout as user5 ana kim'
functions.I.Logout_xpath('//*[@id="kt_header"]/div/div[2]/div[2]/div[1]/div/span/img', '//*[@id="kt_header"]/div/div[2]/div[2]/div[2]/a[2]')

//Additional Product Experience Brand Manager(s) = 3 users
//user1 - Anastasiia BRAZHNIKOVA PX
'Verify Task after submitting 1st phase: user1 - Anastasiia BRAZHNIKOVA PX '
functions.I.Login_password('abrazhnikovapx', password_abrazhnikovapx)

WebUI.delay(2)

String abrazhnikovapx_task_af = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_header"]/div/div[2]/div[1]/div[1]']))

functions.I.print('abrazhnikovapx_task_af ' + abrazhnikovapx_task_af)

double user1_af = Double.parseDouble(abrazhnikovapx_task_af)

'Screnshot: Task before submitting > user1 - Anastasiia BRAZHNIKOVA PX '
WebUI.takeScreenshot()

'Logout as user 1'
functions.I.Logout_xpath('//*[@id="kt_header"]/div/div[2]/div[2]/div[1]/div/span/img', '//*[@id="kt_header"]/div/div[2]/div[2]/div[2]/a[2]')

//user2 - Amelia LARKINS
'Verify Task after submitting 1st phase: user2 - Amelia LARKINS '
functions.I.Login_password('alarkins', password_alarkins)

WebUI.delay(2)

String alarkins_task_af = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_header"]/div/div[2]/div[1]/div[1]']))

functions.I.print('alarkins_task_af ' + alarkins_task_af)

double user2_af = Double.parseDouble(alarkins_task_af)

'Screnshot: Task before submitting > user1 - user2 - Amelia LARKINS '
WebUI.takeScreenshot()

'Logout as user2 - Amelia LARKINS'
functions.I.Logout_xpath('//*[@id="kt_header"]/div/div[2]/div[2]/div[1]/div/span/img', '//*[@id="kt_header"]/div/div[2]/div[2]/div[2]/a[2]')

//user3 - Camille DEMONCHY
'Verify Task after submitting 1st phase: user3 - Camille DEMONCHY '
functions.I.Login_password('cdemonchy', password_cdemonchy)

WebUI.delay(2)

String cdemonchy_task_af = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_header"]/div/div[2]/div[1]/div[1]']))

functions.I.print(' cdemonchy_task_af ' + cdemonchy_task_af)

double user3_af = Double.parseDouble(cdemonchy_task_af)

'Screnshot: Task before submitting > user3 - Camille DEMONCHY '
WebUI.takeScreenshot()

'Logout as user3 - Camille DEMONCHY'
functions.I.Logout_xpath('//*[@id="kt_header"]/div/div[2]/div[2]/div[1]/div/span/img', '//*[@id="kt_header"]/div/div[2]/div[2]/div[2]/a[2]')

//Product Experience Brand Manager = 1 user
//user 4 - Alexandra FRAPPAZ
'Verify Task after submitting 1st phase: user1 - Anastasiia BRAZHNIKOVA PX '
functions.I.Login_password('afrappaz', password_afrappaz)

WebUI.delay(2)

String afrappaz_task_af = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_header"]/div/div[2]/div[1]/div[1]']))

functions.I.print('afrappaz_task_af ' + afrappaz_task_af)

double user4_af = Double.parseDouble(afrappaz_task_af)

'Screnshot: Task before submitting > user 4 - Alexandra FRAPPAZ'
WebUI.takeScreenshot()

///VERIFY THAT NO OF TASK HAS INCREASED
'171 Verify task has been increased by 1 for  user 1'
WebUI.verifyEqual(user1_af - 1, user1_b4)

'Verify task has been increased by 1 for  user 2'
WebUI.verifyEqual(user2_af - 1, user2_b4)

'Verify task has been increased by 1 for  user 3'
WebUI.verifyEqual(user3_af - 1, user3_b4)

'Verify task has been increased by 1 for  user 4'

//WebUI.verifyEqual(user4_af - 1, user4_b4)
//'192 Verify task has been increased by 1 for  user 5'
//WebUI.verifyEqual(user5_af - 1, user5_b4)
////////////////////////////////////////////////END VERIFCATION OF TASK///////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////USER 4: PHASE 2 : LSS Creation //////////////////////////////////
'alexandra frappaz Click on the lhs menu - project tab'
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

'search for the project number'
functions.I.SearchProjectNo_xpath(Project_No, '//*[@id="keynum_project"]', '//*[@id="form_filters"]/div[20]/button')

WebUI.delay(5)

'Screenshot: Ref list page '
WebUI.takeScreenshot()

'Action column : Click on submit to next phase'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[4]/div[3]/div/div[2]/div[2]/div[1]/table/tbody/tr[2]/td[14]/a']))

WebUI.delay(1)

'Click on submit to next phase'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/button[2]']))

'Verify that the lifecycle stay the same'
String Lifecycle_LSS_actual_user4 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[4]/div[3]/div/div[2]/div[2]/div[1]/table/tbody/tr[2]/td[11]/span[2]']))

WebUI.verifyMatch('LSS Creation', Lifecycle_LSS_actual_user4, false)

'Verify the no. of task has decreased '
String afrappaz_task_af2 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_header"]/div/div[2]/div[1]/div[1]']))

functions.I.print('afrappaz_task_af2 ' + afrappaz_task_af2)

double user4_af2

if (afrappaz_task_af2 == '') {
    user4_af2 = 0
} else {
    user4_af2 = Double.parseDouble(afrappaz_task_af2)
}

WebUI.verifyEqual(user4_af2, user4_af - 1)

'Screenshot: Lifecycle status  '
WebUI.takeScreenshot()

'Go to lifecycle tab'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[4]/div[3]/div/div[2]/div[2]/div[1]/table/tbody/tr[2]/td[7]/a']))

WebUI.delay(2)

WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_content"]/div[3]/div/ul/li[3]/a']))

WebUI.delay(2)

'212 Verify the text submitted by'
String Actual_submittedby_user4 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/div/div[1]/div/div[2]/div/div[2]/h5[2]']))

'194'
WebUI.verifyMatch('Submitted by', Actual_submittedby_user4, false)

'214 Verify the username'
String Actual_username_user4 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/div/div[1]/div/div[2]/div/div[2]/div[2]/div/div/div[3]']))

WebUI.verifyMatch('Alexandra FRAPPAZ', Actual_username_user4, false)

'Screenshot: Lifecyce tab (user 4: Alexandra FRAPPAZ)'
WebUI.takeScreenshot()

'Logout as user 4'
functions.I.Logout_xpath('//*[@id="kt_header"]/div/div[2]/div[2]/div[1]/div/span/img', '//*[@id="kt_header"]/div/div[2]/div[2]/div[2]/a[2]')

/////////////////////////////////////////////USER 1 - 2 - 3: PHASE 2 : LSS Creation //////////////////////////////////
'Log in as user 1'
functions.I.Login_password('abrazhnikovapx', password_abrazhnikovapx)

//'Verify task - assigned to user 1'
//String task_user1 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_header"]/div/div[2]/div[1]/div[1]']))
'Ana Click on the lhs menu - project tab'
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

'search for the project number'
functions.I.SearchProjectNo_xpath(Project_No, '//*[@id="keynum_project"]', '//*[@id="form_filters"]/div[20]/button')

WebUI.delay(5)

'Screenshot: Ref list page - Step 2 : Creation / Phase 2:  LSS Creation  '
WebUI.takeScreenshot()

'On action coumn: click on proceed to next phase'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="fiches"]/table/tbody/tr/td[12]/a']))

'Ref list page: click on submit'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/button[2]']))

WebUI.delay(1)

////*[@id="fiches"]/table/tbody/tr/td[9]/span[2]
'207 Verify that the lifecycle stay the same'
String Lifecycle_LSS_actual_user1 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="fiches"]/table/tbody/tr/td[9]/span[2]']))

WebUI.verifyMatch('LSS Creation', Lifecycle_LSS_actual_user1, false)

'Screenshot: Lifecycle status  '
WebUI.takeScreenshot()

'Go to lifecycle tab'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="fiches"]/table/tbody/tr/td[5]/a']))

WebUI.delay(2)

WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_content"]/div[3]/div/ul/li[3]/a']))

WebUI.delay(2)

'Verify the text submitted by'
String Actual_submittedby_user1 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/div/div[1]/div/div[2]/div/div[2]/h5[2]']))

'Verify that submitted by is displayed'
WebUI.verifyMatch('Submitted by', Actual_submittedby_user1, false)

'31 Verify the username'
String Actual_username_user1 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/div/div[1]/div/div[2]/div/div[2]/div[2]/div[2]/div/div[3]']))

WebUI.verifyMatch('Anastasiia BRAZHNIKOVA PX', Actual_username_user1, false)

'Screenshot: Lifecycle tab (user 1:Anastasiia BRAZHNIKOVA PX)'
WebUI.takeScreenshot()

'Logout as user 1'
functions.I.Logout_xpath('//*[@id="kt_header"]/div/div[2]/div[2]/div[1]/div/span/img', '//*[@id="kt_header"]/div/div[2]/div[2]/div[2]/a[2]')

/////////////////////////////////////////////USER 5: PHASE 2 : LSS Creation //////////////////////////////////
'Log in as user 5'
functions.I.Login_password('akim', password_akim)

//'Verify task - assigned to user 1'
//String task_user1 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_header"]/div/div[2]/div[1]/div[1]']))
'Ana Click on the lhs menu - project tab'
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

'search for the project number'
functions.I.SearchProjectNo_xpath(Project_No, '//*[@id="keynum_project"]', '//*[@id="form_filters"]/div[20]/button')

WebUI.delay(5)

'Screenshot: Ref list page - Step 2 : Creation / Phase 2:  LSS Creation  '
WebUI.takeScreenshot()

'On action coumn: click on proceed to next phase'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="fiches"]/table/tbody/tr/td[9]/a']))

'Ref list page: click on submit'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/button[2]']))

WebUI.delay(1)

////*[@id="fiches"]/table/tbody/tr/td[9]/span[2]
'207 Verify that the lifecycle = PP Approval'
String Lifecycle_LSS_actual_user5 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="fiches"]/table/tbody/tr/td[7]/span[2]']))

WebUI.verifyMatch('PP Approval', Lifecycle_LSS_actual_user5, false)

'Screenshot: Lifecycle status  '
WebUI.takeScreenshot()

'Go to lifecycle tab'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="fiches"]/table/tbody/tr/td[5]/a']))

WebUI.delay(2)

WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_content"]/div[3]/div/ul/li[3]/a']))

WebUI.delay(2)

'Screensot: Lifecycle tab '
WebUI.takeScreenshot()

WebUI.delay(1)

'On the lifecycle tab click on step Creation'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/ul/li[1]/a']))

'Click on expand'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/div/div[1]/div/div[2]/div/div[1]/div[2]/a']))

'Verify the text submitted by'
String Actual_submittedby_user5 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/div/div[1]/div/div[2]/div/div[2]/h5[2]']))

'Verify that submitted by is displayed'
WebUI.verifyMatch('Submitted by', Actual_submittedby_user5, false)

'38 Verify the username'
String Actual_username_user5 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/div/div[1]/div/div[2]/div/div[2]/div[2]/div[3]/div/div[3]']))

WebUI.verifyMatch('Anna KIM', Actual_username_user5, false)

'Screenshot: Lifecycle tab (user 1:Ana kim)'
WebUI.takeScreenshot()

'Logout as user 5'
functions.I.Logout_xpath('//*[@id="kt_header"]/div/div[2]/div[2]/div[1]/div/span/img', '//*[@id="kt_header"]/div/div[2]/div[2]/div[2]/a[2]')

WebUI.closeBrowser()

