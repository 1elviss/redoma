package model.bean;

public class IndicesFillFactor {
    private String nomeDoBanco;
    private String nomeIndice;
    private int fillFactor;
    private String nomeTabela;

    public String getNomeDoBanco() {
        return nomeDoBanco;
    }

    public void setNomeDoBanco(String nomeDoBanco) {
        this.nomeDoBanco = nomeDoBanco;
    }

    public String getNomeIndice() {
        return nomeIndice;
    }

    public void setNomeIndice(String nomeIndice) {
        this.nomeIndice = nomeIndice;
    }

    public int getFillFactor() {
        return fillFactor;
    }

    public void setFillFactor(int fillFactor) {
        this.fillFactor = fillFactor;
    }

    public String getNomeTabela() {
        return nomeTabela;
    }

    public void setNomeTabela(String nomeTabela) {
        this.nomeTabela = nomeTabela;
    }
    
    public String cabecalho() {
        String cabecalhoTabela = String.format("|%-20s|%-30s|%-20s|%-20s|\n",
                "nomeDoBanco", "nomeIndice", "fillFactor", "nomeTabela");
        return cabecalhoTabela;
    }

    @Override
    public String toString() {
        String corpoTabela = String.format("|%-20s|%-30s|%-20s|%-20s|\n", nomeDoBanco,
                nomeIndice, fillFactor, nomeTabela);
        return corpoTabela;
    }
    
    
    
    
}