package com.marcelo.sistemaplanodesaude.beneficiarios.application.api;

import com.marcelo.sistemaplanodesaude.beneficiarios.application.service.BeneficiarioService;
import com.marcelo.sistemaplanodesaude.beneficiarios.dto.BeneficiarioRequest;
import com.marcelo.sistemaplanodesaude.beneficiarios.dto.BeneficiarioResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class BeneficiarioController implements BeneficiarioApi{

    private final BeneficiarioService beneficiarioService;

    @Override
    public BeneficiarioResponse postNovoBeneficiario(BeneficiarioRequest beneficiarioRequest){
        BeneficiarioResponse beneficiarioAdicionado = beneficiarioService.adicionarBeneficiario(beneficiarioRequest);
        return beneficiarioAdicionado;
    }
}
