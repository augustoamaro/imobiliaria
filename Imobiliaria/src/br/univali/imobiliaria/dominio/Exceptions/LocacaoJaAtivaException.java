/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univali.imobiliaria.dominio.Exceptions;

import br.univali.imobiliaria.dominio.imovel.Imovel;

/**
 *
 * @author Guto
 */
public class LocacaoJaAtivaException extends Exception {
    public LocacaoJaAtivaException(Imovel imovel) {
        super("Não é possível cancelar a locacao do imovel com a matricula " + imovel.getMatricula() + ", pois o mesmo já possui uma locacao ativa.");
    }
}
