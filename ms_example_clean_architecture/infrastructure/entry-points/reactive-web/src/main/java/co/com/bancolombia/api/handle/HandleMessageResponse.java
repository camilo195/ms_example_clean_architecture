package co.com.bancolombia.api.handle;

import co.com.bancolombia.api.handle.constants.HandleMessageResponseConstants;
import co.com.bancolombia.api.response.CompleteResponse;
import co.com.bancolombia.api.response.message.MessageData;
import co.com.bancolombia.model.customerinformation.CustomerInformation;
import co.com.bancolombia.model.customerinformation.exception.BusinessCustomerException;
import org.springframework.stereotype.Component;

@Component
public class HandleMessageResponse {

    public CompleteResponse createResponseSuccess(CustomerInformation customerInformation) {
        return CompleteResponse.builder()
                .customerInformation(customerInformation)
                .messageData(createMessageData(HandleMessageResponseConstants.SUCCESS_STATUS,
                        HandleMessageResponseConstants.SUCCESS_DETAIL,HandleMessageResponseConstants.SUCCESS_STATUS_CODE))
                .build();
    }

    public CompleteResponse createErrorResponse(BusinessCustomerException exception) {
        return CompleteResponse.builder()
                .messageData(createMessageData(exception.getStatus(), exception.getDetail(), exception.getCode()))
                .build();
    }
    private MessageData createMessageData(String status, String detail, String code){
        return MessageData.builder()
                .status(status)
                .detail(detail)
                .statusCode(code)
                .build();
    }
}
