package br.edu.catolica.ucb.poo.service;

import br.edu.catolica.ucb.poo.model.Morador;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ServicoMorador {

    private final List<Morador> moradores = new ArrayList<>();

    public void adicionarMorador(Morador morador) {
        if (morador == null) {
            throw new IllegalArgumentException("Morador não pode ser nulo.");
        }
        moradores.add(morador);
    }

    public List<Morador> listarMoradores() {
        return Collections.unmodifiableList(moradores);
    }

    public int totalMoradores() {
        return moradores.size();
    }
}
