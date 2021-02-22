package common

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable

public class StringHelper {
  public static String randomValue(String value = 'abc') {
    def random = Math.abs(new Random().nextInt() % 100000000 + 1) //random range 1-10000
    WebUI.comment("${value}${random}")
    return "${value}${random}"
  }

  public String splitAndConcatPath(String str){
    String[] splitStr = str.split("/")
    String folderID = ""
    for(int i = 1; i < splitStr.length; i++){
      folderID += "/" + splitStr[i]
    }
    println folderID
    return folderID
  }
  
  
  public String setNameVariable(String str, String regex ){
    String[] splitStr = str.split(regex)
    print "splitStr: ${splitStr.length}"
    
    //remove "/"
    String[] nameObj = splitStr[1].split("/")
    print "nameObj: ${nameObj.length}"
    
    //remove "_" and " ". 
    String[] splitNameObj = nameObj[nameObj.length - 1].split("(\\_| )")
    print "splitNameObj: ${splitNameObj.length}"
    
    String nameVariable = ""
    for (int i = 1; i < splitNameObj.length; i++){ //ignore splitNameObj 0
      nameVariable += Character.toUpperCase(splitNameObj[i].charAt(0))
      nameVariable += splitNameObj[i].substring(1)
    }
    println nameVariable
    return nameVariable
  }
}