package co.com.bancolombia.api;

import co.com.bancolombia.model.customerinformation.CustomerInformation;
import co.com.bancolombia.model.customerinformation.request.CustomerInformationRequest;
import co.com.bancolombia.model.customerinformation.response.CustomerInformationResponse;
import co.com.bancolombia.usecase.UseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class Handler {

    @Value("${app.rest.client-id}")
    private String clientIdValue;

    @Value("${app.rest.client-secret}")
    private String clientSecretValue;

    private final UseCase useCase;


    public Mono<ServerResponse> listenGETUseCase(ServerRequest serverRequest) {
        return validateHeaders(serverRequest)
                .flatMap(request -> request.bodyToMono(CustomerInformationRequest.class))
                .flatMap(customerRequest -> useCase.saveDataBase(customerRequest))
                .flatMap(this::createServerResponse)
                .onErrorResume(error -> {
                    System.out.println("Error ocurrido: " + error.getMessage());
                    return Mono.empty();
                });
    }

    private Mono<ServerResponse> createServerResponse(CustomerInformation customerInformation){
        return ServerResponse.ok()
                .bodyValue(CustomerInformationResponse.builder()
                        .customerInformation(customerInformation)
                        .status("Sucess")
                        .detail("Registro generado con exito")
                        .code("200")
                        .build())
                .doOnNext(response -> System.out.println("Success response"));
    }

    public Mono<ServerRequest> validateHeaders(ServerRequest request) {

        var clientId = request.headers().firstHeader("ClientId");
        var clientSecret = request.headers().firstHeader("ClientSecret");
        if (clientId != null && !clientId.isBlank() && clientSecret != null && !clientSecret.isBlank()) {
            return Mono.just(clientId)
                    .filter(header -> validateCredential(header, clientSecret))
                    .switchIfEmpty(Mono.defer(() ->
                            Mono.error(() -> new RuntimeException("Not Authorized"))))
                    .thenReturn(clientSecret)
                    .thenReturn(request);
        } else {
            return Mono.error(() -> new RuntimeException("Not Authorized"));
        }
    }

    public boolean validateCredential(String clientId, String clientSecret) {
        return clientId.equals(this.clientIdValue) && clientSecret.equals(clientSecretValue);
    }


}
