package com.marcelo.sistemaplanodesaude.beneficiarios.application.service;

import com.marcelo.sistemaplanodesaude.beneficiarios.domain.Beneficiario;
import com.marcelo.sistemaplanodesaude.beneficiarios.dto.BeneficiarioListResponse;
import com.marcelo.sistemaplanodesaude.beneficiarios.dto.BeneficiarioRequest;
import com.marcelo.sistemaplanodesaude.beneficiarios.dto.BeneficiarioResponse;

import java.util.List;

public interface BeneficiarioService {

    BeneficiarioResponse adicionarBeneficiario(BeneficiarioRequest beneficiarioRequest);

    List<BeneficiarioListResponse> listarBeneficiarios();
}
