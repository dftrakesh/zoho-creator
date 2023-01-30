package io.github.dft.zohocreator;

import io.github.dft.zohocreator.model.authenticationapi.AccessCredential;
import io.github.dft.zohocreator.model.metaapi.ReportListRequest;
import io.github.dft.zohocreator.model.metaapi.ReportWrapper;
import lombok.SneakyThrows;
import org.apache.http.HttpHeaders;
import org.apache.http.client.utils.URIBuilder;

import java.net.http.HttpRequest;

import static io.github.dft.zohocreator.constantcode.ConstantCodes.*;

public class MetaAPI extends ZohoCreatorSdk {

    public MetaAPI(AccessCredential accessCredential) {
        super(accessCredential);
    }

    @SneakyThrows
    public ReportWrapper getReports(ReportListRequest reportListRequest) {

        URIBuilder uriBuilder = new URIBuilder(API_BASE_END_POINT.concat(SLASH_CHARACTER)
            .concat(reportListRequest.getAccountOwnerName())
            .concat(SLASH_CHARACTER)
            .concat(reportListRequest.getAppLinkName())
            .concat(REPORT_ENDPOINT));

        HttpRequest request = HttpRequest.newBuilder(uriBuilder.build())
            .header(HttpHeaders.CONTENT_TYPE, CONTENT_TYPE_VALUE)
            .headers(AUTHORIZATION_HEADER, TOKEN_NAME.concat(accessCredential.getAccessToken()))
            .build();

        return getRequestWrapped(request, ReportWrapper.class);
    }
}