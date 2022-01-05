package com.bridgelabz.censusanalyzer;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.stream.StreamSupport;

public class CensusAnalyzer {
    /*
    public int loadIndiaCensusData(String csvPath) throws CensusAnalyzerException {
        try (Reader reader = Files.newBufferedReader(Paths.get(csvPath))) {
            Iterator<CSVStateCensus> censusCSVIterator = new OpenCSV().getCSVIterator(reader, CSVStateCensus.class);
            return getCount(censusCSVIterator);
        } catch (IOException e) {
            throw new CensusAnalyzerException(e.getMessage(), CensusAnalyzerException.ExceptionType.CENSUS_FILE_PROBLEM);
        }
    }

     */

    public int loadIndianStatesInfo(String csvPath) throws CensusAnalyzerException {
        try (Reader reader = Files.newBufferedReader(Paths.get(csvPath))) {
            Iterator<IndianStateCSV> indianStateCSVIterator = getCSVIterator(reader, IndianStateCSV.class);
            return getCount(indianStateCSVIterator);
        } catch (IOException e) {
            throw new CensusAnalyzerException(e.getMessage(), CensusAnalyzerException.ExceptionType.CSV_FILE_ISSUE);
        }
    }
    private <E> Iterator getCSVIterator(Reader reader, Class csvClass) {
        CsvToBeanBuilder<E> csvToBeanBuilder = new CsvToBeanBuilder(reader);
        csvToBeanBuilder.withType(csvClass);
        csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
        CsvToBean<E> csvToBean = csvToBeanBuilder.build();
        return csvToBean.iterator();
    }
    //Defining generic type method to get count.
    private <E> int getCount(Iterator<E> censusCSVIterator) {
        Iterable<E> csvIterator = () -> censusCSVIterator;
        int numberOfEntries = (int) StreamSupport.stream(csvIterator.spliterator(),
                true).count();
        return numberOfEntries;
    }
}
