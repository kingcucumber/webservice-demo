package com.xfire.authentication;

import org.codehaus.xfire.MessageContext;
import org.codehaus.xfire.fault.XFireFault;
import org.codehaus.xfire.handler.AbstractHandler;
import org.jdom.Element;
import org.jdom.Namespace;

public class AuthenticationHandler extends AbstractHandler {

	private final static Namespace ns= Namespace.getNamespace("http://www.test.com");
	
	public void invoke(MessageContext context) throws Exception {
		// TODO Auto-generated method stub
		if(context.getInMessage().getHeader() == null){
			throw new XFireFault("请求必须包含身份验证信息",XFireFault.SENDER);
		}
		
		Element token = context.getInMessage().getHeader().getChild("AuthenticationToken",ns);
		if(token == null){
			throw new XFireFault("请求必须包含身份验证信息",XFireFault.SENDER);
		}
		
		String username = token.getChild("username",ns).getValue();
		String password = token.getChild("password").getValue();
		if(!username.equals("admin") || !password.equals("123"))
			throw new XFireFault("非法用户名和密码",XFireFault.SENDER);
		
		context.setProperty("username", username);
		
	}

}
