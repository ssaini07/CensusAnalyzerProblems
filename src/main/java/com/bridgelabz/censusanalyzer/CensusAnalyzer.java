package com.bridgelabz.censusanalyzer;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.stream.StreamSupport;

public class CensusAnalyzer {
    public int loadIndiaCensusData(String csvPath) throws CensusAnalyzerException {
        try (Reader reader = Files.newBufferedReader(Paths.get(csvPath))) {
            Iterator<CSVStateCensus> censusCSVIterator = new OpenCSV().getCSVIterator(reader, CSVStateCensus.class);
            return getCount(censusCSVIterator);
        } catch (IOException e) {
            throw new CensusAnalyzerException(e.getMessage(), CensusAnalyzerException.ExceptionType.CENSUS_FILE_PROBLEM);
        }
    }
//Defining generic type method to get count.
    private <E> int getCount(Iterator<E> censusCSVIterator) {
        Iterable<E> csvIterable = () -> censusCSVIterator;
        int numberOfEntries = (int) StreamSupport.stream(csvIterable.spliterator(), true).count();
        return numberOfEntries;
    }
}
