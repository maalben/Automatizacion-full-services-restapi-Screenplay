package co.com.practice.utils.resource;

import co.com.practice.utils.constants.Endpoints;

public enum WebServiceEndPoints {
    URI(Endpoints.URL_USERS);

    private final String url;

    WebServiceEndPoints(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
