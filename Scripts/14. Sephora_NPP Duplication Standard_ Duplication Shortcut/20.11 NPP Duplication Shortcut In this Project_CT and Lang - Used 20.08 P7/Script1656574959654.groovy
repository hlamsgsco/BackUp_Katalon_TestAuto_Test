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

///////////////////////////USERNAME - PASSWORD - URL////////////////////////////////////
//USERNAME & PASSWORD  - NPP
def data_Npp = TestDataFactory.findTestData('Data Files/Username_Password/Test_Npp')

String password_ncur = data_Npp.getValue(2, 1) //R

String password_akim = data_Npp.getValue(2, 2) //R


def data_urlAUTO = TestDataFactory.findTestData('Data Files/URL/URL_testauto')

String Url_Npp = data_urlAUTO.getValue(2, 5)

//READ FROM NOTEPAD TC 16.08
String Project_No = functions.I.readnotepad('D:\\Upoad_File\\zTest_Auto\\Test_Projet_Login\\NPP\\16.08\\20.08_NPP_ProjectNo.txt')

String refID = functions.I.readnotepad('D:\\Upoad_File\\zTest_Auto\\Test_Projet_Login\\NPP\\16.08\\20.08_NPP_refID.txt')


////////////////////////////NAVIGATE TO NPP ///////////////////////////////////
'Navigate to NPP'
WebUI.openBrowser(Url_Npp)

// http://mdb-release.diadeis.lan/MediaboxIndependence/?MBI_datasource=
WebUI.maximizeWindow()

'Screenshot: Navigate to Npp'
WebUI.takeScreenshot()

'Login as ncur'
functions.I.Login_password('ncur', password_ncur)

'Screenshot: Dashboard page '
WebUI.takeScreenshot()

'ncur Click on the lhs menu - project tab'
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

WebUI.delay(1)


//REF LIST PAGE
'Search for the project number'
functions.I.SearchProjectNo_xpath(Project_No, '//*[@id="keynum_project"]', '//*[@id="form_filters"]/div[9]/button')

WebUI.delay(1)


'Click on duplicate'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_content"]/div[3]/div/div[2]/div[1]/div[2]/span/div/button']))

WebUI.delay(1)

'Choose 1st option - Duplicate in a new LSS Version'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="btnduplicatereference"]']))

'select all ref - 1 ref'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="fiches"]/table/thead/tr/th[1]/label']))

WebUI.delay(1)

'Click confirm duplication'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="action_btnduplicatereference"]']))

WebUI.delay(1)

//POPUP DUPLICATION
'Screenshot: Popup dupli'
WebUI.takeScreenshot()

'Click //Content source texts and languages'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="modal_duplicate_reference"]/div/div/div[2]/div/div[8]/div[1]/label[4]']))

'Verify the text of the Window HELPER TEXT is: New LSS version'
functions.I.VerifyMatchText('//*[@id="info_translation_block"]', 'This option will duplicate the values from the brief, the source text structure and content, as well as the translations.')

//NO OTHER OPTION FOR REF TEMPLATE + REF TEMPLATE IS PREFILLED
'Verify that there is no other option in the ref template list'
int No_Reftemplate = WebUI.getNumberOfTotalOption(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ref_tpl7"]']))

WebUI.verifyEqual(No_Reftemplate, '1')

'Verify that ref template is prefilled - LSS Reference'
functions.I.VerifyMatchText('//*[@id="select2-ref_tpl7-container"]', 'LSS Reference')

//THERE IS OTHER OPTION FOR LIFECYCLE TEMPLATE + IT IS PREFILLED
'Verify that there is no other option in the ref template list'
int No_lifetemplate = WebUI.getNumberOfTotalOption(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="lfc_tpl7"]']))

WebUI.verifyEqual(No_lifetemplate, '5')

'Verify that ref template is prefilled - LSS Reference'
functions.I.VerifyMatchText('//*[@id="select2-lfc_tpl7-container"]', 'LSS Lifecycle (3)')

'Click on the duplication button'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="btn_submit_duplication"]']))

