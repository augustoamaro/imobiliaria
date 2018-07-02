//
//import br.univali.imobiliaria.dominio.Cliente;
//import br.univali.imobiliaria.dominio.Exceptions.ImovelComMatriculaJaExistenteException;
//import br.univali.imobiliaria.dominio.Imobiliaria;
//import br.univali.imobiliaria.dominio.imovel.Apartamento;
//import br.univali.imobiliaria.dominio.imovel.Casa;
//import br.univali.imobiliaria.dominio.imovel.Imovel;
//import br.univali.imobiliaria.dominio.imovel.Terreno;
//import java.util.Calendar;
//import java.util.Date;
//import javax.swing.JOptionPane;
//
///**
// *
// * @author 1978233
// */
//public class Principal {
//    
//    Imobiliaria imobiliaria;
//
//    public Principal() throws Exception {
//        
//        try {
//            imobiliaria = new Imobiliaria();
//            imobiliaria.adicionarCliente(new Cliente("João","123456"));
//            imobiliaria.adicionarCliente(new Cliente("João","123456"));
//
//            imobiliaria.adicionarImovel(new Casa(true,"123456"));
//            imobiliaria.adicionarImovel(new Terreno(322.12,"123459"));
//            imobiliaria.adicionarImovel(new Terreno(345.23,"123459"));
//            imobiliaria.adicionarImovel(new Apartamento(10,"102030"));
//            imobiliaria.adicionarImovel(new Casa(false,"405060"));
//            imobiliaria.adicionarImovel(new Apartamento(5,"321645"));
//            imobiliaria.colocarParaVenda(imobiliaria.obterImovel("123456"),500000);
//            imobiliaria.colocarParaVenda(imobiliaria.obterImovel("321645"),500000);
//            imobiliaria.colocarParaVenda(imobiliaria.obterImovel("102030"),100000);
//            imobiliaria.colocarParaLocacao(imobiliaria.obterImovel("102030"),1500);
//            imobiliaria.colocarParaLocacao(imobiliaria.obterImovel("123459"),500);
//
//            Calendar c = Calendar.getInstance();
//            Date dataIni = c.getTime();
//            c.add(Calendar.YEAR, 1);
//            Date dataFim = c.getTime();
//            imobiliaria.alugar(imobiliaria.obterImovel("102030"), imobiliaria.obterCliente("123456"), 800, dataIni, dataFim);
//
//            for(Imovel imovel:imobiliaria.obterImoveis()){
//                System.out.println(imovel);
//            }   
//        } catch(Exception exception) {
//            JOptionPane.showMessageDialog(null, exception.getMessage());
//            //System.out.println("Não foi possível executar todo o programa: " + exception.getMessage());
//        }
//    }
//    
//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String[] args) throws Exception {
//        new Principal();
//        //Imobiliaria imob = new Imobiliaria();
//        
//    }
//    
//}
