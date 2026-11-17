package br.edu.catolica.ucb.poo.model;

import br.edu.catolica.ucb.poo.interfaces.Notificavel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "funcionarios")
@PrimaryKeyJoinColumn(name = "pessoa_id")
public class Funcionario extends Pessoa implements Notificavel {

    @Column(name = "cargo", nullable = false)
    private String cargo;

    @Column(name = "salario", nullable = false)
    private double salario;

    protected Funcionario() {
        super();
    }

    public Funcionario(String nome, String documento, String telefone, String cargo, double salario) {
        super(nome, documento, telefone);
        this.cargo = cargo;
        this.salario = salario;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("Funcionário: " + getNome()
                + " | Cargo: " + cargo
                + " | Salário: R$ " + salario
                + " | Documento: " + getDocumento());
    }

    @Override
    public void enviarNotificacao(String mensagem) {
        System.out.println("Notificação para o funcionário " + getNome() + ": " + mensagem);
    }
}
