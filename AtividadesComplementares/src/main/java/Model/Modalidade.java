package Model;

public class Modalidade {
    private String id;
    private String nome;
    private double porcentagemMaxima;

    public Modalidade(String nome, double porcentagemMaxima){
        this.nome = nome;
        this.id = "Indefinido";
        this.porcentagemMaxima = porcentagemMaxima;
    }

    public Modalidade(String nome, double porcentagemMaxima, String id){
        this.nome = nome;
        this.porcentagemMaxima = porcentagemMaxima;
        this.id = id;
    }

    public String nome(){
        return this.nome;
    }

    public String id(){
        return this.id;
    }

    public double porcentagemMaxima(){
        return this.porcentagemMaxima;
    }

}
