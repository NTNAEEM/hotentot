/******************************************************************
 * Generated by Hottentot JAVA Generator
 * Date: 
 * Name: 
 * Description:
 *   This file contains definition of an abstract service class.
 ******************************************************************/
package example.generated;

import ir.ntnaeem.hottentot.serializerHelper.PDTSerializer;
import ir.ntnaeem.hottentot.serializerHelper.PDTDeserializer;
import ir.ntnaeem.hottentot.serializerHelper.ByteArrayToInteger;

public class Token {
  private String value = "";
  private byte id;
  public void setValue(String value) {
    this.value = value;
  }
  public String getValue() {
    return value;
  }
  public void setId(byte id) {
    this.id = id;
  }
  public byte getId() {
    return id;
  }
  @Override 
  public String toString() { 
    return "Token{" + 
      "value = '" + value + '\'' + 
      ",id = '" + id + '\'' + 
      "}"; 
  }
	
  public byte[] serialize() {
    byte[] serializedValue = PDTSerializer.getString(value);
    byte[] serializedId = PDTSerializer.getInt8(id);
    byte[] output = new byte[serializedValue.length + serializedId.length];
    int counter = 0;
    //use a loop for every property
    for (int i = 0; i < serializedValue.length; i++) {
      output[counter++] = serializedValue[i];
    }
    for (int i = 0; i < serializedId.length; i++) {
      output[counter++] = serializedId[i];
    }
    return output;
  }
    
  public void deserialize(byte[] serializedByteArray) {
    int counter = 0;
    int dataLength = 0;
    int numbersOfBytesForDataLength;
    //do for every property
    //value : String
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
    byte[] valueByteArray = new byte[dataLength];
    System.arraycopy(serializedByteArray,counter,valueByteArray,0,dataLength);
    counter += dataLength;
    setValue(PDTDeserializer.getString(valueByteArray));
    //id : byte
    byte[] idByteArray = new byte[1];
    for(int i = 0 ; i < 1 ; i++){
      idByteArray[i] = serializedByteArray[counter++];
    }
    setId(PDTDeserializer.getInt8(idByteArray));

  }
}
