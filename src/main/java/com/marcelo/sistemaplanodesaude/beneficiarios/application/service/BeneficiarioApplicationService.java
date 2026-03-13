package com.marcelo.sistemaplanodesaude.beneficiarios.application.service;

import com.marcelo.sistemaplanodesaude.beneficiarios.application.repository.BeneficiarioRepository;
import com.marcelo.sistemaplanodesaude.beneficiarios.domain.Beneficiario;
import com.marcelo.sistemaplanodesaude.beneficiarios.dto.BeneficiarioListResponse;
import com.marcelo.sistemaplanodesaude.beneficiarios.dto.BeneficiarioRequest;
import com.marcelo.sistemaplanodesaude.beneficiarios.dto.BeneficiarioResponse;
import com.marcelo.sistemaplanodesaude.documentos.domain.Documento;
import com.marcelo.sistemaplanodesaude.documentos.dto.DocumentoResponse;
import com.marcelo.sistemaplanodesaude.documentos.repository.DocumentoRepository;
import com.marcelo.sistemaplanodesaude.exceptions.BeneficiarioJaExisteException;
import com.marcelo.sistemaplanodesaude.exceptions.BeneficiarioNaoExisteException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BeneficiarioApplicationService implements BeneficiarioService{

    private final BeneficiarioRepository beneficiarioRepository;
    private final DocumentoRepository documentoRepository;

    @Override
    public BeneficiarioResponse adicionarBeneficiario(BeneficiarioRequest beneficiarioRequest){
        boolean beneficiarioJaExiste = beneficiarioRepository.existsByNomeAndTelefone(
                beneficiarioRequest.getNome(),
                beneficiarioRequest.getTelefone()
        );
        if (beneficiarioJaExiste){
            throw new BeneficiarioJaExisteException();
        }

        Beneficiario beneficiarioAdicionado = new Beneficiario(beneficiarioRequest);
        beneficiarioRequest.getDocumentos().forEach(beneficiarioAdicionado::adicionarDocumento);

        beneficiarioRepository.save(beneficiarioAdicionado);
        return new BeneficiarioResponse(beneficiarioAdicionado);
    }

    @Override
    public List<BeneficiarioListResponse> listarBeneficiarios() {
        List<Beneficiario> beneficiarios = beneficiarioRepository.findAll();

        List<BeneficiarioListResponse> beneficiarioListResponses = beneficiarios
                .stream()
                .map(BeneficiarioListResponse::new)
                .collect(Collectors.toList());

        return beneficiarioListResponses;
    }

    @Override
    public List<DocumentoResponse> listarDocumentosPorBeneficiario(UUID idBeneficiario) {
        beneficiarioRepository.findById(idBeneficiario)
                .orElseThrow(() -> new BeneficiarioNaoExisteException());

        List<Documento> documentos = documentoRepository.findAllByBeneficiario_Id(idBeneficiario);
        List<DocumentoResponse> documentoResponses = documentos
                .stream()
                .map(DocumentoResponse::new)
                .collect(Collectors.toList());

        return documentoResponses;
    }

}