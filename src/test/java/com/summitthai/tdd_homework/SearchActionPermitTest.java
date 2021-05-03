package com.summitthai.tdd_homework;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.summitthai.tdd_homework.dao.EdcsLetterBoxDao;
import com.summitthai.tdd_homework.dao.EdcsOpenLetterBoxDao;
import com.summitthai.tdd_homework.exception.DataNotFoundException;
import com.summitthai.tdd_homework.model.HrstDepartment;

@ExtendWith(MockitoExtension.class)
public class SearchActionPermitTest {
    @Mock
    HrstDepartmentServiceable departmentService;
    @Mock
    HrstPersonServiceable     hrstPersonService;
    @Mock
    EdcsLetterBoxDao edcsLetterBoxDao;
    @Mock
    EdcsOpenLetterBoxDao edcsOpenLetterBoxDao;

    @Test
    public void letterManagePermitFormSizeShouldBe10() throws DataNotFoundException {
        ManageLetterPermitService service = new ManageLetterPermitService();
        Long deptCode = null;
        String userId = null;
        HrstDepartment departmentByDeptCode = new HrstDepartment();
        //when(departmentService.getByPk(deptCode)).thenReturn(departmentByDeptCode);

        //List<LetterManagePermitForm> letterManagePermitForms = service.searchActionPermit(deptCode, userId);

        //assertEquals(10, letterManagePermitForms.size());
    }
}
