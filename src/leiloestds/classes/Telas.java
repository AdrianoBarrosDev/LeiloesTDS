
package leiloestds.classes;

import leiloestds.telas.TelaCadastro;
import leiloestds.telas.TelaDefault;
import leiloestds.telas.TelaInicial;
import leiloestds.telas.TelaProdutos;
import leiloestds.telas.TelaVendas;

public class Telas {
    
    private final TelaDefault telaDefault;
    private final TelaInicial telaInicial;
    private final TelaCadastro telaCadastro;
    private final TelaProdutos telaProdutos;
    private final TelaVendas telaVendas;
    
    
    public Telas(ConfigFrame configFrame) {
        this.telaDefault = new TelaDefault(configFrame);
        this.telaInicial = new TelaInicial(configFrame);
        this.telaCadastro = new TelaCadastro(configFrame);
        this.telaProdutos = new TelaProdutos(configFrame);
        this.telaVendas = new TelaVendas(configFrame);
    }

    
    public TelaDefault getTelaDefault() {
        return telaDefault;
    }

    public TelaInicial getTelaInicial() {
        return telaInicial;
    }

    public TelaCadastro getTelaCadastro() {
        return telaCadastro;
    }

    public TelaProdutos getTelaProdutos() {
        return telaProdutos;
    }

    public TelaVendas getTelaVendas() {
        return telaVendas;
    }
    
}
