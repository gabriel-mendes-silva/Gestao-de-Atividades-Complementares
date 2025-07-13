package View;

import Sessao.SessaoAtual;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MenuEnsino implements ItemMenu{
    private String titulo;
    private Map<String,ItemMenu> idItensMenu;
    private SessaoAtual sessaoAtual;

    public MenuEnsino(String titulo, SessaoAtual sessaoAtual) {
        this.titulo = titulo;
        this.idItensMenu = new HashMap<>();
        this.sessaoAtual = sessaoAtual;
    }
    @Override
    public String titulo() {
        return this.titulo;
    }

    @Override
    public void exibir() {
        System.out.println("========= Modalidade ==========");
        Scanner scanner = new Scanner(System.in);
        for (String idItem : this.idItensMenu.keySet()) {
            System.out.println(
                    idItem + ") " +
                            this.idItensMenu.get(idItem).titulo()
            );
        }
        System.out.println("Escolha a opção (0 - Sair):");

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
