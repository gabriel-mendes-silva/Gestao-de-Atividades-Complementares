package Model;

public class Documentacao {
    private String id;
    private String descricao;

    public Documentacao(String descricao){
        this.descricao = descricao;
    }

    public Documentacao(String descricao, String id){
        this.descricao = descricao;
        this.id = id;
    }

    public String descricao(){
        return this.descricao;
    }

    public String id(){
        return this.id;
    }
}
