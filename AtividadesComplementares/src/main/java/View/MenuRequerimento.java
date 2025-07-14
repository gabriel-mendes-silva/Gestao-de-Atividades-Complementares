package View;

import Controller.NovoRequerimentoController;
import Sessao.SessaoAtual;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MenuRequerimento implements ItemMenu{
    private NovoRequerimentoController novoRequerimentoController;
    private String titulo;
    private Map<String,ItemMenu> idItensMenu;

    public MenuRequerimento(String titulo, NovoRequerimentoController novoRequerimentoController) {
        this.titulo = titulo;
        this.novoRequerimentoController = novoRequerimentoController;
        this.idItensMenu = new HashMap<>();
    }
    @Override
    public String titulo() {
        return this.titulo;
    }

    @Override
    public void exibir() {
        System.out.println("========= Requerimento Nº " + this.novoRequerimentoController.numeroRequerimento() + " ==========\n");
        System.out.println("Atividades Complementares Declaradas: " + this.novoRequerimentoController.numeroDeAtividades() + "\n");
        System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - \n");
        for (String idItem : this.idItensMenu.keySet()) {
            System.out.println(
                    idItem + ") " +
                            this.idItensMenu.get(idItem).titulo()
            );
        }
        System.out.println("Escolha a opção (0 - Sair):");
        this.buscarItemMenuPorNumero();
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
