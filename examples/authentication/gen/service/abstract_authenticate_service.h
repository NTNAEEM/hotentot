/******************************************************************
 * Generated by Hottentot CC Generator
 * Date: 02-05-2016 05:18:41
 * Name: authenticate_service.h
 * Description:
 *   This file contains definition of an abstract service class.
 ******************************************************************/

#ifndef _NAEEM_HOTTENTOT_EXAMPLES_AUTH__SERVICE__ABSTRACT_AUTHENTICATE_SERVICE_H_
#define _NAEEM_HOTTENTOT_EXAMPLES_AUTH__SERVICE__ABSTRACT_AUTHENTICATE_SERVICE_H_

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

#include <org/labcrypto/hottentot/runtime/service/service.h>

#include "../credential.h"
#include "../user.h"
#include "../token.h"

#include "authenticate_service.h"
#include "authenticate_service_request_handler.h"
#include "../enums.h"


namespace naeem {
namespace hottentot {
namespace examples {
namespace auth {
namespace service {
  class AbstractAuthenticateService : public AuthenticateService, public ::org::labcrypto::hottentot::runtime::service::Service {
  public:
    AbstractAuthenticateService() {}
    virtual ~AbstractAuthenticateService() {}
  public:
    inline virtual uint32_t GetServiceId() const {
      return 1500029818;
    }
  protected:
    inline virtual ::org::labcrypto::hottentot::runtime::service::RequestHandler* MakeRequestHandler() {
      return new AuthenticateServiceRequestHandler(this);
    }
  };
} // END OF NAMESPACE service
} // END OF NAMESPACE auth
} // END OF NAMESPACE examples
} // END OF NAMESPACE hottentot
} // END OF NAMESPACE naeem

#endif