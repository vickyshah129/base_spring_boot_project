/*
package com.innowi.pos.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class CustomResponseEntity<T>  extends ResponseEntity<T>{

	public CustomResponseEntity(HttpStatus statusCode) {
		super(statusCode);
		// TODO Auto-generated constructor stub
	}

	public CustomResponseEntity() {
		super(HttpStatus.OK);
		// TODO Auto-generated constructor stub
	}

    */
/*public ResponseEntity<T> makeResponse(Status status){
        ResponseEntity<T> entity = new ResponseEntity(status, HttpStatus.EXPECTATION_FAILED);
        return entity;
    }*//*


    public ResponseEntity<T> makeResponse(StatusMessage statusMessage,Long id){
	    Status status = new Status(statusMessage,id);
        ResponseEntity<T> entity = new ResponseEntity(status, statusMessage.getStatusCode());
        return entity;
    }
    public ResponseEntity<T> makeResponse(StatusMessage statusMessage){
        Status status = new Status(statusMessage);
        ResponseEntity<T> entity = new ResponseEntity(status, statusMessage.getStatusCode());
        return entity;
    }

    public ResponseEntity<T> makeResponse(Object obj){
    	ResponseEntity<T> entity = new ResponseEntity(obj, HttpStatus.OK);
    	return entity;
    }

    public ResponseEntity<T> makeResponse(Object requestBody, Object obj, HttpStatus responseCode){
    	ResponseEntity<T> entity = new ResponseEntity(obj, responseCode);
    	return entity;
    }
}
*/
