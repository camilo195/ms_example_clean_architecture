package co.com.bancolombia.api.request;

import lombok.Data;

@Data
public class CustomerInformationRequest {

    private String documentType;
    private String documentNumber;
    private String fullName;
}
