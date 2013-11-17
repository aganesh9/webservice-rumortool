/**
 * GetStatusServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.anjana;

public class GetStatusServiceLocator extends org.apache.axis.client.Service implements org.anjana.GetStatusService {

    public GetStatusServiceLocator() {
    }


    public GetStatusServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public GetStatusServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for GetStatus
    private java.lang.String GetStatus_address = "http://localhost:8080/GetStatusOfNews/services/GetStatus";

    public java.lang.String getGetStatusAddress() {
        return GetStatus_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String GetStatusWSDDServiceName = "GetStatus";

    public java.lang.String getGetStatusWSDDServiceName() {
        return GetStatusWSDDServiceName;
    }

    public void setGetStatusWSDDServiceName(java.lang.String name) {
        GetStatusWSDDServiceName = name;
    }

    public org.anjana.GetStatus getGetStatus() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(GetStatus_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getGetStatus(endpoint);
    }

    public org.anjana.GetStatus getGetStatus(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            org.anjana.GetStatusSoapBindingStub _stub = new org.anjana.GetStatusSoapBindingStub(portAddress, this);
            _stub.setPortName(getGetStatusWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setGetStatusEndpointAddress(java.lang.String address) {
        GetStatus_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (org.anjana.GetStatus.class.isAssignableFrom(serviceEndpointInterface)) {
                org.anjana.GetStatusSoapBindingStub _stub = new org.anjana.GetStatusSoapBindingStub(new java.net.URL(GetStatus_address), this);
                _stub.setPortName(getGetStatusWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("GetStatus".equals(inputPortName)) {
            return getGetStatus();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://anjana.org", "GetStatusService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://anjana.org", "GetStatus"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("GetStatus".equals(portName)) {
            setGetStatusEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
