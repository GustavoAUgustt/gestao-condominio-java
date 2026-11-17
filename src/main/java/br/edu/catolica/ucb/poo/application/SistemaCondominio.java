package br.edu.catolica.ucb.poo.application;

import br.edu.catolica.ucb.poo.model.Cobranca;
import br.edu.catolica.ucb.poo.model.Funcionario;
import br.edu.catolica.ucb.poo.model.Morador;
import br.edu.catolica.ucb.poo.model.Pessoa;
import br.edu.catolica.ucb.poo.service.ServicoCobranca;
import br.edu.catolica.ucb.poo.service.ServicoMorador;
import br.edu.catolica.ucb.poo.service.ServicoPessoa;
import br.edu.catolica.ucb.poo.util.JpaUtil;
import jakarta.persistence.EntityManager;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class SistemaCondominio {

    public static void main(String[] args) {
        ServicoMorador servicoMorador = new ServicoMorador();
        Morador morador = new Morador("Ana Souza", "12345678900", "61988887777", "201", "A");
        Funcionario funcionario = new Funcionario("Carlos Lima", "98765432100", "61999990000", "Sindico", 4200.00);

        servicoMorador.adicionarMorador(morador);

        List<Pessoa> pessoas = new ArrayList<>();
        pessoas.add(morador);
        pessoas.add(funcionario);

        ServicoPessoa servicoPessoa = new ServicoPessoa();
        for (Pessoa pessoa : pessoas) {
            servicoPessoa.exibirDetalhes(pessoa);
        }

        morador.enviarNotificacao("Sua taxa condominial foi atualizada.");
        funcionario.enviarNotificacao("Reunião de condomínio marcada para sexta-feira.");

        ServicoCobranca servicoCobranca = new ServicoCobranca();
        try {
            servicoCobranca.registrarCobranca(morador, "Taxa de condomínio", new BigDecimal("350.00"));
        } catch (IllegalArgumentException e) {
            System.out.println("Cobrança inválida: " + e.getMessage());
        }

        try {
            servicoCobranca.registrarCobranca(morador, "Cobrança inválida", new BigDecimal("0.00"));
        } catch (IllegalArgumentException e) {
            System.out.println("Cobrança inválida: " + e.getMessage());
        }

        EntityManager entityManager = JpaUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(morador);
        entityManager.persist(funcionario);
        entityManager.persist(new Cobranca("Taxa condominial", new BigDecimal("350.00"), java.time.LocalDate.now().plusDays(10), morador));
        entityManager.getTransaction().commit();
        entityManager.close();

        System.out.println("Total de moradores cadastrados: " + servicoMorador.totalMoradores());
    }
}
