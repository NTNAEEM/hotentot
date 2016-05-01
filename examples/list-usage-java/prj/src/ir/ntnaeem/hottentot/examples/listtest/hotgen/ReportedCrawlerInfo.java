/******************************************************************
 * Generated by Hottentot JAVA Generator
 * Date: 
 * Name: 
 * Description:
 *   This file contains definition of an abstract service class.
 ******************************************************************/
package ir.ntnaeem.hottentot.examples.listtest.hotgen;

import ir.ntnaeem.hottentot.serializerHelper.PDTSerializer;
import ir.ntnaeem.hottentot.serializerHelper.PDTDeserializer;
import ir.ntnaeem.hottentot.serializerHelper.ByteArrayToInteger;
import java.util.List;
import java.util.ArrayList;

public class ReportedCrawlerInfo {
  private byte status;
  private long startTs;
  private List<String> crawledDomains = new ArrayList<String>();
  private List<String> crawledUrls = new ArrayList<String>();
  private List<String> failedUrls = new ArrayList<String>();
  public void setStatus(byte status) {
    this.status = status;
  }
  public byte getStatus() {
    return status;
  }
  public void setStartTs(long startTs) {
    this.startTs = startTs;
  }
  public long getStartTs() {
    return startTs;
  }
  public void setCrawledDomains(List<String> crawledDomains) {
    this.crawledDomains = crawledDomains;
  }
  public List<String> getCrawledDomains() {
    return crawledDomains;
  }
  public void setCrawledUrls(List<String> crawledUrls) {
    this.crawledUrls = crawledUrls;
  }
  public List<String> getCrawledUrls() {
    return crawledUrls;
  }
  public void setFailedUrls(List<String> failedUrls) {
    this.failedUrls = failedUrls;
  }
  public List<String> getFailedUrls() {
    return failedUrls;
  }
  @Override 
  public String toString() { 
    return "ReportedCrawlerInfo{" + 
      "status = '" + status + '\'' + 
      ",startTs = '" + startTs + '\'' + 
      ",crawledDomains = '" + crawledDomains + '\'' + 
      ",crawledUrls = '" + crawledUrls + '\'' + 
      ",failedUrls = '" + failedUrls + '\'' + 
      "}"; 
  }
	
  public byte[] serialize() {
    byte[] serializedStatus = PDTSerializer.getInt8(status);
    byte[] serializedStartTs = PDTSerializer.getInt64(startTs);
    SerializableStringList serializableStringList3 = new SerializableStringList();
    serializableStringList3.setStringList(crawledDomains);
    byte[] serializedCrawledDomains  = serializableStringList3.serializeWithLength();
    SerializableStringList serializableStringList4 = new SerializableStringList();
    serializableStringList4.setStringList(crawledUrls);
    byte[] serializedCrawledUrls  = serializableStringList4.serializeWithLength();
    SerializableStringList serializableStringList5 = new SerializableStringList();
    serializableStringList5.setStringList(failedUrls);
    byte[] serializedFailedUrls  = serializableStringList5.serializeWithLength();
    byte[] output = new byte[serializedStatus.length + serializedStartTs.length + serializedCrawledDomains.length + serializedCrawledUrls.length + serializedFailedUrls.length];
    int counter = 0;
    //use a loop for every property
    for (int i = 0; i < serializedStatus.length; i++) {
      output[counter++] = serializedStatus[i];
    }
    for (int i = 0; i < serializedStartTs.length; i++) {
      output[counter++] = serializedStartTs[i];
    }
    for (int i = 0; i < serializedCrawledDomains.length; i++) {
      output[counter++] = serializedCrawledDomains[i];
    }
    for (int i = 0; i < serializedCrawledUrls.length; i++) {
      output[counter++] = serializedCrawledUrls[i];
    }
    for (int i = 0; i < serializedFailedUrls.length; i++) {
      output[counter++] = serializedFailedUrls[i];
    }
    return output;
  }
    
  public void deserialize(byte[] serializedByteArray) {
    if(serializedByteArray.length != 0){
      int counter = 0;
      int dataLength = 0;
      int numbersOfBytesForDataLength;
      //do for every property
    //status : byte
    byte[] statusByteArray = new byte[1];
    for(int i = 0 ; i < 1 ; i++){
      statusByteArray[i] = serializedByteArray[counter++];
    }
    setStatus(PDTDeserializer.getInt8(statusByteArray));
    //startTs : long
    byte[] startTsByteArray = new byte[8];
    for(int i = 0 ; i < 8 ; i++){
      startTsByteArray[i] = serializedByteArray[counter++];
    }
    setStartTs(PDTDeserializer.getInt64(startTsByteArray));
    //crawledDomains : List<String>
    dataLength = 0;
    if(( serializedByteArray[counter] & 0x80) == 0 ) {
      dataLength = serializedByteArray[counter++];
    }else{
      numbersOfBytesForDataLength = serializedByteArray[counter++] & 0x0f;
      byte[] serializedByteArrayLength = new byte[numbersOfBytesForDataLength];
      for(byte i = 0 ; i < numbersOfBytesForDataLength ; i++){
        serializedByteArrayLength[i] = serializedByteArray[counter++];
      }
      dataLength = ByteArrayToInteger.getInt(serializedByteArrayLength);
    }
    byte[] crawledDomainsByteArray = new byte[dataLength];
    System.arraycopy(serializedByteArray,counter,crawledDomainsByteArray,0,dataLength);
    counter += dataLength;
    SerializableStringList serializableStringList1 = new SerializableStringList();
    serializableStringList1.deserialize(crawledDomainsByteArray);
    setCrawledDomains(serializableStringList1.getStringList());
    //crawledUrls : List<String>
    dataLength = 0;
    if(( serializedByteArray[counter] & 0x80) == 0 ) {
      dataLength = serializedByteArray[counter++];
    }else{
      numbersOfBytesForDataLength = serializedByteArray[counter++] & 0x0f;
      byte[] serializedByteArrayLength = new byte[numbersOfBytesForDataLength];
      for(byte i = 0 ; i < numbersOfBytesForDataLength ; i++){
        serializedByteArrayLength[i] = serializedByteArray[counter++];
      }
      dataLength = ByteArrayToInteger.getInt(serializedByteArrayLength);
    }
    byte[] crawledUrlsByteArray = new byte[dataLength];
    System.arraycopy(serializedByteArray,counter,crawledUrlsByteArray,0,dataLength);
    counter += dataLength;
    SerializableStringList serializableStringList2 = new SerializableStringList();
    serializableStringList2.deserialize(crawledUrlsByteArray);
    setCrawledUrls(serializableStringList2.getStringList());
    //failedUrls : List<String>
    dataLength = 0;
    if(( serializedByteArray[counter] & 0x80) == 0 ) {
      dataLength = serializedByteArray[counter++];
    }else{
      numbersOfBytesForDataLength = serializedByteArray[counter++] & 0x0f;
      byte[] serializedByteArrayLength = new byte[numbersOfBytesForDataLength];
      for(byte i = 0 ; i < numbersOfBytesForDataLength ; i++){
        serializedByteArrayLength[i] = serializedByteArray[counter++];
      }
      dataLength = ByteArrayToInteger.getInt(serializedByteArrayLength);
    }
    byte[] failedUrlsByteArray = new byte[dataLength];
    System.arraycopy(serializedByteArray,counter,failedUrlsByteArray,0,dataLength);
    counter += dataLength;
    SerializableStringList serializableStringList3 = new SerializableStringList();
    serializableStringList3.deserialize(failedUrlsByteArray);
    setFailedUrls(serializableStringList3.getStringList());

    }
  }
}
