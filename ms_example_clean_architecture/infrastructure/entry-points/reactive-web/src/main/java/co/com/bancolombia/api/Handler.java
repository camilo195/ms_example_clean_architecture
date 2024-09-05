package co.com.bancolombia.api;

import co.com.bancolombia.api.constants.HandlerConstants;
import co.com.bancolombia.api.filter.HeadersValidation;
import co.com.bancolombia.api.handle.HandleMessageResponse;
import co.com.bancolombia.api.helper.CreationCustomerHelper;
import co.com.bancolombia.api.request.CustomerInformationRequest;
import co.com.bancolombia.model.customerinformation.CustomerInformation;
import co.com.bancolombia.model.customerinformation.exception.BusinessCustomerException;
import co.com.bancolombia.usecase.customerinformation.CustomerInformationUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;
import java.util.function.Function;

@Log4j2
@Component
@RequiredArgsConstructor
public class Handler {

    private final HeadersValidation headersValidation;
    private final CustomerInformationUseCase customerInformationUseCase;
    private final HandleMessageResponse handleMessageResponse;
    private final CreationCustomerHelper creationCustomerHelper;

    public Mono<ServerResponse> listenRegistryCustomer(ServerRequest serverRequest) {
        return headersValidation.validateHeaders(serverRequest)
                .flatMap(request -> request.bodyToMono(CustomerInformationRequest.class))
                .flatMap(creationCustomerHelper::getCustomerModel)
                .flatMap(customerInformationUseCase::registryCustomerInformation)
                .flatMap(successResponse())
                .onErrorResume(BusinessCustomerException.class, exc -> errorResponse().apply(exc));
    }

    private Function<CustomerInformation, Mono<? extends ServerResponse>> successResponse(){
        return data -> ServerResponse.ok()
                .bodyValue(handleMessageResponse.createResponseSuccess(data))
                .doOnNext(response -> log.info(HandlerConstants.SUCCESS_RESPONSE));
    }

    private Function<BusinessCustomerException, Mono<? extends ServerResponse>> errorResponse(){
        return errorKnow -> ServerResponse.status(Integer.parseInt(errorKnow.getStatus()))
                .bodyValue(handleMessageResponse.createErrorResponse(errorKnow))
                .doOnNext(error -> log.error(HandlerConstants.ERROR_RESPONSE, errorKnow.getDetail()));
    }

}
