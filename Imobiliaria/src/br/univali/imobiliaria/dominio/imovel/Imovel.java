/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univali.imobiliaria.dominio.imovel;

/**
 *
 * @author 1978233
 */
public abstract class Imovel implements Comparable<Imovel>{
    String matricula;

    public Imovel(String matricula) {
        this.matricula = matricula;
    }

    public String getMatricula() {
        return matricula;
    }
    
    public abstract String getDetalhe();
    
    @Override
    public int compareTo(Imovel o) {
        return this.matricula.compareToIgnoreCase(o.matricula);
    }

    @Override
    public String toString() {
        return getDetalhe();
    }
    
    
    
}
