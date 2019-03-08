package com.project.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.exception.CustomException;
import com.project.filter.ResponseFilter;
import com.project.util.Status;
import com.project.util.StatusMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import javax.servlet.http.HttpServletResponse;

public class BaseController {

    protected static final Logger logger = LoggerFactory.getLogger(CustomException.class);
    @Autowired
    private ObjectMapper json;

    @Autowired
    protected ApplicationContext context;

    public ObjectMapper getJson() {
        return json;
    }

    public void setJson(ObjectMapper json) {
        this.json = json;
    }

    public <T extends Object> T convertToObject(String jsonString, Class<T> c) throws Exception {
        return json.readValue(jsonString, c);
    }

    public <T> T convertToHashMap(String jsonString, TypeReference typeRef) throws Exception {
        return (T) json.readValue(jsonString, typeRef);
    }

    public Object convertToObject(String jsonString) throws Exception {
        return json.readValue(jsonString, Object.class);
    }

    public <T> T response(T obj) {
        HttpServletResponse res = ResponseFilter.getResponse();
        if(obj instanceof StatusMessage){
            StatusMessage statusMessage = (StatusMessage)obj;
            res.setStatus(statusMessage.getStatusCode().value());
        }
        //do changes in object or response if you want
        return obj;
    }

    public Status response(StatusMessage statusMessage, long id) {
        HttpServletResponse res = ResponseFilter.getResponse();
        res.setStatus(statusMessage.getStatusCode().value());
        Status status = new Status(statusMessage, id);
        return status;
    }

    public Status response(StatusMessage statusMessage) {
        HttpServletResponse res = ResponseFilter.getResponse();
        Status status = new Status(statusMessage);
        return status;
    }

    public Status response(String message) {
        HttpServletResponse res = ResponseFilter.getResponse();
        Status status = new Status(message);
        return status;
    }

    public Status response(StatusMessage statusMessage, long id, int responseCode) {
        HttpServletResponse res = ResponseFilter.getResponse();
        res.setStatus(responseCode);
        Status status = new Status(statusMessage, id);
        return status;
    }
}
