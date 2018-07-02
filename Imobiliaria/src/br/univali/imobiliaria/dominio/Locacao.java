/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univali.imobiliaria.dominio;

import br.univali.imobiliaria.dominio.imovel.Imovel;
import br.univali.imobiliaria.dominio.enuns.SituacaoLocacao;
import java.util.Date;

/**
 *
 * @author Guto
 */
public class Locacao{
    
    Imovel imovel;
    double valor;
    SituacaoLocacao situacao;
    Cliente cliente;
    String motivoCancelamento;
    
    private Date dataInicial;
    private Date dataFinal;

    public Locacao(Imovel imovel, double valor) {
        this.imovel = imovel;
        this.valor = valor;
        this.situacao = SituacaoLocacao.Aguardando;
    }

    public void alugar(Cliente cliente, double valor, Date dataInicial, Date dataFinal){
        this.valor = valor;
        this.cliente = cliente;
        this.situacao = SituacaoLocacao.Alugado;
        this.dataInicial = dataInicial;
        this.dataFinal = dataFinal;
    }
    
    public void finalizarLocacao(Date dataFinal){
        this.situacao = SituacaoLocacao.Finalizado;
        this.dataFinal = dataFinal;
    }
    
    public void cancelar(String motivo){
        this.situacao = SituacaoLocacao.Cancelado;
        this.motivoCancelamento = motivo;
    }    
    
    
}
