package com.optify.service.model;

import java.util.Date;

public class Visitor {
    private String _visitorId;
    private String _siteToken;
    private boolean _hidden;
    private Visit[] _visits;
    private LeadScore[] _leadScores;
    private CompanyInformation[] _companyInformation;
    private double _avgPageViewsPerVisit;
    private long _avgVisitDuration;
    private boolean _isLead;
    private int _totalPageViews;
    private int _totalVisits;
    private Date _lastVisitDate;
    private String _lastVisitReferralType;
    private boolean _isIsp;
    private String _organizationName;
    private String _city;
    private String _stateProvince;
    private String _postalCode;
    private String _country;
    private Form _lastFormSubmission;
    private double _defaultLeadScore;
    
    public Visitor(String visitorId, String siteToken, boolean hidden, Visit[] visits, LeadScore[] leadScores, CompanyInformation[] companyInformation, double avgPageViewsPerVisit, long avgVisitDuration, boolean isLead, int totalPageViews, int totalVisits, Date lastVisitDate, String lastVisitReferralType, boolean isIsp, String organizationName, String city, String stateProvince, String postalCode, String country, Form lastFormSubmission, double defaultLeadScore) {
        _visitorId = visitorId;
        _siteToken = siteToken;
        _hidden = hidden;
        _visits = visits;
        _leadScores = leadScores;
        _companyInformation = companyInformation;
        _avgPageViewsPerVisit = avgPageViewsPerVisit;
        _avgVisitDuration = avgVisitDuration;
        _isLead = isLead;
        _totalPageViews = totalPageViews;
        _totalVisits = totalVisits;
        _lastVisitDate = lastVisitDate;
        _lastVisitReferralType = lastVisitReferralType;
        _isIsp = isIsp;
        _organizationName = organizationName;
        _city = city;
        _stateProvince = stateProvince;
        _postalCode = postalCode;
        _country = country;
        _lastFormSubmission = lastFormSubmission;
        _defaultLeadScore = defaultLeadScore;
    }

    public String getVisitorId() {
        return _visitorId;
    }
    
    public String getSiteToken() {
        return _siteToken;
    }
    
    public boolean isHidden() {
        return _hidden;
    }
    
    public Visit[] getVisits() {
        return _visits;
    }
    
    public LeadScore[] getLeadScores() {
        return _leadScores;
    }
    
    public CompanyInformation[] getCompanyInformation() {
        return _companyInformation;
    }
    
    public double getAvgPageViewsPerVisit() {
        return _avgPageViewsPerVisit;
    }
    
    public long getAvgVisitDuration() {
        return _avgVisitDuration;
    }
    
    public boolean isLead() {
        return _isLead;
    }
    
    public int getTotalPageViews() {
        return _totalPageViews;
    }
    
    public int getTotalVisits() {
        return _totalVisits;
    }
    
    public Date getLastVisitDate() {
        return _lastVisitDate;
    }
    
    public String getLastVisitReferralType() {
        return _lastVisitReferralType;
    }
    
    public boolean isIsp() {
        return _isIsp;
    }
    
    public String getOrganizationName() {
        return _organizationName;
    }
    
    public String getCity() {
        return _city;
    }
    
    public String getStateProvince() {
        return _stateProvince;
    }
    
    public String getPostalCode() {
        return _postalCode;
    }
    
    public String getCountry() {
        return _country;
    }
    
    public Form getLastFormSubmission() {
        return _lastFormSubmission;
    }
    
    public double getDefaultLeadScore() {
        return _defaultLeadScore;
    }
}
