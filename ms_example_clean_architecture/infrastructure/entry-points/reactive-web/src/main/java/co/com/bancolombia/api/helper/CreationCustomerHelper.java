package co.com.bancolombia.api.helper;

import co.com.bancolombia.api.request.CustomerInformationRequest;
import co.com.bancolombia.model.customerinformation.CustomerInformation;
import co.com.bancolombia.model.customerinformation.exception.BusinessCustomerException;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class CreationCustomerHelper {

    public Mono<CustomerInformation> getCustomerModel(CustomerInformationRequest informationRequest){
        if (informationRequest == null){
            return Mono.error(new BusinessCustomerException(CreationCustomerHelperConstants.ERROR_REQUEST_NULL_STATUS,
                    CreationCustomerHelperConstants.ERROR_REQUEST_NULL_DETAIL,
                    CreationCustomerHelperConstants.ERROR_REQUEST_NULL_CODE));
        }
        return Mono.just(createCustomerModel(informationRequest));
    }
    private CustomerInformation createCustomerModel(CustomerInformationRequest informationRequest){
        return CustomerInformation.builder()
                .documentType(informationRequest.getDocumentType())
                .documentNumber(informationRequest.getDocumentNumber())
                .fullName(informationRequest.getFullName())
                .build();
    }
}
