package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class RepositorioDeAlunos {
    private List<Aluno> alunos;

    public RepositorioDeAlunos() {
        this.alunos = new ArrayList<>();
    }

    public void adicionarAluno(Aluno aluno){
        this.alunos.add(aluno);
    }

    public Aluno buscarAlunoPorMatricula(String matricula){
        for (Aluno aluno:this.alunos) {
            if(aluno.matricula().equals(matricula)){
                return aluno;
            }
            else{
                throw new NoSuchElementException("Não foi encontrado aluno com essa matrícula!");
            }
        }
        return new Aluno("Not found","0");
    }
}
