package com.nashLinks.NashLink.servicio;

import com.nashLinks.NashLink.data.domain.EnlaceEntidad;
import com.nashLinks.NashLink.data.dtos.request.EnlaceRequest;
import com.nashLinks.NashLink.data.dtos.response.EnlaceResponse;
import com.nashLinks.NashLink.data.mapper.EnlaceMapper;
import com.nashLinks.NashLink.data.repositorio.EnlaceRepositorio;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
public class EnlaceServicio {
    private final EnlaceRepositorio enlaceRepositorio;
    private final EnlaceMapper enlaceMapper;

    public EnlaceServicio(EnlaceRepositorio enlaceRepositorio, EnlaceMapper enlaceMapper) {
        this.enlaceRepositorio = enlaceRepositorio;
        this.enlaceMapper = enlaceMapper;

    }

    //crear

    public EnlaceResponse crearUnEnlace(EnlaceRequest enlaceRequest){

        EnlaceEntidad enlaceEntidadAGuardar = enlaceMapper.enlaceRequestToEntidad(enlaceRequest);

        EnlaceEntidad enlaceEntidadGuardada = enlaceRepositorio.save(enlaceEntidadAGuardar);

        return enlaceMapper.enlaceEntidadToResponse(enlaceEntidadGuardada);
    }

    //eliminar

    public Boolean eliminarUnEnlace(Long idEnlace){

        if (!enlaceRepositorio.existsById(idEnlace)){
            throw new EntityNotFoundException("Enlace con id: "+ idEnlace +" no encontrado");
        }

        enlaceRepositorio.deleteById(idEnlace);
        return Boolean.TRUE;
    }

    //obtener

    public Page<EnlaceResponse> getListadoDeEnlaces(Pageable page){
       return enlaceRepositorio.findAll(page)
                .map(enlaceMapper::enlaceEntidadToResponse);
    }

    public EnlaceResponse getUnEnlace(Long idEnlace){


        return enlaceMapper.enlaceEntidadToResponse(enlaceRepositorio.findById(idEnlace)
                .orElseThrow(()-> new EntityNotFoundException("Enlace con id: "+ idEnlace +" no encontrado"))
        );

    }

    //update

    public EnlaceResponse editarUnEnlace(Long idEnlace, EnlaceRequest enlaceRequest){

        EnlaceEntidad enlaceEntidad = enlaceRepositorio.findById(idEnlace)
                .orElseThrow(()-> new EntityNotFoundException("Enlace con id: "+ idEnlace +" no encontrado"));

        enlaceEntidad.setName(enlaceRequest.getName());
        enlaceEntidad.setUrl(enlaceRequest.getUrl());
        enlaceEntidad.setLast_update(LocalDateTime.now());

        return enlaceMapper.enlaceEntidadToResponse(enlaceRepositorio.save(enlaceEntidad));

    }


}
