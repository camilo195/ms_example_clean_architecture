package co.com.bancolombia.usecase;

import co.com.bancolombia.model.customerinformation.CustomerInformation;
import co.com.bancolombia.model.customerinformation.gateways.CustomerInformationGateway;
import co.com.bancolombia.model.customerinformation.request.CustomerInformationRequest;
import co.com.bancolombia.usecase.util.UseCaseUtil;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class UseCase {

    private final CustomerInformationGateway gateway;

    public Mono<CustomerInformation> saveDataBase(CustomerInformationRequest informationRequest){
        CustomerInformation customerInformation = createCustomerInformation(informationRequest);
        validData(customerInformation);
        return gateway.saveDataBase(customerInformation);
    }

    public CustomerInformation createCustomerInformation(CustomerInformationRequest informationRequest){
        return CustomerInformation.builder()
                .id(informationRequest.getId())
                .documentType(UseCaseUtil.getTypeDocument(informationRequest.getDocumentType()))
                .fullName(informationRequest.getFullName())
                .build();
    }

    public void validData(CustomerInformation customerInformation){
        if (customerInformation.getDocumentNumber() == null){
            throw new RuntimeException();
        }
        if (customerInformation.getDocumentType() == null){
            throw new RuntimeException();
        }
        if (customerInformation.getFullName() == null){
            throw new RuntimeException();
        }
    }
}
