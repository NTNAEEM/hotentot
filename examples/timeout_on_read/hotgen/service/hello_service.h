/***************************************************************
 * Generated by Hottentot CC Generator
 * Date: 24-03-2016 11:11:14
 * Name: hello_service.h
 * Description:
 *   This file contains definition of service interface.
 ***************************************************************/

#ifndef _IR_NTNAEEM_HOTTENTOT_EXAMPLES_TIMEOUT_ON_READ__SERVICE__HELLO_SERVICE_H_
#define _IR_NTNAEEM_HOTTENTOT_EXAMPLES_TIMEOUT_ON_READ__SERVICE__HELLO_SERVICE_H_

#ifdef _MSC_VER
typedef __int8 int8_t;
typedef unsigned __int8 uint8_t;
typedef __int16 int16_t;
typedef unsigned __int16 uint16_t;
typedef __int32 int32_t;
typedef unsigned __int32 uint32_t;
typedef __int64 int64_t;
typedef unsigned __int64 uint64_t;
#else
#include <stdint.h>
#endif

#include <string>

#include <naeem/hottentot/runtime/types/primitives.h>
#include <naeem/hottentot/runtime/service/hot_context.h>




namespace ir {
namespace ntnaeem {
namespace hottentot {
namespace examples {
namespace timeout_on_read {
namespace service {
  class HelloService {
  public:
     HelloService() {}
     virtual ~HelloService() {}
  public:
    virtual void SayHelloTo(
      ::naeem::hottentot::runtime::types::Utf8String &name, 
      ::naeem::hottentot::runtime::types::Utf8String &out, 
      ::naeem::hottentot::runtime::service::HotContext &hotContext
    ) = 0;
  };
} // END OF NAMESPACE service
} // END OF NAMESPACE timeout_on_read
} // END OF NAMESPACE examples
} // END OF NAMESPACE hottentot
} // END OF NAMESPACE ntnaeem
} // END OF NAMESPACE ir

#endif