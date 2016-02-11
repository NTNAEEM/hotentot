/******************************************************************
 * Generated by Hottentot CC Generator
 * Date: 11-02-2016 01:59:08
 * Name: person_authenticator_service_proxy_builder.cc
 * Description:
 *   This file contains implementation of the proxy builder class.
 ******************************************************************/

#include "person_authenticator_service_proxy_builder.h"
#include "person_authenticator_service_proxy.h"


namespace ir {
namespace ntnaeem {
namespace services {
namespace proxy {
  PersonAuthenticatorService*
  PersonAuthenticatorServiceProxyBuilder::Create(std::string host, uint32_t port) {
    return new PersonAuthenticatorServiceProxy(host, port);
  }
  void
  PersonAuthenticatorServiceProxyBuilder::Destroy(PersonAuthenticatorService *service) {
    delete service;
  }
} // END OF NAMESPACE proxy
} // END OF NAMESPACE services
} // END OF NAMESPACE ntnaeem
} // END OF NAMESPACE ir