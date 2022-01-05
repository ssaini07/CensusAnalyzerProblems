package com.bridgelabz.censusanalyzer;

import com.opencsv.bean.CsvBindByName;

public class IndianStateCSV {
    @CsvBindByName(column = "SrNo")
    private int srNo;

    @CsvBindByName(column = "State Name")
    private String stateName;

    @CsvBindByName(column = "TIN")
    private int tin;

    @CsvBindByName(column = "StateCode")
    public String stateCode;

    @Override
    public String toString() {
        return "IndianStateCSV{" +
                "srNo='" + srNo + '\'' +
                ", stateName=" + stateName +
                ", tin=" + tin +
                ", stateCode=" + stateCode +
                '}';
    }
}
