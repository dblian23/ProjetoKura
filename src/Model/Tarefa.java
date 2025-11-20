package Model;

import java.util.Date;

public class Tarefa {

private int id;
private String titulo;
private String descricao;
private Date dtcriacao;
private Date dtfinalizacao;

    public Tarefa(int id, String titulo, String descricao, Date dtcriacao, Date dtfinalizacao) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.dtcriacao = dtcriacao;
        this.dtfinalizacao = dtfinalizacao;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }


}
