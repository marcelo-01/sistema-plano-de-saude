package com.marcelo.sistemaplanodesaude.beneficiarios.application.service;

import com.marcelo.sistemaplanodesaude.beneficiarios.dto.BeneficiarioRequest;
import com.marcelo.sistemaplanodesaude.beneficiarios.dto.BeneficiarioResponse;

public interface BeneficiarioService {

    BeneficiarioResponse adicionarBeneficiario(BeneficiarioRequest beneficiarioRequest);
}
