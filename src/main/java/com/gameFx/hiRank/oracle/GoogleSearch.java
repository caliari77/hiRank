package com.gameFx.hiRank.oracle;

import com.gameFx.hiRank.session.HUWebSessionManager;
import com.gameFx.hiRank.utils.NavigationUtil;
import com.gargoylesoftware.htmlunit.Page;
import com.gargoylesoftware.htmlunit.html.*;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.net.URL;
import java.util.List;

import static com.gameFx.hiRank.Constants.google;

public class GoogleSearch implements SearchMachine {

    private static final Logger log = Logger.getLogger(GoogleSearch.class);

    @Override
    public HtmlPage search(String term) {
        HtmlPage page = NavigationUtil.loadPage(google);
        HtmlInput inputTextField = getSearchTextField(page);

        inputTextField.setValueAttribute(term);

        return clickSearchButton(page);
    }

    private HtmlInput getSearchTextField(HtmlPage homePage){
        return (HtmlInput) NavigationUtil.findHtmlElementByCriteria(homePage.getBody(), "//input[@type='text']")
                .stream()
                .findAny()
                .orElse(null);
    }

    private HtmlPage clickSearchButton(HtmlPage homePage){
        HtmlSubmitInput submitButton = (HtmlSubmitInput) NavigationUtil.findHtmlElementByCriteria(homePage.getBody(), "//input[@aria-label='Google Search']")
                .stream()
                .findAny()
                .orElse(null);

        HtmlPage nextPage = null;
        try {
            if(submitButton !=null)
            {
                Page a = submitButton.click();
                nextPage = new HtmlPage(a.getWebResponse(), a.getEnclosingWindow());

            }
            else
            {
                nextPage = homePage;
            }
        }
        catch (IOException e) {
            log.error("Click operation could not be performed");
            e.printStackTrace();
        }
        finally {
            return nextPage;
        }
    }

}
