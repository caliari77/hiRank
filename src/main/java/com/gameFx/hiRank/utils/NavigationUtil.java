package com.gameFx.hiRank.utils;

import com.gameFx.hiRank.model.SessionContainer;
import com.gameFx.hiRank.session.HUWebSessionManager;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import static com.gameFx.hiRank.Constants.google;

public class NavigationUtil {

    public static HtmlPage loadPage(String url) {
        SessionContainer sessionContainer = new SessionContainer.Builder().withBaseUrl(url).create();
        new HUWebSessionManager().retrievePageHtml(sessionContainer);
        return sessionContainer.getPage();
    }
}
