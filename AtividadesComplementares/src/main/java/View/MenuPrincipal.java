package View;

import Sessao.SessaoAtual;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MenuPrincipal implements ItemMenu{
    private String titulo;
    private Map<String,ItemMenu> idItensMenu;

    public MenuPrincipal(String titulo) {
        this.titulo = titulo;
        this.idItensMenu = new HashMap<>();
    }
    @Override
    public String titulo() {
        return this.titulo;
    }

    @Override
    public void exibir() {
        System.out.println("======== Gestão de Atividades Complementares ========");
        for (String idItem : this.idItensMenu.keySet()) {
            System.out.println(
                    idItem + ") " +
                    this.idItensMenu.get(idItem).titulo()
            );
        }
        System.out.println("Escolha a opção (0 - Sair):");
        Scanner scanner = new Scanner(System.in);
        this.buscarItemMenuPorNumero().exibir();
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

