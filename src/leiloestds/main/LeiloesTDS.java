
package leiloestds.main;

import leiloestds.classes.Fonts;
import leiloestds.classes.Manager;

public class LeiloesTDS {

    public static void main(String[] args) {
        
        // Inicializa as fontes
        Fonts fonts = new Fonts();
        
        // Inicializa o sistema
        Manager manager = new Manager();
        manager.iniciarSistema();
        
    }
    
}
