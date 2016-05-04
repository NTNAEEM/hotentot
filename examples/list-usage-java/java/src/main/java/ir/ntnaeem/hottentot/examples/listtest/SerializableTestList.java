/******************************************************************
 * Generated by Hottentot JAVA Generator
 * Date:
 * Name:
 * Description:
 ******************************************************************/
package ir.ntnaeem.hottentot.examples.listtest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.labcrypto.hottentot.*;
import org.labcrypto.hottentot.helper.DataLengthByteArrayMaker;
import org.labcrypto.hottentot.helper.ByteArrayToInteger;


public class SerializableTestList {

  private List<Test> testList;

  public SerializableTestList() {
    testList = new ArrayList<Test>();
  }

  public List<Test> getTestList() {
    return testList;
  }

  public void setTestList(List<Test> testList) {
    this.testList = testList;
  }

  public byte[] serialize() {
    if (testList.size() != 0) {
      int counter = 0;
      int dataLength = 0;
      //calculate serializedTestListLength
      for (Test test : testList) {
        
        byte[] serializedTest = test.serialize();
        byte[] testLengthByteArray =
          DataLengthByteArrayMaker.getByteArray(serializedTest.length);
        dataLength += testLengthByteArray.length + serializedTest.length;
      }
      byte[] serializedTestList = new byte[dataLength];
      for (Test test : testList) {
        
        byte[] serializedTest = test.serialize();
        int serializedTestLength = serializedTest.length;
        byte[] testLengthByteArray =
          DataLengthByteArrayMaker.getByteArray(serializedTestLength);
        System.arraycopy(testLengthByteArray, 0, serializedTestList, counter, testLengthByteArray.length);
        counter += testLengthByteArray.length;
        System.arraycopy(serializedTest, 0, serializedTestList, counter, serializedTest.length);
        counter += serializedTest.length;
      }
      return serializedTestList;
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

  public void deserialize(byte[] serializedTestList) {
    if(serializedTestList.length != 0){
      int counter = 0;
      int serializedTestByteArrayLength = 0 ;
      while (true) {
        if (counter == serializedTestList.length) {
          break;
        }
        int firstLengthByte = serializedTestList[counter];
        int numOfByteForLength = 1;
        if ((firstLengthByte & 0x80) == 0) {
          serializedTestByteArrayLength = serializedTestList[counter];
        } else {
          counter++;
          numOfByteForLength = firstLengthByte & 0x0f;
          byte[] serializedTestLengthByteArray = new byte[numOfByteForLength];
          int serializedDataWrapperLengthByteArrayCounter = 0;
          for (int i = counter; i < counter + numOfByteForLength; i++) {
            serializedTestLengthByteArray[serializedDataWrapperLengthByteArrayCounter++] = serializedTestList[i];
          }
          serializedTestByteArrayLength = ByteArrayToInteger.getInt(serializedTestLengthByteArray);
        }
        counter += numOfByteForLength;
        byte[] testByteArray = new byte[serializedTestByteArrayLength];
        int testByteArrayCounter = 0;
        for (int i = counter; i < counter + serializedTestByteArrayLength; i++) {
          testByteArray[testByteArrayCounter++] = serializedTestList[i];
        }
        counter += serializedTestByteArrayLength;
        Test test = new Test();
        test.deserialize(testByteArray);
        testList.add(test);
      }
    }
  }
}