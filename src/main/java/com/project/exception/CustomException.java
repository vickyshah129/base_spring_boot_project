package com.project.exception;

import com.project.util.Status;
import org.hibernate.exception.ConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.orm.jpa.JpaObjectRetrievalFailureException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.EntityNotFoundException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.NoSuchElementException;
import java.util.Optional;

@ControllerAdvice
@RequestMapping(produces = "application/json")
public class CustomException {

    private static final Logger logger = LoggerFactory.getLogger(CustomException.class);

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<Status> noSuchElementFound(final Exception e) {
        return error(e, HttpStatus.NOT_FOUND, e.getMessage());
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Status> entityNotFound(final Exception e) {
        return error(e, HttpStatus.NOT_FOUND, e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Status> constraintViolation(final Exception e) {
        return error(e, HttpStatus.EXPECTATION_FAILED, e.getMessage());
    }

    private ResponseEntity<Status> error(final Exception exception, HttpStatus httpStatus, final String logRef) {
        logger.error("",exception);
        String message = "";
        if (exception instanceof NoSuchElementException) {
            message = Optional.of(exception.getMessage()).orElse(exception.getClass().getSimpleName());
        } else if (exception instanceof DataIntegrityViolationException) {
            httpStatus = HttpStatus.BAD_REQUEST;
            Throwable t1 = exception.getCause();
            if (t1 instanceof ConstraintViolationException) {
                ConstraintViolationException cve = (ConstraintViolationException) t1;
                Throwable t2 = cve.getCause();
                if (t2 instanceof SQLIntegrityConstraintViolationException) {
                    SQLIntegrityConstraintViolationException sic = (SQLIntegrityConstraintViolationException) t2;
                    message = createMessageForConstraintViolation(sic);
                }
            }
        } else if (exception instanceof JpaObjectRetrievalFailureException) {
            httpStatus = HttpStatus.BAD_REQUEST;
            Throwable throwable = exception.getCause();
            if (throwable instanceof EntityNotFoundException) {
                EntityNotFoundException enfe = (EntityNotFoundException) throwable;
                message = "Unknown value " + enfe.getMessage().split("\\.")[4];
            }

        }
        if(message.isEmpty()){
            httpStatus = HttpStatus.BAD_REQUEST;
            message = exception.getMessage();
        }
        Status status = new Status(httpStatus.value(), message, 1L);
        logger.info("exception end="+System.currentTimeMillis());
        return new ResponseEntity<Status>(status, httpStatus);
    }

    private String createMessageForConstraintViolation(SQLIntegrityConstraintViolationException sic) {
        String message = "";
        String errorMessage = sic.getMessage();
        String actualConstraintViolated = "";
        if (errorMessage.contains("Duplicate entry")) {
            actualConstraintViolated = errorMessage.split("'")[1];
            if(errorMessage.contains("pin")){
                message = "PIN already exist";
            }else{
                message = "Entry with '" + actualConstraintViolated + "' already exist";
            }
        } else {
            String[] allMsgs = errorMessage.split("REFERENCES");
            actualConstraintViolated = allMsgs[1].split("`")[1];
            //message = Optional.of(exception.getMessage()).orElse(exception.getClass().getSimpleName());
            message = "Could not save data due to data constraints voilation with " + actualConstraintViolated;
        }
        return message;
    }
}
