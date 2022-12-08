package com.demo.dashboard.utility.response;

public class SerieDataResponse {

    private String name;
    private double[] data;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double[] getData() {
        return data;
    }
    public void setData(double[] data) {
        this.data = data;
    }
}
