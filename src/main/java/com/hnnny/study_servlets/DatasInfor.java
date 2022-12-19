package com.hnnny.study_servlets;

import java.util.ArrayList;
import java.util.HashMap;

import com.hnnny.study_servlets.beans.MemberBean;

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

        bundlesData.put("dataWithMemberBean", datasInfor.getDataWithMemberBean());
        bundlesData.put("getDataListWithMemberBean", datasInfor.getDataListWithMemberBean());
        return bundlesData;
    }

    public MemberBean getDataWithMemberBean(){
        // 인스턴스화 시키기
        MemberBean memberBean = new MemberBean();
        memberBean.setFirstName("Mark");
        memberBean.setSecondName("Otto");
        memberBean.setHandleName("@mdo");
        return memberBean;
    }

    public ArrayList<MemberBean> getDataListWithMemberBean(){
        ArrayList<MemberBean> membersList = new ArrayList<>();
        MemberBean memberBean = new MemberBean();
        memberBean.setFirstName("Mark");
        memberBean.setSecondName("Otto");
        memberBean.setHandleName("@mdo");
        membersList.add(memberBean);

        MemberBean memberBean02 = new MemberBean();
        memberBean02.setFirstName("Jacob");
        memberBean02.setSecondName("Thornton");
        memberBean02.setHandleName("@fat");
        membersList.add(memberBean02);

        MemberBean memberBean03 = new MemberBean();
        memberBean03.setFirstName("Larry");
        memberBean03.setSecondName("Bird");
        memberBean03.setHandleName("@twitter");
        membersList.add(memberBean03);
        return membersList;
    }
}
