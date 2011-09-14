package com.houston.mvc;

import org.mortbay.jetty.Connector; 
import org.mortbay.jetty.Server; 
import org.mortbay.jetty.bio.SocketConnector; 
import org.mortbay.jetty.webapp.WebAppContext; 

public class JettyServer {

	private Server jettyServer = null;
    
	private final String contextPath;
	private final int port;
	
	public JettyServer(String contextPath, int port) {
		this.contextPath = contextPath;
		this.port = port;
	}

	public String getContextPath() {
		return contextPath;
	}
	
	public int getPort() {
		return port;
	}
	
	public void start() {
	
        try {
            jettyServer = new Server();

            SocketConnector conn = new SocketConnector();
            conn.setPort(port);
            jettyServer.setConnectors(new Connector[] {conn});

            WebAppContext context = new WebAppContext();
            context.setContextPath(contextPath);
            context.setWar("src/main/webapp");

            jettyServer.setHandler(context);
            jettyServer.start();
        } catch (Exception ignore) {
            if (jettyServer != null) {
                try {
                    jettyServer.stop();
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        }
    }

	public void stop() {
		try {
			jettyServer.stop();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getBaseUrl() {
		String url = String.format("http://localhost:%s/", port);
		if (!contextPath.equals("/")) {
			url += contextPath + "/";
		}
		return url;
	}
	
}