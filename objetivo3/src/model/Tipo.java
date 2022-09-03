package model;

public enum Tipo {
    ATENDIDO, PENDENTE, CANCELADO;

    private String tipo;

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
