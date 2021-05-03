package com.summitthai.tdd_homework;

import com.summitthai.tdd_homework.model.EdcsLetterBox;
import com.summitthai.tdd_homework.model.EdcsOpenLetterBox;
import com.summitthai.tdd_homework.model.HrstDepartment;
import com.summitthai.tdd_homework.model.HrstPerson;

public class LetterManagePermitForm {
    private String userId;
    private String boxId;
    private String regInd;

    public LetterManagePermitForm(String userId, String boxId, String regInd) {

        this.userId = userId;
        this.boxId = boxId;
        this.regInd = regInd;
    }

    public LetterManagePermitForm(HrstDepartment department, String o, HrstPerson hrstPerson, EdcsLetterBox edcsLetterBox, EdcsOpenLetterBox edcsOpenLetterBox, String y, String deptName) {
    }

    public String getUserId() {
        return null;
    }

    public String getRegInd() {
        return null;
    }

    public String getSecretInd() {
        return null;
    }

    public String getRecSecretInd() {
        return null;
    }

    public String getSendSecretInd() {
        return null;
    }

    public String getBoxId() {
        return null;
    }

    public LetterManagePermitForm getEdcsLetterBox() {
        return null;
    }
}
