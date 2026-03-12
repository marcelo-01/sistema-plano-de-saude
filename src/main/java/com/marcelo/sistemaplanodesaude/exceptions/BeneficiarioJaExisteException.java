package com.marcelo.sistemaplanodesaude.exceptions;

public class BeneficiarioJaExisteException extends RuntimeException {

    public BeneficiarioJaExisteException() {
        super("Já existe um beneficiário cadastrado com esses dados.");
    }
}
