package co.com.bancolombia.api.filter.exception;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class HeadersValidationExceptionConstants {

    public static final String NOT_AUTHORIZED_STATUS = "Not Authorized";
    public static final String NOT_AUTHORIZED_DETAIL = "Credentials invalid";
    public static final String NOT_AUTHORIZED_CODE = "401";
}
