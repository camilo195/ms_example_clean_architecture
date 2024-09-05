package co.com.bancolombia.mongo.document;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("customer_information")
public class CustomerInformationDocument {

    private String id;
    private String documentType;
    private String documentNumber;
    private String fullName;
}
