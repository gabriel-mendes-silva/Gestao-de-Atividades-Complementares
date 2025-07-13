package View;

import Model.Aluno;
import Model.Requerimento;
import Sessao.SessaoAtual;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class MenuNovoRequerimento implements ItemMenu{
    private String nomeDoAluno;
    private String matricula;
    private String titulo;
    private Map<String,ItemMenu> idItensMenu;
    private SessaoAtual sessaoAtual;

    public MenuNovoRequerimento(String titulo, SessaoAtual sessaoAtual) {
        this.titulo = titulo;
        this.idItensMenu = new HashMap<>();
        this.sessaoAtual = sessaoAtual;
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
        this.nomeDoAluno = scanner.nextLine();
        System.out.println("Insira matrícula: ");
        this.matricula = scanner.nextLine();
        Aluno aluno = new Aluno(nomeDoAluno,matricula);
        try {
            Requerimento requerimento = new Requerimento(String.valueOf(Math.random()*100),aluno);
            this.sessaoAtual.requerimentoAtual(requerimento);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        MenuRequerimento menuRequerimento = new MenuRequerimento("Requerimento",sessaoAtual);
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
