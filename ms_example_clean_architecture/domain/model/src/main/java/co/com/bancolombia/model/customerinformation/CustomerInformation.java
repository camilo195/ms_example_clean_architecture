package co.com.bancolombia.model.customerinformation;
import co.com.bancolombia.model.customerinformation.exception.BusinessCustomerException;
import co.com.bancolombia.model.customerinformation.exception.BusinessCustomerExceptionConstants;
import lombok.Builder;
import lombok.Data;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Data
@Builder(toBuilder = true)
public class CustomerInformation {

    private UUID id;
    private String documentType;
    private String documentNumber;
    private String fullName;

    public Mono<CustomerInformation> validateCustomerInformation(){
        return validateNullOrBlankValue();
    }

    private Mono<CustomerInformation> validateNullOrBlankValue(){
        if (isNullValue() || isBlankValue()){
            return Mono.error(new BusinessCustomerException(
                    BusinessCustomerExceptionConstants.LOAD_NOT_ACCEPTABLE_EXCEPTION_STATUS,
                    BusinessCustomerExceptionConstants.LOAD_NOT_ACCEPTABLE_EXCEPTION_DETAIL,
                    BusinessCustomerExceptionConstants.LOAD_NOT_ACCEPTABLE_EXCEPTION_CODE));
        }
        return Mono.just(this);
    }

    private boolean isNullValue(){
        return this.documentType == null || this.documentNumber == null || this.fullName == null;
    }

    private boolean isBlankValue(){
        return this.documentType.isBlank() || this.documentNumber.isBlank() || this.fullName.isBlank();
    }


}
