package com.nashLinks.NashLink.data.dtos.request;

import lombok.*;

import java.util.UUID;


@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EnlaceRequest {

    private String name;
    private String url;
    private String client_id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getClient_id() {
        return client_id;
    }

    public void setClient_id(String client_id) {
        this.client_id = client_id;
    }
}
