package com.marcelo.sistemaplanodesaude.beneficiarios.application.service;

import com.marcelo.sistemaplanodesaude.beneficiarios.dto.BeneficiarioAtualizaRequest;
import com.marcelo.sistemaplanodesaude.beneficiarios.dto.BeneficiarioDocumentoResponse;
import com.marcelo.sistemaplanodesaude.beneficiarios.dto.BeneficiarioRequest;
import com.marcelo.sistemaplanodesaude.beneficiarios.dto.BeneficiarioResponse;
import com.marcelo.sistemaplanodesaude.documentos.dto.DocumentoResponse;

import java.util.List;
import java.util.UUID;

public interface BeneficiarioService {

    BeneficiarioResponse adicionarBeneficiario(BeneficiarioRequest beneficiarioRequest);

    List<BeneficiarioDocumentoResponse> listarBeneficiarios();

    List<DocumentoResponse> listarDocumentosPorBeneficiario(UUID idBeneficiario);

    BeneficiarioDocumentoResponse atualizarBeneficiario(UUID idBeneficiario, BeneficiarioAtualizaRequest beneficiarioRequest);
}
