package com.marcelo.sistemaplanodesaude.beneficiarios.application.service;

import com.marcelo.sistemaplanodesaude.beneficiarios.application.repository.BeneficiarioRepository;
import com.marcelo.sistemaplanodesaude.beneficiarios.domain.Beneficiario;
import com.marcelo.sistemaplanodesaude.beneficiarios.dto.BeneficiarioRequest;
import com.marcelo.sistemaplanodesaude.beneficiarios.dto.BeneficiarioResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BeneficiarioApplicationService implements BeneficiarioService{

    private final BeneficiarioRepository beneficiarioRepository;

    @Override
    public BeneficiarioResponse adicionarBeneficiario(BeneficiarioRequest beneficiarioRequest){
        Beneficiario beneficiarioAdicionado = new Beneficiario(beneficiarioRequest);
        beneficiarioRequest.getDocumentos().forEach(beneficiarioAdicionado::adicionarDocumento);

        beneficiarioRepository.save(beneficiarioAdicionado);
        return new BeneficiarioResponse(beneficiarioAdicionado);
    }
}

