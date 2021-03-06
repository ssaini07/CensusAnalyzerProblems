package com.bridgelabz.censusanalyzer;

public class CensusAnalyzerException extends Exception {

    public ExceptionType type;
    private String message;


    public CensusAnalyzerException(String message, ExceptionType type) {
        this.message = message;
        this.type = type;
    }

   public enum ExceptionType {
        //CENSUS_FILE_PROBLEM;
        CSV_FILE_ISSUE;
    }

    @Override
    public String toString() {
        return "CensusAnalyserException{" +
                "type=" + type +
                ", message='" + message + '\'' +
                '}';
    }
}
