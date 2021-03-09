package com/javatech.test;


import java.io.InputStream;
import org.coos.messaging.InteractionHelper;
import org.coos.messaging.plugin.test.DefaultTest;
import org.coos.messaging.Exchange;
import org.coos.messaging.plugin.simple.SimpleProducer;
import com/javatech.api.jenkins-dockerMessageFactory;

public class jenkins-dockerTest extends DefaultTest {

	public void testjenkins-dockerEndpoint() {
		
        SimpleProducer producer = (SimpleProducer) getTestPlugins()[0].getEndpoint().createProducer();
        
        Exchange ex;
        System.out.println("testing example api");
        ex=jenkins-dockerMessageFactory.createExampleMethodExchange("Testing the example");
        InteractionHelper helper = new InteractionHelper(producer.getEndpoint());
        helper.send("coos://jenkins-docker",ex);
        
        assertEquals(true, true);
        
	}

	@Override
	public InputStream loadTestPlugin() {
		return this.getClass().getResourceAsStream("/sePlugin.xml");
	}
    
}
