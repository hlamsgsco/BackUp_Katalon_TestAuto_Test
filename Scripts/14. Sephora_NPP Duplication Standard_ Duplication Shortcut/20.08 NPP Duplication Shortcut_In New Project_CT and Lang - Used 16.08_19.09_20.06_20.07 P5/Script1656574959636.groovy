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
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory

//PARENT BUTTON NOT DISPLAYED
///////////////////////////USERNAME - PASSWORD - URL////////////////////////////////////
//USERNAME & PASSWORD  - NPP
def data_Npp = TestDataFactory.findTestData('Data Files/Username_Password/Test_Npp')

String password_ncur = data_Npp.getValue(2, 1)

String password_akim = data_Npp.getValue(2, 2)

String password_sschunke = data_Npp.getValue(2, 3)

String password_abrazhnikovapx = data_Npp.getValue(2, 4)

String password_afrappaz = data_Npp.getValue(2, 5)

String password_alarkins = data_Npp.getValue(2, 6)

String password_cdemonchy = data_Npp.getValue(2, 7)

def data_urlRELAUTO = TestDataFactory.findTestData('Data Files/URL/URL_relauto')

String Url_Npp = data_urlRELAUTO.getValue(2, 5)

//READ FROM NOTEPAD TC 20.08
functions.I.clearnotepad('D:\\Upoad_File\\Projet_ Login\\NPP\\16.08\\20.08_NPP_ProjectNo.txt')

functions.I.clearnotepad('D:\\Upoad_File\\Projet_ Login\\NPP\\16.08\\20.08_NPP_refID.txt')

//NP16.08
String Project_No = functions.I.readnotepad('D:\\Upoad_File\\Projet_ Login\\NPP\\16.08\\16.08_NPP_ProjectNo.txt')

String refID = functions.I.readnotepad('D:\\Upoad_File\\Projet_ Login\\NPP\\16.08\\16.08_NPP_refID.txt')

////////////////////////////NAVIGATE TO NPP ///////////////////////////////////
'Navigate to NPP'
WebUI.openBrowser(Url_Npp)

// http://mdb-release.diadeis.lan/MediaboxIndependence/?MBI_datasource=
WebUI.maximizeWindow()

'Screenshot: Navigate to Npp'
WebUI.takeScreenshot()

'Login as akim'
functions.I.Login_password('akim', password_akim)

'Screenshot: Dashboard page '
WebUI.takeScreenshot()

'ncur Click on the lhs menu - project tab'
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

//REF LIST PAGE
'Search for the project number'
functions.I.SearchProjectNo_xpath(Project_No, '//*[@id="keynum_project"]', '//*[@id="form_filters"]/div[20]/button')

WebUI.delay(1)

'Click on duplicate'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_content"]/div[3]/div/div[2]/div[1]/div[2]/span/div/button']))

WebUI.delay(1)

'Choose 2nd option - Duplicate in a new project'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[4]/div[3]/div/div[2]/div[1]/div[2]/span/div/div/a[2]']))

'Select 1st ref'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="fiches"]/table/tbody/tr[1]/td[1]/label']))

WebUI.delay(1)

'Click confirm duplication'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="action_btnduplicatereference"]']))

WebUI.delay(1)

//POPUP DUPLICATION
'Screenshot: Popup dupli'
WebUI.takeScreenshot()

//Content source texts and languages
'Click //Content source texts and languages'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="modal_duplicate_reference"]/div/div/div[2]/div/div[8]/div[1]/label[4]']))

'Verify the text of the Window HELPER TEXT is: New LSS version'
functions.I.VerifyMatchText('//*[@id="info_translation_block"]', 'This option will duplicate the values from the brief, the source text structure and content, as well as the translations.')

'Verify that ref template is prefilled - LSS Reference'
functions.I.VerifyMatchText('//*[@id="select2-ref_tpl7-container"]', 'LSS Reference')

'Verify that ref template is prefilled - LSS Reference'
functions.I.VerifyMatchText('//*[@id="select2-lfc_tpl7-container"]', 'LSS Lifecycle (3)')

'Click on the duplication button'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="btn_submit_duplication"]']))

WebUI.delay(1)

'Get ProjectNo'
String Project_No3 = functions.I.ProjectNo()

functions.I.print(Project_No3)

