package com.optify.service.parameter;

public class GetVisitorParameters {
    private String _siteToken;
    private String _visitorId;
    
    public GetVisitorParameters(String siteToken, String visitorId) {
        _siteToken = siteToken;
        _visitorId = visitorId;
    }
    
    public String getSiteToken() {
        return _siteToken;
    }

    public String getVisitorId() {
        return _visitorId;
    }
}
