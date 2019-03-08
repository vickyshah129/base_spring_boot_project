package com.project.util;

import org.springframework.http.HttpStatus;

public enum StatusMessage {
    FAILURE(0,"FAILURE", HttpStatus.NOT_FOUND),
    SUCCESS(1,"SUCCESS", HttpStatus.OK),
    CUSTOMER_ID_REQUIRED(2,"Please Specify customer id.", HttpStatus.BAD_REQUEST),
    CUSTOMER_NOT_FOUND(3,"Unknown Customer for this sale.", HttpStatus.NOT_FOUND),
    SALE_ADDED_SUCCESSFULLY(3,"Sale Added Successfully", HttpStatus.OK),
    ROLE_ADDED_SUCCESSFULLY(4,"ROLE Added Successfully", HttpStatus.OK),
    EMPLOYEE_ADDED_SUCCESSFULLY(5,"Employee added Successfully", HttpStatus.OK),
    EMPLOYEE_UPDATED_SUCCESSFULLY(6,"Employee updated Successfully", HttpStatus.OK),
    EMPLOYEE_ADDED_ERROR(7,"Error while adding employee", HttpStatus.EXPECTATION_FAILED),
    EMPLOYEE_UPDATED_ERROR(8,"Error while updating employee", HttpStatus.EXPECTATION_FAILED),
    PERMISSION_ADDED_SUCCESSFULLY(9,"Permission(s) added successfully", HttpStatus.OK),
    ACTIVITY_LOGGED_SUCCESSFULLY(10,"Activity added successfully", HttpStatus.OK),
    ROLE_UPDATED_SUCCESSFULLY(11,"ROLE updated Successfully", HttpStatus.OK),
    HIGHER_AUTHORITY_VERIFICATION_REQUIRED(12,"Ending break before 30 min require verification from authority", HttpStatus.NOT_ACCEPTABLE)
    ;

    private StatusMessage(int id, String description, HttpStatus statusCode) {
        this.id = id;
        this.description = description;
        this.statusCode = statusCode;
    }
    private int id;
    private String description;
    private HttpStatus statusCode;


    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public HttpStatus getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(HttpStatus statusCode) {
        this.statusCode = statusCode;
    }
}
