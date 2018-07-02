/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univali.imobiliaria.dominio;

import br.univali.imobiliaria.dominio.Exceptions.ClienteComCpfJaExistenteException;
import br.univali.imobiliaria.dominio.Exceptions.ImovelComMatriculaJaExistenteException;
import br.univali.imobiliaria.dominio.Exceptions.ImovelJaEstaLocadoException;
import br.univali.imobiliaria.dominio.Exceptions.ImovelJaEstaAVendaException;
import br.univali.imobiliaria.dominio.Exceptions.LocacaoJaAtivaException;
import br.univali.imobiliaria.dominio.Exceptions.VendaJaFinalizadaException;
import br.univali.imobiliaria.dominio.imovel.Imovel;
import br.univali.imobiliaria.dominio.enuns.SituacaoVenda;
import br.univali.imobiliaria.dominio.enuns.SituacaoLocacao;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author Guto
 */
public class Imobiliaria {
    Set<Cliente> clientes;
    Set<Imovel> imoveis;
    List<Venda> vendas;
    List<Locacao> locacoes;

    public Imobiliaria() {
        clientes = new TreeSet<>();
        imoveis = new TreeSet<>() ;
        vendas = new LinkedList<>();
        locacoes = new LinkedList<>();
    }
    
    public void adicionarCliente(Cliente cliente) throws Exception{
        Cliente clienteDaLista = this.obterCliente(cliente.documentoIdentificacao);
        if(clienteDaLista != null) {
            throw new ClienteComCpfJaExistenteException(cliente.documentoIdentificacao);
        } else {
            this.clientes.add(cliente);
        }
    }
    
    public void adicionarImovel(Imovel imovel) throws Exception {
        Imovel imovelDaLista = this.obterImovel(imovel.getMatricula());
        if(imovelDaLista != null) {
            throw new ImovelComMatriculaJaExistenteException(imovel.getMatricula());
        } else {
            this.imoveis.add(imovel);
        }
    }
    
    public boolean estaVendendo(Imovel imovel){
        return vendas.stream().filter( op -> op.imovel.equals(imovel) && op.situacao.equals(SituacaoVenda.Aguardando)).count() > 0;
    }
    
    public boolean estaAlugando(Imovel imovel){
        return locacoes.stream().filter( op -> op.imovel.equals(imovel) && op.situacao.equals(SituacaoLocacao.Aguardando)).count() > 0;
    }
    
    public Venda obterOperacaoVenda(Imovel imovel, SituacaoVenda situacaoOperacao){
        return (Venda) vendas.stream().filter( op -> op.imovel.equals(imovel) && op.situacao.equals(situacaoOperacao)).findFirst().orElse(null);
    }
    
    public Locacao obterOperacaoLocacao(Imovel imovel, SituacaoLocacao situacaoOperacao){
        return (Locacao) locacoes.stream().filter( op -> op.imovel.equals(imovel) && op.situacao.equals(situacaoOperacao)).findFirst().get();
    }
    
    public Imovel obterImovel(String matricula){
        return imoveis.stream().filter( im -> im.getMatricula().equalsIgnoreCase(matricula)).findFirst().orElse(null);
    }

    public Imovel[] obterImoveis(){
        return imoveis.toArray(new Imovel[0]);
    }
    
    public Cliente obterCliente (String documentoIdentificacao){
        return clientes.stream().filter( cli -> cli.documentoIdentificacao.equalsIgnoreCase(documentoIdentificacao)).findFirst().orElse(null);
    }
    
    public void colocarParaVenda(Imovel imovel, double valor) throws Exception{
        if (!estaVendendo(imovel)){
            vendas.add(new Venda(imovel, valor));
        } else {
            throw new ImovelJaEstaAVendaException(imovel.getMatricula());
        }
    }
    
    public void colocarParaLocacao(Imovel imovel, double valor) throws Exception{
        if (!estaAlugando(imovel)){
            locacoes.add(new Locacao(imovel, valor));
        } else {
            throw new ImovelJaEstaLocadoException(imovel.getMatricula());
        }
    }
    
    public void vender(Imovel imovel, Cliente cliente, double valor, Date dataVenda){
        if (estaVendendo(imovel)){
            Venda venda = obterOperacaoVenda(imovel,SituacaoVenda.Aguardando);
            venda.vender(cliente, valor, dataVenda);
        }
    }
    
    public void cancelarVenda(Imovel imovel, String motivo) throws Exception {
        Venda vendaEstaFinalizada = obterOperacaoVenda(imovel,SituacaoVenda.Finalizado);
        if(vendaEstaFinalizada != null) {
            throw new VendaJaFinalizadaException(imovel);
        } else {
            Venda venda = obterOperacaoVenda(imovel,SituacaoVenda.Aguardando);
            venda.cancelar(motivo);
        }
    }
    
    public void cancelarLocacao(Imovel imovel, String motivo) throws Exception{
        Locacao locacaoEstaAguardando = obterOperacaoLocacao(imovel,SituacaoLocacao.Aguardando);
        if(locacaoEstaAguardando != null) {
            Locacao locacao = obterOperacaoLocacao(imovel,SituacaoLocacao.Cancelado);
            locacao.cancelar(motivo);
        } else {
            throw new LocacaoJaAtivaException(imovel);
        }
    }    
    
    public void alugar(Imovel imovel, Cliente cliente, double valor, Date dataInicio, Date dataFim){
        if (estaAlugando(imovel)){
            Locacao locacao = obterOperacaoLocacao(imovel,SituacaoLocacao.Aguardando);
            locacao.alugar(cliente, valor, dataInicio, dataFim);
        }
    }
    
    public void finalizarLocacao(Imovel imovel, Date dataFim){
        Locacao locacao = obterOperacaoLocacao(imovel,SituacaoLocacao.Alugado);
        locacao.finalizarLocacao(dataFim);
    }
    
}
