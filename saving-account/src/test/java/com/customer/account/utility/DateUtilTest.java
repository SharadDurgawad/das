package com.customer.account.utility;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class DateUtilTest {
	
	@InjectMocks
	private DateUtil dateUtil;
	
	@Test
	public void getValidDateString() {
		String dateOfBirth = "12/12/2000";
		String response = DateUtil.getValidDateString(dateOfBirth);
		Assert.assertNotNull(response);
	}
	
	@Test
	public void getValidDateStringException() {
		String dateOfBirth = "fdsfsdf";
		DateUtil.getValidDateString(dateOfBirth);
	}

}
