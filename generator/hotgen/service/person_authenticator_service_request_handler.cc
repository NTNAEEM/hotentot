/****************************************************************************
 * Generated by Hottentot CC Generator
 * Date: 10-02-2016 11:30:40
 * Name: person_authenticator_service_request_handler.cc
 * Description:
 *   This file contains implementation of service's request handler class.
 ****************************************************************************/
 
#include <string.h>

#include <naeem/hottentot/runtime/request.h>
#include <naeem/hottentot/runtime/response.h>

#include "person_authenticator_service_request_handler.h"
#include "abstract_person_authenticator_service.h"
#include "person_authenticator_service.h"
#include "../person.h"
#include "../phone.h"


namespace ir {
namespace ntnaeem {
namespace services {
namespace service {
  void 
  PersonAuthenticatorServiceRequestHandler::HandleRequest(::naeem::hottentot::runtime::Request &request, ::naeem::hottentot::runtime::Response &response) {
    if (request.GetMethodId() == 2935213856) {
      ::ir::ntnaeem::services::service::AbstractPersonAuthenticatorService *serviceObject = 
        dynamic_cast< ::ir::ntnaeem::services::service::AbstractPersonAuthenticatorService*>(service_);
      /*
       * Deserialization and making input variables
       */
      ::ir::ntnaeem::services::int age;
      age.Deserialize(request.GetArgumentData(0), request.GetArgumentLength(0));
      ::naeem::hottentot::runtime::types::Double percent;
      percent.Deserialize(request.GetArgumentData(1), request.GetArgumentLength(1));
      /*
       * Calling service method
       */
      ::naeem::hottentot::runtime::service::HotContext hotContext;
      ::naeem::hottentot::runtime::types::Utf8String result;
      serviceObject->GetName(age, percent, result, hotContext);
      /*
       * Serializiation of returned object
       */
      uint32_t serializedDataLength = 0;
      unsigned char *serializedData = result.Serialize(&serializedDataLength);

      response.SetStatusCode(0);
      response.SetData(serializedData);
      response.SetDataLength(serializedDataLength);
      return;
    }
    if (request.GetMethodId() == 1784602084) {
      ::ir::ntnaeem::services::service::AbstractPersonAuthenticatorService *serviceObject = 
        dynamic_cast< ::ir::ntnaeem::services::service::AbstractPersonAuthenticatorService*>(service_);
      /*
       * Deserialization and making input variables
       */
      ::naeem::hottentot::runtime::types::Utf8String predicate;
      predicate.Deserialize(request.GetArgumentData(0), request.GetArgumentLength(0));
      /*
       * Calling service method
       */
      ::naeem::hottentot::runtime::service::HotContext hotContext;
      ::naeem::hottentot::runtime::types::List< ::naeem::hottentot::runtime::types::Utf8String> result;
      serviceObject->GetNames(predicate, result, hotContext);
      /*
       * Serializiation of returned object
       */
      uint32_t serializedDataLength = 0;
      unsigned char *serializedData = result.Serialize(&serializedDataLength);
      result.Purge();

      response.SetStatusCode(0);
      response.SetData(serializedData);
      response.SetDataLength(serializedDataLength);
      return;
    }
    if (request.GetMethodId() == 2472013022) {
      ::ir::ntnaeem::services::service::AbstractPersonAuthenticatorService *serviceObject = 
        dynamic_cast< ::ir::ntnaeem::services::service::AbstractPersonAuthenticatorService*>(service_);
      /*
       * Deserialization and making input variables
       */
      /*
       * Calling service method
       */
      ::naeem::hottentot::runtime::service::HotContext hotContext;
      ::naeem::hottentot::runtime::types::List< ::ir::ntnaeem::services::map<set<list<string>>,Phone>> result;
      serviceObject->GetG(result, hotContext);
      /*
       * Serializiation of returned object
       */
      uint32_t serializedDataLength = 0;
      unsigned char *serializedData = result.Serialize(&serializedDataLength);
      result.Purge();

      response.SetStatusCode(0);
      response.SetData(serializedData);
      response.SetDataLength(serializedDataLength);
      return;
    }
    char errorMessage[] = "Method not found.";
    response.SetStatusCode(1);
    response.SetData((unsigned char*)errorMessage);
    response.SetDataLength(strlen(errorMessage));
  }
} // END OF NAMESPACE service
} // END OF NAMESPACE services
} // END OF NAMESPACE ntnaeem
} // END OF NAMESPACE ir