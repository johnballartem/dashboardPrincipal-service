package com.demo.dashboard.utility.response;

import java.util.List;

public class ChartDataResponse {

    //repair
    private String titleText;
    private String subtitleText;
    private String yAxisText;
    private String xAxisText;
    private String valueSuffixTooltip;
    private int valueDecimalsTooltip;
    private List<String> categories;
    private List<SerieDataResponse> series;

    public String getTitleText() {
        return titleText;
    }

    public void setTitleText(String titleText) {
        this.titleText = titleText;
    }

    public String getSubtitleText() {
        return subtitleText;
    }

    public void setSubtitleText(String subtitleText) {
        this.subtitleText = subtitleText;
    }

    public String getyAxisText() {
        return yAxisText;
    }

    public void setyAxisText(String yAxisText) {
        this.yAxisText = yAxisText;
    }

    public String getxAxisText() {
        return xAxisText;
    }

    public void setxAxisText(String xAxisText) {
        this.xAxisText = xAxisText;
    }

    public String getValueSuffixTooltip() {
        return valueSuffixTooltip;
    }

    public void setValueSuffixTooltip(String valueSuffixTooltip) {
        this.valueSuffixTooltip = valueSuffixTooltip;
    }

    public int getValueDecimalsTooltip() {
        return valueDecimalsTooltip;
    }

    public void setValueDecimalsTooltip(int valueDecimalsTooltip) {
        this.valueDecimalsTooltip = valueDecimalsTooltip;
    }

    public List<String> getCategories() {return categories;}

    public void setCategories(List<String> categories) {this.categories = categories;}

    public List<SerieDataResponse> getSeries() {
        return series;
    }

    public void setSeries(List<SerieDataResponse> series) {
        this.series = series;
    }
}
