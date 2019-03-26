package com.gameFx.hiRank.utils;

import com.gameFx.hiRank.model.SessionContainer;
import com.gameFx.hiRank.session.HUWebSessionManager;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import java.util.List;

public class NavigationUtil {

    public static HtmlPage loadPage(String url) {
        SessionContainer sessionContainer = new SessionContainer.Builder().withBaseUrl(url).create();
        new HUWebSessionManager().retrievePageHtml(sessionContainer);
        return sessionContainer.getPage();
    }

    public static List<HtmlElement> findHtmlElementByClass(HtmlPage page, String className) {
        return page.getByXPath("class='" + className + "'");
    }

    public static List<HtmlElement> findHtmlElementByCriteria(HtmlPage page, String criteria) {
        return page.getByXPath(criteria);
    }

    public static List<HtmlElement> findHtmlElementByClass(HtmlElement htmlElement, String className) {
        return htmlElement.getByXPath("class='" + className + "'");
    }

    public static List<HtmlElement> findHtmlElementByCriteria(HtmlElement htmlElement, String criteria) {
        return htmlElement.getByXPath(criteria);
    }
}