def LSSNumber_name = (('TC20.08_AutoTest_Npp_Duplication_NewProj_' + org.apache.commons.lang.RandomStringUtils.randomAlphanumeric(
    3)) + '_') + functions.I.gettimedate()

'Set text for project name'
WebUI.setText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_70"]']), LSSNumber_name)

//VERIFY FIELD IS PREFILLED FOR PROJECT
'Click update project'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/button']))

WebUI.delay(1)

//VERIFY Project FIELDS ARE PREFILLED
'Click View Project'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="card_project"]/div[2]/div/div[3]/a[3]']))

WebUI.delay(1)

//RECIPE
'Technology - Litter'
functions.I.VerifyMatchText('//*[@id="var_107"]', 'Litter')

'Texture'
functions.I.VerifyMatchText('//*[@id="var_108"]', 'Corn')

'Variety: Variety test'
functions.I.VerifyMatchText('//*[@id="var_110"]', 'Variety test')

' Alternative Format Code: Alternative Format code test'
functions.I.VerifyMatchText('//*[@id="var_133"]', 'Alternative Format code test')

' Format prooduct designation'
functions.I.VerifyMatchText('//*[@id="var_65"]', 'FORMAT Product designation test')

//PROJECT INFORMATION
'Project type'
functions.I.VerifyMatchText('//*[@id="var_91"]', 'HIP')

'LSS Planned issue date'
functions.I.VerifyMatchText('//*[@id="var_71"]', '25/08/2021')

'Project Info Comments'
functions.I.VerifyMatchText('//*[@id="var_89"]', 'Project Information - Comments')

'Reason for change'
functions.I.VerifyMatchText('//*[@id="var_93"]', 'Reason for change test')

//PRODUCT INFORMATION
'Brands: Tidy Cat'
functions.I.VerifyMatchText('//*[@id="var_54"]', 'Tidy Cat')

'Sub brands: Tidy Cat - CRYSTALS BLEND'
functions.I.VerifyMatchText('//*[@id="var_106"]', 'Tidy Cat - CRYSTALS BLEND')

'Range type'
functions.I.VerifyMatchText('//*[@id="var_92"]', 'Premium')

'Product descriptor'
functions.I.VerifyMatchText('//*[@id="var_88"]', 'Superfood')

'Presence of colors '
functions.I.VerifyMatchText('//*[@id="var_86"]', 'No color')

' Colors'
functions.I.VerifyMatchText('//*[@id="var_57"]', 'Not applicable')

'Presence of veg: Yes'
functions.I.VerifyMatchText('//*[@id="var_87"]', 'Yes')

'Type of feed: Complete'
functions.I.VerifyMatchText('//*[@id="var_109"]', 'Complete')

'Animal Species: Dogs & Cats'
functions.I.VerifyMatchText('//*[@id="var_52"]', 'Dogs & Cats')

'Lifestage: Tidy Cat - Adult'
functions.I.VerifyMatchText('//*[@id="var_67"]', 'Tidy Cat - Adult')

'Lifestyle: Light'
functions.I.VerifyMatchText('//*[@id="var_140"]', 'Light')

'Animal size  All'
functions.I.VerifyMatchText('//*[@id="var_51"]', 'All')

'Animal activity level : Active'
functions.I.VerifyMatchText('//*[@id="var_50"]', 'Active')

//PRODUCTION
'Factories :FR DC SPI Ham / FR PL Montfort'
functions.I.VerifyMatchText('//*[@id="var_64"]', ('FR DC SPI Ham' + '\n') + 'FR PL Montfort')

'Back-up factories: FR DC SPI Ham'
functions.I.VerifyMatchText('//*[@id="var_53"]', 'FR DC SPI Ham')

'Comanufacturers : Animal Lovers'
functions.I.VerifyMatchText('//*[@id="var_58"]', 'Animal Lovers')

'Copackers :Deuerer'
functions.I.VerifyMatchText('//*[@id="var_59"]', 'Deuerer')

'Manufacturing method :Mousse'
functions.I.VerifyMatchText('//*[@id="var_73"]', 'Mousse')

//TEAM
'Is Local RSA RU approval required ? :No'
functions.I.VerifyMatchText('//*[@id="var_66"]', 'No')

'Is Local RSA FR approval required ? :No'
functions.I.VerifyMatchText('//*[@id="var_142"]', 'No')

'Is Local RSA UK approval required ? :No'
functions.I.VerifyMatchText('//*[@id="var_143"]', 'No')

