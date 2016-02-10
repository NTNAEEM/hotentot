/******************************************************************
 * Generated by Hottentot CC Generator
 * Date: 10-02-2016 11:30:40
 * Name: phone_manager_service_proxy_builder.h
 * Description:
 *   This file contains definition of the proxy builder class.
 ******************************************************************/

#ifndef _IR_NTNAEEM_SERVICES__PROXY__PHONE_MANAGER_SERVICE_PROXY_BUILDER_H_
#define _IR_NTNAEEM_SERVICES__PROXY__PHONE_MANAGER_SERVICE_PROXY_BUILDER_H_

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


namespace ir {
namespace ntnaeem {
namespace services {
namespace proxy {
class PhoneManagerService;
  class PhoneManagerServiceProxyBuilder {
  public:
    static PhoneManagerService* Create(std::string /* host */, uint32_t /* port */);
    static void Destroy(PhoneManagerService *);
  };
} // END OF NAMESPACE proxy
} // END OF NAMESPACE services
} // END OF NAMESPACE ntnaeem
} // END OF NAMESPACE ir

#endif