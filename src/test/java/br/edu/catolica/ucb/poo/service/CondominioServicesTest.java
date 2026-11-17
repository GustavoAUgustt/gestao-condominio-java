package br.edu.catolica.ucb.poo.service;

import br.edu.catolica.ucb.poo.model.Morador;
import br.edu.catolica.ucb.poo.model.Pessoa;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ServicoMoradorTest {

    @Test
    void deveAdicionarEListarMoradores() {
        ServicoMorador servicoMorador = new ServicoMorador();
        Morador morador = new Morador("Maria Silva", "11122233344", "61900001111", "305", "B");

        servicoMorador.adicionarMorador(morador);

        List<Morador> moradores = servicoMorador.listarMoradores();
        assertEquals(1, moradores.size());
        assertEquals("Maria Silva", moradores.get(0).getNome());
    }
}

class ServicoCobrancaTest {

    @Test
    void deveLancarExcecaoParaValorInvalido() {
        ServicoCobranca servicoCobranca = new ServicoCobranca();

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> servicoCobranca.validarCobranca(BigDecimal.ZERO, "Taxa")
        );

        assertEquals("O valor da cobrança deve ser maior que zero.", exception.getMessage());
    }
}

class ServicoPessoaTest {

    @Test
    void deveExibirDetalhesPolimorficos() {
        ServicoPessoa servicoPessoa = new ServicoPessoa();
        Pessoa morador = new Morador("João", "22233344455", "61922223333", "102", "C");

        List<String> detalhes = servicoPessoa.listarDetalhes(List.of(morador));

        assertEquals(1, detalhes.size());
        assertEquals("Morador: João | Apartamento: 102", detalhes.get(0).substring(0, 28));
    }
}
