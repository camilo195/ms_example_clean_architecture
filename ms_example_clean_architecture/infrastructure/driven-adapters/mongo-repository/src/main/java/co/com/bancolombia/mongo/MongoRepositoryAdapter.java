package co.com.bancolombia.mongo;

import co.com.bancolombia.model.customerinformation.CustomerInformation;
import co.com.bancolombia.model.customerinformation.gateways.CustomerInformationGateway;
import co.com.bancolombia.mongo.document.CustomerInformationDocument;
import co.com.bancolombia.mongo.helper.AdapterOperations;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Primary
@Repository
public class MongoRepositoryAdapter extends AdapterOperations<CustomerInformation, CustomerInformationDocument, String, MongoDBRepository>
 implements CustomerInformationGateway {

    public MongoRepositoryAdapter(MongoDBRepository repository, ObjectMapper mapper) {
        super(repository, mapper, d -> mapper.map(d, CustomerInformation.class));
    }

    @Override
    public Mono<CustomerInformation> registryCustomerInformation(CustomerInformation customerInformation) {
        var customerMongoDocument = mapper.map(customerInformation, CustomerInformationDocument.class);
        return repository.save(customerMongoDocument).map(this::toEntity);
    }
}