//REF LIST PAGE
'Verify that the no of ref is 2'
functions.I.VerifyMatchText('//*[@id="kt_content"]/div[3]/div/div[2]/div[1]/div[1]/h1/span', '2')

'Verify lifecycle status of dupli ref'
functions.I.status_lifecycle(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="fiches"]/table/tbody/tr[3]/td[7]/span[2]']), 'LSS Pre-fill')

'Verify lifecycle status of sub ref'
functions.I.status_lifecycle(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[4]/div[3]/div/div[2]/div[2]/table/tbody/tr[4]/td[7]']), 'No lifecycle')

'Click on reflink'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="fiches"]/table/tbody/tr[3]/td[5]/a[1]']))

WebUI.delay(1)

//GET REF ID 2
 String refid2 = functions.I.RefID_Npp()

//VERIFY FIELDS ARE PREFILLED
'Click FULL tab'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="aff_full_brief"]']))

WebUI.delay(1)

//RECIPE
'Technology - Litter'
functions.I.VerifyMatchText('/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[1]/div/div[2]/div/div[2]/div[2]/div[2]/div[2]/div[1]/div',
	'Litter')

'Texture'
functions.I.VerifyMatchText('/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[1]/div/div[2]/div/div[2]/div[2]/div[2]/div[2]/div[2]/div',
	('Clumping clay' + '\n') + 'Corn' + '\n' + 'Grass')

'Variety: Variety test'
functions.I.VerifyMatchText('/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[1]/div/div[2]/div/div[2]/div[2]/div[2]/div[2]/div[3]/div',
	'Variety test')

' Alternative Format Code: Alternative Format code test'
functions.I.VerifyMatchText('/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[1]/div/div[2]/div/div[2]/div[2]/div[2]/div[2]/div[4]/div',
	'Alternative Format code test')

' Format prooduct designation'
functions.I.VerifyMatchText('/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[1]/div/div[2]/div/div[2]/div[2]/div[2]/div[2]/div[5]/div',
	'FORMAT Product designation test')

' SAP designation'
functions.I.VerifyMatchText('/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[1]/div/div[2]/div/div[2]/div[2]/div[2]/div[2]/div[6]/div',
	'SAP Designation test > https://www.google.com/')

'Clam Subs Project link'
functions.I.VerifyMatchText('/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[1]/div/div[2]/div/div[2]/div[2]/div[2]/div[2]/div[7]/div',
	'Claim Substantiation Project Link > https://www.google.com/')

'Grading Link'
functions.I.VerifyMatchText('/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[1]/div/div[2]/div/div[2]/div[2]/div[2]/div[2]/div[8]/div',
	'Grading standard link > test')

//PROJECT INFORMATION
'DEPT'
functions.I.VerifyMatchText('/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[1]/div/div[2]/div/div[2]/div[2]/div[3]/div[2]/div[1]/div',
	'DPET > test')

'Project name'
functions.I.VerifyMatchText('/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[1]/div/div[2]/div/div[2]/div[2]/div[3]/div[2]/div[2]/div',
	'Project name > test')

'Project type'
functions.I.VerifyMatchText('/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[1]/div/div[2]/div/div[2]/div[2]/div[3]/div[2]/div[3]/div',
	'HIP')

'LSS Planned issue date'
functions.I.VerifyMatchText('/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[1]/div/div[2]/div/div[2]/div[2]/div[3]/div[2]/div[4]/div',
	'25/08/2021')

'LSS Translation due date'
functions.I.VerifyMatchText('/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[1]/div/div[2]/div/div[2]/div[2]/div[3]/div[2]/div[5]/div',
	'01/12/2021')

'Mkt translation die date'
functions.I.VerifyMatchText('/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[1]/div/div[2]/div/div[2]/div[2]/div[3]/div[2]/div[6]/div',
	'01/12/2021')

'Project Info Comments'
functions.I.VerifyMatchText('/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[1]/div/div[2]/div/div[2]/div[2]/div[3]/div[2]/div[7]/div',
	'Project Information - Comments')

'Reason for change'
functions.I.VerifyMatchText('/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[1]/div/div[2]/div/div[2]/div[2]/div[3]/div[2]/div[8]/div',
	'Reason for change test')

