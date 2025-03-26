package com.nashLinks.NashLink.data.dtos.request;

import lombok.*;



@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EnlaceRequest {

    private String name;
    private String url;

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
}
