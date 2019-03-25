package com.gameFx.hiRank;

import com.gameFx.hiRank.model.SessionContainer;
import com.gameFx.hiRank.session.HUWebSessionManager;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;


public class SessionTest {

    @Test
    public void webSession_whenMakingAnRequestToGoogle_shouldReturnThePageAsHtml() {
        String googleUrl = "https://www.google.com";
        SessionContainer sc = new SessionContainer.Builder().withBaseUrl(googleUrl).build();
        new HUWebSessionManager().retrievePageHtml(sc);
        String result = sc.getPage().getBody().toString();
        assertTrue(!result.isEmpty());
    }

}
