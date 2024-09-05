package co.com.bancolombia.api.filter;

import co.com.bancolombia.api.filter.constants.HeadersValidationConstants;
import co.com.bancolombia.api.filter.exception.HeadersValidationExceptionConstants;
import co.com.bancolombia.model.customerinformation.exception.BusinessCustomerException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import reactor.core.publisher.Mono;

@Service
public class HeadersValidation {

    @Value("${app.rest.client-id}")
    private String clientIdValue;

    @Value("${app.rest.client-secret}")
    private String clientSecretValue;

    public Mono<ServerRequest> validateHeaders(ServerRequest request) {
        return extractClientId(request)
                .zipWith(extractClientSecret(request))
                .flatMap(credentials -> validateCredentials(credentials.getT1(), credentials.getT2())
                        ? Mono.just(request)
                        : Mono.error(createBusinessContactException()))
                .switchIfEmpty(Mono.error(createBusinessContactException()));
    }

    private Mono<String> extractClientId(ServerRequest request) {
        var clientId = request.headers().firstHeader(HeadersValidationConstants.CLIENT_ID);
        return isValidHeader(clientId) ? Mono.just(clientId) : Mono.empty();
    }

    private Mono<String> extractClientSecret(ServerRequest request) {
        var clientSecret = request.headers().firstHeader(HeadersValidationConstants.CLIENT_SECRET);
        return isValidHeader(clientSecret) ? Mono.just(clientSecret) : Mono.empty();
    }

    private boolean isValidHeader(String header) {
        return header != null && !header.isBlank();
    }

    private boolean validateCredentials(String clientId, String clientSecret) {
        return clientId.equals(this.clientIdValue) && clientSecret.equals(this.clientSecretValue);
    }

    private BusinessCustomerException createBusinessContactException(){
        return new BusinessCustomerException(HeadersValidationExceptionConstants.NOT_AUTHORIZED_STATUS,
                HeadersValidationExceptionConstants.NOT_AUTHORIZED_DETAIL,
                HeadersValidationExceptionConstants.NOT_AUTHORIZED_CODE);
    }

}
