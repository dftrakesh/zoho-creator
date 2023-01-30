package io.github.dft.zohocreator.model.authenticationapi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class AccessCredential {
    private String scope;
    private String clientId;
    private String apiDomain;
    private String tokenType;
    private String clientSecret;
    private LocalDateTime expiresInTime;
    private String accessToken;
    private String appLinkName;
    private String refreshToken;
    private String accountOwnerName;
}
