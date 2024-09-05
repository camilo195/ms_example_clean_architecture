package co.com.bancolombia.model.customerinformation.response;

import co.com.bancolombia.model.customerinformation.CustomerInformation;
import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class CustomerInformationResponse {
    private CustomerInformation customerInformation;
    private String status;
    private String detail;
    private String code;
}
