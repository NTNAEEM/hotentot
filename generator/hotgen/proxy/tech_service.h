/***********************************************************************
 * Generated by Hottentot CC Generator
 * Date: 11-02-2016 01:32:49
 * Name: tech_service.h
 * Description:
 *   This file contains definition of the interface used by proxies.
 ***********************************************************************/

#ifndef _IR_NTNAEEM_HOTTENTOT_EXAMPLES_TECH__PROXY__TECH_SERVICE_H_
#define _IR_NTNAEEM_HOTTENTOT_EXAMPLES_TECH__PROXY__TECH_SERVICE_H_

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




namespace ir {
namespace ntnaeem {
namespace hottentot {
namespace examples {
namespace tech {
namespace proxy {
  class TechService {
  public:
     TechService() {}
     virtual ~TechService() {}
  public:
    virtual void Report(
      ::naeem::hottentot::runtime::types::Utf8String &message
    ) = 0;
    virtual void GetSerial(
      ::naeem::hottentot::runtime::types::Int16 &out
    ) = 0;
  };
} // END OF NAMESPACE proxy
} // END OF NAMESPACE tech
} // END OF NAMESPACE examples
} // END OF NAMESPACE hottentot
} // END OF NAMESPACE ntnaeem
} // END OF NAMESPACE ir

#endif