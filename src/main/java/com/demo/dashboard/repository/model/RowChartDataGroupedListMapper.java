package com.demo.dashboard.repository.model;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RowChartDataGroupedListMapper implements RowMapper<RowChartDataGrouped> {

    public RowChartDataGrouped mapRow(ResultSet rs, int rowNum) throws SQLException {
        RowChartDataGrouped rowChartDataGrouped = new RowChartDataGrouped();
        rowChartDataGrouped.setPurchaseDate(rs.getString("DA_PURCHASE"));
        rowChartDataGrouped.setNameGroupedBy(rs.getString("NA_GROUPED_BY"));
        rowChartDataGrouped.setSumQuantity(rs.getBigDecimal("SUM_AM_QUANTITY"));
        rowChartDataGrouped.setAvgPrice(rs.getBigDecimal("AVG_AM_PRICE"));
        rowChartDataGrouped.setSumTotal(rs.getBigDecimal("SUM_AM_TOTAL"));

        return rowChartDataGrouped;
    }

}

