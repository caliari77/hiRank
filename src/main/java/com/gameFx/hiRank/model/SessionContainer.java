package com.gameFx.hiRank.model;

import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;

public class SessionContainer {

    private String baseUrl = StringUtils.EMPTY;
    private Map<String, String> urlParameters;
    private HtmlPage page;

    private SessionContainer() {
    }

    public Map<String, String> getUrlParameters() {
        return urlParameters;
    }

    public void setUrlParameters(Map<String, String> urlParameters) {
        this.urlParameters = urlParameters;
    }

    public HtmlPage getPage() {
        return page;
    }

    public void setPage(HtmlPage page) {
        this.page = page;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public static class Builder {
        private SessionContainer sc = new SessionContainer();

        public Builder withBaseUrl(String baseUrl) {
            sc.baseUrl = baseUrl;
            return this;
        }

        public SessionContainer create() {
            return sc;
        }
    }

}