//Packaging & Distribution
'Expected commercialisation zone: LATAM'
functions.I.VerifyMatchText('//*[@id="var_119"]', 'LATAM')

'Go back to Ref Lsit page'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_subheader"]/div/nav/ol/li[2]/a']))

//REF LIST PAGE
'Verify that the no of ref is 1'
functions.I.VerifyMatchText('//*[@id="kt_content"]/div[3]/div/div[2]/div[1]/div[1]/h1/span', '1')

'Click on reflink'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="fiches"]/table/tbody/tr[1]/td[5]/a[1]']))

WebUI.delay(1)

//GET REF ID 3
String refID3 = functions.I.RefID_Npp()

//VERIFY FIELDS ARE PREFILLED
'Click FULL tab'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="aff_full_brief"]']))

WebUI.delay(1)

//RECIPE
'Technology - Litter'
functions.I.VerifyMatchText('//*[@id="var_107"]', 'Litter')

'Texture'
functions.I.VerifyMatchText('//*[@id="var_108"]', ('Clumping clay' + '\n') + 'Corn')

'Variety: Variety test'
functions.I.VerifyMatchText('//*[@id="var_110"]', 'Variety test')

' Alternative Format Code: Alternative Format code test'
functions.I.VerifyMatchText('//*[@id="var_133"]', 'Alternative Format code test')

' Format prooduct designation'
functions.I.VerifyMatchText('//*[@id="var_65"]', 'FORMAT Product designation test')

' SAP designation'
functions.I.VerifyMatchText('//*[@id="var_103"]', 'SAP Designation test > https://www.google.com/')

'Clam Subs Project link'
functions.I.VerifyMatchText('//*[@id="var_139"]', 'Claim Substantiation Project Link > https://www.google.com/')

'Grading Link'
functions.I.VerifyMatchText('//*[@id="var_160"]', 'Grading standard link > test')

//PROJECT INFORMATION
'DEPT'
functions.I.VerifyMatchText('//*[@id="var_62"]', 'DPET > test')

'Project name'
functions.I.VerifyMatchText('//*[@id="var_90"]', 'Project name > test')

'Project type'
functions.I.VerifyMatchText('//*[@id="var_91"]', 'HIP')

'LSS Planned issue date'
functions.I.VerifyMatchText('//*[@id="var_71"]', '25/08/2021')

'LSS Translation due date'
functions.I.VerifyMatchText('//*[@id="var_72"]', '01/12/2021')

'Mkt translation die date'
functions.I.VerifyMatchText('//*[@id="var_116"]', '01/12/2021')

'Project Info Comments'
functions.I.VerifyMatchText('//*[@id="var_89"]', 'Project Information - Comments')

'Reason for change'
functions.I.VerifyMatchText('//*[@id="var_93"]', 'Reason for change test')

//PRODUCT INFORMATION
'Brands: Tidy Cat'
functions.I.VerifyMatchText('//*[@id="var_54"]', 'Tidy Cat')

'Sub brands: Tidy Cat - CRYSTALS BLEND'
functions.I.VerifyMatchText('//*[@id="var_106"]', 'Tidy Cat - CRYSTALS BLEND')

'Range type'
functions.I.VerifyMatchText('//*[@id="var_92"]', 'Premium')

'Product descriptor'
functions.I.VerifyMatchText('//*[@id="var_88"]', 'Superfood')

'Presence of colors '
functions.I.VerifyMatchText('//*[@id="var_86"]', 'No color')

' Colors'
functions.I.VerifyMatchText('//*[@id="var_57"]', 'Not applicable')

'Presence of veg: Yes'
functions.I.VerifyMatchText('//*[@id="var_87"]', 'Yes')

'Type of feed: Complete'
functions.I.VerifyMatchText('//*[@id="var_109"]', 'Complete')

'Animal Species: Dogs & Cats'
functions.I.VerifyMatchText('//*[@id="var_52"]', 'Dogs & Cats')

'Lifestage: Tidy Cat - Adult'
functions.I.VerifyMatchText('//*[@id="var_67"]', 'Tidy Cat - Adult')

'Lifestyle: Light'
functions.I.VerifyMatchText('//*[@id="var_140"]', 'Light')

'Animal size  All'
functions.I.VerifyMatchText('//*[@id="var_51"]', 'All')

'Animal activity level : Active'
functions.I.VerifyMatchText('//*[@id="var_50"]', 'Active')

