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

///////////////////////////USERNAME - PASSWORD - URL////////////////////////////////////
//USERNAME & PASSWORD  - Dreyers
def data_ClicknPrint = TestDataFactory.findTestData('Data Files/Username_Password/Test_ClicknPrint')

String password_suser = data_ClicknPrint.getValue(2, 1)

String password_gbouquard = data_ClicknPrint.getValue(2, 2)

String password_jde_rcr = data_ClicknPrint.getValue(2, 3)

//URL
def data_urlTESTAUTO = TestDataFactory.findTestData('Data Files/URL/URL_testauto')

String Url_ClicknPrint = data_urlTESTAUTO.getValue(2, 6)

///////////////////////////// TEST BEGIN /////////////////////////////////////////
//BROWSE & MAXIMIZE BROWSER
'Navigate to URL ClickNPrint'
WebUI.openBrowser(Url_ClicknPrint)

WebUI.maximizeWindow()

WebUI.waitForPageLoad(30)

///////////////////////////////// NAVIGATING TO DREYERS  ////////////////////////////////////////////
'Screenshot: Navigate to URL Dreyer Release'
WebUI.takeScreenshot()

'Log in gbouquard '
functions.I.Login_password('gbouquard', password_gbouquard)

'Click on the lhs menu - project tab'
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

///////////////////////////////// CREATION OF PROJECT  ////////////////////////////////////////////
'click on + button to create project'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_content"]/div[3]/div/div/div[1]/div[2]/a[1]']))

'Screenshot: Project form'
WebUI.takeScreenshot()

WebUI.delay(1)

'Select Client :4340 ADMF - FABRICE BRAOUEZEC'
WebUI.selectOptionByValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_18"]']), '4340', false)

WebUI.delay(1)

'Date de livraison attendue: 01/01/2030'
WebUI.setText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_22"]']), '01/01/2030')

WebUI.delay(1)

'Commentaires: Commentaires test'
WebUI.setText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_173"]']), 'Commentaires test')

WebUI.delay(5)

functions.I.Pagedown()

'Click on Modify this Project'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[3]/div/button']))

WebUI.delay(10)

String Project_No = functions.I.ProjectNo()

'Screenshot: Ref list page'
WebUI.takeScreenshot()

///////////////////////////////// CREATION OF MOTHER REFERENCE  ////////////////////////////////////////////
'Click on + to create ref'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="create_ref_btn"]/button']))

WebUI.delay(1)

'Screenshot: Redemarrer commande'
WebUI.takeScreenshot()

'Click demarrer comande'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="create_ref_btn"]/div/a[1]']))

WebUI.delay(1)

'Click on + to  select selen/etiquette'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="create_ref_btn"]/button']))

WebUI.delay(1)

'Screenshot: Select elan etiquette'
WebUI.takeScreenshot()

'Click select lexan /etiquette'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="btnImportFromPOS"]']))

WebUI.delay(2)

'Screenshot: Catalogue page'
WebUI.takeScreenshot()

'Enter text in filter keywords'
WebUI.setText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="fiche_filter_keywords11"]']), '2167')

'Click Apply'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="form_filters"]/div[3]/button']))

'Screenshot: ref filtered'
WebUI.takeScreenshot()

'41 Click on duplicate ref'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="btnduplicatereference"]']))

WebUI.delay(1)

'Screenshot: Confirm selection button'
WebUI.takeScreenshot()

WebUI.delay(1)

'Check the checkbox'
WebUI.check(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[4]/div[3]/div/div[2]/div[2]/div[1]/table/tbody/tr[2]/td[1]/label']))

'Click on confirm selection'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="action_btnduplicatereference"]']))

WebUI.delay(2)

'Screenshot: Duplicate ref popup'
WebUI.takeScreenshot()

'Verify if the project is prefilled'
String Project_name1 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="select2-nbProject-container"]']))

WebUI.verifyMatch(Project_name1, 'ADMF - FABRICE BRAOUEZEC - ' + Project_No, false)

functions.I.print(Project_name1)

'Click on submit duplication'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="btn_submit_duplication"]']))

'Screenshot: Redirect to ref listpage'
WebUI.takeScreenshot()

WebUI.delay(1)

/////////////////////////////////////ERRROR MESSGAGE
'Click on submit for mother ref'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[4]/div[3]/div/div[2]/div[2]/div[1]/table/tbody/tr[2]/td[12]/a']))

WebUI.delay(1)

'Verify error msg'
String toastr1 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="toast-container"]/div/div[2]']))

WebUI.verifyMatch(toastr1, 'The condition \'Quantité des produits - JDE\' is not matched', false)

'Screenshot: Toastr error msg'
WebUI.takeScreenshot()

'Logout'
functions.I.Logout()

/////////////////////////////////////////////////LOGIN AS jde_rcr	
'Login as jde_rcr'
functions.I.Login_password('jde_rcr', password_jde_rcr)

'Click on the LHS menu'
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

'Search for the project no'
functions.I.SearchProjectNo(Project_No, findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="form_filters"]/div[4]/button']))

'Screenshot: ref list page'
WebUI.takeScreenshot()

//MOTHER REF
'Click on link'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[4]/div[3]/div/div[2]/div[2]/div[1]/table/tbody/tr[1]/td[9]/a[1]']))

'Screenshot: ref page'
WebUI.takeScreenshot()

'get refiD '
String refID = functions.I.RefID()

String refID_daughter1 = Integer.parseInt(refID) + 1

functions.I.print(refID)

'Click on lifecycle tab'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_content"]/div[3]/div/ul/li[3]/a']))

'Verify that lifecycle is Attente des produits individuels'
String lifecyclestatus_Mother = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/div/div[1]/div/div/div/div[1]/div[1]/h3']))

WebUI.verifyMatch(lifecyclestatus_Mother, 'Attente des produits individuels', false)

'Screenshot: Lifecycle tab'
WebUI.takeScreenshot()

'Click on fils dariane'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_subheader"]/div/nav/ol/li[2]/a']))

'Screenshot: ref list page'
WebUI.takeScreenshot()

//DAUGHTER REF
'Click on submit for the daughter ref'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID_daughter1) + '"]/td[12]/a[2]']))

'Screenshot: ref modif page'
WebUI.takeScreenshot()

'Enter quantity: 1'
WebUI.setText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_23"]']), '1')

'Click on submit for the daughter ref'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/button[2]']))

//MOTHER REF
' submit'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID) + '"]/td[12]/a']))

WebUI.delay(1)

'Click on link'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID) + '"]/td[9]/a[1]']))

'Click on lifecycle tab'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_content"]/div[3]/div/ul/li[3]/a']))

'Verify that lifecycle is Vérification de la quantité'
String lifecyclestatus_Mother1 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/div/div[2]/div/div/div/div[1]/div[1]/h3']))

WebUI.verifyMatch(lifecyclestatus_Mother1, 'Vérification de la quantité', false)

WebUI.closeBrowser()

