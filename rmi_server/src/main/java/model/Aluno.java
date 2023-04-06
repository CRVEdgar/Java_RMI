package model;

import java.io.Serializable;

public class Aluno implements Serializable {

    private int id;
    private String nome;
    private String curso;
    private String matricula;

    public Aluno(int id, String nome, String curso, String matricula) {

        this.id = id;
        this.nome = nome;
        this.curso = curso;
        this.matricula = matricula;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCurso() {
        return curso;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", curso='" + curso + '\'' +
                ", matricula='" + matricula + '\'' +
                '}';
    }

}
