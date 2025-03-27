package com.nashLinks.NashLink.data.mapper;


import com.nashLinks.NashLink.data.domain.EnlaceEntidad;
import com.nashLinks.NashLink.data.dtos.request.EnlaceRequest;
import com.nashLinks.NashLink.data.dtos.response.EnlaceResponse;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneId;

@Component
public class EnlaceMapper {

    public EnlaceEntidad enlaceRequestToEntidad(EnlaceRequest enlaceRequest){

        return EnlaceEntidad.builder()
                .url(enlaceRequest.getUrl())
                .last_update(LocalDateTime.now(ZoneId.of("America/Argentina/Buenos_Aires")))
                .timestamp(LocalDateTime.now(ZoneId.of("America/Argentina/Buenos_Aires")))
                .client_id(enlaceRequest.getClient_id())
                .name(enlaceRequest.getName())
                .build();
    }

    public EnlaceResponse enlaceEntidadToResponse(EnlaceEntidad enlaceEntidad){
        return EnlaceResponse.builder()
                .id(enlaceEntidad.getId())
                .last_update(enlaceEntidad.getLast_update())
                .name(enlaceEntidad.getName())
                .timestamp(enlaceEntidad.getTimestamp())
                .url(enlaceEntidad.getUrl())
                .client_id(enlaceEntidad.getClient_id())
                .build();
    }



}
