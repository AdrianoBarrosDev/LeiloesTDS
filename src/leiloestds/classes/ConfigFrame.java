
package leiloestds.classes;

import javax.swing.JFrame;

public class ConfigFrame {

    private final Manager manager;
    private final JFrame mainFrame;
    
    public ConfigFrame(Manager manager) {
        this.manager = manager;
        
        mainFrame = new JFrame();
        mainFrame.setSize(600, 800);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        mainFrame.setUndecorated(true);
        mainFrame.setLayout(null);
        mainFrame.setVisible(true);
        
    }

    
    public Manager getManager() {
        return manager;
    }

    public JFrame getMainFrame() {
        return mainFrame;
    }
    
    
}
