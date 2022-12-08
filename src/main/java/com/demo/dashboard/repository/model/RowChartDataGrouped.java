package com.demo.dashboard.repository.model;

import java.math.BigDecimal;

public class RowChartDataGrouped {

    private String purchaseDate;
    private String nameGroupedBy;
    private BigDecimal sumQuantity;
    private BigDecimal AvgPrice;
    private BigDecimal sumTotal;
    private Integer keyPurchaseDate;
    private Integer keyNameGroupedBy;

    public String getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(String purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public String getNameGroupedBy() {
        return nameGroupedBy;
    }

    public void setNameGroupedBy(String nameGroupedBy) {
        this.nameGroupedBy = nameGroupedBy;
    }

    public BigDecimal getSumQuantity() {
        return sumQuantity;
    }

    public void setSumQuantity(BigDecimal sumQuantity) {
        this.sumQuantity = sumQuantity;
    }

    public BigDecimal getAvgPrice() {
        return AvgPrice;
    }

    public void setAvgPrice(BigDecimal avgPrice) {
        AvgPrice = avgPrice;
    }

    public BigDecimal getSumTotal() {
        return sumTotal;
    }

    public void setSumTotal(BigDecimal sumTotal) {
        this.sumTotal = sumTotal;
    }

    public Integer getKeyPurchaseDate() {
        return keyPurchaseDate;
    }

    public void setKeyPurchaseDate(Integer keyPurchaseDate) {
        this.keyPurchaseDate = keyPurchaseDate;
    }

    public Integer getKeyNameGroupedBy() {
        return keyNameGroupedBy;
    }

    public void setKeyNameGroupedBy(Integer keyNameGroupedBy) {
        this.keyNameGroupedBy = keyNameGroupedBy;
    }
}
