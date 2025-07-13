package Model;

public class Aluno {
    private String id;
    private String nome;
    private String matricula;

    public Aluno(String nome, String matricula){
        this.nome = nome;
        this.matricula = matricula;
        this.id = "Indefinido";
    }

    //Usado pelo banco de dados;
    public Aluno(String nome, String matricula, String id){
        this.nome = nome;
        this.matricula = matricula;
        this.id = id;
    }

    public String nome(){
        return this.nome;
    }

    public String matricula(){
        return this.matricula;
    }
    @Deprecated
    public void definirId(String id){
        this.id = id;
    }
}
