package co.com.bancolombia.model.customerinformation.exception;

import lombok.Getter;

@Getter
public class BusinessCustomerException extends RuntimeException {

    private final String status;
    private final String detail;
    private final String code;

    public BusinessCustomerException(String status, String detail, String code) {
        super(new Exception());
        this.status = status;
        this.detail = detail;
        this.code = code;
    }
}
