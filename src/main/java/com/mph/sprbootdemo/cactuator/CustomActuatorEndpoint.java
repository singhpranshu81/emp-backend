package com.mph.sprbootdemo.cactuator;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.stereotype.Component;

@Component
@Endpoint(id="customActuatorEndpoint")
public class CustomActuatorEndpoint {
    private Map<String,Object> data = new HashMap<>();
    
    public CustomActuatorEndpoint() {
    	data.put("app version","1.0");
    	data.put("status","running perfectly");
    }
    
    @ReadOperation
    public Map<String,Object> getData(){
    	return data;
    }
    
    @WriteOperation
    public void setData(String key, String value){
    	data.put(key, value);
    }
}
