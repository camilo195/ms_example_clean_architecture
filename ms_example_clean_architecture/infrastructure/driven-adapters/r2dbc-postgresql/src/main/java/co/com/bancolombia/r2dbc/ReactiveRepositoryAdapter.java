package co.com.bancolombia.r2dbc;

import co.com.bancolombia.model.customerinformation.CustomerInformation;
import co.com.bancolombia.model.customerinformation.gateways.CustomerInformationGateway;
import co.com.bancolombia.r2dbc.entity.CustomerInformationEntity;
import co.com.bancolombia.r2dbc.helper.ReactiveAdapterOperations;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Repository
public class ReactiveRepositoryAdapter extends ReactiveAdapterOperations<CustomerInformation, CustomerInformationEntity,
        UUID, ReactiveRepository> implements CustomerInformationGateway {

    public ReactiveRepositoryAdapter(ReactiveRepository repository, ObjectMapper mapper) {
        super(repository, mapper, d -> mapper.map(d, CustomerInformation.class));
    }

    @Override
    public Mono<CustomerInformation> registryCustomerInformation(CustomerInformation customerInformation) {
        var customerEntity = mapper.map(customerInformation, CustomerInformationEntity.class);
        return repository.save(customerEntity)
                .map(this::toEntity);
    }
}
