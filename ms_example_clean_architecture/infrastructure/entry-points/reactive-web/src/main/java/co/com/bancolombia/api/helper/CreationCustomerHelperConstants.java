package co.com.bancolombia.api.helper;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CreationCustomerHelperConstants {

    public static final String ERROR_REQUEST_NULL_STATUS = "Not found";
    public static final String ERROR_REQUEST_NULL_DETAIL = "It is not possible to register a client without information";
    public static final String ERROR_REQUEST_NULL_CODE = "404";
}
