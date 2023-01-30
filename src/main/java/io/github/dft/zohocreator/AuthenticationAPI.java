package io.github.dft.zohocreator;

import io.github.dft.zohocreator.handler.JsonBodyHandler;
import io.github.dft.zohocreator.model.authenticationapi.AccessCredential;
import lombok.SneakyThrows;
import org.apache.http.HttpHeaders;
import org.apache.http.client.utils.URIBuilder;

import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;

import static io.github.dft.zohocreator.constantcode.ConstantCodes.CONTENT_TYPE_VALUE;
import static io.github.dft.zohocreator.constantcode.ConstantCodes.OAUTH_BASE_END_POINT;

public class AuthenticationAPI extends ZohoCreatorSdk {

    public AuthenticationAPI(AccessCredential accessCredential) {
        super(accessCredential);
    }

    @SneakyThrows
    public AccessCredential generateAccessToken(HashMap<String, String> params) {

        URIBuilder uriBuilder = new URIBuilder(OAUTH_BASE_END_POINT);
        addParameters(uriBuilder, params);

        HttpRequest request = HttpRequest.newBuilder(uriBuilder.build())
            .POST(HttpRequest.BodyPublishers.noBody())
            .header(HttpHeaders.CONTENT_TYPE, CONTENT_TYPE_VALUE)
            .build();

        return getRequestWrapped(request, AccessCredential.class);
    }
}