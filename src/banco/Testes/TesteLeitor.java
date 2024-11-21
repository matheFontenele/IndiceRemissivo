package banco.Testes;

import banco.Leitor;

import java.util.Map;

public class TesteLeitor {
    public static void main(String[] args) {

        Map<Integer, String> teste = Leitor.lerTexto();

        for (Map.Entry<Integer, String> entrada : teste.entrySet()){
            System.out.println("Linha: "+entrada.getKey()+" - Frase: "+entrada.getValue());
        }
    }
}
