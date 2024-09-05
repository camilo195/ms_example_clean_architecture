package co.com.bancolombia.r2dbc.entity;

import lombok.Data;
import org.springframework.data.relational.core.mapping.Table;

import java.util.UUID;

@Data
@Table(name = "tbl_customer_information")
public class CustomerInformationEntity {

    private UUID id;
    private String documentType;
    private String documentNumber;
    private String fullName;

}
