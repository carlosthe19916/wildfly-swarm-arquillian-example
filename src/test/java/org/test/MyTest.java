package org.test;

import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.as.process.Main;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.wildfly.swarm.example.beans.MyService;
import org.wildfly.swarm.example.rest.HelloEndpoint;
import org.wildfly.swarm.example.rest.RestApplication;
import org.wildfly.swarm.spi.api.JARArchive;

import static org.junit.Assert.*;

@RunWith(Arquillian.class)
public class MyTest {

    @Inject
    private MyService service;

    @Test
    public void testMyComponent() {
      // Runs within the application, CDI injects MyComponent
    	service.getMessage();
    	assertTrue("This is a message from MyService".equals(service.getMessage()));
    }

    @Deployment
    public static Archive createDeployment() {
      JARArchive archive = ShrinkWrap.create( JARArchive.class );

      archive.addClass(Main.class);
      archive.addClass(MyService.class);
      archive.addClass(HelloEndpoint.class);
      archive.addClass(RestApplication.class);
      archive.addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");

      return archive;
    }
}
