package com.summitthai.tdd_homework.model;

public class EdcsOpenLetterBoxPK {
    private String userId;
    private String boxId;

    public EdcsOpenLetterBoxPK(String userId, String boxId) {
        this.userId = userId;
        this.boxId = boxId;
    }

    public void setUserId(String userId) {

        this.userId = userId;
    }

    public void setBoxId(String boxId) {

        this.boxId = boxId;
    }
}