//PRODUCT INFORMATION
'Brands: Tidy Cat'
functions.I.VerifyMatchText('/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[1]/div/div[2]/div/div[2]/div[2]/div[4]/div[2]/div[1]/div',
	'Tidy Cat')

'Sub brands: Tidy Cat - CRYSTALS BLEND'
functions.I.VerifyMatchText('/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[1]/div/div[2]/div/div[2]/div[2]/div[4]/div[2]/div[2]/div',
	'Tidy Cat - CRYSTALS BLEND')

'Range type'
functions.I.VerifyMatchText('/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[1]/div/div[2]/div/div[2]/div[2]/div[4]/div[2]/div[3]/div',
	'Premium')

'Product descriptor'
functions.I.VerifyMatchText('/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[1]/div/div[2]/div/div[2]/div[2]/div[4]/div[2]/div[4]/div',
	'Superfood')

'Presence of colors '
functions.I.VerifyMatchText('/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[1]/div/div[2]/div/div[2]/div[2]/div[4]/div[2]/div[5]/div',
	'No color')

' Colors'
functions.I.VerifyMatchText('/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[1]/div/div[2]/div/div[2]/div[2]/div[4]/div[2]/div[6]/div',
	'Not applicable')

'Presence of veg: Yes'
functions.I.VerifyMatchText('/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[1]/div/div[2]/div/div[2]/div[2]/div[4]/div[2]/div[7]/div',
	'Yes')

'Type of feed: Complete'
functions.I.VerifyMatchText('/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[1]/div/div[2]/div/div[2]/div[2]/div[4]/div[2]/div[8]/div',
	'Complete')

'Animal Species: Dogs & Cats'
functions.I.VerifyMatchText('/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[1]/div/div[2]/div/div[2]/div[2]/div[4]/div[2]/div[9]/div',
	'Dogs & Cats')

'Lifestage: Tidy Cat - Adult'
functions.I.VerifyMatchText('/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[1]/div/div[2]/div/div[2]/div[2]/div[4]/div[2]/div[10]/div',
	'Tidy Cat - Adult')

'Lifestyle: Light'
functions.I.VerifyMatchText('/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[1]/div/div[2]/div/div[2]/div[2]/div[4]/div[2]/div[11]/div',
	'Light')

'Animal size  All'
functions.I.VerifyMatchText('/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[1]/div/div[2]/div/div[2]/div[2]/div[4]/div[2]/div[12]/div',
	'All')

'Animal activity level : Active'
functions.I.VerifyMatchText('/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[1]/div/div[2]/div/div[2]/div[2]/div[4]/div[2]/div[13]/div',
	'Active')

//PRODUcT
'Factories :FR DC SPI Ham / FR PL Montfort'
functions.I.VerifyMatchText('/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[1]/div/div[2]/div/div[2]/div[2]/div[6]/div[2]/div[1]/div',
	('FR DC SPI Ham' + '\n') + 'FR PL Montfort')

'Back-up factories: FR DC SPI Ham'
functions.I.VerifyMatchText('/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[1]/div/div[2]/div/div[2]/div[2]/div[6]/div[2]/div[2]/div',
	'FR DC SPI Ham')

'Comanufacturers : Animal Lovers'
functions.I.VerifyMatchText('/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[1]/div/div[2]/div/div[2]/div[2]/div[6]/div[2]/div[3]/div',
	'Animal Lovers')

'Copackers :Deuerer'
functions.I.VerifyMatchText('/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[1]/div/div[2]/div/div[2]/div[2]/div[6]/div[2]/div[4]/div',
	'Deuerer')

'Manufacturing method :Mousse'
functions.I.VerifyMatchText('/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[1]/div/div[2]/div/div[2]/div[2]/div[6]/div[2]/div[5]/div',
	'Mousse')

//TEAM
'PP Specialist - Technical Leader :Anna KIM'
functions.I.VerifyMatchText('/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[1]/div/div[2]/div/div[2]/div[2]/div[7]/div[2]/div[1]/div',
	'Anna KIM')

