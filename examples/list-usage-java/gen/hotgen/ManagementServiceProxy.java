/******************************************************************
 * Generated by Hottentot JAVA Generator
 * Date: 
 * Name: 
 * Description:
 *   
 ******************************************************************/
package ir.ntnaeem.hottentot.examples.listtest.hotgen;

import ir.ntnaeem.hottentot.runtime.Argument;
import ir.ntnaeem.hottentot.runtime.Proxy;
import ir.ntnaeem.hottentot.runtime.Request;
import ir.ntnaeem.hottentot.runtime.Response;
import ir.ntnaeem.hottentot.runtime.TcpClient;
import ir.ntnaeem.hottentot.runtime.exception.HottentotRuntimeException;
import ir.ntnaeem.hottentot.runtime.exception.TcpClientConnectException;
import ir.ntnaeem.hottentot.runtime.exception.TcpClientReadException;
import ir.ntnaeem.hottentot.runtime.exception.TcpClientWriteException;
import ir.ntnaeem.hottentot.runtime.exception.TcpClientCloseException;
import ir.ntnaeem.hottentot.runtime.factory.ProtocolFactory;
import ir.ntnaeem.hottentot.runtime.factory.TcpClientFactory;
import ir.ntnaeem.hottentot.runtime.protocol.Protocol;
import ir.ntnaeem.hottentot.serializerHelper.PDTSerializer;
import ir.ntnaeem.hottentot.serializerHelper.PDTDeserializer;
import ir.ntnaeem.hottentot.type.*;
import java.util.List;

public class ManagementServiceProxy extends AbstractManagementService implements Proxy {
	
  private String host;
  private int port;

