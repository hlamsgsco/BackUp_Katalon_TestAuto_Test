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
import org.openqa.selenium.JavascriptExecutor as JavascriptExecutor

/////////////////////////////SCENARIO NPP : LSS LIFECYCLE (2) /////////////////////
//STEP 1: CREATION
//PHASE 1 : LSS PREFILL
//Step 2 : Approval
//Step 5 : Effective
//Step 6 : Deactive
///////////////////////////USERNAME - PASSWORD - URL////////////////////////////////////
//USERNAME & PASSWORD  - NPP
def data_Npp = TestDataFactory.findTestData('Data Files/Username_Password/Test_Npp')

String password_ncur = data_Npp.getValue(2, 1 //R
    )

String password_akim = data_Npp.getValue(2, 2 //R
    )

String password_lmoodie_mkt = data_Npp.getValue(2, 12 //R
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
'Log in as Product Platform ??? All users'
functions.I.Login_password('akim', password_akim)

'Screenshot: Log as Product manager'
WebUI.takeScreenshot()

'Go to the project tab'
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

'Click on + icon to create project '
WebUI.click(findTestObject('Object Repository/1. Constant/xpath', [('xpath') : '//*[@id="kt_content"]/div[3]/div/div/div[1]/div[2]/a[1]']))

////////////////////////////MODIFY PROJECT PAGE- LSS ///////////////////////////////////
'Screenshot: Modify project page'
WebUI.takeScreenshot()

'On the modify project page : Fill in all field'

//LSS GENERAL INFO
'Enter text : LSS number'
def LSSNumber_name = (('AutoTest_Npp_SAS_Part5_' + org.apache.commons.lang.RandomStringUtils.randomAlphanumeric(10)) + '_') + 
functions.I.gettimedate()

WebUI.setText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_70"]']), LSSNumber_name)

//RECIPE
'Select from Technology list - Litter'
functions.I.SelectFromList_Value('//*[@id="var_107"]', '2420')

'Select from Texture multiple list - Corn '
functions.I.select_multiplelist('//*[@id="selSource_108"]', '//*[@id="btnAdd_108"]', '2354')

'Enter text: Variety'
WebUI.setText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_110"]']), 'Variety test')

'Enter Text: Alternative Format code'
WebUI.setText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_133"]']), 'Alternative Format code test ')

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

WebUI.delay(3)

'Select from multiple list subbrand - Tidy Cat - CRYSTALS BLEND '
functions.I.select_multiplelist('//*[@id="selSource_106"]', '//*[@id="btnAdd_106"]', '2787')

'Select from Range type - Premium'
functions.I.SelectFromList_Value('//*[@id="var_92"]', '1298')

'Select from multiple list Product descriptor - Superfood '
functions.I.select_multiplelist('//*[@id="selSource_88"]', '//*[@id="btnAdd_88"]', '1303')

'Select from multiple list Presence of colors - No color '
functions.I.select_multiplelist('//*[@id="selSource_86"]', '//*[@id="btnAdd_86"]', '1310')

'Select from multiple list Colors - Not applicable '
functions.I.select_multiplelist('//*[@id="selSource_57"]', '//*[@id="btnAdd_57"]', '2304')

'Select from List Presence of vegetables - yes'
functions.I.SelectFromList_Value('//*[@id="var_87"]', '971')

'Select from List Type of feed - Complete'
functions.I.SelectFromList_Value('//*[@id="var_109"]', '1325')

'Select from List Animal species - Cats & Dogs'
functions.I.SelectFromList_Value('//*[@id="var_52"]', '1330')

'Select from multiple list Lifestage - Superfood '
functions.I.select_multiplelist('//*[@id="selSource_67"]', '//*[@id="btnAdd_67"]', '1624')

'Select from List Lifestyle - Light'
functions.I.SelectFromList_Value('//*[@id="var_140"]', '2296')

'Select from multiple list Animal size - All '
functions.I.select_multiplelist('//*[@id="selSource_51"]', '//*[@id="btnAdd_51"]', '1673')

'Select from multiple list Animal activity level - Acctive '
functions.I.select_multiplelist('//*[@id="selSource_50"]', '//*[@id="btnAdd_50"]', '1681')

//Production
//functions.I.select_multiplelist('//*[@id="selSource_64"]', '//*[@id="btnAdd_64"]', '1701')
'Select from multiple list Factories - 2 options '
functions.I.SelectFromList_Value('//*[@id="selSource_64"]', '1701')

functions.I.select_multiplelist('//*[@id="selSource_64"]', '//*[@id="btnAdd_64"]', '1688')

'Select from multiple list Back-up factories - 1 option '
functions.I.select_multiplelist('//*[@id="selSource_53"]', '//*[@id="btnAdd_53"]', '1701')

'Select from multiple list Back-up factories - Comanufacturers '
functions.I.select_multiplelist('//*[@id="selSource_58"]', '//*[@id="btnAdd_58"]', '1704')

'Select from multiple list Copackers - Deuerer '
functions.I.select_multiplelist('//*[@id="selSource_59"]', '//*[@id="btnAdd_59"]', '1706')

'Select from multiple list Manufacturing method - Mousse '
functions.I.select_multiplelist('//*[@id="selSource_73"]', '//*[@id="btnAdd_73"]', '3147')

WebUI.delay(1)

//Team
'Is Local RSA RU approval required ? - No'
functions.I.SelectFromList_Value('//*[@id="var_66"]', '2402')

'Is Local RSA FR approval required ? - No'
functions.I.SelectFromList_Value('//*[@id="var_142"]', '2404')

'Is Local RSA UK approval required ? - No'
functions.I.SelectFromList_Value('//*[@id="var_143"]', '2406')

//Packaging and distribution
'Select from multiple list Expected commercialisation zone - LATAM '
functions.I.select_multiplelist('//*[@id="selSource_119"]', '//*[@id="btnAdd_119"]', '2165')

WebUI.delay(5)

'Screenshot: Modify Project filled'
WebUI.takeScreenshot()

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

'SElect Lifecycle'
functions.I.SelectFromList_Value('//*[@id="lfc_tpl"]', '51')

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
functions.I.SelectFromList_Value('//*[@id="var_82"]', 'agaudin')


'Product Experience Brand Manager - Alexandra FRAPPAZ'
functions.I.SelectFromList_Value('//*[@id="var_74"]', 'afrappaz')

'Select from multiple list Additional Product Experience Brand Manager(s) - Camille DEMONCHY '
functions.I.SelectFromList_Value('//*[@id="selSource_168"]', 'cdemonchy')

//functions.I.select_multiplelist('//*[@id="selSource_168"]', '//*[@id="btnAdd_168"]', 'alarkins')
functions.I.SelectFromList_Value('//*[@id="selSource_168"]', 'alarkins')
functions.I.select_multiplelist('//*[@id="selSource_168"]', '//*[@id="btnAdd_168"]', 'abrazhnikovapx')

WebUI.delay(1)

'Select from Design to Deliver Manager (D2D) - Adam SVEGAARD (D2D)'
functions.I.SelectFromList_Value('//*[@id="var_60"]', 'asvegaardd2d')


'Select from Central RSA - Amelie SERMENT'
functions.I.SelectFromList_Value('//*[@id="var_102"]', 'aserment')

'Select from E2E Project Manager - Alexandra SAVREUX (E2E)'
functions.I.SelectFromList_Value('//*[@id="var_63"]', 'asavreux')


'Select from Nutritionist - Alexandra SAVREUX (E2E)'
functions.I.SelectFromList_Value('//*[@id="var_161"]', 'achaves')


'Screenshot: Modify Ref page (3)'
WebUI.takeScreenshot()

//Packaging & Distribution
WebUI.scrollToElement(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_143"]']), 10, FailureHandling.OPTIONAL)

'Select from multiple list Pack type - bag (1 options) '
functions.I.select_multiplelist('//*[@id="selSource_79"]', '//*[@id="btnAdd_79"]', '1730')

'Select from multiple list Pack format - 1.1kg & 1.2Kg (2 options)'
functions.I.SelectFromList_Value('//*[@id="selSource_78"]', '1752')
functions.I.select_multiplelist('//*[@id="selSource_78"]', '//*[@id="btnAdd_78"]', '1753')

'Select from multiple list Selling countries - Albania & Austria (2 options)  '
functions.I.SelectFromList_Value('//*[@id="selSource_104"]', '73')
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

/////////////////////////////////////////////STEP 1 : CREATION //////////////////////////////////
/////////////////////////////////////////////PHASE 1 : PREFILL ////////////////////////////////////////////////////////////////////////////
functions.I.Login_password('ncur', password_ncur)

'Ana Click on the lhs menu - project tab'
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

'Search for the project number'
functions.I.SearchProjectNo_xpath(Project_No, '//*[@id="keynum_project"]', '//*[@id="form_filters"]/div[9]/button')

WebUI.delay(2)

'Screenshot: Ref list page - Step 1 : Creation / Phase 1: Prefill  '
WebUI.takeScreenshot()

'On the ref list page Click on submit'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="fiches"]/table/tbody/tr/td[10]/a[2]']))

WebUI.delay(1)

'115 Select value inn a multiple list - Texture'
functions.I.select_multiplelist('//*[@id="selSource_108"]', '//*[@id="btnAdd_108"]', '2344')

'On the ref form: Click on submit form'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/button[2]']))

'Screenshot: S1 (Creation) / P2( LSS Pre-fill)'
WebUI.takeScreenshot()

/////////////creation
'Action column : Click on submit to next phase'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="fiches"]/table/tbody/tr/td[10]/a[2]']))

