/******************************************************************
 * Generated by Hottentot JAVA Generator
 * Date: 
 * Name: 
 * Description:
 *   
 ******************************************************************/
package ir.ntnaeem.hottentot.examples.listtest.hotgen;

import ir.ntnaeem.hottentot.runtime.RequestHandler;

public abstract class AbstractManagementService implements ManagementService {	
  public RequestHandler makeRequestHandler() {
    return new ManagementRequestHandler(this);
  }
  public long getServiceId() {
    return 795813994L;
  }
}
