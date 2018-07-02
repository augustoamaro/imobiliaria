/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univali.imobiliaria.dominio.Exceptions;

/**
 *
 * @author Guto
 */
public class ImovelJaEstaAVendaException extends Exception {
    public ImovelJaEstaAVendaException(String matricula) {
        super("O imóvel com a matricula " + matricula + " já está a venda.");
    }
}
