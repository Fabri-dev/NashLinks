package com.nashLinks.NashLink.data.repositorio;
import com.nashLinks.NashLink.data.domain.EnlaceEntidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface EnlaceRepositorio extends JpaRepository<EnlaceEntidad, UUID> {



}
