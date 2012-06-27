package com.optify.service.model;

public class CompanyInformation {
    private String _name;
    private String _phoneNumber;
    private String _website;
    private String _stockSymbol;
    private String _stockExchange;
    private String _ownership;
    private int _employeeCount;
    private String _employeeRange;
    private long _revenue;
    private String _revenueRange;
    private String _industry;
    private String _subIndustry;
    private String _sicCode;
    private String _address;
    private String _city;
    private String _stateProvince;
    private String _postalCode;
    private String _country;
    
    public CompanyInformation(String name, String phoneNumber, String website, String stockSymbol, String stockExchange, String ownership, int employeeCount, String employeeRange, long revenue, String revenueRange, String industry, String subIndustry, String sicCode, String address, String city, String stateProvince, String postalCode, String country) {
        _name = name;
        _phoneNumber = phoneNumber;
        _website = website;
        _stockSymbol = stockSymbol;
        _stockExchange = stockExchange;
        _ownership = ownership;
        _employeeCount = employeeCount;
        _employeeRange = employeeRange;
        _revenue = revenue;
        _revenueRange = revenueRange;
        _industry = industry;
        _subIndustry = subIndustry;
        _sicCode = sicCode;
        _address = address;
        _city = city;
        _stateProvince = stateProvince;
        _postalCode = postalCode;
        _country = country;
    }
    
    public String getName() {
        return _name;
    }
    
    public String getPhoneNumber() {
        return _phoneNumber;
    }
    
    public String getWebsite() {
        return _website;
    }
    
    public String getStockSymbol() {
        return _stockSymbol;
    }
    
    public String getStockExchange() {
        return _stockExchange;
    }
    
    public String getOwnership() {
        return _ownership;
    }
    
    public int getEmployeeCount() {
        return _employeeCount;
    }
    
    public String getEmployeeRange() {
        return _employeeRange;
    }
    
    public long getRevenue() {
        return _revenue;
    }
    
    public String getRevenueRange() {
        return _revenueRange;
    }
    
    public String getIndustry() {
        return _industry;
    }
    
    public String getSubIndustry() {
        return _subIndustry;
    }
    
    public String getSicCode() {
        return _sicCode;
    }
    
    public String getAddress() {
        return _address;
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
}
