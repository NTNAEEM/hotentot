/******************************************************************
 * Generated by Hottentot CC Generator
 * Date: 04-12-2015 11:22:23
 * Name: echo_service.h
 * Description:
 *   This file contains definition of an abstract service class.
 ******************************************************************/

#ifndef _IR_NTNAEEM_HOTTENTOT_EXAMPLES_ECHOER__SERVICE__ABSTRACT_ECHO_SERVICE_H_
#define _IR_NTNAEEM_HOTTENTOT_EXAMPLES_ECHOER__SERVICE__ABSTRACT_ECHO_SERVICE_H_

#include <stdint.h>
#include <string>

#include <naeem/hottentot/runtime/service/service.h>

#include "../request_message.h"
#include "../response_message.h"
#include "../echo_service.h"
#include "echo_service_request_handler.h"


namespace ir {
namespace ntnaeem {
namespace hottentot {
namespace examples {
namespace echoer {
namespace service {
  class AbstractEchoService : public EchoService, public ::naeem::hottentot::runtime::service::Service {
  public:
    inline virtual uint32_t GetServiceId() const {
      return 3639300462;
    }
  protected:
    inline virtual ::naeem::hottentot::runtime::service::RequestHandler* MakeRequestHandler() {
      return new EchoServiceRequestHandler(this);
    }
  };
} // END OF NAMESPACE service
} // END OF NAMESPACE echoer
} // END OF NAMESPACE examples
} // END OF NAMESPACE hottentot
} // END OF NAMESPACE ntnaeem
} // END OF NAMESPACE ir

#endif