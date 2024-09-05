package co.com.bancolombia.model.customerinformation.gateways;

import co.com.bancolombia.model.customerinformation.CustomerInformation;
import reactor.core.publisher.Mono;

public interface CustomerInformationGateway {
    Mono<CustomerInformation> saveDataBase(CustomerInformation customerInformation);
}
