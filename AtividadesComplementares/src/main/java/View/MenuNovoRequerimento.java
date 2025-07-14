package View;

import Controller.NovoRequerimentoController;
import Model.Aluno;
import Model.Requerimento;
import Sessao.SessaoAtual;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class MenuNovoRequerimento implements ItemMenu{
    private NovoRequerimentoController novoRequerimentoController;
    private String nomeDoAluno;
    private String matricula;
    private String titulo;
    private Map<String,ItemMenu> idItensMenu;
    private SessaoAtual sessaoAtual;

    public MenuNovoRequerimento(String titulo, NovoRequerimentoController novoRequerimentoController) {
        this.titulo = titulo;
        this.idItensMenu = new HashMap<>();
        this.sessaoAtual = sessaoAtual;
        this.novoRequerimentoController = novoRequerimentoController;
    }
    @Override
    public String titulo() {
        return "Iniciar Requerimento";
    }

    @Override
    public void exibir() {
        System.out.println("========= Novo Requerimento ==========");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insira nome completo: ");
        String nome = scanner.nextLine();
        System.out.println("Insira matrícula: ");
        String matricula = scanner.nextLine();
        this.novoRequerimentoController.criarNovoRequerimento(nome,matricula);
        MenuRequerimento menuRequerimento = new MenuRequerimento("Requerimento",this.novoRequerimentoController);
        menuRequerimento.exibir();
    }

    public String matricula() {
        return matricula;
    }

    public String nomeDoAluno() {
        return nomeDoAluno;
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
