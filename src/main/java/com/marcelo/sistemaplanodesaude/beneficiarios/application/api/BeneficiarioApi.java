package com.marcelo.sistemaplanodesaude.beneficiarios.application.api;

import com.marcelo.sistemaplanodesaude.beneficiarios.dto.BeneficiarioAtualizaRequest;
import com.marcelo.sistemaplanodesaude.beneficiarios.dto.BeneficiarioDocumentoResponse;
import com.marcelo.sistemaplanodesaude.beneficiarios.dto.BeneficiarioRequest;
import com.marcelo.sistemaplanodesaude.beneficiarios.dto.BeneficiarioResponse;
import com.marcelo.sistemaplanodesaude.documentos.dto.DocumentoResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/public/beneficiario")
public interface BeneficiarioApi {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    BeneficiarioResponse postNovoBeneficiario(@RequestBody @Valid BeneficiarioRequest beneficiarioRequest);

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    List<BeneficiarioDocumentoResponse> listarUsuarios();

    @GetMapping("/documentos/{idBeneficiario}")
    List<DocumentoResponse> listarDocumentosPorBeneficiario(@PathVariable UUID idBeneficiario);

    @PatchMapping("/{idBeneficiario}")
    @ResponseStatus(HttpStatus.OK)
    BeneficiarioDocumentoResponse atualizarBeneficiario(@PathVariable UUID idBeneficiario,
                                                      @RequestBody @Valid BeneficiarioAtualizaRequest beneficiarioRequest);

    @DeleteMapping("/{idBeneficiario}")
    @ResponseStatus(HttpStatus.OK)
    void deletarBeneficiario(@PathVariable UUID idBeneficiario);
}
