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

//CHANGES DONE ON: 28/04/2022 @13.41
//DATA FLES
def data = TestDataFactory.findTestData('Data Files/Username_Password/Test_Starpack')

String password_suser = data.getValue(2, 1 ) 

def data_urlTestAUTO = TestDataFactory.findTestData('Data Files/URL/URL_testauto')

String Url_Starpack = data_urlTestAUTO.getValue(2, 2)

///////////////////////////////////////////////////////////////
//Keyword log
KeywordLogger log = new KeywordLogger()

//BROWSE & MAXIMIZE BROWSER
'Navigate to URL Starpack Test'
WebUI.openBrowser(Url_Starpack)

WebUI.maximizeWindow()

'Log in as suser/ dchi'
functions.I.Login_password('suser', password_suser)

'Screenshot: Log as suser'
WebUI.takeScreenshot()

'Click on the mediabase'
WebUI.click(findTestObject('Object Repository/Starpack Mediabase/Starpack Mediabase id_menu_medibase_tab_1a'))

'Screenshot: Mediabase Page'
WebUI.takeScreenshot()

'Click on folder Bocetos'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="mediabase-panel-cards"]/div/div[1]/div/div[1]/div/a']))

'Screenshot: Mediabase Page > Folder Bocetos'
WebUI.takeScreenshot()

'Get the doc name of the 1st file in the mediabase'
String value_title1 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div/div[4]/div[3]/div[3]/div[2]/div/div/div[1]/div[1]/div/div[2]/div/div[1]/div/div[2]/h3/label']))

functions.I.print('value for the doc - ' + value_title1)

/////////////////////////////SELECT (0)
//VErify the no in the selection has become 0
'Verify that the selection is 0'
String value_selection_no1 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="mediabase-basket"]/div[1]/div[1]/h1']))

functions.I.print('Value for selection no:' + value_selection_no1)

String expected_selected1 = 'Selection (0)'

WebUI.verifyEqual(value_selection_no1, expected_selected1)

//HOVER OVER DOC
'Hover over doc'
WebUI.mouseOver(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div/div[4]/div[3]/div[3]/div[2]/div/div/div[1]/div[1]/div/div[2]/div/div[1]/div/div[1]']))

//////////////////////////////////////////////////////
'Screenshot: Hover over doc'
WebUI.takeScreenshot()

//HOVER OVER SELECT
'hover over select'
WebUI.mouseOver(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[4]/div[3]/div[3]/div[2]/div/div/div[1]/div[1]/div/div[2]/div/div[1]/div/div[1]/div[2]/div/a[1]']))

///html/body/div[1]/div[4]/div[3]/div[3]/div[2]/div/div/div[1]/div[1]/div/div[2]/div/div[1]/div/div[1]/div[2]/div/a[1]
'Screenshot: Hover over select'
WebUI.takeScreenshot()

//Verify Tooltip is Select
'Verify tooltip is "Select'
String value1 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[2]/div[2]']))

WebUI.verifyEqual(value1, 'Select')

//VErify if the element select is clickable
'Verify if the button "Select" is clickable'
WebUI.verifyElementClickable(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[2]/div[2]']))

//Click on select
'Click on select'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[4]/div[3]/div[3]/div[2]/div/div/div[1]/div[1]/div/div[2]/div/div[1]/div/div[1]/div[2]/div/a[1]']))

//Toastr
String value_toastr = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="toast-container"]/div/div[2]']))

String value2_Expectedtoastr = 'Media added: ' + value_title1

'Screensshot: Success Message for select button (individual)'
WebUI.takeScreenshot()

WebUI.verifyMatch(value_toastr, value2_Expectedtoastr, false)

//VErify the no in the selection has become 1
String value_selection_no = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="mediabase-basket"]/div[1]/div[1]/h1']))

String expected_selected = 'Selection (1)'

//WebUI.verifyMatch(value_selection_no, expected_selected)
WebUI.verifyEqual(value_selection_no, expected_selected)

////////////////////////////////////////////////////////////////////////////////
//VErify that the section selection is  expanded > "saved selection" is visible
'Verify the selection is expanded'
WebUI.verifyElementVisible(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="basket_content_right"]/div/label']))

//Verify saved selection is not no selection
WebUI.verifyOptionNotPresentByLabel(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="id_mediabasket"]']), 'No selection', 
    false, 10)

'Screenshot: saved selection is not NO selection'
WebUI.takeScreenshot()

//VERIFY THAT THE BUTTON ADD TO SELECTION IS NOT CLICKABLE
'Verify that the button is not clickable'
WebUI.verifyElementNotClickable(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="addSelectionToBasket"]']))

