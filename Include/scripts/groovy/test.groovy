import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI



import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException
import com.kms.katalon.core.logging.KeywordLogger as KeywordLogger

import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When




class test {
	/**
	 * The step definitions below match with Katalon sample Gherkin steps
	 */



	@Given("I am on (.*)")
	def I_am_on_Mediabox_Starpack(String Mediabox_Starpack) {
		//BROWSE & MAXIMIZE BROWSER
		WebUI.openBrowser(Mediabox_Starpack)
		WebUI.maximizeWindow()
		WebUI.waitForPageLoad(30)
		WebUI.takeScreenshot()



	}
	@When("I login as suser")
	def I_login_as_suser() {
		String password_suser = TestDataFactory.findTestData("Data Files/Username_Password/Starpack (10June2021)").getValue(2, 1)

		'Login as suser'
		functions.I.Login_password('suser', password_suser)
		WebUI.takeScreenshot()
		WebUI.waitForPageLoad(30)
	}


	@And("I see the settings in the menu")
	def I_see_the_settings_in_the_menu() {
		'Verify that Settings is present in the menu'
		WebUI.verifyElementVisible(findTestObject('Object Repository/Starpack USermanagement/1.0 R_Menu_Settings id_kt_aside_menu_ul_li11aspan2'))
	}
	@And("I click on the menu > Settings")
	def I_click_on_the_menu_Settings() {
		'Verify that Settings is present in the menu'
		WebUI.click(findTestObject('Object Repository/Starpack USermanagement/1.0 R_Menu_Settings id_kt_aside_menu_ul_li11aspan2'))
		WebUI.takeScreenshot()
	}

	@Then ("I see the user management in the menu")
	def I_see_the_user_management_in_the_menu() {
		WebUI.verifyElementVisible(findTestObject('Object Repository/Starpack USermanagement/1.01_Menu_Usermanagement id_kt_aside_menu_ul_li11div_ul_li2aspan'))
		WebUI.waitForPageLoad(30)
	}

	@When ("I click on user management button")
	def I_click_on_usermanagement_button() {
		WebUI.click(findTestObject('Object Repository/Starpack USermanagement/1.01_Menu_Usermanagement id_kt_aside_menu_ul_li11div_ul_li2aspan'))
	}

	@And ("I click on Create user button")
	def I_click_on_Create_user_button () {
		'Click create user button'
		WebUI.click(findTestObject('Object Repository/Starpack USermanagement/1.02 Createuserbutton id_kt_content_div3divdivdivdiv1_diva3'))
		WebUI.waitForPageLoad(30)
		'Screenshot: User creation Page'
		WebUI.takeScreenshot()
	}

	@Then ("I see the (.*) page")
	def I_see_the_user_creation_page (String user_creation) {
		println('User is on user creation page' + user_creation)
	}
}


