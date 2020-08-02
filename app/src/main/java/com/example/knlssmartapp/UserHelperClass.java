package com.example.knlssmartapp;

public class UserHelperClass
{
    String regName,regUsername,regEmail,regPhoneNo, regPassword;

    public UserHelperClass() {
    }

    public UserHelperClass(String regName, String regUsername, String regEmail, String regPhoneNo, String regPassword)
    {
        this.regName = regName;
        this.regUsername = regUsername;
        this.regEmail = regEmail;
        this.regPhoneNo = regPhoneNo;
        this.regPassword = regPassword;
    }

    public String getRegName() {
        return regName;
    }

    public void setRegName(String regName) {
        this.regName = regName;
    }

    public String getRegUsername() {
        return regUsername;
    }

    public void setRegUsername(String regUsername) {
        this.regUsername = regUsername;
    }

    public String getRegEmail() {
        return regEmail;
    }

    public void setRegEmail(String regEmail) {
        this.regEmail = regEmail;
    }

    public String getRegPhoneNo() {
        return regPhoneNo;
    }

    public void setRegPhoneNo(String regPhoneNo) {
        this.regPhoneNo = regPhoneNo;
    }

    public String getRegPassword() {
        return regPassword;
    }

    public void setRegPassword(String regPassword) {
        this.regPassword = regPassword;
    }
}
