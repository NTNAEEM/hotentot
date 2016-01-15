/***************************************************************
 * Generated by Hottentot CC Generator
 * Date: 15-01-2016 03:24:08
 * Name: message.h
 * Description:
 *   This file contains definition of Message class.
 ***************************************************************/

#ifndef _IR_NTNAEEM_HOTTENTOT_EXAMPLES_LISTTEST__MESSAGE_H_
#define _IR_NTNAEEM_HOTTENTOT_EXAMPLES_LISTTEST__MESSAGE_H_

#include <string>

#include <naeem/hottentot/runtime/types/primitives.h>
#include <naeem/hottentot/runtime/serializable.h>


namespace ir {
namespace ntnaeem {
namespace hottentot {
namespace examples {
namespace listtest {
  class Message : public ::naeem::hottentot::runtime::Serializable {
  public:
    Message() {}
    ~Message() {}
  public:
    inline ::naeem::hottentot::runtime::types::Utf8String GetValue() const {
      return value_;
    }
    inline void SetValue(::naeem::hottentot::runtime::types::Utf8String value) {
      value_ = value;
    }
  public:
    virtual unsigned char * Serialize(uint32_t * /* Pointer to length */);
    virtual void Deserialize(unsigned char * /* Data */, uint32_t /* Data length */);
  private:
    ::naeem::hottentot::runtime::types::Utf8String value_;
  };
} // END OF NAMESPACE listtest
} // END OF NAMESPACE examples
} // END OF NAMESPACE hottentot
} // END OF NAMESPACE ntnaeem
} // END OF NAMESPACE ir

#endif