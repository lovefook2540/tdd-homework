package com.summitthai.tdd_homework;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.summitthai.tdd_homework.dao.EdcsOpenLetterBoxDao;
import com.summitthai.tdd_homework.exception.CannotCreateDataException;
import com.summitthai.tdd_homework.model.EdcsOpenLetterBox;
import com.summitthai.tdd_homework.session.EdcsUserSession;

@ExtendWith(MockitoExtension.class)
public class DoCreateTest {

    @Mock
    EdcsOpenLetterBoxDao edcsOpenLetterBoxDao;

    @Mock
    EdcsJpaService db;

    @Test
    public void shouldCallEdcsOpenLetterBoxDao_create() throws CannotCreateDataException {
        // Arrange
        when(db.getEdcsOpenLetterBoxDao()).thenReturn(edcsOpenLetterBoxDao);
        ManageLetterPermitService service = new ManageLetterPermitService(db);
        List<LetterManagePermitForm> saves = new ArrayList<>();

        String userId = null;
        String boxId = null;
        String regInd = null;
        saves.add(new LetterManagePermitForm(userId, boxId, regInd));
        saves.add(new LetterManagePermitForm(userId, boxId, regInd));
        EdcsUserSession edcsUserSession = new EdcsUserSession();

        // Act
        service.doCreate(saves, edcsUserSession);

        // Assert
        //verify(edcsOpenLetterBoxDao).create(any(EdcsOpenLetterBox.class));
        verify(edcsOpenLetterBoxDao, times(2)).create(any(EdcsOpenLetterBox.class));
    }
}
