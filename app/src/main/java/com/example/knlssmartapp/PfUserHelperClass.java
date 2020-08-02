package com.example.knlssmartapp;

public class PfUserHelperClass {
    String pfuan,pfcellno,pfname,pfdob,pfaadhar,pfbank,pfifsc,pfpan;

    public PfUserHelperClass() {

    }

    public PfUserHelperClass(String pfuan, String pfcellno, String pfname, String pfdob, String pfaadhar, String pfbank, String pfifsc, String pfpan) {
        this.pfuan = pfuan;
        this.pfcellno = pfcellno;
        this.pfname = pfname;
        this.pfdob = pfdob;
        this.pfaadhar = pfaadhar;
        this.pfbank = pfbank;
        this.pfifsc = pfifsc;
        this.pfpan = pfpan;
    }

    public String getPfuan() {
        return pfuan;
    }

    public void setPfuan(String pfuan) {
        this.pfuan = pfuan;
    }

    public String getPfcellno() {
        return pfcellno;
    }

    public void setPfcellno(String pfcellno) {
        this.pfcellno = pfcellno;
    }

    public String getPfname() {
        return pfname;
    }

    public void setPfname(String pfname) {
        this.pfname = pfname;
    }

    public String getPfdob() {
        return pfdob;
    }

    public void setPfdob(String pfdob) {
        this.pfdob = pfdob;
    }

    public String getPfaadhar() {
        return pfaadhar;
    }

    public void setPfaadhar(String pfaadhar) {
        this.pfaadhar = pfaadhar;
    }

    public String getPfbank() {
        return pfbank;
    }

    public void setPfbank(String pfbank) {
        this.pfbank = pfbank;
    }

    public String getPfifsc() {
        return pfifsc;
    }

    public void setPfifsc(String pfifsc) {
        this.pfifsc = pfifsc;
    }

    public String getPfpan() {
        return pfpan;
    }

    public void setPfpan(String pfpan) {
        this.pfpan = pfpan;
    }
}
