package com.bridgelabz.censusanalyzertest;

import com.bridgelabz.censusanalyzer.CensusAnalyzer;
import com.bridgelabz.censusanalyzer.CensusAnalyzerException;
import org.junit.Assert;
import org.junit.Test;

public class CensusAnalyzerTest {

    private static final String INDIA_CENSUS_CSV_PATH = "D:\\CensusAnalyzerProblems\\src\\main\\resources\\IndiaStateCensusData.csv";

    //TC1.1 ==> Given Case1 India State Census CSV File when Check the correct Record
    @Test
    public void givenCase1IndiaCensusCSVFile_WhenLoad_ShouldReturnCorrectRecord() {
        CensusAnalyzer censusAnalyser = new CensusAnalyzer();
        try {
            int numOfRecord = censusAnalyser.loadIndiaCensusData(INDIA_CENSUS_CSV_PATH);
            Assert.assertEquals(29, numOfRecord);
        } catch (CensusAnalyzerException e) {

        }
    }

    //TC1.2 ==> Given the State Census CSV File if incorrect Returns a custom Exception

    @Test
    public void givenCase2IndiaCensusCSVFile_WhenLoad_ShouldReturnInCorrectRecord() {
        String pathOfFile = "D:\\CensusAnalyzerProblems\\src\\main\\resources\\IndiaStateCensusData.pdf";
        CensusAnalyzer censusAnalyser = new CensusAnalyzer();
        try {
            int numOfRecord = censusAnalyser.loadIndiaCensusData(pathOfFile);
            Assert.assertEquals(27, numOfRecord);
        } catch (CensusAnalyzerException e) {

        }
    }

    //TC1.3 ==> Given the State Census CSV File when correct but type incorrect Returns a custom Exception
    @Test
    public void givenCase3IndiaCensusCSVFile_ShouldReturnACustomExceptionWhenTypeIncorrect() {

        String pathOfFile = "D:\\CensusAnalyzerProblems\\src\\main\\resources\\IndiaStateCensusData.pdf";
        CensusAnalyzer censusAnalyser = new CensusAnalyzer();
        try {
            int numOfRecord = censusAnalyser.loadIndiaCensusData(pathOfFile);
            Assert.assertEquals(30, numOfRecord);
        } catch (CensusAnalyzerException e) {

        }
    }

    //TC1.4 ==> Given the State Census CSV File when correct but delimiter incorrect Returns a custom Exception

    @Test
    public void givenCase4IndiaCensusCSVFile_ButDelimiterIncorrectShouldReturnACustomException() {

        String pathOfFile = "D:\\CensusAnalyzerProblems\\src\\main\\resources\\IndiaStateCensusData.pdf";
        CensusAnalyzer censusAnalyser = new CensusAnalyzer();
        try {
            int numOfRecord = censusAnalyser.loadIndiaCensusData(pathOfFile);
            Assert.assertEquals("Delimiter Failed here", true);
        } catch (CensusAnalyzerException e) {

        }
    }

    //TC1.5 ==> Given the State Census CSV File when correct but csv header incorrect Returns a custom Exception
    @Test
    public void givenCase5IndiaCensusCSVFile_WhenCorrectButCSVHeaderIncorrectShouldReturnACustomException() {

        String pathOfFile = "D:\\CensusAnalyzerProblems\\src\\main\\resources\\IndiaStateCensusDataHeader.csv";
        CensusAnalyzer censusAnalyser = new CensusAnalyzer();
        try {
            int numOfRecord = censusAnalyser.loadIndiaCensusData(pathOfFile);
            Assert.assertEquals("Header Defined Incorrectly", true);
        } catch (CensusAnalyzerException e) {

        }
    }


}
