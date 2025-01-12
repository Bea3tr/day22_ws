package paf.day22_ws.exception;

import java.util.Date;

import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import paf.day22_ws.models.exceptions.ApiError;
import paf.day22_ws.models.exceptions.ResourceNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiError> handleException(Exception ex, 
        HttpServletRequest req, HttpServletResponse resp) {

        ApiError apiError = new ApiError(resp.getStatus(), ex.getMessage(), new Date(), req.getRequestURI());
        return new ResponseEntity<ApiError>(apiError, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ApiError> handleIllegalArgumentException(IllegalArgumentException ex, 
        HttpServletRequest req, HttpServletResponse resp) {

        ApiError apiError = new ApiError(resp.getStatus(), ex.getMessage(), new Date(), req.getRequestURI());
        return new ResponseEntity<ApiError>(apiError, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiError> handleResourceNotFoundException(ResourceNotFoundException ex, 
        HttpServletRequest req, HttpServletResponse resp) {

        ApiError apiError = new ApiError(404, ex.getMessage(), new Date(), req.getRequestURI());
        return new ResponseEntity<ApiError>(apiError, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DataAccessException.class)
    public ResponseEntity<ApiError> handleDataAccessException(DataAccessException ex, 
        HttpServletRequest req, HttpServletResponse resp) {

        ApiError apiError = new ApiError(404, "Record not found", new Date(), req.getRequestURI());
        return new ResponseEntity<ApiError>(apiError, HttpStatus.NOT_FOUND);
    }
    
}
