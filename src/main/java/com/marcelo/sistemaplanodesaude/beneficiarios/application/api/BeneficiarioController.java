package com.marcelo.sistemaplanodesaude.beneficiarios.application.api;

import com.marcelo.sistemaplanodesaude.beneficiarios.application.service.BeneficiarioService;
import com.marcelo.sistemaplanodesaude.beneficiarios.dto.BeneficiarioAtualizaRequest;
import com.marcelo.sistemaplanodesaude.beneficiarios.dto.BeneficiarioDocumentoResponse;
import com.marcelo.sistemaplanodesaude.beneficiarios.dto.BeneficiarioRequest;
import com.marcelo.sistemaplanodesaude.beneficiarios.dto.BeneficiarioResponse;
import com.marcelo.sistemaplanodesaude.documentos.dto.DocumentoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class BeneficiarioController implements BeneficiarioApi{

    private final BeneficiarioService beneficiarioService;

    @Override
    public BeneficiarioResponse postNovoBeneficiario(BeneficiarioRequest beneficiarioRequest){
        BeneficiarioResponse beneficiarioAdicionado = beneficiarioService.adicionarBeneficiario(beneficiarioRequest);
        return beneficiarioAdicionado;
    }

    @Override
    public List<BeneficiarioDocumentoResponse> listarUsuarios() {
        return beneficiarioService.listarBeneficiarios();
    }

    @Override
    public List<DocumentoResponse> listarDocumentosPorBeneficiario(UUID idBeneficiario) {
        return beneficiarioService.listarDocumentosPorBeneficiario(idBeneficiario);
    }

    @Override
    public BeneficiarioDocumentoResponse atualizarBeneficiario(UUID idBeneficiario, BeneficiarioAtualizaRequest beneficiarioRequest) {
        return beneficiarioService.atualizarBeneficiario(idBeneficiario, beneficiarioRequest);
    }

    @Override
    public void deletarBeneficiario(UUID idBeneficiario) {
        beneficiarioService.deletarBeneficiairo(idBeneficiario);
    }
}
