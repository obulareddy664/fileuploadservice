package com.file.upload.exception.handler;

import com.file.upload.constant.RecordErrorMsg;
import com.file.upload.exception.FileNameException;
import com.file.upload.model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalApplicationExceptionHandler {

    @ExceptionHandler(FileNameException.class)
    public ResponseEntity<ErrorResponse> nameAlreadyEsxistException(FileNameException fileNameException){
    ErrorResponse errorResponse=new ErrorResponse();
    errorResponse.setMessage(String.join(RecordErrorMsg.EMPTY_STRING,
            RecordErrorMsg.FILE_NAME_EXIST ,fileNameException.getMessage(),
            RecordErrorMsg.PROVIDE_FILE_NAME));
    errorResponse.setStatusCode(HttpStatus.FORBIDDEN.value());
    errorResponse.setType(HttpStatus.FORBIDDEN.name());

    return  new ResponseEntity<>(errorResponse,HttpStatus.FORBIDDEN);
    }
}