WebUI.delay(1)

'Click onSubmit'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/button[2]']))

WebUI.delay(1)

/////////////////////////////////////////////PHASE 3 :PP Approval //////////////////////////////////
'Action column : Click on submit to next phase'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[4]/div[3]/div/div[2]/div[2]/table/tbody/tr/td[10]/div[2]/button']))

WebUI.delay(1)

'Click on Option 1'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="fiches"]/table/tbody/tr/td[10]/div[2]/div/a[1]']))

WebUI.takeScreenshot()

'111 Select from PP specialist'
functions.I.SelectFromList_Value('//*[@id="var_84"]', 'akim')

WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/div']))

WebUI.delay(1)

'Click on Option 1'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/div/div/a[1]']))

WebUI.delay(2)

/////////////////////////////////////////////PHASE 4 :PX Approval //////////////////////////////////
'Action column : Click on submit to next phase'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="fiches"]/table/tbody/tr/td[10]/div[2]/button']))

WebUI.delay(1)

'Click on Option 1'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="fiches"]/table/tbody/tr/td[10]/div[2]/div/a[1]']))

WebUI.takeScreenshot()

'Select from PP specialist'
functions.I.SelectFromList_Value('//*[@id="var_76"]', 'afrappaz')

WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/div/button']))

WebUI.delay(1)

