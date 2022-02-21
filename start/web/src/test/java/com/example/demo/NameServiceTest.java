package com.example.demo;

import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.*;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @author Ryan Baxter
 */
public class NameServiceTest {

	@Test
	public void getNameTest() throws Exception {
		NameService.NameFeignClient nameFeignClient = mock(NameService.NameFeignClient.class);
		doReturn("Ryan").when(nameFeignClient).getName();
		NameService nameService = new NameService(nameFeignClient);
		String name = nameService.getName();
		assertEquals(name, "Ryan");
	}

}