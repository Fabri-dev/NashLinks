package com.nashLinks.NashLink.data.dtos.response;

import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@Setter
@Getter
@Builder
public class EnlaceResponse {

    private Long id;
    private LocalDateTime timestamp;
    private LocalDateTime last_update;
    private String name;
    private String url;

    public EnlaceResponse() {}

}
