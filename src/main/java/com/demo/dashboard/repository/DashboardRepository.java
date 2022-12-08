package com.demo.dashboard.repository;


import com.demo.dashboard.repository.model.RowTableData;
import com.demo.dashboard.repository.model.RowChartDataGrouped;
import com.demo.dashboard.utility.exception.DBException;
import com.demo.dashboard.utility.request.GetChartsDataByFilterRequest;

import java.sql.SQLException;
import java.util.List;

public interface DashboardRepository {

    public List<RowChartDataGrouped> getChartsDataGrouped(String mensajeTransaccion, GetChartsDataByFilterRequest request) throws DBException, SQLException;

    public List<RowTableData> getTableData(String mensajeTransaccion, GetChartsDataByFilterRequest request) throws DBException, SQLException;

}
