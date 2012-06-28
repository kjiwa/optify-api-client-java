package com.optify.service;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.TimeZone;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.optify.service.exception.BadRequestException;
import com.optify.service.exception.InternalException;
import com.optify.service.exception.UnauthorizedException;
import com.optify.service.model.CompanyInformation;
import com.optify.service.model.Form;
import com.optify.service.model.LeadScore;
import com.optify.service.model.PageView;
import com.optify.service.model.Site;
import com.optify.service.model.Visit;
import com.optify.service.model.Visitor;
import com.optify.service.parameter.GetSiteParameters;
import com.optify.service.parameter.GetVisitorParameters;
import com.optify.service.parameter.GetVisitorsParameters;

public class OptifyServiceImpl implements OptifyService {
    private String _accessToken;
    private DateFormat _f;
    private String _url;
    
    public OptifyServiceImpl(String accessToken) {
        this(accessToken, "https://api.optify.net");
    }
    
    public OptifyServiceImpl(String accessToken, String url) {
        _accessToken = accessToken;
        _url = url;
        _f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        _f.setTimeZone(TimeZone.getTimeZone("GMT"));
    }
    
    public String whoAmI() throws BadRequestException, UnauthorizedException {
        try {
            URL url = new URL(_url + "/whoami?access_token=" + _accessToken);
            HttpURLConnection c = (HttpURLConnection) url.openConnection();
            return _get(c);
        } catch (MalformedURLException e) {
            throw new InternalException(e);
        } catch (IOException e) {
            throw new InternalException(e);
        }
    }

    public Site[] getSites() throws BadRequestException, UnauthorizedException {
        try {
            URL url = new URL(_url + "/v1/sites?access_token=" + _accessToken);
            HttpURLConnection c = (HttpURLConnection) url.openConnection();
            String response = _get(c);
            
            JSONArray array = new JSONArray(response);
            Site[] sites = new Site[array.length()];
            for (int i = 0; i < array.length(); i++) {
                JSONObject json = array.getJSONObject(i);
                sites[i] = _getSiteFromJson(json);
            }
            
            return sites;
        } catch (MalformedURLException e) {
            throw new InternalException(e);
        } catch (IOException e) {
            throw new InternalException(e);
        } catch (JSONException e) {
            throw new InternalException(e);
        }
    }

    public Site getSite(GetSiteParameters params) throws BadRequestException, UnauthorizedException {
        try {
            URL url = new URL(_url + "/v1/sites/" + params.getSiteToken() + "?access_token=" + _accessToken);
            HttpURLConnection c = (HttpURLConnection) url.openConnection();
            String response = _get(c);
            
            JSONObject json = new JSONObject(response);
            return _getSiteFromJson(json);
        } catch (MalformedURLException e) {
            throw new InternalException(e);
        } catch (IOException e) {
            throw new InternalException(e);
        } catch (JSONException e) {
            throw new InternalException(e);
        }
    }

