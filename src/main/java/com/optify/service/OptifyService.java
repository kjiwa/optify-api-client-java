package com.optify.service;

import com.optify.service.exception.BadRequestException;
import com.optify.service.exception.UnauthorizedException;
import com.optify.service.model.Site;
import com.optify.service.model.Visitor;
import com.optify.service.parameter.GetSiteParameters;
import com.optify.service.parameter.GetVisitorParameters;
import com.optify.service.parameter.GetVisitorsParameters;

public interface OptifyService {
    String whoAmI() throws BadRequestException, UnauthorizedException;
    Site[] getSites() throws BadRequestException, UnauthorizedException;
    Site getSite(GetSiteParameters params) throws BadRequestException, UnauthorizedException;
    Visitor[] getVisitors(GetVisitorsParameters params) throws BadRequestException, UnauthorizedException;
    Visitor getVisitor(GetVisitorParameters params) throws BadRequestException, UnauthorizedException;
}
