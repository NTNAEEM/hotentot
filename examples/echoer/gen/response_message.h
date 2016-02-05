/***************************************************************
 * Generated by Hottentot CC Generator
 * Date: 05-02-2016 01:15:26
 * Name: response_message.h
 * Description:
 *   This file contains definition of ResponseMessage class.
 ***************************************************************/

#ifndef _IR_NTNAEEM_HOTTENTOT_EXAMPLES_ECHOER__RESPONSE_MESSAGE_H_
#define _IR_NTNAEEM_HOTTENTOT_EXAMPLES_ECHOER__RESPONSE_MESSAGE_H_

#include <string>

#include <naeem/hottentot/runtime/types/primitives.h>
#include <naeem/hottentot/runtime/serializable.h>


namespace ir {
namespace ntnaeem {
namespace hottentot {
namespace examples {
namespace echoer {
  class ResponseMessage : public ::naeem::hottentot::runtime::Serializable {
  public:
    ResponseMessage() {}
    ~ResponseMessage() {}
  public:
    inline ::naeem::hottentot::runtime::types::Utf8String GetMessage() const {
      return message_;
    }
    inline void SetMessage(::naeem::hottentot::runtime::types::Utf8String message) {
      message_ = message;
    }
  public:
    virtual unsigned char * Serialize(uint32_t * /* Pointer to length */);
    virtual void Deserialize(unsigned char * /* Data */, uint32_t /* Data length */);
  private:
    ::naeem::hottentot::runtime::types::Utf8String message_;
  };
} // END OF NAMESPACE echoer
} // END OF NAMESPACE examples
} // END OF NAMESPACE hottentot
} // END OF NAMESPACE ntnaeem
} // END OF NAMESPACE ir

#endif