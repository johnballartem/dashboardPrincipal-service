package com.demo.dashboard.utility.request;

import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

public class GetChartsDataByFilterRequest {
    private String groupBy;
    private String invoice;
    private Date initialPurchaseDate;
    private Date finalPurchaseDate;
    private Integer idProduct;
    private Integer idCustomerRoot;
    private Integer idCustomerLeaf;
    private Integer idPackSize;
    private Integer idUnitType;
    private Integer idCategory;
    private Integer idDistributorRoot;
    private Integer idDistributorLeaf;
    private Integer idManufacturer;

    public String getGroupBy() {
        return groupBy;
    }

    public void setGroupBy(String groupBy) {
        this.groupBy = groupBy;
    }

    public String getInvoice() {
        return invoice;
    }

    public void setInvoice(String invoice) {
        this.invoice = invoice;
    }

    public Date getInitialPurchaseDate() {
        return initialPurchaseDate;
    }

    public void setInitialPurchaseDate(Date initialPurchaseDate) {
        this.initialPurchaseDate = initialPurchaseDate;
    }

    public Date getFinalPurchaseDate() {
        return finalPurchaseDate;
    }

    public void setFinalPurchaseDate(Date finalPurchaseDate) {
        this.finalPurchaseDate = finalPurchaseDate;
    }

    public Integer getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Integer idProduct) {
        this.idProduct = idProduct;
    }

    public Integer getIdCustomerRoot() {
        return idCustomerRoot;
    }

    public void setIdCustomerRoot(Integer idCustomerRoot) {
        this.idCustomerRoot = idCustomerRoot;
    }

    public Integer getIdCustomerLeaf() {
        return idCustomerLeaf;
    }

    public void setIdCustomerLeaf(Integer idCustomerLeaf) {
        this.idCustomerLeaf = idCustomerLeaf;
    }

    public Integer getIdPackSize() {
        return idPackSize;
    }

    public void setIdPackSize(Integer idPackSize) {
        this.idPackSize = idPackSize;
    }

    public Integer getIdUnitType() {
        return idUnitType;
    }

    public void setIdUnitType(Integer idUnitType) {
        this.idUnitType = idUnitType;
    }

    public Integer getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(Integer idCategory) {
        this.idCategory = idCategory;
    }

    public Integer getIdDistributorRoot() {
        return idDistributorRoot;
    }

    public void setIdDistributorRoot(Integer idDistributorRoot) {
        this.idDistributorRoot = idDistributorRoot;
    }

    public Integer getIdDistributorLeaf() {
        return idDistributorLeaf;
    }

    public void setIdDistributorLeaf(Integer idDistributorLeaf) {
        this.idDistributorLeaf = idDistributorLeaf;
    }

    public Integer getIdManufacturer() {
        return idManufacturer;
    }

    public void setIdManufacturer(Integer idManufacturer) {
        this.idManufacturer = idManufacturer;
    }
}
