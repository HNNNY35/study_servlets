package com.hnnny.study_servlets;

import java.util.ArrayList;
import java.util.HashMap;

public class DatasInfor {
    public HashMap<String, String> getSearchFormData()  {
        HashMap<String, String> searchForm = new HashMap<String, String>();
        searchForm.put("search_key", "Search Title");
        searchForm.put("name", "요주의랩!");
        searchForm.put("id", "ID0001");
        return searchForm;
    }

    public ArrayList<String> getTablesListWithString(){
        ArrayList<String> tablesListwithString = new ArrayList<String>();
        tablesListwithString.add("@mdo");
        tablesListwithString.add("@fat");
        tablesListwithString.add("@twitter");
        return tablesListwithString;
    }

    public HashMap<String, Object> getBundlesData() {
        DatasInfor datasInfor = new DatasInfor();
        HashMap<String, String> searchForm = datasInfor.getSearchFormData();
        ArrayList<String> tablesListWithString = datasInfor.getTablesListWithString();

        HashMap<String, Object> bundlesData = new HashMap<>();
        bundlesData.put("searchForm", searchForm);
        bundlesData.put("tablesListWithString", tablesListWithString);

        return bundlesData;
    }
}
