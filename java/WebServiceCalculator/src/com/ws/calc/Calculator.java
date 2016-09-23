package com.ws.calc;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * Created by freddy on 22/09/2016.
 */
@WebService
public class Calculator {

    @WebMethod
    public int add(@WebParam(name = "a") int a, @WebParam(name = "b") int b) {
        return a + b;
    }

    @WebMethod
    public int sub(@WebParam(name = "a") int a, @WebParam(name = "b") int b) {
        return a - b;
    }

}
