//import java.io.BufferedReader;
//import java.io.FileReader;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//public class LeitorDeArquivos {
//    public static void main(String[] args) {
//        BufferedReader leitor = null;
//        try{
//            FileReader fileReader = new FileReader("produtos.csv"); // Localiza o arquivo
//            leitor = new BufferedReader(fileReader); // Lê blocos do arquivo
//
//            // Cabeçalho
//            String linha = leitor.readLine();
//
//            List<Produto> produtos = new ArrayList<>();
//
//            while( (linha = leitor.readLine()) != null){
//                String[] colunas = linha.split(",");
//                String id = colunas[0];
//                String nome = colunas[1];
//                double preco = Double.valueOf(colunas[2]);
//                int estoque = Integer.valueOf(colunas[3]);
//                String descricao = colunas[4];
//                Produto produto = new Produto(nome, preco, estoque, id, descricao);
//
//                produtos.add(produto);
//            }
//
//            System.out.println(produtos.size());
//
//        } catch (IOException i){
//            System.err.println("Arquivo não encontrado!");
//        } finally {
//            try {
//                if(leitor != null){
//                leitor.close();
//                }
//            } catch (IOException e){
//                System.err.println("Erro ao fechar o arquivo.");
//            }
//        }
//    }
//}