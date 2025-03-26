package com.nashLinks.NashLink.data.domain;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "enlaces")
@Getter
@Setter
@Builder
@AllArgsConstructor
public class EnlaceEntidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime timestamp;

    private LocalDateTime last_update;

    private String name;

    private String url;

    public EnlaceEntidad() {}

}
