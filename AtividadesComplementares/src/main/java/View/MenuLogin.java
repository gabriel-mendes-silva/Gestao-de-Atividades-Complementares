package View;

import Model.Aluno;
import Model.RepositorioDeAlunos;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MenuLogin implements ItemMenu{
    private RepositorioDeAlunos repositorioDeAlunos;

    private String titulo;
    private Map<String,ItemMenu> idItensMenu;

    public MenuLogin(String titulo, RepositorioDeAlunos repositorioDeAlunos) {
        this.titulo = titulo;
        this.idItensMenu = new HashMap<>();
        this.repositorioDeAlunos = repositorioDeAlunos;
    }

    @Override
    public String titulo() {
        return "======== Menu de Login ========";
    }

    @Override
    public void exibir() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insira nome completo: ");
        String nome = scanner.nextLine();
        System.out.println("Insira matrícula: ");
        String matricula = scanner.nextLine();
        this.autenticar(new Aluno(nome,matricula));
    }

    public Aluno autenticar(Aluno aluno){

    }

    public void adicionarItemMenu(ItemMenu itemMenu, String numero){
        this.idItensMenu.put(numero,itemMenu);
    }

    public ItemMenu buscarItemMenuPorNumero(){
        Scanner scanner = new Scanner(System.in);
        String numero = scanner.nextLine().trim();
        return this.idItensMenu.get(numero);
    }
}
