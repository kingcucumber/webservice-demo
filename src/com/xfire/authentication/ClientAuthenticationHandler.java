package com.xfire.authentication;

import org.codehaus.xfire.MessageContext;
import org.codehaus.xfire.handler.AbstractHandler;
import org.jdom.Element;
import org.jdom.Namespace;

public class ClientAuthenticationHandler extends AbstractHandler {

	final Namespace ns = Namespace.getNamespace("http://www.test.com");
	private String username;
	private String password;
	
	public ClientAuthenticationHandler(){
		
	};
	public ClientAuthenticationHandler(String username,String password){
		this.username = username;
		this.password = password;
	}
	public void setUsername(String username){
		this.username = username;
	}
	public void setPassword(String password){
		this.password = password;
	}
	
	public void invoke(MessageContext context) throws Exception {
		// TODO Auto-generated method stub
		Element el = new Element("header",ns);
		context.getOutMessage().setHeader(el);
		Element auth = new Element("AuthenticationToken",ns);
		Element usernameElement  =new Element("username",ns);
		usernameElement.addContent(username);
		Element passwordElement = new Element("password",ns);
		passwordElement.addContent(password);
		auth.addContent(usernameElement);
		auth.addContent(passwordElement);
		
		el.addContent(auth);
		
	}

}
