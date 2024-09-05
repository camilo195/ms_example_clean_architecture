package co.com.bancolombia.model.customerinformation.request;

import lombok.Data;

import java.util.UUID;

@Data
public class CustomerInformationRequest {

    private UUID id;
    private String documentType;
    private String documentNumber;
    private String fullName;
}
