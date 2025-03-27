package com.nashLinks.NashLink.data.domain;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "enlaces")
@Getter
@Setter
@Builder
@AllArgsConstructor
public class EnlaceEntidad {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private LocalDateTime timestamp;

    private LocalDateTime last_update;

    private String client_id;

    private String name;

    private String url;

    public EnlaceEntidad() {}

}
