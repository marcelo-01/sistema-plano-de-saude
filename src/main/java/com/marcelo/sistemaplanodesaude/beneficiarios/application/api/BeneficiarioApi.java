package com.marcelo.sistemaplanodesaude.beneficiarios.application.api;

import com.marcelo.sistemaplanodesaude.beneficiarios.dto.BeneficiarioRequest;
import com.marcelo.sistemaplanodesaude.beneficiarios.dto.BeneficiarioResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/public/beneficiario")
public interface BeneficiarioApi {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    BeneficiarioResponse postNovoBeneficiario(@RequestBody @Valid BeneficiarioRequest beneficiarioRequest);
}
