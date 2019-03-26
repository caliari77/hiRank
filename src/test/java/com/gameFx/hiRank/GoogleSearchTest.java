package com.gameFx.hiRank;

import com.gameFx.hiRank.oracle.GoogleSearch;
import org.junit.Test;

public class GoogleSearchTest {

    @Test
    public void googleSearch_whenSearchATerm_shouldReturnResultPage() {
        new GoogleSearch().search("doom");
    }

}