  public ManagementServiceProxy(String host, int port) {
    this.host = host;
    this.port = port;
  }
  public boolean isCrawlerIdValid(long crawlerId) { 
    //serialize crawlerId
    _Int64 crawlerIdWrapper = new _Int64(crawlerId);
    byte[] serializedCrawlerId = crawlerIdWrapper.serialize();

    //make request
    Request request = new Request();
    request.setServiceId(795813994L);
    request.setMethodId(852340039L);
    request.setArgumentCount((byte) 1);
    request.setType(Request.RequestType.InvokeStateless);
    Argument arg0 = new Argument();
    arg0.setDataLength(serializedCrawlerId.length);
    arg0.setData(serializedCrawlerId);
    request.addArgument(arg0);
    int dataLength = 0;
    //calculate data length for every argument
    //calulate crawlerIdDataLength
    int crawlerIdDataLength= serializedCrawlerId.length;
    int crawlerIdDataLengthByteArrayLength = 1;
    if (crawlerIdDataLength >= 0x80) {
      if (crawlerIdDataLength <= 0xff) {
        //ex 0x81 0xff
        crawlerIdDataLengthByteArrayLength = 2;
      } else if (crawlerIdDataLength <= 0xffff) {
        //ex 0x82 0xff 0xff
        crawlerIdDataLengthByteArrayLength = 3;
      } else if (crawlerIdDataLength <= 0xffffff) {
        //ex 0x83 0xff 0xff 0xff
        crawlerIdDataLengthByteArrayLength = 4;
      }
    }
    dataLength += crawlerIdDataLength + crawlerIdDataLengthByteArrayLength;
    //arg count(1) + request type(1) + method ID(4) + service ID(4) = 10;
    request.setLength(10 + dataLength);
    //connect to server
    TcpClient tcpClient = TcpClientFactory.create();
    try{
      tcpClient.connect(host, port);
    } catch (TcpClientConnectException e) {
      throw new HottentotRuntimeException(e);
    }
    //serialize request according to HTNP
    Protocol protocol = ProtocolFactory.create();
    byte[] serializedRequest = protocol.serializeRequest(request);
    //send request
    try {
      tcpClient.write(serializedRequest);
    } catch (TcpClientWriteException e) {
      throw new HottentotRuntimeException(e);
    }
    //read response from server
    byte[] buffer = new byte[256];
    while (!protocol.isResponseComplete()) {
      byte[] dataChunkRead;
      try {
        dataChunkRead = tcpClient.read();
      } catch (TcpClientReadException e) {
        throw new HottentotRuntimeException(e);
      }
      protocol.processDataForResponse(dataChunkRead);
    }
    Response response = protocol.getResponse();
    //close everything
     try { 
       tcpClient.close(); 
    } catch (TcpClientCloseException e) { 
      e.printStackTrace(); 
    } 
    //deserialize boolpart from response
    if (response.getStatusCode() == -1) {
      //TODO
    }
    _Boolean ret = new _Boolean();
    ret.deserialize(response.getData());
    return ret.getValue();
  }
  public long startCrawler(Crawler crawler,String startURL,List<String> domainList) { 
    //serialize crawler
    byte[] serializedCrawler = crawler.serialize();
    //serialize startURL
    _String startURLWrapper = new _String(startURL);
    byte[] serializedStartURL = startURLWrapper.serialize();
    //serialize domainList
    SerializableStringList serializableStringList = new SerializableStringList();
serializableStringList.setStringList(domainList);
byte[] serializedDomainList = serializableStringList.serialize();

    //make request
    Request request = new Request();
    request.setServiceId(795813994L);
    request.setMethodId(732023276L);
    request.setArgumentCount((byte) 3);
    request.setType(Request.RequestType.InvokeStateless);
    Argument arg0 = new Argument();
    arg0.setDataLength(serializedCrawler.length);
    arg0.setData(serializedCrawler);
    request.addArgument(arg0);
    Argument arg1 = new Argument();
    arg1.setDataLength(serializedStartURL.length);
    arg1.setData(serializedStartURL);
    request.addArgument(arg1);
    Argument arg2 = new Argument();
    arg2.setDataLength(serializedDomainList.length);
    arg2.setData(serializedDomainList);
    request.addArgument(arg2);
    int dataLength = 0;
    //calculate data length for every argument
    //calulate crawlerDataLength
    int crawlerDataLength= serializedCrawler.length;
    int crawlerDataLengthByteArrayLength = 1;
    if (crawlerDataLength >= 0x80) {
      if (crawlerDataLength <= 0xff) {
        //ex 0x81 0xff
        crawlerDataLengthByteArrayLength = 2;
      } else if (crawlerDataLength <= 0xffff) {
        //ex 0x82 0xff 0xff
        crawlerDataLengthByteArrayLength = 3;
      } else if (crawlerDataLength <= 0xffffff) {
        //ex 0x83 0xff 0xff 0xff
        crawlerDataLengthByteArrayLength = 4;
      }
    }
    dataLength += crawlerDataLength + crawlerDataLengthByteArrayLength;
    //calulate startURLDataLength
    int startURLDataLength= serializedStartURL.length;
    int startURLDataLengthByteArrayLength = 1;
    if (startURLDataLength >= 0x80) {
      if (startURLDataLength <= 0xff) {
        //ex 0x81 0xff
        startURLDataLengthByteArrayLength = 2;
      } else if (startURLDataLength <= 0xffff) {
        //ex 0x82 0xff 0xff
        startURLDataLengthByteArrayLength = 3;
      } else if (startURLDataLength <= 0xffffff) {
        //ex 0x83 0xff 0xff 0xff
        startURLDataLengthByteArrayLength = 4;
      }
    }
    dataLength += startURLDataLength + startURLDataLengthByteArrayLength;
    //calulate domainListDataLength
    int domainListDataLength= serializedDomainList.length;
    int domainListDataLengthByteArrayLength = 1;
    if (domainListDataLength >= 0x80) {
      if (domainListDataLength <= 0xff) {
        //ex 0x81 0xff
        domainListDataLengthByteArrayLength = 2;
      } else if (domainListDataLength <= 0xffff) {
        //ex 0x82 0xff 0xff
        domainListDataLengthByteArrayLength = 3;
      } else if (domainListDataLength <= 0xffffff) {
        //ex 0x83 0xff 0xff 0xff
        domainListDataLengthByteArrayLength = 4;
      }
    }
    dataLength += domainListDataLength + domainListDataLengthByteArrayLength;
    //arg count(1) + request type(1) + method ID(4) + service ID(4) = 10;
    request.setLength(10 + dataLength);
    //connect to server
    TcpClient tcpClient = TcpClientFactory.create();
    try{
      tcpClient.connect(host, port);
    } catch (TcpClientConnectException e) {
      throw new HottentotRuntimeException(e);
    }
    //serialize request according to HTNP
    Protocol protocol = ProtocolFactory.create();
    byte[] serializedRequest = protocol.serializeRequest(request);
    //send request
    try {
      tcpClient.write(serializedRequest);
    } catch (TcpClientWriteException e) {
      throw new HottentotRuntimeException(e);
    }
    //read response from server
    byte[] buffer = new byte[256];
    while (!protocol.isResponseComplete()) {
      byte[] dataChunkRead;
      try {
        dataChunkRead = tcpClient.read();
      } catch (TcpClientReadException e) {
        throw new HottentotRuntimeException(e);
      }
      protocol.processDataForResponse(dataChunkRead);
    }
    Response response = protocol.getResponse();
    //close everything
     try { 
       tcpClient.close(); 
    } catch (TcpClientCloseException e) { 
      e.printStackTrace(); 
    } 
    //deserialize uint64part from response
    if (response.getStatusCode() == -1) {
      //TODO
    }
    _Int64 ret = new _Int64();
    ret.deserialize(response.getData());
    return ret.getValue();
  }
  public void stopCrawler(long crawlerId) { 
    //serialize crawlerId
    _Int64 crawlerIdWrapper = new _Int64(crawlerId);
    byte[] serializedCrawlerId = crawlerIdWrapper.serialize();

    //make request
    Request request = new Request();
    request.setServiceId(795813994L);
    request.setMethodId(1177595769L);
    request.setArgumentCount((byte) 1);
    request.setType(Request.RequestType.InvokeStateless);
    Argument arg0 = new Argument();
    arg0.setDataLength(serializedCrawlerId.length);
    arg0.setData(serializedCrawlerId);
    request.addArgument(arg0);
    int dataLength = 0;
    //calculate data length for every argument
    //calulate crawlerIdDataLength
    int crawlerIdDataLength= serializedCrawlerId.length;
    int crawlerIdDataLengthByteArrayLength = 1;
    if (crawlerIdDataLength >= 0x80) {
      if (crawlerIdDataLength <= 0xff) {
        //ex 0x81 0xff
        crawlerIdDataLengthByteArrayLength = 2;
      } else if (crawlerIdDataLength <= 0xffff) {
        //ex 0x82 0xff 0xff
        crawlerIdDataLengthByteArrayLength = 3;
      } else if (crawlerIdDataLength <= 0xffffff) {
        //ex 0x83 0xff 0xff 0xff
        crawlerIdDataLengthByteArrayLength = 4;
      }
    }
    dataLength += crawlerIdDataLength + crawlerIdDataLengthByteArrayLength;
    //arg count(1) + request type(1) + method ID(4) + service ID(4) = 10;
    request.setLength(10 + dataLength);
    //connect to server
    TcpClient tcpClient = TcpClientFactory.create();
    try{
      tcpClient.connect(host, port);
    } catch (TcpClientConnectException e) {
      throw new HottentotRuntimeException(e);
    }
    //serialize request according to HTNP
    Protocol protocol = ProtocolFactory.create();
    byte[] serializedRequest = protocol.serializeRequest(request);
    //send request
    try {
      tcpClient.write(serializedRequest);
    } catch (TcpClientWriteException e) {
      throw new HottentotRuntimeException(e);
    }
  }
  public void pauseCrawler(long crawlerId) { 
    //serialize crawlerId
    _Int64 crawlerIdWrapper = new _Int64(crawlerId);
    byte[] serializedCrawlerId = crawlerIdWrapper.serialize();

    //make request
    Request request = new Request();
    request.setServiceId(795813994L);
    request.setMethodId(1990011886L);
    request.setArgumentCount((byte) 1);
    request.setType(Request.RequestType.InvokeStateless);
    Argument arg0 = new Argument();
    arg0.setDataLength(serializedCrawlerId.length);
    arg0.setData(serializedCrawlerId);
    request.addArgument(arg0);
    int dataLength = 0;
    //calculate data length for every argument
    //calulate crawlerIdDataLength
    int crawlerIdDataLength= serializedCrawlerId.length;
    int crawlerIdDataLengthByteArrayLength = 1;
    if (crawlerIdDataLength >= 0x80) {
      if (crawlerIdDataLength <= 0xff) {
        //ex 0x81 0xff
        crawlerIdDataLengthByteArrayLength = 2;
      } else if (crawlerIdDataLength <= 0xffff) {
        //ex 0x82 0xff 0xff
        crawlerIdDataLengthByteArrayLength = 3;
      } else if (crawlerIdDataLength <= 0xffffff) {
        //ex 0x83 0xff 0xff 0xff
        crawlerIdDataLengthByteArrayLength = 4;
      }
    }
    dataLength += crawlerIdDataLength + crawlerIdDataLengthByteArrayLength;
    //arg count(1) + request type(1) + method ID(4) + service ID(4) = 10;
    request.setLength(10 + dataLength);
    //connect to server
    TcpClient tcpClient = TcpClientFactory.create();
    try{
      tcpClient.connect(host, port);
    } catch (TcpClientConnectException e) {
      throw new HottentotRuntimeException(e);
    }
    //serialize request according to HTNP
    Protocol protocol = ProtocolFactory.create();
    byte[] serializedRequest = protocol.serializeRequest(request);
    //send request
    try {
      tcpClient.write(serializedRequest);
    } catch (TcpClientWriteException e) {
      throw new HottentotRuntimeException(e);
    }
  }
  public void resumeCrawler(long crawlerId) { 
    //serialize crawlerId
    _Int64 crawlerIdWrapper = new _Int64(crawlerId);
    byte[] serializedCrawlerId = crawlerIdWrapper.serialize();

    //make request
    Request request = new Request();
    request.setServiceId(795813994L);
    request.setMethodId(1151769776L);
    request.setArgumentCount((byte) 1);
    request.setType(Request.RequestType.InvokeStateless);
    Argument arg0 = new Argument();
    arg0.setDataLength(serializedCrawlerId.length);
    arg0.setData(serializedCrawlerId);
    request.addArgument(arg0);
    int dataLength = 0;
    //calculate data length for every argument
    //calulate crawlerIdDataLength
    int crawlerIdDataLength= serializedCrawlerId.length;
    int crawlerIdDataLengthByteArrayLength = 1;
    if (crawlerIdDataLength >= 0x80) {
      if (crawlerIdDataLength <= 0xff) {
        //ex 0x81 0xff
        crawlerIdDataLengthByteArrayLength = 2;
      } else if (crawlerIdDataLength <= 0xffff) {
        //ex 0x82 0xff 0xff
        crawlerIdDataLengthByteArrayLength = 3;
      } else if (crawlerIdDataLength <= 0xffffff) {
        //ex 0x83 0xff 0xff 0xff
        crawlerIdDataLengthByteArrayLength = 4;
      }
    }
    dataLength += crawlerIdDataLength + crawlerIdDataLengthByteArrayLength;
    //arg count(1) + request type(1) + method ID(4) + service ID(4) = 10;
    request.setLength(10 + dataLength);
    //connect to server
    TcpClient tcpClient = TcpClientFactory.create();
    try{
      tcpClient.connect(host, port);
    } catch (TcpClientConnectException e) {
      throw new HottentotRuntimeException(e);
    }
    //serialize request according to HTNP
    Protocol protocol = ProtocolFactory.create();
    byte[] serializedRequest = protocol.serializeRequest(request);
    //send request
    try {
      tcpClient.write(serializedRequest);
    } catch (TcpClientWriteException e) {
      throw new HottentotRuntimeException(e);
    }
  }
  public List<Crawler> getCrawlers() { 

    //make request
    Request request = new Request();
    request.setServiceId(795813994L);
    request.setMethodId(2298290131L);
    request.setArgumentCount((byte) 0);
    request.setType(Request.RequestType.InvokeStateless);
    int dataLength = 0;
    //calculate data length for every argument
    //arg count(1) + request type(1) + method ID(4) + service ID(4) = 10;
    request.setLength(10 + dataLength);
    //connect to server
    TcpClient tcpClient = TcpClientFactory.create();
    try{
      tcpClient.connect(host, port);
    } catch (TcpClientConnectException e) {
      throw new HottentotRuntimeException(e);
    }
    //serialize request according to HTNP
    Protocol protocol = ProtocolFactory.create();
    byte[] serializedRequest = protocol.serializeRequest(request);
    //send request
    try {
      tcpClient.write(serializedRequest);
    } catch (TcpClientWriteException e) {
      throw new HottentotRuntimeException(e);
    }
    //read response from server
    byte[] buffer = new byte[256];
    while (!protocol.isResponseComplete()) {
      byte[] dataChunkRead;
      try {
        dataChunkRead = tcpClient.read();
      } catch (TcpClientReadException e) {
        throw new HottentotRuntimeException(e);
      }
      protocol.processDataForResponse(dataChunkRead);
    }
    Response response = protocol.getResponse();
    //close everything
     try { 
       tcpClient.close(); 
    } catch (TcpClientCloseException e) { 
      e.printStackTrace(); 
    } 
    //deserialize list<Crawler>part from response
    SerializableCrawlerList serializableCrawlerList = null;
    if (response.getStatusCode() == -1) {
      //TODO
    }
    serializableCrawlerList = new SerializableCrawlerList();
    serializableCrawlerList.deserialize(response.getData());
    return serializableCrawlerList.getCrawlerList();
  }
  public Crawler getCrawlerById(long crawlerId) { 
    //serialize crawlerId
    _Int64 crawlerIdWrapper = new _Int64(crawlerId);
    byte[] serializedCrawlerId = crawlerIdWrapper.serialize();

    //make request
    Request request = new Request();
    request.setServiceId(795813994L);
    request.setMethodId(3219824823L);
    request.setArgumentCount((byte) 1);
    request.setType(Request.RequestType.InvokeStateless);
    Argument arg0 = new Argument();
    arg0.setDataLength(serializedCrawlerId.length);
    arg0.setData(serializedCrawlerId);
    request.addArgument(arg0);
    int dataLength = 0;
    //calculate data length for every argument
    //calulate crawlerIdDataLength
    int crawlerIdDataLength= serializedCrawlerId.length;
    int crawlerIdDataLengthByteArrayLength = 1;
    if (crawlerIdDataLength >= 0x80) {
      if (crawlerIdDataLength <= 0xff) {
        //ex 0x81 0xff
        crawlerIdDataLengthByteArrayLength = 2;
      } else if (crawlerIdDataLength <= 0xffff) {
        //ex 0x82 0xff 0xff
        crawlerIdDataLengthByteArrayLength = 3;
      } else if (crawlerIdDataLength <= 0xffffff) {
        //ex 0x83 0xff 0xff 0xff
        crawlerIdDataLengthByteArrayLength = 4;
      }
    }
    dataLength += crawlerIdDataLength + crawlerIdDataLengthByteArrayLength;
    //arg count(1) + request type(1) + method ID(4) + service ID(4) = 10;
    request.setLength(10 + dataLength);
    //connect to server
    TcpClient tcpClient = TcpClientFactory.create();
    try{
      tcpClient.connect(host, port);
    } catch (TcpClientConnectException e) {
      throw new HottentotRuntimeException(e);
    }
    //serialize request according to HTNP
    Protocol protocol = ProtocolFactory.create();
    byte[] serializedRequest = protocol.serializeRequest(request);
    //send request
    try {
      tcpClient.write(serializedRequest);
    } catch (TcpClientWriteException e) {
      throw new HottentotRuntimeException(e);
    }
    //read response from server
    byte[] buffer = new byte[256];
    while (!protocol.isResponseComplete()) {
      byte[] dataChunkRead;
      try {
        dataChunkRead = tcpClient.read();
      } catch (TcpClientReadException e) {
        throw new HottentotRuntimeException(e);
      }
      protocol.processDataForResponse(dataChunkRead);
    }
    Response response = protocol.getResponse();
    //close everything
     try { 
       tcpClient.close(); 
    } catch (TcpClientCloseException e) { 
      e.printStackTrace(); 
    } 
    //deserialize Crawlerpart from response
    Crawler crawler= null;
    if (response.getStatusCode() == -1) {
      //TODO
    }
    crawler= new Crawler();
    crawler.deserialize(response.getData());
    return crawler;
  }
  public String getStartURL(long crawlerId) { 
    //serialize crawlerId
    _Int64 crawlerIdWrapper = new _Int64(crawlerId);
    byte[] serializedCrawlerId = crawlerIdWrapper.serialize();

    //make request
    Request request = new Request();
    request.setServiceId(795813994L);
    request.setMethodId(2137106771L);
    request.setArgumentCount((byte) 1);
    request.setType(Request.RequestType.InvokeStateless);
    Argument arg0 = new Argument();
    arg0.setDataLength(serializedCrawlerId.length);
    arg0.setData(serializedCrawlerId);
    request.addArgument(arg0);
    int dataLength = 0;
    //calculate data length for every argument
    //calulate crawlerIdDataLength
    int crawlerIdDataLength= serializedCrawlerId.length;
    int crawlerIdDataLengthByteArrayLength = 1;
    if (crawlerIdDataLength >= 0x80) {
      if (crawlerIdDataLength <= 0xff) {
        //ex 0x81 0xff
        crawlerIdDataLengthByteArrayLength = 2;
      } else if (crawlerIdDataLength <= 0xffff) {
        //ex 0x82 0xff 0xff
        crawlerIdDataLengthByteArrayLength = 3;
      } else if (crawlerIdDataLength <= 0xffffff) {
        //ex 0x83 0xff 0xff 0xff
        crawlerIdDataLengthByteArrayLength = 4;
      }
    }
    dataLength += crawlerIdDataLength + crawlerIdDataLengthByteArrayLength;
    //arg count(1) + request type(1) + method ID(4) + service ID(4) = 10;
    request.setLength(10 + dataLength);
    //connect to server
    TcpClient tcpClient = TcpClientFactory.create();
    try{
      tcpClient.connect(host, port);
    } catch (TcpClientConnectException e) {
      throw new HottentotRuntimeException(e);
    }
    //serialize request according to HTNP
    Protocol protocol = ProtocolFactory.create();
    byte[] serializedRequest = protocol.serializeRequest(request);
    //send request
    try {
      tcpClient.write(serializedRequest);
    } catch (TcpClientWriteException e) {
      throw new HottentotRuntimeException(e);
    }
    //read response from server
    byte[] buffer = new byte[256];
    while (!protocol.isResponseComplete()) {
      byte[] dataChunkRead;
      try {
        dataChunkRead = tcpClient.read();
      } catch (TcpClientReadException e) {
        throw new HottentotRuntimeException(e);
      }
      protocol.processDataForResponse(dataChunkRead);
    }
    Response response = protocol.getResponse();
    //close everything
     try { 
       tcpClient.close(); 
    } catch (TcpClientCloseException e) { 
      e.printStackTrace(); 
    } 
    //deserialize stringpart from response
    if (response.getStatusCode() == -1) {
      //TODO
    }
    _String ret = new _String();
    ret.deserialize(response.getData());
    return ret.getValue();
  }
  public List<String> getDomainList(long crawlerId) { 
    //serialize crawlerId
    _Int64 crawlerIdWrapper = new _Int64(crawlerId);
    byte[] serializedCrawlerId = crawlerIdWrapper.serialize();

    //make request
    Request request = new Request();
    request.setServiceId(795813994L);
    request.setMethodId(1975619138L);
    request.setArgumentCount((byte) 1);
    request.setType(Request.RequestType.InvokeStateless);
    Argument arg0 = new Argument();
    arg0.setDataLength(serializedCrawlerId.length);
    arg0.setData(serializedCrawlerId);
    request.addArgument(arg0);
    int dataLength = 0;
    //calculate data length for every argument
    //calulate crawlerIdDataLength
    int crawlerIdDataLength= serializedCrawlerId.length;
    int crawlerIdDataLengthByteArrayLength = 1;
    if (crawlerIdDataLength >= 0x80) {
      if (crawlerIdDataLength <= 0xff) {
        //ex 0x81 0xff
        crawlerIdDataLengthByteArrayLength = 2;
      } else if (crawlerIdDataLength <= 0xffff) {
        //ex 0x82 0xff 0xff
        crawlerIdDataLengthByteArrayLength = 3;
      } else if (crawlerIdDataLength <= 0xffffff) {
        //ex 0x83 0xff 0xff 0xff
        crawlerIdDataLengthByteArrayLength = 4;
      }
    }
    dataLength += crawlerIdDataLength + crawlerIdDataLengthByteArrayLength;
    //arg count(1) + request type(1) + method ID(4) + service ID(4) = 10;
    request.setLength(10 + dataLength);
    //connect to server
    TcpClient tcpClient = TcpClientFactory.create();
    try{
      tcpClient.connect(host, port);
    } catch (TcpClientConnectException e) {
      throw new HottentotRuntimeException(e);
    }
    //serialize request according to HTNP
    Protocol protocol = ProtocolFactory.create();
    byte[] serializedRequest = protocol.serializeRequest(request);
    //send request
    try {
      tcpClient.write(serializedRequest);
    } catch (TcpClientWriteException e) {
      throw new HottentotRuntimeException(e);
    }
    //read response from server
    byte[] buffer = new byte[256];
    while (!protocol.isResponseComplete()) {
      byte[] dataChunkRead;
      try {
        dataChunkRead = tcpClient.read();
      } catch (TcpClientReadException e) {
        throw new HottentotRuntimeException(e);
      }
      protocol.processDataForResponse(dataChunkRead);
    }
    Response response = protocol.getResponse();
    //close everything
     try { 
       tcpClient.close(); 
    } catch (TcpClientCloseException e) { 
      e.printStackTrace(); 
    } 
    //deserialize list<string>part from response
    SerializableStringList serializableStringList = null;
    if (response.getStatusCode() == -1) {
      //TODO
    }
    serializableStringList = new SerializableStringList();
    serializableStringList.deserialize(response.getData());
    return serializableStringList.getStringList();
  }

  public void destroy() {
    //TODO
  }
}