//PRODUcT
'Factories :FR DC SPI Ham / FR PL Montfort'
functions.I.VerifyMatchText('//*[@id="var_64"]', ('FR DC SPI Ham' + '\n') + 'FR PL Montfort')

'Back-up factories: FR DC SPI Ham'
functions.I.VerifyMatchText('//*[@id="var_53"]', 'FR DC SPI Ham')

'Comanufacturers : Animal Lovers'
functions.I.VerifyMatchText('//*[@id="var_58"]', 'Animal Lovers')

'Copackers :Deuerer'
functions.I.VerifyMatchText('//*[@id="var_59"]', 'Deuerer')

'Manufacturing method :Mousse'
functions.I.VerifyMatchText('//*[@id="var_73"]', 'Mousse')

//TEAM
'PP Specialist - Technical Leader :Anna KIM'
functions.I.VerifyMatchText('//*[@id="var_85"]', 'Anna KIM')

'PP Back-up :AnneLise GAUDIN'
functions.I.VerifyMatchText('//*[@id="var_82"]', 'AnneLise GAUDIN')

'Product Experience Brand Manager :Alexandra FRAPPAZ'
functions.I.VerifyMatchText('//*[@id="var_74"]', 'Alexandra FRAPPAZ')

'Additional Product Experience Brand Manager(s) :Anastasiia BRAZHNIKOVA PX / Amelia LARKINS /Camille DEMONCHY'
functions.I.VerifyMatchText('//*[@id="var_168"]', ((('Anastasiia BRAZHNIKOVA PX' + '\n') + 'Amelia LARKINS') + '\n') + 'Camille DEMONCHY')

'Design to Deliver Manager (D2D) :Adam SVEGAARD (D2D)'
functions.I.VerifyMatchText('//*[@id="var_60"]', 'Adam SVEGAARD (D2D)')

'Central RSA : Amelie SERMENT'
functions.I.VerifyMatchText('//*[@id="var_102"]', 'Amelie SERMENT')

'E2E Project Manager :Alexandra SAVREUX (E2E)'
functions.I.VerifyMatchText('//*[@id="var_63"]', 'Alexandra SAVREUX (E2E)')

'Nutritionist : Ana CHAVES'
functions.I.VerifyMatchText('//*[@id="var_161"]', 'Ana CHAVES')

'Is Local RSA RU approval required ? :No'
functions.I.VerifyMatchText('//*[@id="var_66"]', 'No')

'Is Local RSA FR approval required ? :No'
functions.I.VerifyMatchText('//*[@id="var_142"]', 'No')

'Is Local RSA UK approval required ? :No'
functions.I.VerifyMatchText('//*[@id="var_143"]', 'No')

//Packaging & Distribution
'Expected commercialisation zone: LATAM'
functions.I.VerifyMatchText('//*[@id="var_119"]', 'LATAM')

'Pack type :Bag - Woven'
functions.I.VerifyMatchText('//*[@id="var_79"]', 'Bag - Woven')

'Pack format :1.1kg / 1.2kg'
functions.I.VerifyMatchText('//*[@id="var_78"]', ('1.1kg' + '\n') + '1.2kg')

'Distribution channel : Vet'
functions.I.VerifyMatchText('//*[@id="var_61"]', 'Vet')

'Selling countries :Albania/ Austria'
functions.I.VerifyMatchText('//*[@id="var_104"]', ('Albania' + '\n') + 'Austria')

//PP Specialist Signature
'PP Specialist - Approver : Anna KIM'
functions.I.VerifyMatchText('//*[@id="var_84"]', 'Anna KIM')

// PX Signature
'Product Experience Brand Manager - Approver: Alexandra FRAPPAZ'
functions.I.VerifyMatchText('//*[@id="var_76"]', 'Alexandra FRAPPAZ')

//Central RSA Signature
'Central RSA - Approver: Amelie SERMENT'
functions.I.VerifyMatchText('//*[@id="var_56"]', 'Amelie SERMENT')

//Version History
'Version History: Version History'
functions.I.VerifyMatchText('//*[@id="var_169"]', 'Version History')

//LIFECYCLE TAB
WebUI.delay(1)

'Click Lifecycle tab'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_content"]/div[3]/div/ul/li[3]/a']))

WebUI.delay(1)

