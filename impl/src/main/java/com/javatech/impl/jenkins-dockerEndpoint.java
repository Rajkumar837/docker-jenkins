package com/javatech.impl;

import org.coos.messaging.Consumer;
import org.coos.messaging.Processor;
import org.coos.messaging.Producer;
import org.coos.messaging.Service;
import org.coos.messaging.impl.DefaultEndpoint;
import org.coos.messaging.util.Log;
import org.coos.messaging.util.LogFactory;

public class jenkins-dockerEndpoint extends DefaultEndpoint {

    private Consumer consumer;
    private Producer producer;
    private static final Log LOG = LogFactory.getLog(jenkins-dockerEndpoint.class.getName());
    
    public jenkins-dockerEndpoint() {
    }

    public jenkins-dockerEndpoint(String uri, Processor processor) {
        super(uri, processor);
    }
    
    @Override
    public Consumer createConsumer() {
        if (consumer == null) {
            consumer = new jenkins-dockerConsumer(this);
        }
        return consumer;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Producer createProducer() {
        if(producer == null) {
            producer = new jenkins-dockerProducer(this);
            getServices().addElement(producer);
            try {
                ((Service) producer).start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return producer;
    }
    
    @Override
    public void start() throws Exception {
        LOG.debug("Starting endpoint");
    }

    @Override
    public void stop() throws Exception {
        LOG.debug("Stopping endpoint");
    }

}