'Click on Option 1'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/div/div/a[1]']))

WebUI.delay(2)

////////////////////// Nutritionist Approval/////////////////////////////
'Action column : Click on submit to next phase'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="fiches"]/table/tbody/tr/td[10]/div[2]/button']))

WebUI.delay(1)

'Click on Option 1'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="fiches"]/table/tbody/tr/td[10]/div[2]/div/a[1]']))

WebUI.takeScreenshot()

WebUI.delay(1)

WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/div/button']))

WebUI.delay(1)

'Click on Option 1'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/div/div/a[1]']))

WebUI.delay(2)

///////////////////////Central RSA Approval//////////////////////////////////////
'Action column : Click on submit to next phase'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="fiches"]/table/tbody/tr/td[10]/div[2]/button']))

WebUI.delay(1)

'Click on Option 1'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="fiches"]/table/tbody/tr/td[10]/div[2]/div/a[1]']))

WebUI.takeScreenshot()

WebUI.delay(1)

'Select from CT RSA'
functions.I.SelectFromList_Value('//*[@id="var_56"]', 'aserment')

WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/div/button']))

WebUI.delay(1)

'Click on Option 1'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/div/div/a[1]']))

WebUI.delay(2)

WebUI.takeScreenshot()

//////////////////////////////EDIT SOURCE TEXT //////
'Click Edit '
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="fiches"]/table/tbody/tr/td[10]/div[1]/button']))

WebUI.delay(1)

'Click Edit Source text '
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="fiches"]/table/tbody/tr/td[10]/div[1]/div/a[2]']))

WebUI.delay(2)

WebUI.takeScreenshot()

'Click + to add translation field'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="aff_newfield_zone"]']))

WebUI.delay(2)

functions.I.Pagedown()

'Select content template'
functions.I.SelectFromList_Value('//*[@id="type_new"]', '160')

'Click add'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="add_newtranslationfield"]']))

WebUI.delay(1)

