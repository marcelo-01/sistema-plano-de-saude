package com.marcelo.sistemaplanodesaude.beneficiarios.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.marcelo.sistemaplanodesaude.beneficiarios.domain.Beneficiario;
import com.marcelo.sistemaplanodesaude.documentos.dto.DocumentoResponse;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@JsonPropertyOrder({"id", "nome", "telefone", "dataNascimento", "documentos"})
public class BeneficiarioDocumentoResponse {
    private UUID id;
    private String nome;
    private String telefone;
    private LocalDate dataNascimento;
    private List<DocumentoResponse> documentos;

    public BeneficiarioDocumentoResponse(Beneficiario beneficiario){
        this.id = beneficiario.getId();
        this.nome = beneficiario.getNome();
        this.telefone = beneficiario.getTelefone();
        this.dataNascimento = beneficiario.getDataNascimento();
        this.documentos = beneficiario.getDocumentos()
                .stream()
                .map(DocumentoResponse::new)
                .collect(Collectors.toList());
    }
}