//VERIFY CHECK AND UNCHECK
WebUI.check(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div/div[4]/div[3]/div[3]/div[2]/div/div/div[1]/div[1]/div/div[2]/div/div[2]/div/div[2]/h3/label']))

WebUI.verifyElementChecked(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div/div[4]/div[3]/div[3]/div[2]/div/div/div[1]/div[1]/div/div[2]/div/div[2]/div/div[2]/h3/label/input']), 
    5)

'Screenshot: Verification of chebox (checked)'
WebUI.takeScreenshot()

WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div/div[4]/div[3]/div[3]/div[2]/div/div/div[1]/div[1]/div/div[2]/div/div[2]/div/div[2]/h3/label']))

WebUI.verifyElementNotChecked(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div/div[4]/div[3]/div[3]/div[2]/div/div/div[1]/div[1]/div/div[2]/div/div[2]/div/div[2]/h3/label/input']), 
    5)

'Screenshot: Verification of chebox (Unchecked)'
WebUI.takeScreenshot()

//CLICKON CHECKBOX 2
'Click on the checkbox 2'
WebUI.check(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div/div[4]/div[3]/div[3]/div[2]/div/div/div[1]/div[1]/div/div[2]/div/div[2]/div/div[2]/h3/label']))

//CLICKON CHECKBOX 3 
'Click on the checkbox 3'
WebUI.check(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div/div[4]/div[3]/div[3]/div[2]/div/div/div[1]/div[1]/div/div[2]/div/div[3]/div/div[2]/h3/label']))

WebUI.delay(5)

'Verify that the checkbox is check'
WebUI.verifyElementAttributeValue(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div/div[4]/div[3]/div[3]/div[2]/div/div/div[1]/div[1]/div/div[2]/div/div[2]/div']), 
    'class', 'card card-custom overlay card-mediabase checked', 20)

WebUI.verifyElementAttributeValue(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div/div[4]/div[3]/div[3]/div[2]/div/div/div[1]/div[1]/div/div[2]/div/div[3]/div']), 
    'class', 'card card-custom overlay card-mediabase checked', 20)

//VERIFY THAT THE BUTTON ADD TO SELECTION IS CLICKABLE
'Verify that the button is  clickable'
WebUI.verifyElementClickable(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="addSelectionToBasket"]']))

'Screenshot: Button select is clickable'
WebUI.takeScreenshot()

////////////////////////ADD TO SELECTION BUTTON
//MOUSE OVER
WebUI.mouseOver(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="addSelectionToBasket"]']))

'Screenshot: Tooltip for add to selection button'
WebUI.takeScreenshot()

//VERIFY TOOLTIP
String tooltip_addtoselection = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[2]/div[2]']))

//Add to selection
WebUI.verifyEqual(tooltip_addtoselection, 'Add to selection')

//Click on select
////*[@id="addSelectionToBasket"]
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="addSelectionToBasket"]']))

'67'
String ToastrSucess1 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="toast-container"]/div/div[2]']))

'Screenshot: Verify the toastr message'
WebUI.takeScreenshot()

WebUI.verifyEqual(ToastrSucess1, 'Selected media added')

//VErify the no in the selection has become 3
String value_selection_no3 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="mediabase-basket"]/div[1]/div[1]/h1']))

functions.I.print('Value for selection no:' + value_selection_no3)

String expected_selected3 = 'Selection (3)'

WebUI.verifyEqual(value_selection_no3, expected_selected3)

'56 Verify that the checkbox is uncheck'
WebUI.verifyElementAttributeValue(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div/div[4]/div[3]/div[3]/div[2]/div/div/div[1]/div[1]/div/div[2]/div/div[2]/div']), 
    'class', 'card card-custom overlay card-mediabase', 20)

WebUI.verifyElementAttributeValue(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div/div[4]/div[3]/div[3]/div[2]/div/div/div[1]/div[1]/div/div[2]/div/div[3]/div']), 
    'class', 'card card-custom overlay card-mediabase', 20)

//CLICK ON EXPAND/COLLAPSE
'Click on expand/collapse'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="mediabase-basket"]/div[1]/div[2]/button']))

'Screenshot: The selection is expanded'
WebUI.takeScreenshot()

//CLICK THE EDIT SELECTION
'Edit the selection'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="basket_content_right"]/div/div[2]/a[1]']))

WebUI.delay(2)

//INPUT TEXT EDIT
'Input test in Selection name'
WebUI.clearText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="EditPanier"]/div[1]/input']))

WebUI.setText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="EditPanier"]/div[1]/input']), 'Edit Selection name')

//Input comment
'Input comment'
WebUI.setText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="EditPanier"]/div[2]/textarea']), 'Comment on this text area')

'Screenshot: Popup edit'
WebUI.takeScreenshot()

WebUI.delay(1)

//Click on eDit
'Click Edit button'
functions.I.click_button_javascript(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="DivEditPanier"]/div/div/div[3]/button[2]']))

