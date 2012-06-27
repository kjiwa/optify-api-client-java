package com.optify.service.parameter;

public class GetSiteParameters {
    private String _siteToken;
    
    public GetSiteParameters(String siteToken) {
        _siteToken = siteToken;
    }
    
    public String getSiteToken() {
        return _siteToken;
    }
}
