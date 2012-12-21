
package com.xfire.webservice.client;

import java.net.MalformedURLException;
import java.util.Collection;
import java.util.HashMap;
import javax.xml.namespace.QName;

import org.codehaus.xfire.XFireFactory;
import org.codehaus.xfire.XFireRuntimeException;
import org.codehaus.xfire.aegis.AegisBindingProvider;
import org.codehaus.xfire.annotations.AnnotationServiceFactory;
import org.codehaus.xfire.annotations.jsr181.Jsr181WebAnnotations;
import org.codehaus.xfire.client.Client;
import org.codehaus.xfire.client.XFireProxyFactory;
import org.codehaus.xfire.jaxb2.JaxbTypeRegistry;
import org.codehaus.xfire.service.Endpoint;
import org.codehaus.xfire.service.Service;
import org.codehaus.xfire.service.binding.ObjectServiceFactory;
import org.codehaus.xfire.soap.AbstractSoapBinding;
import org.codehaus.xfire.transport.TransportManager;

import com.xfire.authentication.ClientAuthenticationHandler;
import com.xfire.webservice.IHelloWebservice;

public class HelloWebserviceClient {

    private static XFireProxyFactory proxyFactory = new XFireProxyFactory();
    private HashMap endpoints = new HashMap();
    private Service service0;

    public HelloWebserviceClient() {
        create0();
        Endpoint HelloWebserviceHttpPortEP = service0 .addEndpoint(new QName("http://webservice.xfire.com", "HelloWebserviceHttpPort"), new QName("http://webservice.xfire.com", "HelloWebserviceHttpBinding"), "http://localhost:8080/EJBClient/services/HelloWebservice");
        endpoints.put(new QName("http://webservice.xfire.com", "HelloWebserviceHttpPort"), HelloWebserviceHttpPortEP);
        Endpoint HelloWebservicePortTypeLocalEndpointEP = service0 .addEndpoint(new QName("http://webservice.xfire.com", "HelloWebservicePortTypeLocalEndpoint"), new QName("http://webservice.xfire.com", "HelloWebservicePortTypeLocalBinding"), "xfire.local://HelloWebservice");
        endpoints.put(new QName("http://webservice.xfire.com", "HelloWebservicePortTypeLocalEndpoint"), HelloWebservicePortTypeLocalEndpointEP);
    }

    public Object getEndpoint(Endpoint endpoint) {
        try {
            return proxyFactory.create((endpoint).getBinding(), (endpoint).getUrl());
        } catch (MalformedURLException e) {
            throw new XFireRuntimeException("Invalid URL", e);
        }
    }

    public Object getEndpoint(QName name) {
        Endpoint endpoint = ((Endpoint) endpoints.get((name)));
        if ((endpoint) == null) {
            throw new IllegalStateException("No such endpoint!");
        }
        return getEndpoint((endpoint));
    }

    public Collection getEndpoints() {
        return endpoints.values();
    }

    private void create0() {
        TransportManager tm = (org.codehaus.xfire.XFireFactory.newInstance().getXFire().getTransportManager());
        HashMap props = new HashMap();
        props.put("annotations.allow.interface", true);
        AnnotationServiceFactory asf = new AnnotationServiceFactory(new Jsr181WebAnnotations(), tm, new AegisBindingProvider(new JaxbTypeRegistry()));
        asf.setBindingCreationEnabled(false);
        service0 = asf.create((com.xfire.webservice.client.HelloWebservicePortType.class), props);
        {
            AbstractSoapBinding soapBinding = asf.createSoap11Binding(service0, new QName("http://webservice.xfire.com", "HelloWebservicePortTypeLocalBinding"), "urn:xfire:transport:local");
        }
        {
            AbstractSoapBinding soapBinding = asf.createSoap11Binding(service0, new QName("http://webservice.xfire.com", "HelloWebserviceHttpBinding"), "http://schemas.xmlsoap.org/soap/http");
        }
    }

    public HelloWebservicePortType getHelloWebserviceHttpPort() {
        return ((HelloWebservicePortType)(this).getEndpoint(new QName("http://webservice.xfire.com", "HelloWebserviceHttpPort")));
    }

    public HelloWebservicePortType getHelloWebserviceHttpPort(String url) {
        HelloWebservicePortType var = getHelloWebserviceHttpPort();
        org.codehaus.xfire.client.Client.getInstance(var).setUrl(url);
        return var;
    }

    public HelloWebservicePortType getHelloWebservicePortTypeLocalEndpoint() {
        return ((HelloWebservicePortType)(this).getEndpoint(new QName("http://webservice.xfire.com", "HelloWebservicePortTypeLocalEndpoint")));
    }

    public HelloWebservicePortType getHelloWebservicePortTypeLocalEndpoint(String url) {
        HelloWebservicePortType var = getHelloWebservicePortTypeLocalEndpoint();
        org.codehaus.xfire.client.Client.getInstance(var).setUrl(url);
        return var;
    }

    public static void main(String[] args) {
        

        HelloWebserviceClient client = new HelloWebserviceClient();
        
		//create a default service endpoint
        HelloWebservicePortType service = client.getHelloWebserviceHttpPort();
        
        Service srvcModel = new ObjectServiceFactory().create(IHelloWebservice.class);
        XFireProxyFactory factory = new XFireProxyFactory(XFireFactory.newInstance().getXFire());
        service = factory.create(srvcModel,serviceURL);
        
        Client cl = Client.getInstance(service);
        cl.addOutHandler(new ClientAuthenticationHandler("admin","123"));
        
		//TODO: Add custom client code here
        		//
        		//service.yourServiceOperationHere();
        System.out.println(service.sayHello("web service!"));
		System.out.println("test client completed");
        		System.exit(0);
    }

}
