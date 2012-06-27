package com.optify.service.model;

import java.util.Date;

public class PageView {
    private String _url;
    private String _referralUrl;
    private String _pageTitle;
    private String _ipAddress;
    private Date _dateViewed;
    
    public PageView(String url, String referralUrl, String pageTitle, String ipAddress, Date dateViewed) {
        _url = url;
        _referralUrl = referralUrl;
        _pageTitle = pageTitle;
        _ipAddress = ipAddress;
        _dateViewed = dateViewed;
    }
    
    public String getUrl() {
        return _url;
    }
    
    public String getReferralUrl() {
        return _referralUrl;
    }
    
    public String getPageTitle() {
        return _pageTitle;
    }
    
    public String getIpAddress() {
        return _ipAddress;
    }
    
    public Date getDateViewed() {
        return _dateViewed;
    }
}
