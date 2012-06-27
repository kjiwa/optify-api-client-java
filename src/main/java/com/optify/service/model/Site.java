package com.optify.service.model;

public class Site {
    private String _name;
    private String _siteToken;
    private String _url;
    
    public Site(String name, String siteToken, String url) {
        _name = name;
        _siteToken = siteToken;
        _url = url;
    }
    
    public String getName() {
        return _name;
    }
    
    public String getSiteToken() {
        return _siteToken;
    }
    
    public String getUrl() {
        return _url;
    }
    
    void setName(String name) {
        _name = name;
    }
    
    void setSiteToken(String siteToken) {
        _siteToken = siteToken;
    }
    
    void setUrl(String url) {
        _url = url;
    }
}
