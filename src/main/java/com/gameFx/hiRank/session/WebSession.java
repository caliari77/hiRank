package com.gameFx.hiRank.session;


import com.gameFx.hiRank.model.SessionContainer;

/**
 * Defines how to manage a web session like a non visual browser.
 */
public interface WebSession {

    /**
     * Make the request and retrieves the response as html to put
     * It inside the container
     *
     * @param sessionContainer The container for actual request
     */
    public void retrievePageHtml(SessionContainer sessionContainer);


}
