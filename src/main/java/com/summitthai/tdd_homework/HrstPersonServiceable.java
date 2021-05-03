package com.summitthai.tdd_homework;

import java.math.BigDecimal;
import java.util.List;

import com.summitthai.tdd_homework.model.HrstPerson;

public interface HrstPersonServiceable {

	public List<HrstPerson> getPersonsByWorkDepartment(BigDecimal bigDecimal);

}
