/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

/**
 *
 * @author elvis
 */
public class TabelasHeap {

    private String nomeTabela;
    private String tipoCluster;
    private int chaveUnica;
    private int chavePrimaria;

    public String getNomeTabela() {
        return nomeTabela;
    }

    public void setNomeTabela(String nomeTabela) {
        this.nomeTabela = nomeTabela;
    }

    public String getTipoCluster() {
        return tipoCluster;
    }

    public void setTipoCluster(String tipoCluster) {
        this.tipoCluster = tipoCluster;
    }

    public int getChaveUnica() {
        return chaveUnica;
    }

    public void setChaveUnica(int chaveUnica) {
        this.chaveUnica = chaveUnica;
    }

    public int getChavePrimaria() {
        return chavePrimaria;
    }

    public void setChavePrimaria(int chavePrimaria) {
        this.chavePrimaria = chavePrimaria;
    }
    
    public String cabecalho() {
        String cabecalhoTabela = String.format("|%-20s|%-30s|%-20s|%-20s|\n",
                "nomeTabela", "tipoCluster", "chaveUnica", "chavePrimaria");
        return cabecalhoTabela;
    }

    @Override
    public String toString() {
        String corpoTabela = String.format("|%-20s|%-30s|%-20s|%-20s|\n", nomeTabela,
                tipoCluster, chaveUnica, chavePrimaria);
        return corpoTabela;
    }
    
    

}
