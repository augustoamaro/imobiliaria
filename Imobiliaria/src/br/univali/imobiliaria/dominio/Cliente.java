/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univali.imobiliaria.dominio;

/**
 *
 * @author Guto
 */
public class Cliente implements Comparable<Cliente>{
    
    /**
     * Nome do Cliente
     */
    protected String nome;
    /**
     * CPF/CNPJ do Cliente
     */
    protected String documentoIdentificacao;

    public Cliente(String nome, String documentoIdentificacao) {
        this.nome = nome;
        this.documentoIdentificacao = documentoIdentificacao;
    }

    @Override
    public int compareTo(Cliente o) {
        return this.documentoIdentificacao.compareTo(o.documentoIdentificacao);
    }
    
}
