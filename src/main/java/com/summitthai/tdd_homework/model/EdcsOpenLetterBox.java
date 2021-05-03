package com.summitthai.tdd_homework.model;

public class EdcsOpenLetterBox {
    private String regInd;
    private String secretInd;
    private String recSecretInd;
    private String sendSecretInd;
    private String currentDateTime;
    private String userId;
    private String currentDateTime1;
    private String userId1;
    private EdcsOpenLetterBoxPK edcsOpenLetterBoxPK;

    public EdcsOpenLetterBox(EdcsOpenLetterBoxPK edcsOpenLetterBoxPK, String regInd, String secretInd, String recSecretInd, String sendSecretInd, String currentDateTime, String userId, String currentDateTime1, String userId1) {
        this.edcsOpenLetterBoxPK = edcsOpenLetterBoxPK;
        this.regInd = regInd;
        this.secretInd = secretInd;
        this.recSecretInd = recSecretInd;
        this.sendSecretInd = sendSecretInd;
        this.currentDateTime = currentDateTime;
        this.userId = userId;
        this.currentDateTime1 = currentDateTime1;
        this.userId1 = userId1;
    }

    public void setRegInd(String regInd) {
        this.regInd = regInd;
    }

    public void setSecretInd(String secretInd) {

        this.secretInd = secretInd;
    }

    public void setRecSecretInd(String recSecretInd) {

        this.recSecretInd = recSecretInd;
    }

    public void setSendSecretInd(String sendSecretInd) {

        this.sendSecretInd = sendSecretInd;
    }

    public void setUpdDtm(String currentDateTime) {

    }

    public void setUpdUserId(String userId) {

        this.userId = userId;
    }

    public void refreshData() {

    }
}
