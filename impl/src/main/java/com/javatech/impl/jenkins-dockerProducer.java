package com/javatech.impl;

import org.coos.messaging.impl.DefaultProducer;
import org.coos.messaging.*;
import org.coos.messaging.util.Log;
import org.coos.messaging.util.LogFactory;

public class jenkins-dockerProducer extends DefaultProducer {
    
    private static final Log LOG = LogFactory.getLog(jenkins-dockerProducer.class.getName());
    
    public jenkins-dockerProducer(Endpoint endpoint) {
        super(endpoint);
    }

    @Override
    public void start() {
        LOG.debug("Starting Producer");
    }

    @Override
    public void stop() {
        LOG.debug("Stopping Producer");
    }
}
