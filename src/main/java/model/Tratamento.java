package model;

import java.util.Date;

public class Tratamento {
    private int id;
    private Date dataInicial;
    private Date dataFinal;
    private String resumo;
    private Animal animal;

    public Tratamento() {
    }

    public Tratamento(int id, Date dataInicial, Date dataFinal, String resumo, Animal animal) {
        this.id = id;
        this.dataInicial = dataInicial;
        this.dataFinal = dataFinal;
        this.resumo = resumo;
        this.animal = animal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(Date dataInicial) {
        this.dataInicial = dataInicial;
    }

    public Date getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(Date dataFinal) {
        this.dataFinal = dataFinal;
    }

    public String getResumo() {
        return resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    @Override
    public String toString() {
        return "\nTratamento{" +
                "id=" + id +
                ", dataInicial=" + dataInicial +
                ", dataFinal=" + dataFinal +
                ", resumo='" + resumo + '\'' +
                ", animal=" + animal +
                '}';
    }
}
