package com.optify.service.parameter;

import java.util.Calendar;
import java.util.Date;

public class GetVisitorsParameters {
    private String _siteToken;
    private Date _startDate;
    private Date _endDate;
    private boolean _includeIsp;
    private int _offset;
    private int _count;
    
    public GetVisitorsParameters(String siteToken) {
        _siteToken = siteToken;
        _includeIsp = false;
        _offset = 0;
        _count = 10;
        
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DAY_OF_YEAR, -1);
        _startDate = c.getTime();
        _endDate = new Date();
    }
    
    public String getSiteToken() {
        return _siteToken;
    }

    public Date getStartDate() {
        return _startDate;
    }

    public Date getEndDate() {
        return _endDate;
    }

    public boolean getIncludeIsp() {
        return _includeIsp;
    }

    public int getOffset() {
        return _offset;
    }

    public int getCount() {
        return _count;
    }
    
    public void setStartDate(Date startDate) {
        _startDate = startDate;
    }
    
    public void setEndDate(Date endDate) {
        _endDate = endDate;
    }
    
    public void setIncludeIsp(boolean includeIsp) {
        _includeIsp = includeIsp;
    }
    
    public void setOffset(int offset) {
        _offset = offset;
    }
    
    public void setCount(int count) {
        _count = count;
    }
}
