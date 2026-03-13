package com.marcelo.sistemaplanodesaude.exceptions;

public class BeneficiarioNaoExisteException extends RuntimeException {
    public BeneficiarioNaoExisteException() {
        super("Não existe um beneficiário com esse Id.");
    }
}
