/******************************************************************
 * Generated by Hottentot JAVA Generator
 * Date:
 * Name:
 * Description:
 ******************************************************************/
package client;

import example.generated.AuthenticationService;
import example.generated.AuthenticationServiceProxyBuilder;
import example.generated.StringWrapper;

import ir.ntnaeem.hottentot.runtime.exception.MainArgsNotCorrectException;

import java.io.IOException;
import java.util.List;

public class Main {
  public static void main(String[] args) throws IOException, InterruptedException {
    ir.ntnaeem.hottentot.runtime.config.Config.setMainArgs(args);
    final AuthenticationService proxy = AuthenticationServiceProxyBuilder.create("127.0.0.1", 2000);
    //

    //    List<StringWrapper> stringWrapperList = new ArrayList<StringWrapper>();
//    StringWrapper stringWrapper = new StringWrapper();
//    String str = "";
//    for(int i = 0 ; i < 1000 ; i++) {
//      str += "a";
//    }
//    stringWrapper.setValue(str);
//    //
//    StringWrapper stringWrapper2 = new StringWrapper();
//    String str2 = "";
//    for(int i = 0 ; i < 10000 ; i++) {
//      str2 += "a";
//    }
//    stringWrapper2.setValue(str2);
//    //
//    stringWrapperList.add(stringWrapper);
//    stringWrapperList.add(stringWrapper2);
//    DataWrapper dataWrapper = proxy.test5(stringWrapperList);
//    System.out.println(" res : " + Arrays.toString(dataWrapper.getDigi()));
//    Result result = proxy.test7();
//    System.out.println("status 8 : " + result.getStatus8());
//    System.out.println("status 16 : " + result.getStatus16());
//    System.out.println("status 32 : " + result.getStatus32());
//    System.out.println("status 64 : " + result.getStatus64());
////    //
//    System.out.println("ustatus 8 : " + result.getUstatus8());
//    System.out.println("ustatus 16 : " + result.getUstatus16());
//    System.out.println("ustatus 32 : " + result.getUstatus32());
//    System.out.println("ustatus 64 : " + result.getUstatus64());
//
//    //
//    Credential credential = new Credential();
//    credential.setUsername("a");
//    String pass = "";
//    for(int i = 0 ; i < 1000 ; i++){
//      pass += "a";
//    }
//    credential.setPassword("a");
//    List<Token> tokenList = proxy.auth(credential);
//    System.out.println("token id : " + tokenList.get(0).getId());
//    //
//    List<DataWrapper> wrapperList = proxy.test();
//    System.out.println(" 0 size : " + wrapperList.get(0).getDigi().length);
//    System.out.println(" 0 digi : " + Arrays.toString(wrapperList.get(0).getDigi()));
//    System.out.println(" 0 value  : " + wrapperList.get(0).getValue());
//    System.out.println(" 1 size : " + wrapperList.get(1).getDigi().length);
//    System.out.println(" 1 value : " + wrapperList.get(1).getValue());
////    //
    while(true) {
      Thread.sleep(3000);
      List<StringWrapper> stringWrapperList2 = proxy.test2();
      System.out.println("TEST2 stringWrapperList2 size : " + stringWrapperList2.size());
      System.out.println("TEST2 stringWrapperList2 : " + stringWrapperList2);
    }

//////    //
//    StringWrapper stringWrapper3 = proxy.test3();
//    System.out.println("TEST 3 stringWrapper size : " + stringWrapper3.getValue().length());
////    //
//    DataWrapper dataWrapper4 = proxy.test4();
//    System.out.println("TEST4 dataWrapper size : " + dataWrapper4.getDigi().length);
//    System.out.println("TEST4 dataWrapper size : " + Arrays.toString(dataWrapper4.getDigi()));

//    List<DataWrapper> dataWrapperList = new ArrayList<DataWrapper>();
//    DataWrapper dr = new DataWrapper();
//    dr.setDigi(new byte[]{1});
//    dataWrapperList.add(dr);
//    DataWrapper dataWrapper1 = proxy.test6(dataWrapperList);
//    System.out.println("TEST6 : " + dataWrapper1);
    //

  }
}