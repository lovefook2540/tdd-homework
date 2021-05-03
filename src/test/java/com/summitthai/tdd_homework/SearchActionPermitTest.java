package com.summitthai.tdd_homework;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.summitthai.tdd_homework.dao.EdcsLetterBoxDao;
import com.summitthai.tdd_homework.dao.EdcsOpenLetterBoxDao;
import com.summitthai.tdd_homework.exception.DataNotFoundException;
import com.summitthai.tdd_homework.model.EdcsLetterBox;
import com.summitthai.tdd_homework.model.EdcsOpenLetterBox;
import com.summitthai.tdd_homework.model.EdcsOpenLetterBoxPK;

@ExtendWith(MockitoExtension.class)
public class SearchActionPermitTest {
	
	@Mock
    EdcsJpaService db;
    @Mock
    HrstDepartmentServiceable departmentService;
    @Mock
    HrstPersonServiceable     hrstPersonService;
    @Mock
    EdcsLetterBoxDao edcsLetterBoxDao;
    @Mock
    EdcsOpenLetterBoxDao edcsOpenLetterBoxDao;
    
    @Test
    public void letterManagePermitFormSizeShouldBe_10() throws DataNotFoundException  {
        //Arrange
    	int expectedResult = 10;
        when(db.getEdcsOpenLetterBoxDao()).thenReturn(edcsOpenLetterBoxDao);
        when(db.getEdcsLetterBoxDao()).thenReturn(edcsLetterBoxDao);
        ManageLetterPermitService service = new ManageLetterPermitService(db);
        Long deptCode = new Long("123");
        String userId = "fluke";
        String boxId  = "AAA";
        when(db.getEdcsLetterBoxDao().findEdcsLetterBoxByOwner("D", "123")).thenReturn(stubEdcsLetterBoxList());
        when(db.getEdcsOpenLetterBoxDao().findOpenLetterBoxByUserId(userId, boxId)).thenReturn(stubEdcsOpenLetterBox(userId, boxId, 10));
        
        //Act
        List<LetterManagePermitForm> actualResult = service.searchActionPermit(deptCode, userId);

        //Assert
        verify(edcsLetterBoxDao, times(1)).findEdcsLetterBoxByOwner("D", "123");
        verify(edcsOpenLetterBoxDao, times(1)).findOpenLetterBoxByUserId(userId, boxId);
        assertEquals(expectedResult, actualResult.size());
    }
    
    @Test
    public void letterManagePermitFormTypeShouldBe_Y() throws DataNotFoundException  {
    	//Arrange
    	String expectedResult = "Y";
        when(db.getEdcsOpenLetterBoxDao()).thenReturn(edcsOpenLetterBoxDao);
        when(db.getEdcsLetterBoxDao()).thenReturn(edcsLetterBoxDao);
        ManageLetterPermitService service = new ManageLetterPermitService(db);
        Long deptCode = new Long("123");
        String userId = "fluke";
        String boxId  = "AAA";
        when(db.getEdcsLetterBoxDao().findEdcsLetterBoxByOwner("D", "123")).thenReturn(stubEdcsLetterBoxList());
        when(db.getEdcsOpenLetterBoxDao().findOpenLetterBoxByUserId(userId, boxId)).thenReturn(stubEdcsOpenLetterBox(userId, boxId, 1));
        
        //Act
        List<LetterManagePermitForm> actualResult = service.searchActionPermit(deptCode, userId);

        //Assert
        verify(edcsLetterBoxDao, times(1)).findEdcsLetterBoxByOwner("D", "123");
        verify(edcsOpenLetterBoxDao, times(1)).findOpenLetterBoxByUserId(userId, boxId);
        assertEquals(expectedResult, actualResult.get(0).getY());
    }
    
    @Test
    public void letterManagePermitFormTypeShouldBe_N() throws DataNotFoundException  {
    	//Arrange
    	String expectedResult = "N";
        when(db.getEdcsOpenLetterBoxDao()).thenReturn(edcsOpenLetterBoxDao);
        when(db.getEdcsLetterBoxDao()).thenReturn(edcsLetterBoxDao);
        ManageLetterPermitService service = new ManageLetterPermitService(db);
        Long deptCode = new Long("123");
        String userId = "fluke";
        String boxId  = "AAA";
        when(db.getEdcsLetterBoxDao().findEdcsLetterBoxByOwner("D", "123")).thenReturn(stubEdcsLetterBoxList());
        when(db.getEdcsOpenLetterBoxDao().findOpenLetterBoxByUserId(userId, boxId)).thenReturn(Collections.emptyList());
        
        //Act
        List<LetterManagePermitForm> actualResult = service.searchActionPermit(deptCode, userId);

        //Assert
        verify(edcsLetterBoxDao, times(1)).findEdcsLetterBoxByOwner("D", "123");
        verify(edcsOpenLetterBoxDao, times(1)).findOpenLetterBoxByUserId(userId, boxId);
        assertEquals(expectedResult, actualResult.get(0).getY());
    }

	private List<EdcsLetterBox> stubEdcsLetterBoxList() {
		List<EdcsLetterBox> edcsLetterBoxList = new ArrayList<>();
		EdcsLetterBox edcsLetterBox = new EdcsLetterBox();
    	edcsLetterBox.setBoxId("AAA");
    	edcsLetterBoxList.add(edcsLetterBox);
		return edcsLetterBoxList;
	}
	
	private List<EdcsOpenLetterBox> stubEdcsOpenLetterBox(String userId, String boxId, int times){
		List<EdcsOpenLetterBox> edcsOpenLetterBoxList = new ArrayList<>();
		for (int i = 0; i < times; i++) {
			EdcsOpenLetterBoxPK edcsOpenLetterBoxPK = new EdcsOpenLetterBoxPK(userId, boxId);
	    	EdcsOpenLetterBox edcsOpenLetterBox = new EdcsOpenLetterBox(
	    										  edcsOpenLetterBoxPK, 
	    										  "REG", 
	    										  "SECRET", 
	    										  String.valueOf(i), 
	    										  String.valueOf(i+1), 
	    										  "12:00", 
	    										  "fluke", 
	    										  "12:30", 
	    										  "phai");
	    	edcsOpenLetterBoxList.add(edcsOpenLetterBox);
		}
		return edcsOpenLetterBoxList;
	}
}