    public Visitor[] getVisitors(GetVisitorsParameters params) throws BadRequestException, UnauthorizedException {
        Date startDate = params.getStartDate();
        Date endDate = params.getEndDate();
        
        if (startDate == null) {
            Calendar c = Calendar.getInstance();
            c.add(Calendar.DAY_OF_YEAR, -1);
            startDate = c.getTime();
        }
        
        if (endDate == null) {
            endDate = new Date();
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append(_url)
            .append("/v1/sites/")
            .append(URLEncoder.encode(params.getSiteToken()))
            .append("/visitors?start_date=")
            .append(URLEncoder.encode(_f.format(startDate)))
            .append("&end_date=")
            .append(URLEncoder.encode(_f.format(endDate)))
            .append("&include_isp=")
            .append(params.getIncludeIsp())
            .append("&offset=")
            .append(params.getOffset())
            .append("&count=")
            .append(params.getCount())
            .append("&access_token=")
            .append(_accessToken);
        
        try {
            Collection visitors = new ArrayList();
            URL url = new URL(sb.toString());
            HttpURLConnection c = (HttpURLConnection) url.openConnection();
            String response = _get(c);
                
            JSONArray array = new JSONArray(response);
            for (int i = 0; i < array.length(); i++) {
                JSONObject json = array.getJSONObject(i);
                visitors.add(_getVisitorFromJson(json));
            }
            
            return (Visitor[]) visitors.toArray(new Visitor[visitors.size()]);
        } catch (MalformedURLException e) {
            throw new InternalException(e);
        } catch (IOException e) {
            throw new InternalException(e);
        } catch (JSONException e) {
            throw new InternalException(e);
        }
    }
    
    public Visitor getVisitor(GetVisitorParameters params) throws BadRequestException, UnauthorizedException {
        try {
            URL url = new URL(_url + "/v1/sites/" + params.getSiteToken() + "/visitors/" + params.getVisitorId() + "?access_token=" + _accessToken);
            HttpURLConnection c = (HttpURLConnection) url.openConnection();
            String response = _get(c);
            
            JSONObject json = new JSONObject(response);
            return _getVisitorFromJson(json);
        } catch (MalformedURLException e) {
            throw new InternalException(e);
        } catch (IOException e) {
            throw new InternalException(e);
        } catch (JSONException e) {
            throw new InternalException(e);
        }
    }
    
    private String _get(HttpURLConnection c) throws BadRequestException, UnauthorizedException {
        c.setRequestProperty("Accept", "application/json,text/plain");
        c.setRequestProperty("X-Optify-Client-Version", "1.0");
        try {
            switch (c.getResponseCode()) {
            case HttpURLConnection.HTTP_FORBIDDEN:
                throw new UnauthorizedException();
            case HttpURLConnection.HTTP_BAD_REQUEST:
                throw new BadRequestException();
            case HttpURLConnection.HTTP_OK:
                return new Scanner(c.getInputStream()).useDelimiter("\\A").next();
            default:
                throw new InternalException();
            }
            
        } catch (IOException e) {
            throw new InternalException(e);
        } catch (NoSuchElementException e) {
            throw new InternalException(e);
        }
    }
    
    private String _getStringOrNull(JSONObject json, String key) {
        if (!json.isNull(key)) {
            try {
                return json.getString(key);
            } catch (JSONException e) {
                throw new InternalException(e);
            }
        }
        
        return null;
    }
    
    private Site _getSiteFromJson(JSONObject json) {
        try {
            String name = json.getString("name");
            String token = json.getString("site_token");
            String url = json.getString("url");
            return new Site(name, token, url);
        } catch (JSONException e) {
            throw new InternalException(e);
        }
    }
    
    private Visitor _getVisitorFromJson(JSONObject json) {
        try {
            String visitorId = json.getString("visitor_id");
            String siteToken = json.getString("site_token");
            boolean hidden = json.getBoolean("hidden");
            Visit[] visits = null;
            LeadScore[] leadScores = null;
            CompanyInformation[] companyInformation = null;
            double avgPageViewsPerVisit = json.getDouble("avg_pageviews_per_visit");
            long avgVisitDuration = json.getLong("avg_visit_duration");
            boolean isLead = json.getBoolean("is_lead");
            int totalPageViews = json.getInt("total_page_views");
            int totalVisits = json.getInt("total_visits");
            Date lastVisitDate = new Date(json.getLong("last_visit_date"));
            String lastVisitReferralType = json.getString("last_visit_referral_type");
            boolean isIsp = json.getBoolean("is_isp");
            String organizationName = json.getString("organization_name");
            String city = json.getString("city");
            String stateProvince = json.getString("state_province");
            String postalCode = json.getString("postal_code");
            String country = json.getString("country");
            Form lastFormSubmission = null;
            double defaultLeadScore = json.getDouble("default_lead_score");
            
            JSONArray array = json.getJSONArray("visits");
            visits = new Visit[array.length()];
            for (int i = 0; i < array.length(); i++) {
                visits[i] = _getVisitFromJson(array.getJSONObject(i));
            }
            
            if (!json.isNull("leadScores")) {
                array = json.getJSONArray("leadScores");
                leadScores = new LeadScore[array.length()];
                for (int i = 0; i < array.length(); i++) {
                    leadScores[i] = _getLeadScoreFromJson(array.getJSONObject(i));
                }
            }
            
            if (!json.isNull("company_information")) {
                array = json.getJSONArray("company_information");
                companyInformation = new CompanyInformation[array.length()];
                for (int i = 0; i < array.length(); i++) {
                    companyInformation[i] = _getCompanyInformationFromJson(array.getJSONObject(i));
                }
            }
            
            if (!json.isNull("last_form_submission")) {
                lastFormSubmission = _getFormFromJson(json.getJSONObject("last_form_submission"));
            }
            
            return new Visitor(visitorId, siteToken, hidden, visits, leadScores, companyInformation, avgPageViewsPerVisit, avgVisitDuration, isLead, totalPageViews, totalVisits, lastVisitDate, lastVisitReferralType, isIsp, organizationName, city, stateProvince, postalCode, country, lastFormSubmission, defaultLeadScore);
        } catch (JSONException e) {
            throw new InternalException(e);
        }
    }
    
    private Visit _getVisitFromJson(JSONObject json) {
        try {
            String visitId = json.getString("visit_id");
            Date visitDate = new Date(json.getLong("visit_date"));
            String keyword = _getStringOrNull(json, "keyword");
            Integer referralSerpRank = null;
            String customReferralDetail = _getStringOrNull(json, "custom_referral_detail");
            String customReferralType = _getStringOrNull(json, "custom_referral_type");
            String referralSearchEngine = _getStringOrNull(json, "referral_search_engine");
            String referralType = json.getString("referral_type");
            PageView[] pageViews = null;
            Form[] forms = null;
            String userAgent = json.getString("user_agent");
            
            if (!json.isNull("referral_serp_rank")) {
                referralSerpRank = new Integer(json.getInt("referral_serp_rank"));
            }
            
            JSONArray array = json.getJSONArray("pageviews");
            pageViews = new PageView[array.length()];
            for (int i = 0; i < array.length(); i++) {
                pageViews[i] = _getPageViewFromJson(array.getJSONObject(i));
            }
            
            array = json.getJSONArray("forms");
            forms = new Form[array.length()];
            for (int i = 0; i < array.length(); i++) {
                forms[i] = _getFormFromJson(array.getJSONObject(i));
            }
            
            return new Visit(visitId, visitDate, keyword, referralSerpRank, customReferralDetail, customReferralType, referralSearchEngine, referralType, pageViews, forms, userAgent);
        } catch (JSONException e) {
            throw new InternalException(e);
        }
    }

    private PageView _getPageViewFromJson(JSONObject json) {
        try {
            String url = json.getString("url");
            String referralUrl = _getStringOrNull(json, "referral_url");
            String pageTitle = json.getString("page_title");
            String ipAddress = json.getString("ip_address");
            Date dateViewed = new Date(json.getLong("date_viewed"));
            
            return new PageView(url, referralUrl, pageTitle, ipAddress, dateViewed);
        } catch (JSONException e) {
            throw new InternalException(e);
        }
    }
    
    private Form _getFormFromJson(JSONObject json) {
        try {
            String jobTitle = _getStringOrNull(json, "job_title");
            String firstName = _getStringOrNull(json, "first_name");
            String lastName = _getStringOrNull(json, "last_name");
            String emailAddress = _getStringOrNull(json, "email_address");
            String company = _getStringOrNull(json, "company");
            String city = _getStringOrNull(json, "city");
            String stateProvince = _getStringOrNull(json, "state_province");
            String postalCode = _getStringOrNull(json, "postal_code");
            String phoneNumber = _getStringOrNull(json, "phone_number");
            String website = _getStringOrNull(json, "website");
            String industry = _getStringOrNull(json, "industry");
            String salutation = _getStringOrNull(json, "salutation");
            String street = _getStringOrNull(json, "street");
            String country = _getStringOrNull(json, "country");
            String employees = _getStringOrNull(json, "employees");
            String revenue = _getStringOrNull(json, "revenue");
            String mobile = _getStringOrNull(json, "mobile");
            String fax = _getStringOrNull(json, "fax");
            String rating = _getStringOrNull(json, "rating");
            String formTitle = json.getString("form_title");
            String formUrl = json.getString("form_url");
            String visitId = json.getString("visit_id");
            String siteToken = json.getString("site_token");
            Date submissionDate = new Date(json.getLong("submission_date"));
            
            return new Form(jobTitle, firstName, lastName, emailAddress, company, city, stateProvince, postalCode, phoneNumber, website, industry, salutation, street, country, employees, revenue, mobile, fax, rating, formTitle, formUrl, visitId, siteToken, submissionDate);
        } catch (JSONException e) {
            throw new InternalException(e);
        }
    }
    
    private LeadScore _getLeadScoreFromJson(JSONObject json) {
        try {
            String ruleSet = json.getString("rule_set");
            double leadScore = json.getDouble("lead_score");
            double previousLeadScore = json.getDouble("previous_lead_score");
            double maxLifetimeLeadScore = json.getDouble("max_lifetime_lead_score");
            boolean hidden = json.getBoolean("hidden");
            
            return new LeadScore(ruleSet, leadScore, previousLeadScore, maxLifetimeLeadScore, hidden);
        } catch (JSONException e) {
            throw new InternalException(e);
        }
    }
    
    private CompanyInformation _getCompanyInformationFromJson(JSONObject json) {
        try {
            String name = json.getString("name");
            String phoneNumber = json.getString("phone_number");
            String website = json.getString("website");
            String stockSymbol = json.getString("stock_symbol");
            String stockExchange = json.getString("stock_exchange");
            String ownership = json.getString("ownership");
            int employeeCount = json.getInt("employee_count");
            String employeeRange = json.getString("employee_range");
            long revenue = json.getLong("revenue");
            String revenueRange = json.getString("revenue_range");
            String industry = json.getString("industry");
            String subIndustry = json.getString("sub_industry");
            String sicCode = json.getString("sic_code");
            String address = json.getString("address");
            String city = json.getString("city");
            String stateProvince = json.getString("state_province");
            String postalCode = json.getString("postal_code");
            String country = json.getString("country");
            
            return new CompanyInformation(name, phoneNumber, website, stockSymbol, stockExchange, ownership, employeeCount, employeeRange, revenue, revenueRange, industry, subIndustry, sicCode, address, city, stateProvince, postalCode, country);
        } catch (JSONException e) {
            throw new InternalException(e);
        }
    }
}
