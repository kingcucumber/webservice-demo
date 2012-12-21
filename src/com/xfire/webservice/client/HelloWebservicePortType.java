
package com.xfire.webservice.client;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService(name = "HelloWebservicePortType", targetNamespace = "http://webservice.xfire.com")
@SOAPBinding(use = SOAPBinding.Use.LITERAL, parameterStyle = SOAPBinding.ParameterStyle.WRAPPED)
public interface HelloWebservicePortType {

	@WebMethod(operationName = "sayHello", action = "")
	@WebResult(name = "out", targetNamespace = "http://webservice.xfire.com")
	public String sayHello(
			@WebParam(name = "in0", targetNamespace = "http://webservice.xfire.com") String in0);

}
