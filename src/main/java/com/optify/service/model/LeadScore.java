package com.optify.service.model;

public class LeadScore {
    private String _ruleSetName;
    private double _leadScore;
    private double _previousLeadScore;
    private double _maxLifetimeLeadScore;
    private boolean _hidden;
    
    public LeadScore(String ruleSetName, double leadScore, double previousLeadScore, double maxLifetimeLeadScore, boolean hidden) {
        _ruleSetName = ruleSetName;
        _leadScore = leadScore;
        _previousLeadScore = previousLeadScore;
        _maxLifetimeLeadScore = maxLifetimeLeadScore;
        _hidden = hidden;
    }
    
    public String getRuleSetName() {
        return _ruleSetName;
    }
    
    public double getLeadScore() {
        return _leadScore;
    }
    
    public double getPreviousLeadScore() {
        return _previousLeadScore;
    }
    
    public double getMaxLifetimeLeadScore() {
        return _maxLifetimeLeadScore;
    }
    
    public boolean isHidden() {
        return _hidden;
    }
}
