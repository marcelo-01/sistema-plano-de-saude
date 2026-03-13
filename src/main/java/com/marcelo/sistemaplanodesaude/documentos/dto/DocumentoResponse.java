package com.marcelo.sistemaplanodesaude.documentos.dto;

import com.marcelo.sistemaplanodesaude.documentos.domain.Documento;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
public class DocumentoResponse {
    private UUID id;
    private String tipoDocumento;
    private String descricao;

    public DocumentoResponse(Documento documento) {
        this.id = documento.getId();
        this.tipoDocumento = documento.getTipoDocumento();
        this.descricao = documento.getDescricao();
    }
}
