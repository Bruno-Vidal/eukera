package br.com.cristal.eureka.business.exception;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BaseException extends RuntimeException {

    private String msg;
    private Integer status;
    public BaseException() {
        super();
        status = 500;
        msg = "Internal server error";
    }
    public BaseException(String message, Throwable cause) {
        super(message, cause);
    }
    public BaseException(String message) {
        super(message);
    }
    public BaseException(String message, Integer status) {
        super(message);
        msg = message;
        this.status = status;
    }
    public BaseException(Throwable cause) {
        super(cause);
    }
}
