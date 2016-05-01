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

public class SerializableUint64List {

  private List<Long> uint64List;

  public SerializableUint64List() {
    uint64List = new ArrayList<Long>();
  }

  public List<Long> getUint64List() {
    return uint64List;
  }

  public void setUint64List(List<Long> uint64List) {
    this.uint64List = uint64List;
  }

  public byte[] serialize() {
    if (uint64List.size() != 0) {
      int counter = 0;
      int dataLength = 0;
      //calculate serializeduint64ListLength
      for (Long uint64 : uint64List) {
        _Int64 _Int64 = new _Int64( uint64 );
        byte[] serializedUint64 = _Int64.serialize();
        byte[] uint64LengthByteArray =
          DataLengthByteArrayMaker.getByteArray(serializedUint64.length);
        dataLength += uint64LengthByteArray.length + serializedUint64.length;
      }
      byte[] serializedUint64List = new byte[dataLength];
      for (Long uint64 : uint64List) {
        _Int64 _Int64 = new _Int64( uint64 );
        byte[] serializedUint64 = _Int64.serialize();
        int serializedUint64Length = serializedUint64.length;
        byte[] uint64LengthByteArray =
          DataLengthByteArrayMaker.getByteArray(serializedUint64Length);
        System.arraycopy(uint64LengthByteArray, 0, serializedUint64List, counter, uint64LengthByteArray.length);
        counter += uint64LengthByteArray.length;
        System.arraycopy(serializedUint64, 0, serializedUint64List, counter, serializedUint64.length);
        counter += serializedUint64.length;
      }
      return serializedUint64List;
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

  public void deserialize(byte[] serializedUint64List) {
    if(serializedUint64List.length != 0){
      int counter = 0;
      int serializedUint64ByteArrayLength = 0 ;
      while (true) {
        if (counter == serializedUint64List.length) {
          break;
        }
        int firstLengthByte = serializedUint64List[counter];
        int numOfByteForLength = 1;
        if ((firstLengthByte & 0x80) == 0) {
          serializedUint64ByteArrayLength = serializedUint64List[counter];
        } else {
          counter++;
          numOfByteForLength = firstLengthByte & 0x0f;
          byte[] serializedUint64LengthByteArray = new byte[numOfByteForLength];
          int serializedDataWrapperLengthByteArrayCounter = 0;
          for (int i = counter; i < counter + numOfByteForLength; i++) {
            serializedUint64LengthByteArray[serializedDataWrapperLengthByteArrayCounter++] = serializedUint64List[i];
          }
          serializedUint64ByteArrayLength = ByteArrayToInteger.getInt(serializedUint64LengthByteArray);
        }
        counter += numOfByteForLength;
        byte[] uint64ByteArray = new byte[serializedUint64ByteArrayLength];
        int uint64ByteArrayCounter = 0;
        for (int i = counter; i < counter + serializedUint64ByteArrayLength; i++) {
          uint64ByteArray[uint64ByteArrayCounter++] = serializedUint64List[i];
        }
        counter += serializedUint64ByteArrayLength;
        _Int64 _Int64 = new _Int64();
        _Int64.deserialize(uint64ByteArray);
        uint64List.add(_Int64.getValue());
      }
    }
  }
}