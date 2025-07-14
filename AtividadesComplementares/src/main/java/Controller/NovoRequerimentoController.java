package Controller;

import Model.Aluno;
import Model.Requerimento;
import Repositorio.RequerimentoPg;

public class NovoRequerimentoController {
    private RequerimentoPg requerimentoPg;
    private Requerimento requerimento;

    public NovoRequerimentoController(){

    }

    public void criarNovoRequerimento(String nome, String matricula){
        Aluno aluno = new Aluno(nome,matricula);
        this.requerimento = new Requerimento(aluno);
        //this.requerimentoPg.inserir(requerimento);
    }
    
    public void adicionarAtividade(){
        
    }

    public String numeroRequerimento(){
        return this.requerimento.numero();
    }

    public int numeroDeAtividades(){
        return this.requerimento.getAtividadesDeclarada().size();
    }
}
