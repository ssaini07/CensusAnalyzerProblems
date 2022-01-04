package com.bridgelabz.censusanalyzer;

public class CensusAnalyzerException extends Exception {

    ExceptionType type;
    private String message;


    public CensusAnalyzerException(String message, ExceptionType type) {
        this.message = message;
        this.type = type;
    }

    enum ExceptionType {
        CENSUS_FILE_PROBLEM;

    }

    @Override
    public String toString() {
        return "CensusAnalyserException{" +
                "type=" + type +
                ", message='" + message + '\'' +
                '}';
    }
}