'Click send LSS translation'
functions.I.click_button_javascript(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div[2]/button[2]']))

WebUI.delay(3)

WebUI.takeScreenshot()

'Select languages'
functions.I.select_multiplelist('//*[@id="selSource_default_target_language"]', '//*[@id="btn_add_default_target_language"]', 
    'EN')

WebUI.delay(2)

'Select lifecyle translation'
functions.I.SelectFromList_Value('//*[@id="var_127_128_line_1"]', '2211')

'set text in LSS Translation due date'
WebUI.setText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_72"]']), '01/12/2021')

WebUI.delay(2)

'set text in Marketing Translation due datemandatory'
WebUI.setText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_116"]']), '01/12/2021')

WebUI.delay(1)

functions.I.Pagedown()

'SElect Distribution channel'
functions.I.select_multiplelist('//*[@id="selSource_61"]', '//*[@id="btnAdd_61"]', '2147')

WebUI.delay(1)

WebUI.takeScreenshot()

'Click send LSS translation'
functions.I.click_button_javascript(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[3]/div/button[2]']))

WebUI.delay(1)

/////////////////////////////////////////////REF LIST PAGE /////////////////////////////////
'REf List page '
WebUI.takeScreenshot()

'181 Click submit translation'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[4]/div[3]/div/div[2]/div[2]/table/tbody/tr[2]/td[10]/a[3]']))

'Ref List page > Translation submitted '
WebUI.takeScreenshot()

'Click submit translation'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[4]/div[3]/div/div[2]/div[2]/table/tbody/tr[2]/td[10]/a[3]']))

WebUI.delay(1)

'Click on ref link'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[4]/div[3]/div/div[2]/div[2]/table/tbody/tr[2]/td[5]/a']))

////////////////////////////
/////////////////////////
'Click lifecycle tab'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_content"]/div[3]/div/ul/li[3]/a']))

WebUI.delay(1)

'Click step'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/ul/li/a']))

WebUI.delay(1)

WebUI.takeScreenshot()

'Click SAS'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/div/div/div/div[3]/div/div[1]/div[2]/div/button']))

WebUI.delay(3)

WebUI.takeScreenshot()

//CLCICK ON THE SAS WITH THE LABEL
'no of option present '
int x = 20
int i = 1

while ( i <=x)
{
	String Expected_SAS_Selected = 'Reset to Agency translation'
	//*[@id="source_' + refID35 + '"]/td[14]/div[1]/div/a[10]
	String xpath_SAS ='/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/div/div/div/div[3]/div/div[1]/div[2]/div/div/a['+i+']'
	
	
	String Actual_SAS = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : xpath_SAS]))
	functions.I.print(i)
	
	if (Actual_SAS.contains(Expected_SAS_Selected))
	{
	WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : xpath_SAS]))

		//functions.I.click_button_javascriptS(xpath_SAS)
		
		break
		}
		i =i+1
	}
	
/*
' Click Option 1:Reset agency'
functions.I.click_button_javascript(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/div/div/div/div[3]/div/div[1]/div[2]/div/div/a[1]']))
*/
WebUI.takeScreenshot()

'Select reason'
functions.I.SelectFromList_Value('//*[@id="added_support_action_reason"]', '3')

'Click OK'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="modal_support_action_shortcut"]/div/div/div[3]/button[2]']))

WebUI.delay(1)

'Logout'
functions.I.Logout_xpath('//*[@id="kt_header"]/div/div[2]/div[2]/div[1]/div/span/img', '//*[@id="kt_header"]/div/div[2]/div[2]/div[2]')

///////////////////////////////USER 1 Submit
'Login as lmoodie_mkt\t'
functions.I.Login_password('lmoodie_mkt', password_lmoodie_mkt)

'Verify task'
double user1_b4 =  functions.I.Get_Task_No('//*[@id="kt_header"]/div/div[2]/div[1]/div[1]/span')


'Click on the lhs menu - project tab'
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

'Search for the project number'
functions.I.SearchProjectNo_xpath(Project_No, '//*[@id="keynum_project"]', '//*[@id="form_filters"]/div[20]/button')

WebUI.delay(2)

'Screenshot: Ref list '
WebUI.takeScreenshot()

'211 Click on submit'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[4]/div[3]/div/div[2]/div[2]/table/tbody/tr[2]/td[12]/a[2]']))

WebUI.delay(1)

'Screenshot: Ref list '
WebUI.takeScreenshot()

'Verify task'
double user1_a4 = functions.I.Get_Task_No('//*[@id="kt_header"]/div/div[2]/div[1]/div[1]/span')


WebUI.verifyEqual(user1_a4, user1_b4 - 1)

'Close Browser'
WebUI.closeBrowser()

