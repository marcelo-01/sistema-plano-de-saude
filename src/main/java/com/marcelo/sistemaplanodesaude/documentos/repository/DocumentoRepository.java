package com.marcelo.sistemaplanodesaude.documentos.repository;

import com.marcelo.sistemaplanodesaude.documentos.domain.Documento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface DocumentoRepository extends JpaRepository<Documento, UUID> {

    List<Documento> findAllByBeneficiario_Id(UUID idBeneficiario);
}
