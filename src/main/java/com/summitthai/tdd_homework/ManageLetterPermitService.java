package com.summitthai.tdd_homework;

import java.util.ArrayList;
import java.util.List;

import com.summitthai.tdd_homework.exception.CannotCreateDataException;
import com.summitthai.tdd_homework.exception.DataNotFoundException;
import com.summitthai.tdd_homework.model.EdcsLetterBox;
import com.summitthai.tdd_homework.model.EdcsOpenLetterBox;
import com.summitthai.tdd_homework.model.EdcsOpenLetterBoxPK;
import com.summitthai.tdd_homework.model.HrstDepartment;
import com.summitthai.tdd_homework.session.EdcsUserSession;
import com.summitthai.tdd_homework.utils.DateUtils;

public class ManageLetterPermitService {

    private EdcsJpaService db;
    private HrstDepartmentServiceable departmentService;
    private HrstPersonServiceable hrstPersonService;

    public ManageLetterPermitService() {
        db = new EdcsJpaService();
        departmentService = new HrstDepartmentService();
        hrstPersonService = new HrstPersonService();
    }

    public ManageLetterPermitService(EdcsJpaService db) {
        super();
        this.db = db;
        departmentService = new HrstDepartmentService();
        hrstPersonService = new HrstPersonService();
    }

    public void doCreate(List<LetterManagePermitForm> saves, EdcsUserSession edcsUserSession) throws CannotCreateDataException {
        try {
            db.createConnection(db.getEdcsOpenLetterBoxDao());
            db.begin();

            String currentDateTime = DateUtils.getCurrentDateTimeString();

            if (saves != null && !saves.isEmpty()) {
                for (LetterManagePermitForm eol : saves) {

                    db.getEdcsOpenLetterBoxDao().create(getEdcsOpenLetterBox(edcsUserSession, currentDateTime, eol));
                }
            }

            db.commit();
        } catch (Exception e) {
            db.rollback();
            throw e;
        } finally {
            db.closeConnection();
        }
    }

    private EdcsOpenLetterBox getEdcsOpenLetterBox(EdcsUserSession edcsUserSession, String currentDateTime, LetterManagePermitForm eol) {
        EdcsOpenLetterBox saveEdcsOpenLetterBox = new EdcsOpenLetterBox(
                new EdcsOpenLetterBoxPK(eol.getUserId(),
                        eol.getBoxId()),
                eol.getRegInd(),
                eol.getSecretInd(),
                eol.getRecSecretInd(),
                eol.getSendSecretInd(),
                currentDateTime,
                edcsUserSession.getUserId(),
                currentDateTime,
                edcsUserSession.getUserId());
        return saveEdcsOpenLetterBox;
    }

    public List<LetterManagePermitForm> searchActionPermit(Long deptCode, String userId) throws DataNotFoundException {
        try {
            db.createConnection(db.getEdcsOpenLetterBoxDao(), db.getEdcsLetterBoxDao());


            List<LetterManagePermitForm> letterManagePermitForms = new ArrayList<>();

            HrstDepartment departmentByDeptCode = departmentService.getByPk(deptCode);
            List<HrstDepartment> departmentsByAction = departmentService.searchDeptCode(departmentByDeptCode.getDeptCodeAction());

            for (HrstDepartment department : departmentsByAction) {

                // * กล่องหน่วยงาน *

                List<EdcsLetterBox> edcsLetterBoxs = db.getEdcsLetterBoxDao().findEdcsLetterBoxByOwner("D", department.getDeptCode());
                for (EdcsLetterBox edcsLetterBox : edcsLetterBoxs) {
                    List<EdcsOpenLetterBox> edcsOpenLetterBoxs = db.getEdcsOpenLetterBoxDao().findOpenLetterBoxByUserId(userId, edcsLetterBox.getBoxId());

                    if (edcsOpenLetterBoxs != null && !edcsOpenLetterBoxs.isEmpty()) {
                        for (EdcsOpenLetterBox edcsOpenLetterBox : edcsOpenLetterBoxs) {
                            edcsOpenLetterBox.refreshData();
                            letterManagePermitForms.add(new LetterManagePermitForm(department, null, null, edcsLetterBox, edcsOpenLetterBox, "Y", department.getDeptName()));
                        }
                    } else {
                        letterManagePermitForms.add(new LetterManagePermitForm(department, null, null, edcsLetterBox, null, "N", department.getDeptName()));
                    }
                }

            }
            return letterManagePermitForms;

        } catch (Exception e) {
            throw e;
        } finally {
            db.closeConnection();
        }
    }
}
