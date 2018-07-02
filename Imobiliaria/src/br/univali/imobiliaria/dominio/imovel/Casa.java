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
public class Casa extends Imovel {
    
    boolean alvenaria;

    public Casa(boolean alvenaria, String matricula) {
        super(matricula);
        this.alvenaria = alvenaria;
    }
    
    @Override
    public String getDetalhe() {
        return "Matricula da Casa: "+this.getMatricula()+" alvenaria: "+(this.alvenaria?"sim":"não");
    }
    
}
