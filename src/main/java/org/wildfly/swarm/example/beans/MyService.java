package org.wildfly.swarm.example.beans;

import javax.enterprise.context.ApplicationScoped;
import java.io.Serializable;

@ApplicationScoped
public class MyService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public String getMessage() {
		return "This is a message from MyService";
	}
}