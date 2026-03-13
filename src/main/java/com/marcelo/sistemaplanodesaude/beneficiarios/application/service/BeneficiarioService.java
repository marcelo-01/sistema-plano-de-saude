package com.marcelo.sistemaplanodesaude.beneficiarios.application.service;

import com.marcelo.sistemaplanodesaude.beneficiarios.domain.Beneficiario;
import com.marcelo.sistemaplanodesaude.beneficiarios.dto.BeneficiarioListResponse;
import com.marcelo.sistemaplanodesaude.beneficiarios.dto.BeneficiarioRequest;
import com.marcelo.sistemaplanodesaude.beneficiarios.dto.BeneficiarioResponse;
import com.marcelo.sistemaplanodesaude.documentos.dto.DocumentoResponse;

import java.util.List;
import java.util.UUID;

public interface BeneficiarioService {

    BeneficiarioResponse adicionarBeneficiario(BeneficiarioRequest beneficiarioRequest);

    List<BeneficiarioListResponse> listarBeneficiarios();

    List<DocumentoResponse> listarDocumentosPorBeneficiario(UUID idBeneficiario);
}
