package br.edu.catolica.ucb.poo.model;

import br.edu.catolica.ucb.poo.interfaces.Notificavel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "moradores")
@PrimaryKeyJoinColumn(name = "pessoa_id")
public class Morador extends Pessoa implements Notificavel {

    @Column(name = "apartamento", nullable = false)
    private String apartamento;

    @Column(name = "bloco", nullable = false)
    private String bloco;

    @OneToMany(mappedBy = "morador")
    private List<Cobranca> cobrancas = new ArrayList<>();

    protected Morador() {
        super();
    }

    public Morador(String nome, String documento, String telefone, String apartamento, String bloco) {
        super(nome, documento, telefone);
        this.apartamento = apartamento;
        this.bloco = bloco;
    }

    public String getApartamento() {
        return apartamento;
    }

    public void setApartamento(String apartamento) {
        this.apartamento = apartamento;
    }

    public String getBloco() {
        return bloco;
    }

    public void setBloco(String bloco) {
        this.bloco = bloco;
    }

    public List<Cobranca> getCobrancas() {
        return cobrancas;
    }

    public void setCobrancas(List<Cobranca> cobrancas) {
        this.cobrancas = cobrancas;
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("Morador: " + getNome()
                + " | Apartamento: " + apartamento
                + " | Bloco: " + bloco
                + " | Documento: " + getDocumento());
    }

    @Override
    public void enviarNotificacao(String mensagem) {
        System.out.println("Notificação para o morador " + getNome() + ": " + mensagem);
    }
}
