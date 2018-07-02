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
public class ImovelComMatriculaJaExistenteException extends Exception {
    public ImovelComMatriculaJaExistenteException(String matricula) {
        super("Já existe um imóvel com a matricula " + matricula + " informada.");
    }
}
