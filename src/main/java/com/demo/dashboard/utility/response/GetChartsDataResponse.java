package com.demo.dashboard.utility.response;

import java.util.List;

public class GetChartsDataResponse {

    private ChartDataResponse total;
    private ChartDataResponse quantity;
    private ChartDataResponse price;
    private List<RowTableDataResponse> table;

    public ChartDataResponse getTotal() {
        return total;
    }

    public void setTotal(ChartDataResponse total) {
        this.total = total;
    }

    public ChartDataResponse getQuantity() {
        return quantity;
    }

    public void setQuantity(ChartDataResponse quantity) {
        this.quantity = quantity;
    }

    public ChartDataResponse getPrice() {
        return price;
    }

    public void setPrice(ChartDataResponse price) {
        this.price = price;
    }

    public List<RowTableDataResponse> getTable() {
        return table;
    }

    public void setTable(List<RowTableDataResponse> table) {
        this.table = table;
    }
}

