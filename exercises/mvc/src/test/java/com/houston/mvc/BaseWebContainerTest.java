package com.houston.mvc;

import static net.sourceforge.jwebunit.junit.JWebUnit.setBaseUrl;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/context.xml")
public abstract class BaseWebContainerTest {
	
	protected JettyServer jettyServer;

	@Before
	public final void startWebContainer() {
		jettyServer = new JettyServer("/", 8081);
		jettyServer.start();
        setBaseUrl(jettyServer.getBaseUrl());
	}

	@After
	public final void stopWebContainer() {
		jettyServer.stop();
	}
}