'Verify that the Lifeycle template is LSS Lifecycle (3)'
functions.I.VerifyMatchText('//*[@id="tab_lifecycle"]/div/h3', 'LSS Lifecycle (3)')

//CONTENT TEMPALTE BLANK
'Click Brief tab'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_content"]/div[3]/div/ul/li[1]/a']))

WebUI.delay(1)

'Click Text Content tab'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="aff_text_content_brief"]']))

WebUI.delay(5)

//TABLE
String ExpectedValue1 = ((((((((('Analytical Constituents:' + '\n') + 'protein: %,') + '\n') + 'fat content: %,') + '\n') + 
'crude ash: %,') + '\n') + 'crude fibre: %,') + '\n') + 'omega 6 fatty acids: %.'

String ExpectedValue2 = ((((((((('Analytical constituents:' + '\n') + 'Protein: %,') + '\n') + 'Fat content: %,') + '\n') + 
'Crude ash: %,') + '\n') + 'Crude fibre: %,') + '\n') + 'Omega 6 fatty acids: %.'

'Verify source content '
functions.I.Verify_Table_getdata('//*[@id="table_body"]', 0, 8, ExpectedValue1)

'Verify Translated reference '
functions.I.Verify_Table_getdata('//*[@id="table_body"]', 0, 9, ExpectedValue2)

//REF LSIT PAGE
'Click breadcrum'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_subheader"]/div/nav/ol/li[2]/a']))

'On the ref list page Click on submit'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="fiches"]/table/tbody/tr[1]/td[9]/a']))

'Select value inn a multiple list - Texture'
functions.I.select_multiplelist('//*[@id="selSource_108"]', '//*[@id="btnAdd_108"]', '2357')

'On the ref form: Click on submit form'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/button[2]/i']))

'Screenshot: S1 (Creation) / P2( LSS Pre-fill)'
WebUI.takeScreenshot()

'Logout'
functions.I.Logout_xpath('//*[@id="kt_header"]/div/div[2]/div[2]/div[1]/div/span/img', '//*[@id="kt_header"]/div/div[2]/div[2]/div[2]/a[2]')

'Login as ncur'
functions.I.Login_password('ncur', password_ncur)

'Screenshot: Dashboard page '
WebUI.takeScreenshot()

'ncur Click on the lhs menu - project tab'
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

//REF LIST PAGE
'Search for the project number'
functions.I.SearchProjectNo_xpath(Project_No3, '//*[@id="keynum_project"]', '//*[@id="form_filters"]/div[9]/button')

WebUI.delay(1)

/////////////LSS Createion
'Action column : Click on submit to next phase'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="fiches"]/table/tbody/tr[1]/td[10]/a[2]']))

WebUI.delay(1)

'32 Click on Submit'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/button[2]']))

WebUI.delay(1)

/////////////////////////////////////////////PHASE 3 :PP Approval //////////////////////////////////
////*[@id="fiches"]/table/tbody/tr[1]/td[10]/div[2]/button
'Action column : Click on submit to next phase'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[4]/div[3]/div/div[2]/div[2]/table/tbody/tr/td[10]/div[2]/button']))

WebUI.delay(1)

'Click on Option 1'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="fiches"]/table/tbody/tr/td[10]/div[2]/div/a[1]']))

WebUI.takeScreenshot()

'Click on save'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/div/button']))

WebUI.delay(1)

'Click on Option 1'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/div/div/a[1]']))

WebUI.delay(2)

/////////////////////////////////////////////PHASE 4 :PX Approval //////////////////////////////////
'Action column : Click on submit to next phase'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="fiches"]/table/tbody/tr[1]/td[10]/div[2]/button']))

WebUI.delay(1)

'Click on Option 1'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="fiches"]/table/tbody/tr[1]/td[10]/div[2]/div/a[1]']))

WebUI.takeScreenshot()

'Click save'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/div/button']))

WebUI.delay(1)

'Click on Option 1'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/div/div/a[1]']))

WebUI.delay(2)

////////////////////// Nutritionist Approval/////////////////////////////
'Action column : Click on submit to next phase'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="fiches"]/table/tbody/tr[1]/td[10]/div[2]/button']))

WebUI.delay(1)

'Click on Option 1'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="fiches"]/table/tbody/tr[1]/td[10]/div[2]/div/a[1]']))

WebUI.takeScreenshot()

WebUI.delay(1)

WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/div/button']))

WebUI.delay(1)