'PP Back-up :AnneLise GAUDIN'
functions.I.VerifyMatchText('/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[1]/div/div[2]/div/div[2]/div[2]/div[7]/div[2]/div[2]/div',
	'AnneLise GAUDIN')

'Product Experience Brand Manager :Alexandra FRAPPAZ'
functions.I.VerifyMatchText('/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[1]/div/div[2]/div/div[2]/div[2]/div[7]/div[2]/div[3]/div',
	'Alexandra FRAPPAZ')

'Additional Product Experience Brand Manager(s) :Anastasiia BRAZHNIKOVA PX / Amelia LARKINS /Camille DEMONCHY'
functions.I.VerifyMatchText('/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[1]/div/div[2]/div/div[2]/div[2]/div[7]/div[2]/div[4]/div',
	((('Anastasiia BRAZHNIKOVA PX' + '\n') + 'Amelia LARKINS') + '\n') + 'Camille DEMONCHY')

'Design to Deliver Manager (D2D) :Adam SVEGAARD (D2D)'
functions.I.VerifyMatchText('/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[1]/div/div[2]/div/div[2]/div[2]/div[7]/div[2]/div[5]/div',
	'Adam SVEGAARD (D2D)')

'Central RSA : Amelie SERMENT'
functions.I.VerifyMatchText('/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[1]/div/div[2]/div/div[2]/div[2]/div[7]/div[2]/div[6]/div',
	'Amelie SERMENT')

'E2E Project Manager :Alexandra SAVREUX (E2E)'
functions.I.VerifyMatchText('/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[1]/div/div[2]/div/div[2]/div[2]/div[7]/div[2]/div[7]/div',
	'Alexandra SAVREUX (E2E)')

'Nutritionist : Ana CHAVES'
functions.I.VerifyMatchText('/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[1]/div/div[2]/div/div[2]/div[2]/div[7]/div[2]/div[8]/div',
	'Ana CHAVES')

'Is Local RSA RU approval required ? :No'
functions.I.VerifyMatchText('/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[1]/div/div[2]/div/div[2]/div[2]/div[7]/div[2]/div[9]/div',
	'No')

'Is Local RSA FR approval required ? :No'
functions.I.VerifyMatchText('/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[1]/div/div[2]/div/div[2]/div[2]/div[7]/div[2]/div[10]/div',
	'No')

'Is Local RSA UK approval required ? :No'
functions.I.VerifyMatchText('/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[1]/div/div[2]/div/div[2]/div[2]/div[7]/div[2]/div[11]/div',
	'No')

//Packaging & Distribution
'Expected commercialisation zone: LATAM'
functions.I.VerifyMatchText('/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[1]/div/div[2]/div/div[2]/div[2]/div[8]/div[2]/div[1]/div',
	'LATAM')

'Pack type :Bag - Woven'
functions.I.VerifyMatchText('/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[1]/div/div[2]/div/div[2]/div[2]/div[8]/div[2]/div[2]/div',
	'Bag - Woven')

'Pack format :1.1kg / 1.2kg'
functions.I.VerifyMatchText('/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[1]/div/div[2]/div/div[2]/div[2]/div[8]/div[2]/div[3]/div',
	('1.1kg' + '\n') + '1.2kg')

'Distribution channel : Vet'
functions.I.VerifyMatchText('/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[1]/div/div[2]/div/div[2]/div[2]/div[8]/div[2]/div[4]/div',
	'Vet')

'Selling countries :Albania/ Austria'
functions.I.VerifyMatchText('/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[1]/div/div[2]/div/div[2]/div[2]/div[8]/div[2]/div[5]/div',
	('Albania' + '\n') + 'Austria')

//PP Specialist Signature
'PP Specialist - Approver : Anna KIM'
functions.I.VerifyMatchText('/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[1]/div/div[2]/div/div[2]/div[2]/div[9]/div[2]/div[1]/div',
	'Anna KIM')

// PX Signature
'Product Experience Brand Manager - Approver: Alexandra FRAPPAZ'
functions.I.VerifyMatchText('/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[1]/div/div[2]/div/div[2]/div[2]/div[11]/div[2]/div[1]/div',
	'Alexandra FRAPPAZ')

