package Model;

public class Checklist {
    
    private boolean feito;
    private String descriçao;
    private int id;

    public Checklist(boolean feito, String descriçao, int id) {
        this.feito = feito;
        this.descriçao = descriçao;
        this.id = id;
    }

    public boolean isFeito() {
        return feito;
    }

    public void setFeito(boolean feito) {
        this.feito = feito;
    }

    public String getDescriçao() {
        return descriçao;
    }

    public void setDescriçao(String descriçao) {
        this.descriçao = descriçao;
    }
    
    
    
}
