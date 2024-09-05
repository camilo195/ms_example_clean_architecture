package co.com.bancolombia.config;

import co.com.bancolombia.model.customerinformation.gateways.CustomerInformationGateway;
import co.com.bancolombia.usecase.customerinformation.CustomerInformationUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(basePackages = "co.com.bancolombia.usecase",
        includeFilters = {
                @ComponentScan.Filter(type = FilterType.REGEX, pattern = "^.+UseCase$")
        },
        useDefaultFilters = false)
public class UseCasesConfig {

        @Bean
        public CustomerInformationUseCase customerInformationUseCase(CustomerInformationGateway customerInformationGateway){
                return new CustomerInformationUseCase(customerInformationGateway);
        }
}
