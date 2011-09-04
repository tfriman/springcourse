package com.houston.rest;

import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/context.xml")
public class BaseWebContainerTest {
	
	@Autowired
	protected WebApplicationContainer webContainer;

	@Before
	public final void startWebContainer() {
		webContainer.setWebRoot(computeWebRoot());
		webContainer.start();
	}

	private File computeWebRoot() {
		return new File(new File("").getAbsolutePath() + "/src/main/webapp");
	}

	@After
	public final void stopWebContainer() {
		if (webContainer.isStarted()) {
			webContainer.stop();
		}
	}
}