package com.sabre;

import org.glassfish.jersey.internal.inject.AbstractBinder;

public class MyDAOConfigBinder extends AbstractBinder {
    @Override
    protected void configure() {
        bind(ActorDAO.class).to(ActorDAO.class);
    }
	
}