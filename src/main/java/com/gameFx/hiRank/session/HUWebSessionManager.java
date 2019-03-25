package com.gameFx.hiRank.session;

import com.gameFx.hiRank.model.SessionContainer;
import com.gargoylesoftware.htmlunit.WebClient;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.net.MalformedURLException;


/**
 * HtmlUnit based implementation to deal with browser connections.
 */
public class HUWebSessionManager implements WebSession {

    private static final Logger log = Logger.getLogger(HUWebSessionManager.class);

    @Override
    public void retrievePageHtml(SessionContainer sessionContainer) {
        try (WebClient webClient = new WebClient()) {
            sessionContainer.setPage(webClient.getPage(sessionContainer.getBaseUrl()));

        }
        catch (MalformedURLException e) {
            log.error("The url request is malformed.");
            e.printStackTrace();
        }
        catch (IOException e) {
            log.error("A file operation could not be performed.");
            e.printStackTrace();
        }
    }



}
