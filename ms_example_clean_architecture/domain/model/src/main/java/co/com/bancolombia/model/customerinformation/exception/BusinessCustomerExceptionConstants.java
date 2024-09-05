package co.com.bancolombia.model.customerinformation.exception;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BusinessCustomerExceptionConstants {

    public static final String LOAD_NOT_ACCEPTABLE_EXCEPTION_STATUS = "loadNotAcceptableException";
    public static final String LOAD_NOT_ACCEPTABLE_EXCEPTION_DETAIL = "There are null or empty parameters";
    public static final String LOAD_NOT_ACCEPTABLE_EXCEPTION_CODE = "406";
}
