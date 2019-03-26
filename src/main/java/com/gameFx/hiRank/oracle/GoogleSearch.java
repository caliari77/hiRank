package com.gameFx.hiRank.oracle;

import com.gameFx.hiRank.utils.NavigationUtil;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import java.util.List;

import static com.gameFx.hiRank.Constants.google;

public class GoogleSearch implements SearchMachine {


    @Override
    public HtmlPage search(String term) {
        HtmlPage homePage = NavigationUtil.loadPage(google);
        List<HtmlElement> a = NavigationUtil.findHtmlElementByCriteria(homePage, "//input[@id='q']");

        return null;
    }
}
