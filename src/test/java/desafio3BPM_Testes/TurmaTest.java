package desafio3BPM_Testes;

import org.edu.desafio3BPM.Pessoa;
import org.edu.desafio3BPM.Turma;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TurmaTest {

    private Turma turma = new Turma();

    @Test
    @DisplayName("Deve adcionar uma pessoa válida")
    public void testAdcionarPessoaUm() throws Exception {
        Pessoa pessoa1 = new Pessoa(1, "Fulano");
        turma.adicionarPessoa(pessoa1);
        assertTrue(turma.getPessoas().contains(pessoa1));
    }
    @Test
    @DisplayName("Deve cair em exception ao passar uma pessoa com id = 0")
    public void testAdcionarPessoaDois() throws Exception{
        Pessoa pessoa1 = new Pessoa(0, "Fulano");
        try {
            assertThrows(Exception.class,() ->turma.adicionarPessoa(pessoa1));
        }catch (Exception e){
            assertEquals("Objeto pessoa inválido",e.getMessage());
        }

    }
    @Test
    @DisplayName("Deve cair em exception ao passar uma pessoa com nome vazio ")
    public void testAdcionarPessoaTrês() throws Exception{
        Pessoa pessoa1 = new Pessoa(1, "");
        try {
            assertThrows(Exception.class,() ->turma.adicionarPessoa(pessoa1));
        }catch (Exception e){
            assertEquals("Objeto pessoa inválido",e.getMessage());
        }
    }
    @Test
    @DisplayName("Deve cair em exception ao passar uma pessoa com nome vazio e id - 0 ")
    public void testAdcionarPessoaQuatro() throws Exception{
        Pessoa pessoa1 = new Pessoa(0, "");
        try {
            assertThrows(Exception.class,() ->turma.adicionarPessoa(pessoa1));
        }catch (Exception e){
            assertEquals("Objeto pessoa inválido",e.getMessage());
        }
    }

    @Test
    @DisplayName("Deve cair em exception ao passar uma pessoa já existente na lista ")
    public void testAdcionarPessoaCinco() throws Exception{
        Pessoa pessoa1 = new Pessoa(1, "Fulano");
        Pessoa pessoa2 = new Pessoa(1, "Fulano");
        try {
            turma.adicionarPessoa(pessoa1);
            assertThrows(Exception.class,() ->turma.adicionarPessoa(pessoa2));
        }catch (Exception e){
            assertEquals("Objeto pessoa já está atribuido a turma",e.getMessage());
        }
    }

    @Test
    @DisplayName("Deve retornar as pessoas adicionadas")
    public void testGetPessoas() throws Exception {
        List<Pessoa> listaEsperada = new ArrayList<>();
        Pessoa pessoa1 = new Pessoa(1, "Fulano");
        Pessoa pessoa2 = new Pessoa(2, "Beltrano");
        listaEsperada.add(pessoa1);
        listaEsperada.add(pessoa2);

        turma.adicionarPessoa(pessoa1);
        turma.adicionarPessoa(pessoa2);

        assertEquals(listaEsperada,turma.getPessoas());
    }

    @Test
    @DisplayName("Deve limpar a lista ")
    public void testRemoverPessoas() throws Exception{
        Pessoa pessoa1 = new Pessoa(1, "Fulano");
        Pessoa pessoa2 = new Pessoa(2, "Beltrano");
        turma.adicionarPessoa(pessoa1);
        turma.adicionarPessoa(pessoa2);

        turma.removerTodasPessoas();
        assertTrue(turma.getPessoas().isEmpty());
    }

}
