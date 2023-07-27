package com.mycode.sparkspay;

public class Customers {
    private int slNo;
    private String name;
    private String acNo;
    private String mob;
    private String e_mail;
    private int balance;
    private String gender;

    public int getSlNo(int i) {
        return slNo;
    }

    public void setSlNo(int slNo) {
        this.slNo = slNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAcNo() {
        return acNo;
    }

    public void setAcNo(String acNo) {
        this.acNo = acNo;
    }

    public String getMob() {
        return mob;
    }

    public void setMob(String mob) {
        this.mob = mob;
    }

    public String getEmail() {
        return e_mail;
    }

    public void setEmail(String e_mail) {
        this.e_mail = e_mail;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
