
package leiloestds.classes;

public class Manager {

    private final ConfigFrame configFrame;
    private final Telas telas;
    private final Fonts fonts;
    
    public Manager() {
        this.configFrame = new ConfigFrame(this);
        this.telas = new Telas(configFrame);
        this.fonts = new Fonts();
        
    }

    
    public ConfigFrame getConfigFrame() {
        return configFrame;
    }

    public Telas getTelas() {
        return telas;
    }

    public Fonts getFonts() {
        return fonts;
    }
    
    
    public void iniciarSistema() {
        
        telas.getTelaDefault().configTelaDefault();
        telas.getTelaInicial().configTelaInicial();
        configFrame.getMainFrame().repaint();
        
    }
     
}
