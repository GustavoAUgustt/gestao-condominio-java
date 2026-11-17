package br.edu.catolica.ucb.poo.service;

import br.edu.catolica.ucb.poo.model.Cobranca;
import br.edu.catolica.ucb.poo.model.Morador;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ServicoCobranca {

    public void validarCobranca(BigDecimal valor, String descricao) {
        if (valor == null) {
            throw new IllegalArgumentException("O valor da cobrança não pode ser nulo.");
        }
        if (valor.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("O valor da cobrança deve ser maior que zero.");
        }
        if (descricao == null || descricao.isBlank()) {
            throw new IllegalArgumentException("A descrição da cobrança não pode estar vazia.");
        }
    }

    public Cobranca registrarCobranca(Morador morador, String descricao, BigDecimal valor) {
        try {
            validarCobranca(valor, descricao);
            Cobranca cobranca = new Cobranca(descricao, valor, LocalDate.now().plusDays(15), morador);
            System.out.println("Cobrança registrada com sucesso: " + cobranca);
            return cobranca;
        } catch (IllegalArgumentException e) {
            System.err.println("Erro ao registrar cobrança: " + e.getMessage());
            throw e;
        }
    }
}
