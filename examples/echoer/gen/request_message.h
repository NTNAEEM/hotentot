/***************************************************************
 * Generated by Hottentot CC Generator
 * Date: 01-12-2015 05:07:25
 * Name: request_message.h
 * Description:
 *   This file contains definition of RequestMessage class.
 ***************************************************************/

#ifndef _IR_NTNAEEM_HOTTENTOT_EXAMPLES_ECHOER__REQUEST_MESSAGE_H_
#define _IR_NTNAEEM_HOTTENTOT_EXAMPLES_ECHOER__REQUEST_MESSAGE_H_

#include <string>

#include <naeem/hottentot/serialization/serializable.h>


namespace ir {
namespace ntnaeem {
namespace hottentot {
namespace examples {
namespace echoer {
  class RequestMessage : public ::naeem::hottentot::serialization::Serializable {
  public:
    RequestMessage() {}
    ~RequestMessage() {}
  public:
    inline std::string GetName() const {
      return name_;
    }
    inline void SetName(std::string name) {
      name_ = name;
    }
  public:
    virtual unsigned char * Serialize(uint32_t * /* Pointer to length */);
    virtual void Deserialize(unsigned char * /* Data */, uint32_t /* Data length */);
  private:
    std::string name_;
  };
} // END OF NAMESPACE echoer
} // END OF NAMESPACE examples
} // END OF NAMESPACE hottentot
} // END OF NAMESPACE ntnaeem
} // END OF NAMESPACE ir

#endif