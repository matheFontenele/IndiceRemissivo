package bancoDoChat;

import java.io.*;
import java.util.*;

public class IndexRemissivo {
    // Função para ler o texto e gerar o índice remissivo
    public static Map<String, List<Integer>> gerarIndiceRemissivo(String filePath, List<String> keywords) throws IOException {
        Map<String, List<Integer>> indice = new HashMap<>();

        // Inicializar o mapa com as palavras-chave e listas vazias
        for (String palavra : keywords) {
            indice.put(palavra, new ArrayList<>());
        }

        // Ler o arquivo linha por linha
        BufferedReader reader = new BufferedReader(new FileReader("src\\banco\\docs\\texto.txt"));
        String linha;
        int numeroLinha = 1;

        while ((linha = reader.readLine()) != null) {
            // Quebrar a linha em palavras
            String[] palavras = linha.split("\\W+");

            // Verificar cada palavra na linha
            for (String palavra : palavras) {
                palavra = palavra.toLowerCase(); // Ignorar diferenças de maiúsculas e minúsculas

                // Se a palavra for uma palavra-chave, adicionar a linha ao índice
                if (indice.containsKey(palavra)) {
                    indice.get(palavra).add(numeroLinha);
                }
            }
            numeroLinha++;
        }

        reader.close();
        return indice;
    }

    // Função para escrever o índice em um arquivo de texto
    public static void escreverIndiceEmArquivo(Map<String, List<Integer>> indice, String outputFilePath) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath));

        for (Map.Entry<String, List<Integer>> entrada : indice.entrySet()) {
            String palavra = entrada.getKey();
            List<Integer> linhas = entrada.getValue();
            writer.write("Palavra: " + palavra + " - Linhas: " + linhas.toString());
            writer.newLine();
        }

        writer.close();
    }

    public static void main(String[] args) {
        String caminhoArquivoEntrada = "src\\banco\\docs\\texto.txt"; // Caminho para o arquivo de entrada
        String caminhoArquivoSaida = "src\\banco\\docs\\indicetexto.txt"; // Caminho para o arquivo de saída

        // Palavras-chave para buscar
        List<String> palavrasChave = Arrays.asList(
                "and", "be", "by", "easy", "human-engineered", "programming", "programs", "to"
        );

        try {
            // Gerar o índice remissivo
            Map<String, List<Integer>> indice = gerarIndiceRemissivo(caminhoArquivoEntrada, palavrasChave);

            // Escrever o índice em um arquivo
            escreverIndiceEmArquivo(indice, caminhoArquivoSaida);

            System.out.println("Índice remissivo gerado com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao processar o arquivo: " + e.getMessage());
        }
    }
}
