package com.gameFx.hiRank;

import com.gameFx.hiRank.utils.NavigationUtil;
import org.junit.Test;

import static com.gameFx.hiRank.Constants.google;
import static org.junit.Assert.assertTrue;

public class NavigationUtilTest {

    @Test
    public void loadPage_whenLoadingGoogle_shouldReturnNotEmpty() {
        assertTrue(!NavigationUtil.loadPage(google).getBody().getTextContent().isEmpty());
    }

    @Test
    public void findHtmlClass_whenSearchingClass_shouldReturnListOfHtmlElements() {

        assertTrue(!NavigationUtil.findHtmlElementByClass(NavigationUtil.loadPage(google), "content").isEmpty());
    }
}
