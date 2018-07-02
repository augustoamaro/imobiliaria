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
public class Apartamento extends Imovel{
    
    int andar;

    public Apartamento(int andar, String matricula) {
        super(matricula);
        this.andar = andar;
    }

    @Override
    public String getDetalhe() {
        return "Matricula do Apartamento: "+this.getMatricula()+" andar: "+this.andar;

    }
    
}