'Click on Option 1'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/div/div/a[1]']))

WebUI.delay(2)

///////////////////////Central RSA Approval//////////////////////////////////////
'Action column : Click on submit to next phase'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="fiches"]/table/tbody/tr[1]/td[10]/div[2]']))

WebUI.delay(1)

'Click on Option 1'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="fiches"]/table/tbody/tr[1]/td[10]/div[2]/div/a[1]']))

WebUI.takeScreenshot()

WebUI.delay(1)

'Click submit'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/div/button']))

WebUI.delay(1)

'Click on Option 1'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/div/div/a[1]']))

WebUI.delay(2)

//LANGUAGE SETUP
'Click submit'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="fiches"]/table/tbody/tr[1]/td[10]/a[2]']))

WebUI.delay(1)

'Click on Submit'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/button[2]']))

//WAITING FOR TRANSLATION
//TRANSLATION VERIFY SUB REF
'Verify that the lifecycle status is MKT Translation'
functions.I.status_lifecycle(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[4]/div[3]/div/div[2]/div[2]/table/tbody/tr[2]/td[7]/span[2]']), 
    'MKT Translation')

//'Verify that the translation has been copied'
'Click ref link'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[4]/div[3]/div/div[2]/div[2]/table/tbody/tr[2]/td[5]/a']))

WebUI.delay(1)

'Click on text content tab'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="aff_text_content_brief"]']))

WebUI.delay(1)

//TABLE
String ExpectedValue3 = ((((((((('Analytical Constituents:' + '\n') + 'protein: %,') + '\n') + 'fat content: %,') + '\n') + 
'crude ash: %,') + '\n') + 'crude fibre: %,') + '\n') + 'omega 6 fatty acids: %.'

String ExpectedValue4 = ((((((((('Analytical constituents:' + '\n') + 'Protein: %,') + '\n') + 'Fat content: %,') + '\n') + 
'Crude ash: %,') + '\n') + 'Crude fibre: %,') + '\n') + 'Omega 6 fatty acids: %.'

WebUI.delay(3)


'208 Verify source content '
functions.I.Verify_Table_getdata('//*[@id="table_body"]', 0, 15, ExpectedValue3)

'Verify Translated reference '
functions.I.Verify_Table_getdata('//*[@id="table_body"]', 0, 16, ExpectedValue4)

//REF LSIT PAGE
'Click breadcrum'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_subheader"]/div/nav/ol/li[2]/a']))

'Screenshot: Sub translation ref'
WebUI.takeScreenshot()

WebUI.delay(1)

'Click edit Translate sub translation ref'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[4]/div[3]/div/div[2]/div[2]/table/tbody/tr[2]/td[10]/a[2]']))

WebUI.delay(1)

'Click submit Translate sub translation ref'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_content"]/div[3]/div/div[2]/div[1]/div[1]/div[2]/a']))

WebUI.delay(1)

'Click Ok'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_body"]/div[9]/div/div/div[2]/button[2]']))

'Screenshot: Ref List page'
WebUI.takeScreenshot()

//TRANSLATION VERIFY SUB REF - RSA Translation
'Verify that the lifecycle status is RSA Translation'
functions.I.status_lifecycle(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[4]/div[3]/div/div[2]/div[2]/table/tbody/tr[2]/td[7]/span[2]']), 
    'RSA Translation')

WebUI.delay(1)

'Click submit Translate sub translation ref'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[4]/div[3]/div/div[2]/div[2]/table/tbody/tr[2]/td[10]/a[3]']))

'Screenshot: Ref List page'
WebUI.takeScreenshot()

WebUI.delay(3)

//TRANSLATION VERIFY SUB REF - Complete
'Verify that the lifecycle status is RSA Translation'
functions.I.status_lifecycle(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[4]/div[3]/div/div[2]/div[2]/table/tbody/tr[2]/td[7]/span']), 
    'Complete')

// REF - Local Translation Validation
'Verify that the lifecycle status isLocal Translation Validation'
functions.I.status_lifecycle(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="fiches"]/table/tbody/tr[1]/td[7]/span[2]']), 
    'Local Translation Validation')

//READ FROM NOTEPAD TC 20.08
functions.I.writenotepad('D:\\Upoad_File\\Projet_ Login\\NPP\\16.08\\20.08_NPP_ProjectNo.txt', Project_No3)

WebUI.closeBrowser()

