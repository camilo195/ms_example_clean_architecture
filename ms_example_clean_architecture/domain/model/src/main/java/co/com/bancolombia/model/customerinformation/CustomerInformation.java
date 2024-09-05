package co.com.bancolombia.model.customerinformation;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder(toBuilder = true)
public class CustomerInformation {

    private UUID id;
    private String documentType;
    private String documentNumber;
    private String fullName;
}
