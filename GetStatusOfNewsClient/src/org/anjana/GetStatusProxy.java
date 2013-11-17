package org.anjana;

public class GetStatusProxy implements org.anjana.GetStatus {
  private String _endpoint = null;
  private org.anjana.GetStatus getStatus = null;
  
  public GetStatusProxy() {
    _initGetStatusProxy();
  }
  
  public GetStatusProxy(String endpoint) {
    _endpoint = endpoint;
    _initGetStatusProxy();
  }
  
  private void _initGetStatusProxy() {
    try {
      getStatus = (new org.anjana.GetStatusServiceLocator()).getGetStatus();
      if (getStatus != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)getStatus)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)getStatus)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (getStatus != null)
      ((javax.xml.rpc.Stub)getStatus)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public org.anjana.GetStatus getGetStatus() {
    if (getStatus == null)
      _initGetStatusProxy();
    return getStatus;
  }
  
  public void main(java.lang.String[] args) throws java.rmi.RemoteException{
    if (getStatus == null)
      _initGetStatusProxy();
    getStatus.main(args);
  }
  
  public java.lang.String getNewsStatus(java.lang.String content) throws java.rmi.RemoteException{
    if (getStatus == null)
      _initGetStatusProxy();
    return getStatus.getNewsStatus(content);
  }
  
  
}