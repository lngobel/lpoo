package model;

import java.util.ArrayList;
import java.util.List;

public class Especie {
    private int id;
    private String nome;
    private List<Animal> animalList = new ArrayList<>();

    public Especie() {
    }

    public Especie(int id, String nome, List<Animal> animalList) {
        this.id = id;
        this.nome = nome;
        this.animalList = animalList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Animal> getAnimalList() {
        return animalList;
    }

    public void setAnimalList(List<Animal> animalList) {
        this.animalList = animalList;
    }

    @Override
    public String toString() {
        return "\nEspecie{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", animalList=" + animalList +
                '}';
    }
}
