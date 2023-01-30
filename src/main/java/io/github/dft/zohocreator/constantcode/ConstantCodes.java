package io.github.dft.zohocreator.constantcode;

public interface ConstantCodes {

    String SLASH_CHARACTER = "/";
    String FORM_ENDPOINT = "/form";
    String CLIENT_ID = "client_id";
    String PATCH_REQUEST = "PATCH";
    String GRANT_TYPE = "grant_type";
    String REPORT_ENDPOINT = "/report";
    String TOKEN_NAME = "Zoho-oauthtoken ";
    String CLIENT_SECRET = "client_secret";
    String AUTHORIZATION_HEADER = "Authorization";
    String CONTENT_TYPE_VALUE = "application/json";
    String REFRESH_TOKEN = "refresh_token";

    String API_BASE_END_POINT = "https://creator.zoho.com/api/v2/";
    String OAUTH_BASE_END_POINT = "https://accounts.zoho.com/oauth/v2/token";

    int MAX_ATTEMPTS = 50;
    int TIME_OUT_DURATION = 3000;
    int TOO_MANY_REQUEST_EXCEPTION_CODE = 429;
}