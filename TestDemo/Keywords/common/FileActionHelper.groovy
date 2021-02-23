package common

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import org.apache.poi.hssf.record.PageBreakRecord.Break

import com.google.common.io.Closeables
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import groovy.io.FileType
import internal.GlobalVariable

public class FileActionHelper {
  StringHelper stringHelper = new StringHelper()

  public void readFileLineByLine(String filePath) {
    File file = new File(filePath)
    def line
    file.withReader { reader ->
      while ((line = reader.readLine()) != null) {
        println "${line}"
        def contentLine = line.toString()

        println contentLine.isEmpty()
      }
    }
  }

  public int numberOfOccurrencesWordsLineByLine(String filePath, String value){
    File file = new File("${RunConfiguration.getProjectDir()}/${filePath}.tc")
    def line, temp = value
    int count = 0
    file.withReader { reader ->
      while ((line = reader.readLine()) != null) {
        def contentLine = line.toString()
        if(contentLine.contains(temp)){
          count++
        }
      }
    }
    return count
  }

  public void appendFileByNoOfLine(String testCaseID, int noOfLine, String nameValue, String defaultValue){
    def idVariable = UUID.randomUUID()
    def file = new File("${RunConfiguration.getProjectDir()}/${testCaseID}.tc")
    def lines = file.readLines()
    String str ="""
   <variable>
      <defaultValue>'${defaultValue}'</defaultValue>
      <description></description>
      <id>${idVariable}</id>
      <masked>false</masked>
      <name>${nameValue}</name>
   </variable>"""

    lines = lines.plus(noOfLine, str)
    file.text = lines.join('\n')
  }

  public void reviseVariable(String folderID, String scriptName,int noOfLine, String oldValue, String newValue){
    folderID = stringHelper.splitAndConcatPath(folderID)
    File file = new File("${RunConfiguration.getProjectDir()}/Scripts${folderID}/${scriptName}")
    def result = file.text.replace(oldValue, newValue)
    file.text = result
  }

  public void AddAndReplaceVariable(String folderID, String scriptName) {
    String scripsID = stringHelper.splitAndConcatPath(folderID)
    String nameVariable
    File file = new File("${RunConfiguration.getProjectDir()}/Scripts${scripsID}/${scriptName}")
    def line, noOfLines = 0, findValue1 = "WebUI.set", findValue2 = "WebUI.select", preLine
    file.withReader { reader ->
      while ((line = reader.readLine()) != null) {
        def contentLine = line.toString()
        //The statements are line breaks => concatenate them into a line for processing
        if(!contentLine.isEmpty() && !preLine.toString().isEmpty()){
          contentLine = "${preLine}${contentLine}"
        }
        println contentLine
        if(contentLine.contains(findValue1) | contentLine.contains(findValue2)){
          //split the chain into two parts. Part 2 is the value of the variable
          String[] str = contentLine.split("('?,[\\s]+'?|'?\\)\$)")
          print str.length
          for(int i = 0; i < str.length; i++){
            println "str: ${str[i]}"
          }
          if(str.length >= 2){
            //append Variable
            //variable is always added to line 7 of file
            nameVariable = stringHelper.setNameVariable(str[0], "(\\('|'\\))")
            String defaultValue = str[1]
            //The variable repeats twice, its value changing
            if(numberOfOccurrencesWordsLineByLine(folderID, nameVariable) >= 1 &&
            numberOfOccurrencesWordsLineByLine(folderID, "'${defaultValue}'") == 0){
              nameVariable = stringHelper.randomValue(nameVariable)
              appendFileByNoOfLine(folderID, 7, nameVariable, "${defaultValue}")
            }else if (numberOfOccurrencesWordsLineByLine(folderID, nameVariable) == 0){ // variable repeats once
              appendFileByNoOfLine(folderID, 7, nameVariable, "${defaultValue}")
            }
            //change the value to a variable in Scripts
            reviseVariable(folderID, scriptName, noOfLines, "'${defaultValue}'", nameVariable)
          }
        }
        noOfLines++
        preLine = contentLine
      }
    }
  }
  public String findScriptTCName(String testCaseID){
    testCaseID = stringHelper.splitAndConcatPath(testCaseID)
    File currentDir = new File("${RunConfiguration.getProjectDir()}/Scripts${testCaseID}")
    String fileName
    currentDir.traverse { File file ->
      if (file.name.endsWith('.groovy')) {
        fileName = file.name.toString()
      }
    }
    return fileName
  }
}
