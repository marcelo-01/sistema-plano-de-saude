package com.marcelo.sistemaplanodesaude.beneficiarios.application.repository;

import com.marcelo.sistemaplanodesaude.beneficiarios.domain.Beneficiario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BeneficiarioRepository extends JpaRepository<Beneficiario, UUID> {

    boolean existsByNomeAndTelefone(
            String nome,
            String telefone
    );
}
