package io.github.dft.zohocreator;

import io.github.dft.zohocreator.constantcode.ConstantCodes;
import io.github.dft.zohocreator.model.authenticationapi.AccessCredential;
import io.github.dft.zohocreator.model.metaapi.ReportListRequest;
import io.github.dft.zohocreator.model.metaapi.ReportWrapper;
import lombok.SneakyThrows;
import org.apache.http.HttpHeaders;
import org.apache.http.client.utils.URIBuilder;

import java.net.http.HttpRequest;

public class MetaAPI extends ZohoCreatorSdk {

    public MetaAPI(AccessCredential accessCredential) {
        super(accessCredential);
    }

    @SneakyThrows
    public ReportWrapper getReports(ReportListRequest reportListRequest) {

        URIBuilder uriBuilder = new URIBuilder(ConstantCodes.API_BASE_END_POINT.concat(ConstantCodes.SLASH_CHARACTER)
            .concat(reportListRequest.getAccountOwnerName())
            .concat(ConstantCodes.SLASH_CHARACTER)
            .concat(reportListRequest.getAppLinkName())
            .concat(ConstantCodes.REPORT_ENDPOINT));

        HttpRequest request = HttpRequest.newBuilder(uriBuilder.build())
            .header(HttpHeaders.CONTENT_TYPE, ConstantCodes.CONTENT_TYPE_VALUE)
            .headers(ConstantCodes.AUTHORIZATION_HEADER, ConstantCodes.TOKEN_NAME.concat(accessCredential.getAccessToken()))
            .build();

        return getRequestWrapped(request, ReportWrapper.class);
    }
}