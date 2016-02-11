/***********************************************************************
 * Generated by Hottentot CC Generator
 * Date: 11-02-2016 01:59:08
 * Name: person_authenticator_service.h
 * Description:
 *   This file contains definition of the interface used by proxies.
 ***********************************************************************/

#ifndef _IR_NTNAEEM_SERVICES__PROXY__PERSON_AUTHENTICATOR_SERVICE_H_
#define _IR_NTNAEEM_SERVICES__PROXY__PERSON_AUTHENTICATOR_SERVICE_H_

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

#include "../person.h"
#include "../phone.h"


namespace ir {
namespace ntnaeem {
namespace services {
namespace proxy {
  class PersonAuthenticatorService {
  public:
     PersonAuthenticatorService() {}
     virtual ~PersonAuthenticatorService() {}
  public:
    virtual void GetName(
      ::ir::ntnaeem::services::int &age, 
      ::naeem::hottentot::runtime::types::Double &percent, 
      ::naeem::hottentot::runtime::types::Utf8String &out
    ) = 0;
    virtual void GetNames(
      ::naeem::hottentot::runtime::types::Utf8String &predicate, 
      ::naeem::hottentot::runtime::types::List< ::naeem::hottentot::runtime::types::Utf8String> &out
    ) = 0;
    virtual void GetG(
      ::naeem::hottentot::runtime::types::List< ::ir::ntnaeem::services::map<set<list<string>>,Phone>> &out
    ) = 0;
  };
} // END OF NAMESPACE proxy
} // END OF NAMESPACE services
} // END OF NAMESPACE ntnaeem
} // END OF NAMESPACE ir

#endif