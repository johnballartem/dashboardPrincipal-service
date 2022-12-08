package com.demo.dashboard.utility.response;

import com.demo.dashboard.utility.types.ResponseStatusType;

public class StandardValidateLoginResponse {

    private ResponseStatusType responseAudit;
    private UserResponse user;

    public ResponseStatusType getResponseAudit() {
        return responseAudit;
    }

    public void setResponseAudit(ResponseStatusType responseAudit) {
        this.responseAudit = responseAudit;
    }

    public UserResponse getUser() {
        return user;
    }

    public void setUser(UserResponse user) {
        this.user = user;
    }
}
