package com.demo.dashboard.utility.response;

import java.math.BigDecimal;

public class RowTableDataResponse {

    private int idPurchase;
    private String purchaseDate;
    private String invoice;
    private String customerRoot;
    private String customerLeaf;
    private String product;
    private String packSize;
    private String unitType;
    private String category;
    private String distributorRoot;
    private String distributorLeaf;
    private String manufacturer;
    private BigDecimal quantity;
    private BigDecimal price;
    private BigDecimal total;

    public int getIdPurchase() {
        return idPurchase;
    }

    public void setIdPurchase(int idPurchase) {
        this.idPurchase = idPurchase;
    }

    public String getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(String purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public String getInvoice() {
        return invoice;
    }

    public void setInvoice(String invoice) {
        this.invoice = invoice;
    }

    public String getCustomerRoot() {
        return customerRoot;
    }

    public void setCustomerRoot(String customerRoot) {
        this.customerRoot = customerRoot;
    }

    public String getCustomerLeaf() {
        return customerLeaf;
    }

    public void setCustomerLeaf(String customerLeaf) {
        this.customerLeaf = customerLeaf;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getPackSize() {
        return packSize;
    }

    public void setPackSize(String packSize) {
        this.packSize = packSize;
    }

    public String getUnitType() {
        return unitType;
    }

    public void setUnitType(String unitType) {
        this.unitType = unitType;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDistributorRoot() {
        return distributorRoot;
    }

    public void setDistributorRoot(String distributorRoot) {
        this.distributorRoot = distributorRoot;
    }

    public String getDistributorLeaf() {
        return distributorLeaf;
    }

    public void setDistributorLeaf(String distributorLeaf) {
        this.distributorLeaf = distributorLeaf;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }
}
