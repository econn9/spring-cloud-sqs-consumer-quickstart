package com.bmw.omc.consumer;

import com.consumer.AppConfig;
import com.consumer.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@ActiveProfiles({"local"})
public class AppConfigTests {

	@Autowired
	private AppConfig appConfig;

	@Test
	public void testAwsRegionGet() {
		String expected = "us-east-1";
		assertEquals(expected, appConfig.getSqsRegion());
	}

}
