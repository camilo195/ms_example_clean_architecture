package co.com.bancolombia.api.response.message;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class MessageData {
    private String status;
    private String detail;
    private String statusCode;
}
