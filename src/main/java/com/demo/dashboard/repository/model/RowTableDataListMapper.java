package com.demo.dashboard.repository.model;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RowTableDataListMapper implements RowMapper<RowTableData> {

    public RowTableData mapRow(ResultSet rs, int rowNum) throws SQLException {
        RowTableData rowTableData = new RowTableData();

        rowTableData.setIdPurchase(rs.getInt("ID_PURCHASE"));
        rowTableData.setPurchaseDate(rs.getString("DA_PURCHASE"));
        rowTableData.setInvoice(rs.getString("NU_INVOICE"));
        rowTableData.setCustomerRoot(rs.getString("NA_CUSTOMER_ROOT"));
        rowTableData.setCustomerLeaf(rs.getString("NA_CUSTOMER_LEAF"));
        rowTableData.setProduct(rs.getString("NA_PRODUCT"));
        rowTableData.setPackSize(rs.getString("NA_PACK_SIZE"));
        rowTableData.setUnitType(rs.getString("NA_UNIT_TYPE"));
        rowTableData.setCategory(rs.getString("NA_CATEGORY"));
        rowTableData.setDistributorRoot(rs.getString("NA_DISTRIBUTOR_ROOT"));
        rowTableData.setDistributorLeaf(rs.getString("NA_DISTRIBUTOR_LEAF"));
        rowTableData.setManufacturer(rs.getString("NA_MANUFACTURER"));
        rowTableData.setQuantity(rs.getBigDecimal("AM_QUANTITY"));
        rowTableData.setPrice(rs.getBigDecimal("AM_PRICE"));
        rowTableData.setTotal(rs.getBigDecimal("AM_TOTAL"));

        return rowTableData;
    }

}

