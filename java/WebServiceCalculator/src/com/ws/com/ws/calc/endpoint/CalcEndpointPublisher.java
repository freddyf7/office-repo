package com.ws.com.ws.calc.endpoint;

/**
 * Created by freddy on 22/09/2016.
 */
import com.ws.calc.Calculator;

import javax.xml.ws.Endpoint;

public class CalcEndpointPublisher {

    public static void main(String[] args) {
        Endpoint.publish("http://localhost:8080/Calculator",
                new Calculator());
    }

}
