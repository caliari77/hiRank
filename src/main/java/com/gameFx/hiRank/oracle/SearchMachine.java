package com.gameFx.hiRank.oracle;

import com.gargoylesoftware.htmlunit.html.HtmlPage;

public interface SearchMachine {

    /**
     * Use the search machine to find the page of results
     *
     * @param term The expression to search
     * @return the result page
     */
    public HtmlPage search(String term);

}
