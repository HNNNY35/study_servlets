package com.hnnny.study_servlets.beans;

public class MemberBean {
    String firstName;
    String secondName;
    String handleName;

    // 게터, 세터 만들기 : 변수를 직접적으로 건드리지 않아도 값 사용 가능
    // 
    public String getFirstName()  {
        return this.firstName;
    }
    public String getSecondName() {
        return this.secondName;
    }
    public String getHandleName() {
        return this.handleName;
    }


    // 세터 : 넣는 건 리턴 값이 없음
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }
    public void setHandleName(String handleName) {
        this.handleName  = handleName;
    }
}
