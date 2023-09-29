package desafio3BPM_Testes;

import org.edu.desafio3BPM.Pessoa;
import org.edu.desafio3BPM.Turma;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class TurmaTestMock {
    private Turma turma;
    private Pessoa pessoa;

    @BeforeEach
    public void setUp(){
        turma = new Turma();
        pessoa = mock(Pessoa.class);
    }

    @Test
    @DisplayName("Deve retornar verdadeiro ao tentar adicionar um objeto pessoa mockado")
    public void testAdicionarPessoa() throws Exception{
        when(pessoa.getId()).thenReturn(1);
        when(pessoa.getNome()).thenReturn("Fulano");
        when(pessoa.valido()).thenReturn(true);

        turma.adicionarPessoa(pessoa);
        List<Pessoa> pessoasDaTurma = turma.getPessoas();
        assertTrue(pessoasDaTurma.size() == 1);

    }

    @Test
    @DisplayName("Deve cair na exception ao tentar adicionar um obejto do tipo pessoa não válido.")
    public void  testAdicionarPessoaDois() throws Exception{
        when(pessoa.valido()).thenReturn(false);
        try {
            turma.adicionarPessoa(pessoa);
        }catch (Exception e){
            assertEquals("Objeto pessoa inválido",e.getMessage());
        }
    }
    @Test
    @DisplayName("Deve cair na exception ao tentar adicionar um mesmo objeto pessoa mockado válido mais de uma vez")
    public void  testAdicionarPessoaTres() throws Exception{
        when(pessoa.valido()).thenReturn(true);
        try {
            turma.adicionarPessoa(pessoa);
            turma.adicionarPessoa(pessoa);
        }catch (Exception e){
            assertEquals("Objeto pessoa já está atribuido a turma",e.getMessage());
        }
    }

}
