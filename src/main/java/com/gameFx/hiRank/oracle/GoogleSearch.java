package com.gameFx.hiRank.oracle;

import com.gameFx.hiRank.model.SessionContainer;
import com.gameFx.hiRank.session.HUWebSessionManager;
import com.gameFx.hiRank.session.WebSession;
import com.gameFx.hiRank.utils.NavigationUtil;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import java.util.ArrayList;
import java.util.List;
import java.util.function.IntUnaryOperator;
import java.util.stream.IntStream;

import static com.gameFx.hiRank.Constants.*;

public class GoogleSearch implements SearchMachine{

    /**
     * UNFINISHED CLASSSSSSSS
     *
     *
     *
     *
     *
     *
     */



    @Override
    public List<String> retrieveSiteList(Integer numberOfPages, String acceptanceCriteria, String filterCriteria) {

        List<String> urlResultListForAllpages = new ArrayList<>();
        HtmlPage mainPage = NavigationUtil.loadPage(google);

        IntStream.range(0, numberOfPages).map(indexSearch -> getAllUrlFromThisSearch(indexSearch, mainPage, filterCriteria));

        return urlResultListForAllpages;
    }



    private List<String> getAllUrlFromThisSearch(int indexSearch, HtmlPage mainPage, String filterCriteria) {
        HtmlPage searchPage = goToPageWithIndex();


        return retrieveAllUrlResultsFromAPage();
    }

    private HtmlPage goToPageWithIndex(HtmlPage mainPage, int index) {

        if(index == 1){
            return mainPage;
        }

        HtmlElement indexBar =
                (HtmlElement) mainPage.getByXPath("/div[class='" + googleIndexBarClass + "']")
                .stream()
                .findAny()
                .orElse(null);

        if(indexBar != null){
            List<HtmlElement> indexBarList = indexBar.getByXPath("/div[class='" + googleIndexBarElementClass + "']");

            indexBarList.get(index-1).get

            return NavigationUtil.loadPage();
        }

        return null;
    }


    public List<String> retrieveAllUrlResultsFromAPage(HtmlPage htmlPage, String filterCriteria) {
        List<HtmlElement> htmlElementResultList = htmlPage.getByXPath("/div[class='" + googleSearchElementClassName + "']");

        List<String> urlList = new ArrayList();
        htmlElementResultList.stream().map(page -> urlList.add(page.getNodeValue()));

        return urlList;
    }


}
