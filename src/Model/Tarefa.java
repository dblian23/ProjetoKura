package model;

public class Tarefa {

//    private int id; // conferir se precisa ou se é alfgo que vai só no banco!
    private String titulo;
    private String descricao;
    private String materia;
    private String prioridade;
    private String dataCriacao;
    private String dataEntrega;
    private int usuarioId;

    public Tarefa() {}

    public Tarefa(String titulo, String descricao, String materia, String prioridade, String dataCriacao, String dataEntrega, int usuarioId) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.materia = materia;
        this.prioridade = prioridade;
        this.dataCriacao = dataCriacao;
        this.dataEntrega = dataEntrega;
        this.usuarioId = usuarioId;
    }

    // Get set

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

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public String getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(String prioridade) {
        this.prioridade = prioridade;
    }

    public String getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(String dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public String getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(String dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }
    
    
}
