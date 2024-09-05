package co.com.bancolombia.usecase.customerinformation;

import co.com.bancolombia.model.customerinformation.CustomerInformation;
import co.com.bancolombia.model.customerinformation.gateways.CustomerInformationGateway;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class CustomerInformationUseCase {

    private final CustomerInformationGateway gateway;

    public Mono<CustomerInformation> registryCustomerInformation(CustomerInformation customerInformation){
        return gateway.registryCustomerInformation(customerInformation);
    }

}
