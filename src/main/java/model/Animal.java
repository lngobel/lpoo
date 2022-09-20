package model;

import java.util.ArrayList;
import java.util.List;

public class Animal {
    private String nome;
    private Integer idade;
    private String sexo;
    private Especie especie;
    private List<Tratamento> tratamentoList = new ArrayList<>();

    public Animal() {
    }

    public Animal(String nome, Integer idade, String sexo, Especie especie, List<Tratamento> tratamentoList) {
        this.nome = nome;
        this.idade = idade;
        this.sexo = sexo;
        this.especie = especie;
        this.tratamentoList = tratamentoList;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Especie getEspecie() {
        return especie;
    }

    public void setEspecie(Especie especie) {
        this.especie = especie;
    }

    public List<Tratamento> getTratamentoList() {
        return tratamentoList;
    }

    public void setTratamentoList(List<Tratamento> tratamentoList) {
        this.tratamentoList = tratamentoList;
    }

    @Override
    public String toString() {
        return "\nAnimal{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", sexo='" + sexo + '\'' +
                ", especie=" + especie +
                ", tratamentoList=" + tratamentoList +
                '}';
    }
}
