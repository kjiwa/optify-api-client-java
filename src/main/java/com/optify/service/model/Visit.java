package com.optify.service.model;

import java.util.Date;

public class Visit {
    private String _visitId;
    private Date _visitDate;
    private String _keyword;
    private Integer _referralSerpRank;
    private String _customReferralDetail;
    private String _customReferralType;
    private String _referralSearchEngine;
    private String _referralType;
    private PageView[] _pageViews;
    private Form[] _forms;
    private String _userAgent;
    
    public Visit(String visitId, Date visitDate, String keyword, Integer referralSerpRank, String customReferralDetail, String customReferralType, String referralSearchEngine, String referralType, PageView[] pageViews, Form[] forms, String userAgent) {
        _visitId = visitId;
        _visitDate = visitDate;
        _keyword = keyword;
        _referralSerpRank = referralSerpRank;
        _customReferralDetail = customReferralDetail;
        _customReferralType = customReferralType;
        _referralSearchEngine = referralSearchEngine;
        _referralType = referralType;
        _pageViews = pageViews;
        _forms = forms;
        _userAgent = userAgent;
    }
    
    public String getVisitId() {
        return _visitId;
    }
    
    public Date getVisitDate() {
        return _visitDate;
    }
    
    public String getKeyword() {
        return _keyword;
    }
    
    public Integer getReferralSerpRank() {
        return _referralSerpRank;
    }
    
    public String getCustomReferralDetail() {
        return _customReferralDetail;
    }
    
    public String getCustomReferralType() {
        return _customReferralType;
    }
    
    public String getReferralSearchEngine() {
        return _referralSearchEngine;
    }
    
    public String getReferralType() {
        return _referralType;
    }
    
    public PageView[] getPageViews() {
        return _pageViews;
    }
    
    public Form[] getForms() {
        return _forms;
    }
    
    public String getUserAgent() {
        return _userAgent;
    }
}
