package io.github.dft.zohocreator.model.authenticationapi;

import lombok.Data;

@Data
public class AccessTokenResponse {
    private String scope;
    private String tokenType;
    private Integer expiresIn;
    private String apiDomain;
    private String accessToken;
}
