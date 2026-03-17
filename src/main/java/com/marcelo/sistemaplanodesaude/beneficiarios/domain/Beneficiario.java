package com.marcelo.sistemaplanodesaude.beneficiarios.domain;

import com.marcelo.sistemaplanodesaude.beneficiarios.dto.BeneficiarioAtualizaRequest;
import com.marcelo.sistemaplanodesaude.beneficiarios.dto.BeneficiarioRequest;
import com.marcelo.sistemaplanodesaude.documentos.domain.Documento;
import com.marcelo.sistemaplanodesaude.documentos.dto.DocumentoRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "beneficiarios")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Beneficiario {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(length = 100, nullable = false)
    private String nome;

    @Column(length = 11, nullable = false)
    private String telefone;

    @Column(name = "data_nascimento", nullable = false)
    private LocalDate dataNascimento;

    @Column(name = "data_inclusao", nullable = false)
    private LocalDate dataInclusao;

    @Column(name = "data_atualizacao", nullable = false)
    private LocalDate dataAtualizacao;

    @OneToMany(mappedBy = "beneficiario", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Documento> documentos = new ArrayList<>();

    public Beneficiario(BeneficiarioRequest beneficiarioRequest){
        this.nome = beneficiarioRequest.getNome();
        this.telefone = beneficiarioRequest.getTelefone();
        this.dataNascimento = beneficiarioRequest.getDataNascimento();
        this.dataInclusao = LocalDate.now();
        this.dataAtualizacao = LocalDate.now();
    }

    public void adicionarDocumento(DocumentoRequest documentoRequest){
        Documento documentoAdicionado = new Documento(documentoRequest, this);

        this.documentos.add(documentoAdicionado);
    }

    public void atualizaBeneficiario(BeneficiarioAtualizaRequest beneficiarioRequest){
        this.nome = beneficiarioRequest.getNome();
        this.telefone = beneficiarioRequest.getTelefone();
        this.dataNascimento = beneficiarioRequest.getDataNascimento();
        this.dataAtualizacao = LocalDate.now();
    }
}