// GET TEXT Toastr
String Sucessmsg = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="toast-container"]/div/div[2]']))

'Screenshot: Success msg for edit'
WebUI.takeScreenshot()

WebUI.verifyEqual(Sucessmsg, 'The basket Edit Selection name has successfully been updated !')

////*[@id="toast-container"]/div/button
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="toast-container"]/div/button']))

//Click Expand button
'Click on Expand button'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="mediabase-basket"]/div[1]/div[2]/button']))

'Screenshot: Verification of the selection name'
WebUI.takeScreenshot()

//VERIFY THAT SELECTION NAME HAS BEEN MODIFIED CORRECT
'Verification of the selection name'
WebUI.verifyOptionSelectedByLabel(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div/div[4]/div[6]/div[6]/div[2]/div/div/div/div[2]/div/div[1]/form/div/select']), 
    'Edit Selection name', false, 20)

'Click on delete button for the saved selection'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="basket_content_right"]/div/div[2]/a[2]']))

'Screenshot: Popup delete'
WebUI.takeScreenshot()

//CLick
'Click on delete on the popup'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="DivSupprimerPanier"]/div/div/div[3]/button[2]']))

//VErify the no in the selection has become 0
String value_selection_no00 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="mediabase-basket"]/div[1]/div[1]/h1']))

'Screenshot: Selection (0)'
WebUI.takeScreenshot()

String expected_selected00 = 'Selection (0)'

//WebUI.verifyMatch(value_selection_no, expected_selected)
WebUI.verifyEqual(value_selection_no00, expected_selected00)

//VErify the no in the selection get all
String value_selection_noAll = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : ' //*[@id="kt_content"]/div[3]/div[1]/div[1]/h1/span']))

Int_SelectAll = value_selection_noAll.toInteger()

functions.I.print('Section All: ' + Int_SelectAll)

//CLICK ON SELECT ALL
'Click on select all'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="allRefs"]']))

WebUI.delay(2)
'Screenshot: Verification of the selection all checkbox'
WebUI.takeScreenshot()

//VERIFY THAT CHECKBOX
for (int i = 1; i <= Int_SelectAll; i++) {
    functions.I.VerifyCheckboxChecked('checkbox 1', findTestObject('Object Repository/Starpack Mediabase/Starpack Mediabase checkbox', 
            [('No') : i]))
}

//CLICK ON DESELECT ALL
'Click on deselect all'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="allRefs"]']))

for (int i = 1; i <= Int_SelectAll; i++) {
    WebUI.verifyElementAttributeValue(findTestObject('1. Constant/xpath', [('xpath') : ('/html/body/div[1]/div[4]/div[3]/div[3]/div[2]/div/div/div[1]/div[1]/div/div[2]/div/div[' + 
                i) + ']/div']), 'class', 'card card-custom overlay card-mediabase', 20)
}

'Screenshot: Verification of the deselection all'
WebUI.takeScreenshot()

'Click on select all'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="allRefs"]']))

WebUI.delay(2)

'100 Click on add to selection'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="addSelectionToBasket"]']))

WebUI.delay(2)

/*
//VErify Toastr
'104 Verify Toastr'
String Sucessmsg2 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="toast-container"]/div/div[2]']))

'111 Screenshot: toastr success all'
WebUI.takeScreenshot()

WebUI.verifyEqual(Sucessmsg2, 'Selected media added')
*/
for (int i = 1; i <= Int_SelectAll; i++) {
    WebUI.verifyElementAttributeValue(findTestObject('1. Constant/xpath', [('xpath') : ('/html/body/div[1]/div[4]/div[3]/div[3]/div[2]/div/div/div[1]/div[1]/div/div[2]/div/div[' + 
                i) + ']/div']), 'class', 'card card-custom overlay card-mediabase', 20)
}

//VErify the no in the selection has become all
String value_selection_noalll = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="mediabase-basket"]/div[1]/div[1]/h1']))

functions.I.print('Value for selection no:' + value_selection_noalll)

WebUI.verifyEqual(value_selection_noalll, ('Selection (' + value_selection_noAll) + ')')

'Screensshot: All folder have been selected'
WebUI.takeScreenshot()

'Click on expand'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="mediabase-basket"]/div[1]/div[2]/button']))

'Click on delete button for the saved selection'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="basket_content_right"]/div/div[2]/a[2]']))

'Click on delete on the popup'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="DivSupprimerPanier"]/div/div/div[3]/button[2]']))

//VErify the no in the selection has become 0
String value_selection_no000 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="mediabase-basket"]/div[1]/div[1]/h1']))

functions.I.print('Value for selection no:' + value_selection_no000)

WebUI.verifyEqual(value_selection_no000, 'Selection (0)')

'Screensshot: Selection deleted'
WebUI.takeScreenshot()

WebUI.closeBrowser()

