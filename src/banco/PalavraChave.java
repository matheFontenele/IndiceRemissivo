package banco;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PalavraChave {

    //Atributos
    private List<String> palavrasChaves = new ArrayList<>();
    private String caminho = "src\\banco\\docs\\palavras_chave.txt";


    //Metodo para adicionar as palavras chaves do texto na lista
    public void adicionarPalavras(){
        try {
            palavrasChaves = Files.readAllLines(Paths.get(caminho));
            for (String palavra : palavrasChaves){
                System.out.println(palavra);
            }
        } catch (IOException e){
            System.out.println("Deu bom não" + e.getMessage());
        }
    }


    //Getter
    public List<String> getPalavrasChaves() {
        return palavrasChaves;
    }
}
