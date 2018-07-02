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
public class Terreno extends Imovel {
    
    double area;

    public Terreno(double area, String matricula) {
        super(matricula);
        this.area = area;
    }

    @Override
    public String getDetalhe() {
        return "Matricula do  Terreno: "+this.getMatricula()+" area: "+this.area;
    }
    
}
