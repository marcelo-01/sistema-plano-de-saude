package com.marcelo.sistemaplanodesaude.documentos.domain;

import com.marcelo.sistemaplanodesaude.beneficiarios.domain.Beneficiario;
import com.marcelo.sistemaplanodesaude.documentos.dto.DocumentoRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "documento")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Documento {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "tipo_documento",length = 100, nullable = false)
    private String tipoDocumento;

    @Column(length = 255, nullable = false)
    private String descricao;

    @Column(name = "data_inclusao", nullable = false)
    private LocalDate dataInclusao;

    @Column(name = "data_atualizacao", nullable = false)
    private LocalDate dataAtualizacao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_beneficiario", referencedColumnName = "id", nullable = false)
    private Beneficiario beneficiario;

    public Documento(DocumentoRequest documentoRequest, Beneficiario beneficiario) {
        this.tipoDocumento = documentoRequest.getTipoDocumento();
        this.descricao = documentoRequest.getDescricao();
        this.dataInclusao = LocalDate.now();
        this.dataAtualizacao = LocalDate.now();
        this.beneficiario = beneficiario;
    }
}
