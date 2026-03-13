package com.marcelo.sistemaplanodesaude.beneficiarios.application.api;

import com.marcelo.sistemaplanodesaude.beneficiarios.domain.Beneficiario;
import com.marcelo.sistemaplanodesaude.beneficiarios.dto.BeneficiarioListResponse;
import com.marcelo.sistemaplanodesaude.beneficiarios.dto.BeneficiarioRequest;
import com.marcelo.sistemaplanodesaude.beneficiarios.dto.BeneficiarioResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/public/beneficiario")
public interface BeneficiarioApi {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    BeneficiarioResponse postNovoBeneficiario(@RequestBody @Valid BeneficiarioRequest beneficiarioRequest);

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    List<BeneficiarioListResponse> listarUsuarios();
}
