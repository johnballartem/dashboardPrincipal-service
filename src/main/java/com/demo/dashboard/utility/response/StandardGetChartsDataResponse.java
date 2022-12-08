package com.demo.dashboard.utility.response;


import com.demo.dashboard.utility.types.ResponseStatusType;

public class StandardGetChartsDataResponse {

    private ResponseStatusType responseAudit;
    private GetChartsDataResponse responseData;

    public ResponseStatusType getResponseAudit() {
        return responseAudit;
    }

    public void setResponseAudit(ResponseStatusType responseAudit) {
        this.responseAudit = responseAudit;
    }

    public GetChartsDataResponse getResponseData() {
        return responseData;
    }

    public void setResponseData(GetChartsDataResponse responseData) {
        this.responseData = responseData;
    }
}
