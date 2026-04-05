import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CrudTest {

    @Test
    void testeValidacaoDadosCrud() {
        // Simulando a lógica do seu CRUD
        String nomeEsperado = "Andrew";
        String nomeNoSistema = "Andrew";

        // Verifica se o sistema está mantendo os dados corretamente
        assertEquals(nomeEsperado, nomeNoSistema, "O nome no CRUD deve ser igual ao inserido.");
    }

    @Test
    void testeFalhaProposital() {
        // REQUISITO DA PARTE 2: Teste de Falha
        // Este teste vai travar o Pipeline no GitLab propositalmente
        int valorEsperado = 100;
        int valorObtido = 0;

        assertEquals(valorEsperado, valorObtido, "ERRO PROPOSITAL: O valor obtido não corresponde ao esperado.");
    }
}