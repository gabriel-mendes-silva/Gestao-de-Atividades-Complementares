package Model;

public class HoraPorAtividade {
    private String id;
    private String descricao;

    public HoraPorAtividade(String descricao){
        this.descricao = descricao;
    }

    public HoraPorAtividade(String descricao, String id){
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
