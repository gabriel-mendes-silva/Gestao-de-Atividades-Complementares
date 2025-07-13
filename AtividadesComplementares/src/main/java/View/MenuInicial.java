package View;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MenuInicial implements ItemMenu {
    private String titulo;
    private Map<String,ItemMenu> idItensMenu;

    public MenuInicial(String titulo) {
        this.titulo = titulo;
        this.idItensMenu = new HashMap<>();
    }

    public void adicionarMenu(ItemMenu itemMenu, String numero){
        this.idItensMenu.put(numero, itemMenu);
    }

    @Override
    public String titulo() {
        return "======== Menu Inicial =======";
    }

    public void exibir(){
        // exibir todos os itens de menu
    }
}
