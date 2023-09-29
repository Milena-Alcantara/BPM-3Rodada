package desafio3BPM_Testes;

import org.edu.desafio3BPM.Pessoa;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PessoaTest {
    private Pessoa pessoa = new Pessoa(1,"Fulano");
    private Pessoa pessoa2 = new Pessoa(0,"Fulano");
    private Pessoa pessoa3 = new Pessoa(1,"");
    private Pessoa pessoa4 = new Pessoa(-1,"");

    @Test
    @DisplayName("Deve retornar verdadeiro ao pasar uma pessoa válida")
    public void testVerificaSeÉValidoUm(){
        assertTrue(pessoa.valido());
    }
    @Test
    @DisplayName("Deve retornar falso  ao pasar uma pessoa com id = 0")
    public void testVerificaSeÉValidoDois(){
        assertFalse(pessoa2.valido());
    }
    @Test
    @DisplayName("Deve retornar falso  ao pasar uma pessoa com nome vazio ")
    public void testVerificaSeÉValidoTres(){
        assertFalse(pessoa3.valido());
    }
    @Test
    @DisplayName("Deve retornar falso  ao pasar uma pessoa com nome vazio e id <= 0 ")
    public void testVerificaSeÉValidoQuatro(){
        assertFalse(pessoa4.valido());
    }

}
