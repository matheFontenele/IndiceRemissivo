package banco;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leitor {

    //Metodo para ler texto e criar tabela hash
    public static Map<Integer, String> lerTexto(){

        //Bloco Try Catch para captura de linhas do texto
        Map<Integer, String> tabela = new HashMap<>();
        try {
            List<String> linhas = Files.readAllLines(Paths.get("src\\banco\\docs\\texto.txt"));
            for (String linha : linhas) {
                tabela.put(tabela.size()+1, linha);
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
        return tabela;

    }

    /**
     *
     * @return hash map de int com numero da linha e valor string com frase
     *
     * @throws IOException caso o caminho do arquivo não seja encontrado
     *
     */

}
