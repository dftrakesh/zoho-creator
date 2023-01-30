package io.github.dft.zohocreator;

import io.github.dft.zohocreator.model.authenticationapi.AccessCredential;
import io.github.dft.zohocreator.model.dataapi.AddRecordRequest;
import io.github.dft.zohocreator.model.dataapi.AddRecordResponse;
import io.github.dft.zohocreator.model.dataapi.Records;
import io.github.dft.zohocreator.model.dataapi.UpdateRecordRequest;
import lombok.SneakyThrows;
import org.apache.http.HttpHeaders;
import org.apache.http.client.utils.URIBuilder;

import java.net.http.HttpRequest;
import java.util.HashMap;

import static io.github.dft.zohocreator.constantcode.ConstantCodes.*;

public class DataAPI extends ZohoCreatorSdk {

    public DataAPI(AccessCredential accessCredential) {
        super(accessCredential);
    }

    @SneakyThrows
    public Records getRecords(HashMap<String, String> params, String reportLinkName) {

        URIBuilder uriBuilder = new URIBuilder(API_BASE_END_POINT.concat(SLASH_CHARACTER)
            .concat(accessCredential.getAccountOwnerName())
            .concat(SLASH_CHARACTER)
            .concat(accessCredential.getAppLinkName())
            .concat(REPORT_ENDPOINT)
            .concat(SLASH_CHARACTER)
            .concat(reportLinkName));

        addParameters(uriBuilder, params);

        HttpRequest request = HttpRequest.newBuilder(uriBuilder.build())
            .GET()
            .header(HttpHeaders.CONTENT_TYPE, CONTENT_TYPE_VALUE)
            .headers(AUTHORIZATION_HEADER, TOKEN_NAME.concat(accessCredential.getAccessToken()))
            .build();

        return getRequestWrapped(request, Records.class);
    }

    @SneakyThrows
    public AddRecordResponse addRecord(AddRecordRequest addRecordRequest) {

        URIBuilder uriBuilder = new URIBuilder(API_BASE_END_POINT.concat(SLASH_CHARACTER)
            .concat(accessCredential.getAccountOwnerName())
            .concat(SLASH_CHARACTER)
            .concat(accessCredential.getAppLinkName())
            .concat(FORM_ENDPOINT)
            .concat(SLASH_CHARACTER)
            .concat(addRecordRequest.getFormLinkName()));

        HttpRequest request = HttpRequest.newBuilder(uriBuilder.build())
            .POST(HttpRequest.BodyPublishers.ofString(getString(addRecordRequest.getData())))
            .header(HttpHeaders.CONTENT_TYPE, CONTENT_TYPE_VALUE)
            .headers(AUTHORIZATION_HEADER, TOKEN_NAME.concat(accessCredential.getAccessToken()))
            .build();

        return getRequestWrapped(request, AddRecordResponse.class);
    }


    @SneakyThrows
    public AddRecordResponse updateRecord(UpdateRecordRequest updateRecordRequest) {

        URIBuilder uriBuilder = new URIBuilder(API_BASE_END_POINT.concat(SLASH_CHARACTER)
            .concat(accessCredential.getAccountOwnerName())
            .concat(SLASH_CHARACTER)
            .concat(accessCredential.getAppLinkName())
            .concat(REPORT_ENDPOINT)
            .concat(SLASH_CHARACTER)
            .concat(updateRecordRequest.getFormLinkName())
            .concat(SLASH_CHARACTER)
            .concat(updateRecordRequest.getRecordId()));

        HttpRequest request = HttpRequest.newBuilder(uriBuilder.build())
            .method(PATCH_REQUEST, HttpRequest.BodyPublishers.ofString(getString(updateRecordRequest.getData())))
            .header(HttpHeaders.CONTENT_TYPE, CONTENT_TYPE_VALUE)
            .headers(AUTHORIZATION_HEADER, TOKEN_NAME.concat(accessCredential.getAccessToken()))
            .build();

        return getRequestWrapped(request, AddRecordResponse.class);
    }
}
