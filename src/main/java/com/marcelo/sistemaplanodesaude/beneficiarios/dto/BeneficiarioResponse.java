package com.marcelo.sistemaplanodesaude.beneficiarios.dto;

import com.marcelo.sistemaplanodesaude.beneficiarios.domain.Beneficiario;
import lombok.Data;

import java.util.UUID;

@Data
public class BeneficiarioResponse {
    private UUID id;
    private String nome;

    public BeneficiarioResponse(Beneficiario beneficiario){
        this.id = beneficiario.getId();
        this.nome = beneficiario.getNome();
    }
}