//Central RSA Signature
'Central RSA - Approver: Amelie SERMENT'
functions.I.VerifyMatchText('/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[1]/div/div[2]/div/div[2]/div[2]/div[12]/div[2]/div[1]/div',
	'Amelie SERMENT')

//Version History
'Version History: Version History'
functions.I.VerifyMatchText('/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[1]/div/div[2]/div/div[2]/div[2]/div[17]/div[2]/div/div',
	'Version History')


//LIFECYCLE TAB
WebUI.delay(1)

'Click Lifecycle tab'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_content"]/div[3]/div/ul/li[3]/a']))

WebUI.delay(1)

'Verify that the Lifeycle template is LSS Lifecycle (3)'
functions.I.VerifyMatchText('//*[@id="tab_lifecycle"]/div/h3', 'LSS Lifecycle (3)')

WebUI.delay(1)

//CONTENT TEMPALTE BLANK
'Click Brief tab'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_content"]/div[3]/div/ul/li[1]/a']))

WebUI.delay(1)

'Click Text Content tab'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="aff_text_content_brief"]']))

WebUI.delay(5)

//TABLE
String ExpectedValue3 = ((((((((('Analytical Constituents:' + '\n') + 'protein: %,') + '\n') + 'fat content: %,') + '\n') +
'crude ash: %,') + '\n') + 'crude fibre: %,') + '\n') + 'omega 6 fatty acids: %.'

String ExpectedValue4 = ((((((((('Analytical constituents:' + '\n') + 'Protein: %,') + '\n') + 'Fat content: %,') + '\n') +
'Crude ash: %,') + '\n') + 'Crude fibre: %,') + '\n') + 'Omega 6 fatty acids: %.'

'Verify source content '
functions.I.Verify_Table_getdata('//*[@id="table_body"]', 0, 15, ExpectedValue3)

'Verify Translated reference '
functions.I.Verify_Table_getdata('//*[@id="table_body"]', 0, 16, ExpectedValue4)


//PARENT BUTTON
'Click phase tab'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="aff_phase_brief"]']))

'click view parent '
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="btn_view_ref_parent"]']))

'Screenshot: Refpage'
WebUI.takeScreenshot()

WebUI.delay(1)

String parent_refid = functions.I.RefID_Npp()

'Verify that user is redirect to the parent ref'
WebUI.verifyNotMatch(parent_refid, refID, false)

'114 Logout'
functions.I.Logout_xpath('//*[@id="kt_header"]/div/div[2]/div[2]/div[1]/div/span/img', '//*[@id="kt_header"]/div/div[2]/div[2]/div[2]/a[2]')

//AKIM SUBMIT & SUPER EDIT	
'Login as akim '
functions.I.Login_password('akim', password_akim)

'Screenshot: Dashboard page '
WebUI.takeScreenshot()

'ncur Click on the lhs menu - project tab'
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

//REF LIST PAGE
'Search for the project number'
functions.I.SearchProjectNo_xpath(Project_No, '//*[@id="keynum_project"]', '//*[@id="form_filters"]/div[20]/button')

WebUI.delay(1)

'Superedit'
functions.I.superedit_ref(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="fiches"]/table/tbody/tr[3]/td[9]/div[2]/button']), findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="fiches"]/table/tbody/tr[3]/td[9]/div[2]/div/a[4]']))

'Enter Variety'
WebUI.setText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_110"]']), 'Super edit Variety')

functions.I.Pagedown()
'Update'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[3]/div/button']))

WebUI.delay(1)

'Submit p'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="fiches"]/table/tbody/tr[3]/td[9]/a']))

'Verify value of the variety'
String Actual_Edited_Variety = WebUI.getAttribute(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_110"]']), 'value')

WebUI.verifyMatch(Actual_Edited_Variety,'Super edit Variety', false)

'Submit'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/button[2]']))

'Verify lifecycle'
functions.I.status_lifecycle(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="fiches"]/table/tbody/tr[3]/td[7]/span[2]']), 'LSS Creation')

WebUI.closeBrowser()
