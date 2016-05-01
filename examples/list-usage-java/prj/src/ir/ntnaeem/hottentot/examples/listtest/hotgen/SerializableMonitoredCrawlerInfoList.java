/******************************************************************
 * Generated by Hottentot JAVA Generator
 * Date:
 * Name:
 * Description:
 ******************************************************************/
package ir.ntnaeem.hottentot.examples.listtest.hotgen;

import ir.ntnaeem.hottentot.serializerHelper.DataLengthByteArrayMaker;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import ir.ntnaeem.hottentot.serializerHelper.ByteArrayToInteger;
import ir.ntnaeem.hottentot.type.*;

public class SerializableMonitoredCrawlerInfoList {

  private List<MonitoredCrawlerInfo> monitoredCrawlerInfoList;

  public SerializableMonitoredCrawlerInfoList() {
    monitoredCrawlerInfoList = new ArrayList<MonitoredCrawlerInfo>();
  }

  public List<MonitoredCrawlerInfo> getMonitoredCrawlerInfoList() {
    return monitoredCrawlerInfoList;
  }

  public void setMonitoredCrawlerInfoList(List<MonitoredCrawlerInfo> monitoredCrawlerInfoList) {
    this.monitoredCrawlerInfoList = monitoredCrawlerInfoList;
  }

  public byte[] serialize() {
    if (monitoredCrawlerInfoList.size() != 0) {
      int counter = 0;
      int dataLength = 0;
      //calculate serializedMonitoredCrawlerInfoListLength
      for (MonitoredCrawlerInfo monitoredCrawlerInfo : monitoredCrawlerInfoList) {
        
        byte[] serializedMonitoredCrawlerInfo = monitoredCrawlerInfo.serialize();
        byte[] monitoredCrawlerInfoLengthByteArray =
          DataLengthByteArrayMaker.getByteArray(serializedMonitoredCrawlerInfo.length);
        dataLength += monitoredCrawlerInfoLengthByteArray.length + serializedMonitoredCrawlerInfo.length;
      }
      byte[] serializedMonitoredCrawlerInfoList = new byte[dataLength];
      for (MonitoredCrawlerInfo monitoredCrawlerInfo : monitoredCrawlerInfoList) {
        
        byte[] serializedMonitoredCrawlerInfo = monitoredCrawlerInfo.serialize();
        int serializedMonitoredCrawlerInfoLength = serializedMonitoredCrawlerInfo.length;
        byte[] monitoredCrawlerInfoLengthByteArray =
          DataLengthByteArrayMaker.getByteArray(serializedMonitoredCrawlerInfoLength);
        System.arraycopy(monitoredCrawlerInfoLengthByteArray, 0, serializedMonitoredCrawlerInfoList, counter, monitoredCrawlerInfoLengthByteArray.length);
        counter += monitoredCrawlerInfoLengthByteArray.length;
        System.arraycopy(serializedMonitoredCrawlerInfo, 0, serializedMonitoredCrawlerInfoList, counter, serializedMonitoredCrawlerInfo.length);
        counter += serializedMonitoredCrawlerInfo.length;
      }
      return serializedMonitoredCrawlerInfoList;
    }
    return new byte[0];
  }

  public byte[] serializeWithLength() {
    byte[] serializedBytes = serialize();
    byte[] dataLengthInBytes = DataLengthByteArrayMaker.getByteArray(serializedBytes.length);
    byte[] output = new byte[serializedBytes.length + dataLengthInBytes.length];
    int c = 0;
    for(int i = 0 ; i < dataLengthInBytes.length ; i++){
      output[c++] = dataLengthInBytes[i];
    }
    for(int i = 0 ; i < serializedBytes.length ; i++){
      output[c++] = serializedBytes[i];
    }
    return output;
  }

  public void deserialize(byte[] serializedMonitoredCrawlerInfoList) {
    if(serializedMonitoredCrawlerInfoList.length != 0){
      int counter = 0;
      int serializedMonitoredCrawlerInfoByteArrayLength = 0 ;
      while (true) {
        if (counter == serializedMonitoredCrawlerInfoList.length) {
          break;
        }
        int firstLengthByte = serializedMonitoredCrawlerInfoList[counter];
        int numOfByteForLength = 1;
        if ((firstLengthByte & 0x80) == 0) {
          serializedMonitoredCrawlerInfoByteArrayLength = serializedMonitoredCrawlerInfoList[counter];
        } else {
          counter++;
          numOfByteForLength = firstLengthByte & 0x0f;
          byte[] serializedMonitoredCrawlerInfoLengthByteArray = new byte[numOfByteForLength];
          int serializedDataWrapperLengthByteArrayCounter = 0;
          for (int i = counter; i < counter + numOfByteForLength; i++) {
            serializedMonitoredCrawlerInfoLengthByteArray[serializedDataWrapperLengthByteArrayCounter++] = serializedMonitoredCrawlerInfoList[i];
          }
          serializedMonitoredCrawlerInfoByteArrayLength = ByteArrayToInteger.getInt(serializedMonitoredCrawlerInfoLengthByteArray);
        }
        counter += numOfByteForLength;
        byte[] monitoredCrawlerInfoByteArray = new byte[serializedMonitoredCrawlerInfoByteArrayLength];
        int monitoredCrawlerInfoByteArrayCounter = 0;
        for (int i = counter; i < counter + serializedMonitoredCrawlerInfoByteArrayLength; i++) {
          monitoredCrawlerInfoByteArray[monitoredCrawlerInfoByteArrayCounter++] = serializedMonitoredCrawlerInfoList[i];
        }
        counter += serializedMonitoredCrawlerInfoByteArrayLength;
        MonitoredCrawlerInfo monitoredCrawlerInfo = new MonitoredCrawlerInfo();
        monitoredCrawlerInfo.deserialize(monitoredCrawlerInfoByteArray);
        monitoredCrawlerInfoList.add(monitoredCrawlerInfo);
      }
    }
  }
}