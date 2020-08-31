package com.sabre;

import org.glassfish.jersey.server.ResourceConfig;

public class MyDAOConfig extends ResourceConfig {
	public MyDAOConfig() {
        register(new MyDAOConfigBinder());
        packages(true, "com.sabre");
    }
}