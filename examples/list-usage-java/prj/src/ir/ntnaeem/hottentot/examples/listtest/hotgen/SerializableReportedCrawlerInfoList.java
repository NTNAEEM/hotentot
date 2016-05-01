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

public class SerializableReportedCrawlerInfoList {

  private List<ReportedCrawlerInfo> reportedCrawlerInfoList;

  public SerializableReportedCrawlerInfoList() {
    reportedCrawlerInfoList = new ArrayList<ReportedCrawlerInfo>();
  }

  public List<ReportedCrawlerInfo> getReportedCrawlerInfoList() {
    return reportedCrawlerInfoList;
  }

  public void setReportedCrawlerInfoList(List<ReportedCrawlerInfo> reportedCrawlerInfoList) {
    this.reportedCrawlerInfoList = reportedCrawlerInfoList;
  }

  public byte[] serialize() {
    if (reportedCrawlerInfoList.size() != 0) {
      int counter = 0;
      int dataLength = 0;
      //calculate serializedReportedCrawlerInfoListLength
      for (ReportedCrawlerInfo reportedCrawlerInfo : reportedCrawlerInfoList) {
        
        byte[] serializedReportedCrawlerInfo = reportedCrawlerInfo.serialize();
        byte[] reportedCrawlerInfoLengthByteArray =
          DataLengthByteArrayMaker.getByteArray(serializedReportedCrawlerInfo.length);
        dataLength += reportedCrawlerInfoLengthByteArray.length + serializedReportedCrawlerInfo.length;
      }
      byte[] serializedReportedCrawlerInfoList = new byte[dataLength];
      for (ReportedCrawlerInfo reportedCrawlerInfo : reportedCrawlerInfoList) {
        
        byte[] serializedReportedCrawlerInfo = reportedCrawlerInfo.serialize();
        int serializedReportedCrawlerInfoLength = serializedReportedCrawlerInfo.length;
        byte[] reportedCrawlerInfoLengthByteArray =
          DataLengthByteArrayMaker.getByteArray(serializedReportedCrawlerInfoLength);
        System.arraycopy(reportedCrawlerInfoLengthByteArray, 0, serializedReportedCrawlerInfoList, counter, reportedCrawlerInfoLengthByteArray.length);
        counter += reportedCrawlerInfoLengthByteArray.length;
        System.arraycopy(serializedReportedCrawlerInfo, 0, serializedReportedCrawlerInfoList, counter, serializedReportedCrawlerInfo.length);
        counter += serializedReportedCrawlerInfo.length;
      }
      return serializedReportedCrawlerInfoList;
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

  public void deserialize(byte[] serializedReportedCrawlerInfoList) {
    if(serializedReportedCrawlerInfoList.length != 0){
      int counter = 0;
      int serializedReportedCrawlerInfoByteArrayLength = 0 ;
      while (true) {
        if (counter == serializedReportedCrawlerInfoList.length) {
          break;
        }
        int firstLengthByte = serializedReportedCrawlerInfoList[counter];
        int numOfByteForLength = 1;
        if ((firstLengthByte & 0x80) == 0) {
          serializedReportedCrawlerInfoByteArrayLength = serializedReportedCrawlerInfoList[counter];
        } else {
          counter++;
          numOfByteForLength = firstLengthByte & 0x0f;
          byte[] serializedReportedCrawlerInfoLengthByteArray = new byte[numOfByteForLength];
          int serializedDataWrapperLengthByteArrayCounter = 0;
          for (int i = counter; i < counter + numOfByteForLength; i++) {
            serializedReportedCrawlerInfoLengthByteArray[serializedDataWrapperLengthByteArrayCounter++] = serializedReportedCrawlerInfoList[i];
          }
          serializedReportedCrawlerInfoByteArrayLength = ByteArrayToInteger.getInt(serializedReportedCrawlerInfoLengthByteArray);
        }
        counter += numOfByteForLength;
        byte[] reportedCrawlerInfoByteArray = new byte[serializedReportedCrawlerInfoByteArrayLength];
        int reportedCrawlerInfoByteArrayCounter = 0;
        for (int i = counter; i < counter + serializedReportedCrawlerInfoByteArrayLength; i++) {
          reportedCrawlerInfoByteArray[reportedCrawlerInfoByteArrayCounter++] = serializedReportedCrawlerInfoList[i];
        }
        counter += serializedReportedCrawlerInfoByteArrayLength;
        ReportedCrawlerInfo reportedCrawlerInfo = new ReportedCrawlerInfo();
        reportedCrawlerInfo.deserialize(reportedCrawlerInfoByteArray);
        reportedCrawlerInfoList.add(reportedCrawlerInfo);
      }
    }
  }
}