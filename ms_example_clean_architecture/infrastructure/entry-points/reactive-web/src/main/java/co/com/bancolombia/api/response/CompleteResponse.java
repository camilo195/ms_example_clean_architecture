package co.com.bancolombia.api.response;

import co.com.bancolombia.api.response.message.MessageData;
import co.com.bancolombia.model.customerinformation.CustomerInformation;
import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class CompleteResponse {

    private CustomerInformation customerInformation;
    private MessageData messageData;
}
