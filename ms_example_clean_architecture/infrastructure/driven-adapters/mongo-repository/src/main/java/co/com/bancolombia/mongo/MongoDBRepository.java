package co.com.bancolombia.mongo;

import co.com.bancolombia.mongo.document.CustomerInformationDocument;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;

public interface MongoDBRepository extends ReactiveMongoRepository<CustomerInformationDocument, String>,
        ReactiveQueryByExampleExecutor<CustomerInformationDocument> {
}
