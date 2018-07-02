/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univali.imobiliaria.dominio;

import br.univali.imobiliaria.dominio.imovel.Imovel;
import br.univali.imobiliaria.dominio.enuns.SituacaoVenda;
import java.util.Date;

/**
 *
 * @author Guto
 */
public class Venda{
    Imovel imovel;
    double valor;
    SituacaoVenda situacao;
    Cliente cliente;
    String motivoCancelamento;
    
    Date dataVenda;

    public Venda(Imovel imovel, double valor) {
        this.imovel = imovel;
        this.valor = valor;
        this.situacao = SituacaoVenda.Aguardando;
    }
    
    public void vender(Cliente cliente, double valor, Date dataVenda){
        this.valor = valor;
        this.cliente = cliente;
        this.situacao = SituacaoVenda.Finalizado;
        this.dataVenda = dataVenda;
    }
    
    public void cancelar(String motivo){
        this.situacao = SituacaoVenda.Cancelado;
        this.motivoCancelamento = motivo;
    }
    
    
    
}
