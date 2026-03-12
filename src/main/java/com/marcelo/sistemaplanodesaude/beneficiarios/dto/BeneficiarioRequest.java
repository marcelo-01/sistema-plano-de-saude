package com.marcelo.sistemaplanodesaude.beneficiarios.dto;

import com.marcelo.sistemaplanodesaude.documentos.dto.DocumentoRequest;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class BeneficiarioRequest {

    @NotBlank(message = "Nome não pode estar em branco.")
    private String nome;
    @NotBlank(message = "Telefone não pode estar em branco.")
    private String telefone;
    @NotNull(message = "Data de nascimento não pode estar em branco.")
    private LocalDate dataNascimento;
    @NotEmpty(message = "Deve haver ao menos um documento.")
    private List<DocumentoRequest> documentos;
}
