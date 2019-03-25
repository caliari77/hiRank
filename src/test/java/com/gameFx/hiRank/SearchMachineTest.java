package com.gameFx.hiRank;

import com.gameFx.hiRank.oracle.GoogleSearch;
import com.gameFx.hiRank.oracle.SearchMachine;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class SearchMachineTest {

    public void googleSearch_whenRetrieveSiteList_withGameCriteria_shouldReturnListOfresultNotEmpty(){
        SearchMachine sm = new GoogleSearch();
        List<String> urlList = sm.retrieveSiteList(1, "Doom","tetris");

        assertTrue(!urlList.isEmpty());
    }
}
