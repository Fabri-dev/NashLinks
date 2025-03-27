package com.nashLinks.NashLink.data.dtos.response;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@Setter
@Getter
@Builder
public class EnlaceResponse {

    private UUID id;
    private LocalDateTime timestamp;
    private LocalDateTime last_update;
    private String client_id;
    private String name;
    private String url;


    public EnlaceResponse() {}

}
