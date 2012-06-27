package com.optify.service.model;

import java.util.Date;

public class Form {
    private String _jobTitle;
    private String _firstName;
    private String _lastName;
    private String _emailAddress;
    private String _company;
    private String _city;
    private String _stateProvince;
    private String _postalCode;
    private String _phoneNumber;
    private String _website;
    private String _industry;
    private String _salutation;
    private String _street;
    private String _country;
    private String _employees;
    private String _revenue;
    private String _mobile;
    private String _fax;
    private String _rating;
    private String _formTitle;
    private String _formUrl;
    private String _visitId;
    private String _siteToken;
    private Date _submissionDate;
    
    public Form(String jobTitle, String firstName, String lastName, String emailAddress, String company, String city, String stateProvince, String postalCode, String phoneNumber, String website, String industry, String salutation, String street, String country, String employees, String revenue, String mobile, String fax, String rating, String formTitle, String formUrl, String visitId, String siteToken, Date submissionDate) {
        _jobTitle = jobTitle;
        _firstName = firstName;
        _lastName = lastName;
        _emailAddress = emailAddress;
        _company = company;
        _city = city;
        _stateProvince = stateProvince;
        _postalCode = postalCode;
        _phoneNumber = phoneNumber;
        _website = website;
        _industry = industry;
        _salutation = salutation;
        _street = street;
        _country = country;
        _employees = employees;
        _revenue = revenue;
        _mobile = mobile;
        _fax = fax;
        _rating = rating;
        _formTitle = formTitle;
        _formUrl = formUrl;
        _visitId = visitId;
        _siteToken = siteToken;
        _submissionDate = submissionDate;
    }

    public String getJobTitle() {
        return _jobTitle;
    }

    public String getFirstName() {
        return _firstName;
    }

    public String getLastName() {
        return _lastName;
    }

    public String getEmailAddress() {
        return _emailAddress;
    }

    public String getCompany() {
        return _company;
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

    public String getPhoneNumber() {
        return _phoneNumber;
    }

    public String getWebsite() {
        return _website;
    }

    public String getIndustry() {
        return _industry;
    }

    public String getSalutation() {
        return _salutation;
    }
    
    public String getStreet() {
        return _street;
    }

    public String getCountry() {
        return _country;
    }

    public String getEmployees() {
        return _employees;
    }

    public String getRevenue() {
        return _revenue;
    }

    public String getMobile() {
        return _mobile;
    }

    public String getFax() {
        return _fax;
    }

    public String getRating() {
        return _rating;
    }

    public String getFormTitle() {
        return _formTitle;
    }

    public String getFormUrl() {
        return _formUrl;
    }

    public String getVisitId() {
        return _visitId;
    }

    public String getSiteToken() {
        return _siteToken;
    }

    public Date getSubmissionDate() {
        return _submissionDate;
    }
}
