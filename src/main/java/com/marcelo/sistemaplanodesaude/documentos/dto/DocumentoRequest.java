package com.marcelo.sistemaplanodesaude.documentos.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class DocumentoRequest {

    @NotBlank(message = "Tipo do documento não pode estar em branco!")
    private String tipoDocumento;
    @NotBlank(message = "Descrição não pode estar em branco!")
    private String descricao;
}
