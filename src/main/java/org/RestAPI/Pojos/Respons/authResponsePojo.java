package org.RestAPI.Pojos.Respons;

import java.util.LinkedHashMap;
import java.util.Map;

public class authResponsePojo {

    private String token;
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}