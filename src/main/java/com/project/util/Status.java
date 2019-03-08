package com.project.util;

public class Status {

    private int code;
    private String message;
    private Long returnId;

    private Object additionalDetail;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getReturnId() {
        return returnId;
    }

    public void setReturnId(Long returnId) {
        this.returnId = returnId;
    }

    public Status(StatusMessage statusMessage, Long returnId) {
        this.setCode(statusMessage.getId());
        this.setMessage(statusMessage.getDescription());
        this.setReturnId(returnId);
    }
    public Status(StatusMessage statusMessage) {
        this.setCode(statusMessage.getId());
        this.setMessage(statusMessage.getDescription());
        this.setReturnId(0L);
    }

    public Status(String message) {
        this.setCode(000);
        this.setMessage(message);
        this.setReturnId(0L);
    }

    public Status(String message, Long id) {
        this.setCode(000);
        this.setMessage(message);
        this.setReturnId(id);
    }

    public Status(int code, String message, Long returnId) {
        this.code = code;
        this.message = message;
        this.returnId = returnId;
    }

    public Status(StatusMessage statusMessage, Object additionalDetail) {
        this.setCode(statusMessage.getId());
        this.setMessage(statusMessage.getDescription());
        this.additionalDetail = additionalDetail;
    }

    public Object getAdditionalDetail() {
        return additionalDetail;
    }

    public void setAdditionalDetail(Object additionalDetail) {
        this.additionalDetail = additionalDetail;
    }
}
