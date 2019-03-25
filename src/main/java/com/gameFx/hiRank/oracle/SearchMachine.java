package com.gameFx.hiRank.oracle;

import java.util.List;

public interface SearchMachine {

    /**
     * Gets all pages related to search criteria in a range of pages.
     *
     * @param numberOfPages Depth of pages that the search engine may get results.
     * @param acceptanceCriteria Field to be filled for search engine.
     * @param filterCriteria Things that you don't want your page to contain. They should be 100% filtered.
     * @return The url list of pages that matches the criteria in defined depth.
     */
    public List<String> retrieveSiteList(Integer numberOfPages, String acceptanceCriteria, String filterCriteria);

    /**
     * Gets all pages related to search cruteria in a page.
     *
     * @param acceptanceCriteria Field to be filled for search engine.
     * @param filterCriteria Things that you don't want your page to contain. They should be 100% filtered.
     * @return The url list of pages that matches the criteria in defined depth.     */
    public List<String> retrieveAllUrlResultsFromAPage(String acceptanceCriteria, String filterCriteria);

}
