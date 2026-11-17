package br.edu.catolica.ucb.poo.service;

import br.edu.catolica.ucb.poo.model.Pessoa;
import br.edu.catolica.ucb.poo.model.Morador;
import br.edu.catolica.ucb.poo.model.Funcionario;

import java.util.ArrayList;
import java.util.List;

public class ServicoPessoa {

    public void exibirDetalhes(Pessoa pessoa) {
        if (pessoa == null) {
            throw new IllegalArgumentException("Pessoa não pode ser nula.");
        }
        pessoa.exibirDetalhes();
    }

    public List<String> listarDetalhes(List<Pessoa> pessoas) {
        List<String> detalhes = new ArrayList<>();

        for (Pessoa pessoa : pessoas) {
            if (pessoa instanceof Morador morador) {
                detalhes.add("Morador: " + morador.getNome() + " | Apartamento: " + morador.getApartamento());
            } else if (pessoa instanceof Funcionario funcionario) {
                detalhes.add("Funcionario: " + funcionario.getNome() + " | Cargo: " + funcionario.getCargo());
            } else {
                detalhes.add("Pessoa: " + pessoa.getNome());
            }
        }

        return detalhes;
    }
}
