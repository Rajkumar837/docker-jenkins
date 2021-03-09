package com/javatech.impl;

import java.util.Hashtable;
import org.coos.messaging.Endpoint;
import org.coos.messaging.Exchange;
import org.coos.messaging.Message;
import org.coos.messaging.impl.DefaultConsumer;
import org.coos.messaging.util.Log;
import org.coos.messaging.util.LogFactory;
import com/javatech.api.jenkins-dockerMessageFactory;
import com/javatech.api.jenkins-dockerMessageProperties;

public class jenkins-dockerConsumer extends DefaultConsumer {

    Message msg;
    private static final Log LOG = LogFactory.getLog(jenkins-dockerConsumer.class.getName());
    
    public jenkins-dockerConsumer(Endpoint endpoint) {
        super(endpoint);
    }

    @Override
    public void process(Exchange exchange) {
    	msg = exchange.getInBoundMessage();
    	Hashtable<?, ?> props = msg.getBodyAsProperties();
    	if (msg.getName().equals(jenkins-dockerMessageFactory.EXAMPLE_METHOD)) {
    		LOG.debug("Received msg: " + msg.getName() + " from: " + msg.getSenderEndpointUri() + " with property: " + props.get(jenkins-dockerMessageProperties.EXAMPLE_PROP_EXAMPLENAME));
    		return;
    	}
    }
}
