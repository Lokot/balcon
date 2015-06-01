package ru.skysoftlab.balcon.impl;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Initialized;
import javax.enterprise.event.Observes;

import org.jboss.logging.Logger;

public class ProtonizerInitialized {
	
	private static final Logger log = Logger.getLogger(ProtonizerInitialized.class);
	
	public void initialized(@Observes @Initialized(ApplicationScoped.class) Object event) {
		log.info("call method initialized() ....");
	}

}
