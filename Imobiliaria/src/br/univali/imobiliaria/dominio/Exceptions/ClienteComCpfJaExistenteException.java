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
public class ClienteComCpfJaExistenteException extends Exception {
    public ClienteComCpfJaExistenteException(String documentoIdentificacaoCliente) {
        super("Já existe um cliente com o documento " + documentoIdentificacaoCliente + " cadastrado.");
    }
}
