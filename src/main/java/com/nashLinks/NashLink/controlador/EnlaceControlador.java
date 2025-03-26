package com.nashLinks.NashLink.controlador;
import com.nashLinks.NashLink.data.dtos.request.EnlaceRequest;
import com.nashLinks.NashLink.data.dtos.response.EnlaceResponse;
import com.nashLinks.NashLink.servicio.EnlaceServicio;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/enlaces")
public class EnlaceControlador {

    private final EnlaceServicio enlaceServicio;

    public EnlaceControlador(EnlaceServicio enlaceServicio) {
        this.enlaceServicio = enlaceServicio;
    }




    @GetMapping()
    public ResponseEntity<Page<EnlaceResponse>> obtenerListadoDeEnlaces(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortBy
    ){
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        Page<EnlaceResponse> unaPage = enlaceServicio.getListadoDeEnlaces(pageable);
        return ResponseEntity.ok(unaPage);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnlaceResponse> obtenerUnEnlace(
            @PathVariable("id") Long idEnlace
    ){
        EnlaceResponse enlaceResponse = enlaceServicio.getUnEnlace(idEnlace);
        return ResponseEntity.ok(enlaceResponse);
    }

    @PostMapping()
    public ResponseEntity<EnlaceResponse> crearUnEnlace(
            @RequestBody EnlaceRequest enlaceRequest
    ){
        EnlaceResponse enlaceResponse= enlaceServicio.crearUnEnlace(enlaceRequest);
        return ResponseEntity.ok(enlaceResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> eliminarUnEnlace(
            @PathVariable("id") Long idEnlace
    ){
        Boolean enlaceEliminado = enlaceServicio.eliminarUnEnlace(idEnlace);
        return ResponseEntity.ok(enlaceEliminado);
    }

    @PutMapping("{id}")
    public ResponseEntity<EnlaceResponse> editarUnEnlace(
            @PathVariable("id") Long idEnlace,
            @RequestBody EnlaceRequest enlaceReq
    ){
        EnlaceResponse enlaceResponse = enlaceServicio.editarUnEnlace(idEnlace,enlaceReq);
        return ResponseEntity.ok(enlaceResponse);
    }

}
