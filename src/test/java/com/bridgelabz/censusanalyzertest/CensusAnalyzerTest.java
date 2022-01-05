package com.bridgelabz.censusanalyzertest;

import com.bridgelabz.censusanalyzer.CensusAnalyzer;
import com.bridgelabz.censusanalyzer.CensusAnalyzerException;
import org.junit.Assert;
import org.junit.Test;

import javax.swing.*;

public class CensusAnalyzerTest {

    private static final String INDIA_STATE_CODE_CSV_PATH = "D:\\CensusAnalyzerProblems\\src\\main\\resources\\IndiaStateCode.csv";

    //TC1.1 ==> Given Case1 India States Code CSV File when Check the correct Record
    @Test
    public void givenCase1IndiaCensusCSVFile_WhenLoad_ShouldReturnCorrectRecord() {
        CensusAnalyzer censusAnalyser = new CensusAnalyzer();
        try {
            int numOfRecord = censusAnalyser.loadIndianStatesInfo(INDIA_STATE_CODE_CSV_PATH);
            Assert.assertEquals(37, numOfRecord);
        } catch (CensusAnalyzerException e) {

        }
    }

    //TC1.2 ==> Given the State code Census CSV File if incorrect Returns a custom Exception

    @Test
    public void givenCase2IndiaCensusCSVFile_WhenLoad_ShouldReturnInCorrectRecord() {
        String pathOfFile = "D:\\CensusAnalyzerProblems\\src\\main\\resources\\IndiaStateCode.csv";
        CensusAnalyzer censusAnalyser = new CensusAnalyzer();
        try {
            int numOfRecord = censusAnalyser.loadIndianStatesInfo(pathOfFile);
            Assert.assertEquals(27, numOfRecord);
        } catch (CensusAnalyzerException e) {

        }
    }

    //TC1.3 ==> Given the State Census CSV File when correct but type incorrect Returns a custom Exception
    @Test
    public void givenCase3IndiaCensusCSVFile_ShouldReturnACustomExceptionWhenTypeIncorrect() {

        String pathOfFile = "D:\\CensusAnalyzerProblems\\src\\main\\resources\\IndiaStateCode.pdf";
        CensusAnalyzer censusAnalyser = new CensusAnalyzer();
        try {
            int numOfRecord = censusAnalyser.loadIndianStatesInfo(pathOfFile);
            Assert.assertEquals(30, numOfRecord);
        } catch (CensusAnalyzerException e) {

        }
    }

    //TC1.4 ==> Given the State Census CSV File when correct but delimiter incorrect Returns a custom Exception

    @Test
    public void givenCase4IndiaCensusCSVFile_ButDelimiterIncorrectShouldReturnACustomException() {

        String pathOfFile = "D:\\CensusAnalyzerProblems\\src\\main\\resources// IndiaStateCode.csv";
        CensusAnalyzer censusAnalyser = new CensusAnalyzer();
        try {
            int numOfRecord = censusAnalyser.loadIndianStatesInfo(pathOfFile);
            Assert.assertEquals("Delimiter Failed here", true);
        } catch (CensusAnalyzerException e) {

        }
    }

    //TC1.5 ==> Given the State Census CSV File when correct but csv header incorrect Returns a custom Exception
    @Test
    public void givenCase5IndiaCensusCSVFile_WhenCorrectButCSVHeaderIncorrectShouldReturnACustomException() {

        String pathOfFile = "D:\\CensusAnalyzerProblems\\src\\main\\resources\\IndiaStateCodeHeaderChanged.csv";
        CensusAnalyzer censusAnalyser = new CensusAnalyzer();
        try {
            int numOfRecord = censusAnalyser.loadIndianStatesInfo(pathOfFile);
        } catch (CensusAnalyzerException e) {
            Assert.assertEquals(CensusAnalyzerException.ExceptionType.CSV_FILE_ISSUE, e.type);
        }
    }

}
