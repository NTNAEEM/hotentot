/*  The MIT License (MIT)
 *
 *  Copyright (c) 2015 Noavaran Tejarat Gostar NAEEM Co.
 *
 *  Permission is hereby granted, free of charge, to any person obtaining a copy
 *  of this software and associated documentation files (the "Software"), to deal
 *  in the Software without restriction, including without limitation the rights
 *  to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 *  copies of the Software, and to permit persons to whom the Software is
 *  furnished to do so, subject to the following conditions:
 *  
 *  The above copyright notice and this permission notice shall be included in all
 *  copies or substantial portions of the Software.
 *  
 *  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTAB_STRILITY,
 *  FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 *  AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 *  SOFTWARE.
 */

package example.generated;

import ir.ntnaeem.hottentot.runtime.Argument;
import ir.ntnaeem.hottentot.runtime.Request;
import ir.ntnaeem.hottentot.runtime.RequestHandler;
import ir.ntnaeem.hottentot.runtime.Response;
import ir.ntnaeem.hottentot.runtime.Service;
import ir.ntnaeem.hottentot.runtime.exception.MethodNotSupportException;
import ir.ntnaeem.hottentot.runtime.exception.TcpClientConnectException;
import ir.ntnaeem.hottentot.runtime.exception.TcpClientReadException;
import ir.ntnaeem.hottentot.runtime.exception.TcpClientWriteException;
import java.util.List;

public class AuthenticationRequestHandler extends RequestHandler {
    public AuthenticationRequestHandler(Service service) {
        super(service);
    }
    @Override
    public Response handleRequest(Request request) throws TcpClientWriteException, TcpClientReadException, TcpClientConnectException, MethodNotSupportException {
        byte methodId = request.getMethodId();
        AuthenticationService authenticationImpl = (AbstractAuthenticationService) service;

	    if(methodId == 1){
            List <Argument> args = request.getArgs();
            Argument arg0 = args.get(0);
            byte[] serializedCredential = arg0.getData();
            Credential credential = new Credential();
            credential.deserialize(serializedCredential);
            Token token = null;
            Response response = new Response();
            token = authenticationImpl.authenticate(credential);
            byte[] serializedToken = token.serialize();
            response.setStatusCode((byte) 100);
            response.setData(serializedToken);
            response.setLength(serializedToken.length + 1);
            return response;
        }
        throw new MethodNotSupportException("method id is incorrect");
    }
}
