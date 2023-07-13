package main.java.model;

public abstract class Registro {
    protected String nome;
    protected String email;
    protected String id;
    protected boolean sexo;

    public Registro() {
    }

    public Registro(String nome, String email, boolean sexo) {
        this.nome = nome;
        this.email = email;
        this.sexo = sexo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public abstract String toString();

    public void setSexo(boolean sexo) {
        this.sexo = sexo;
    }

    public String getSexo() {
        if (this.sexo) {
            return "Masculino";
        }
        return "Feminino";
    }

}
