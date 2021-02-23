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
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.openBrowser('')

WebUI.navigateToUrl('https://katalon-demo-cura.herokuapp.com/')

WebUI.click(findTestObject('Object Repository/Login/Page_Saleor e-commerce/Page_CURA Healthcare Service/a_Make Appointment'))

WebUI.setText(findTestObject('Object Repository/Login/Page_Saleor e-commerce/Page_CURA Healthcare Service/input_Username'), 
    Username)

WebUI.setEncryptedText(findTestObject('Object Repository/Login/Page_Saleor e-commerce/Page_CURA Healthcare Service/Pass'), 
    Pass)

WebUI.click(findTestObject('Object Repository/Login/Page_Saleor e-commerce/Page_CURA Healthcare Service/btn_button'))

WebUI.click(findTestObject('Object Repository/Login/Page_Saleor e-commerce/Page_CURA Healthcare Service/p_Login failed Please ensure the username a_eb55b5'))

WebUI.setText(findTestObject('Object Repository/Login/Page_Saleor e-commerce/Page_CURA Healthcare Service/input_Username'), 
  Username13408290)

WebUI.setEncryptedText(findTestObject('Object Repository/Login/Page_Saleor e-commerce/Page_CURA Healthcare Service/Pass'), 
  Pass68761848)

WebUI.click(findTestObject('Object Repository/Login/Page_Saleor e-commerce/Page_CURA Healthcare Service/btn_button'))

WebUI.setText(findTestObject('Object Repository/Login/Page_Saleor e-commerce/Page_CURA Healthcare Service/input_Username'), 
  Username48633706)

WebUI.setEncryptedText(findTestObject('Object Repository/Login/Page_Saleor e-commerce/Page_CURA Healthcare Service/Pass'), 
  Pass61391365)

WebUI.click(findTestObject('Object Repository/Login/Page_Saleor e-commerce/Page_CURA Healthcare Service/btn_button'))

WebUI.click(findTestObject('Object Repository/Login/Page_Saleor e-commerce/Page_CURA Healthcare Service/txt_Demo account_form-control'))

WebUI.rightClick(findTestObject('Object Repository/Login/Page_Saleor e-commerce/Page_CURA Healthcare Service/txt_Demo account_form-control'))

WebUI.rightClick(findTestObject('Object Repository/Login/Page_Saleor e-commerce/Page_CURA Healthcare Service/input_Username'))

WebUI.click(findTestObject('Object Repository/Login/Page_Saleor e-commerce/Page_CURA Healthcare Service/input_Demo account_form-control_1'))

WebUI.rightClick(findTestObject('Object Repository/Login/Page_Saleor e-commerce/Page_CURA Healthcare Service/input_Demo account_form-control_1'))

WebUI.rightClick(findTestObject('Object Repository/Login/Page_Saleor e-commerce/Page_CURA Healthcare Service/Pass'))

WebUI.setText(findTestObject('Object Repository/Login/Page_Saleor e-commerce/Page_CURA Healthcare Service/input_Username'),     
  Username16742483)

WebUI.setEncryptedText(findTestObject('Object Repository/Login/Page_Saleor e-commerce/Page_CURA Healthcare Service/Pass'),     
  Pass35988477)

WebUI.sendKeys(findTestObject('Object Repository/Login/Page_Saleor e-commerce/Page_CURA Healthcare Service/Pass'), Keys.chord(
  Keys.ENTER))

WebUI.selectOptionByValue(findTestObject('Object Repository/Login/Page_Saleor e-commerce/Page_CURA Healthcare Service/select_Tokyo CURA Healthcare Center_5b4107'), 
  'Hongkong CURA Healthcare Center', true)

WebUI.click(findTestObject('Object Repository/Login/Page_Saleor e-commerce/Page_CURA Healthcare Service/input_Medicaid_programs'))

WebUI.click(findTestObject('Object Repository/Login/Page_Saleor e-commerce/Page_CURA Healthcare Service/input_Apply for hospital readmission_hospit_63901f'))

WebUI.verifyElementPresent(findTestObject('Object Repository/Login/Page_Saleor e-commerce/Page_CURA Healthcare Service/label_Apply for hospital readmission'), 
  0)

WebUI.setText(findTestObject('Object Repository/Login/Page_Saleor e-commerce/Page_CURA Healthcare Service/input_Visit Date Required_visit_date'),     
  VisitDateRequiredVisitDate)

WebUI.setText(findTestObject('Object Repository/Login/Page_Saleor e-commerce/Page_CURA Healthcare Service/input_Visit Date Required_visit_date'),     
  VisitDateRequiredVisitDate)

WebUI.setText(findTestObject('Object Repository/Login/Page_Saleor e-commerce/Page_CURA Healthcare Service/textarea_Comment_comment'),     
  CommentComment)

WebUI.click(findTestObject('Object Repository/Login/Page_Saleor e-commerce/Page_CURA Healthcare Service/button_Book Appointment'))
