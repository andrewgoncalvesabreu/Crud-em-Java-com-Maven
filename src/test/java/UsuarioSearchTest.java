import dao.UsuarioDAO;
import model.Usuario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class UsuarioSearchTest {

    private UsuarioDAO usuarioDAO;

    @BeforeEach
    public void setup() {
        usuarioDAO = new UsuarioDAO();
    }

    @Test
    public void deveBuscarUsuarioPorLetraInicial() {
        // ARRANGE: Criar um usuário específico para garantir que a busca funcione
        String nomeTeste = "JoaoCesarTeste";
        Usuario novo = new Usuario(nomeTeste, "senha123");
        usuarioDAO.create(novo);

        // ACT: Buscar pela primeira letra "J"
        String letraBusca = "J";
        List<Usuario> resultados = usuarioDAO.buscarPorLetra(letraBusca);

        // EXIBIR NO CONSOLE
        System.out.println("\n--- TESTE DE BUSCA POR LETRA '" + letraBusca + "' ---");
        for (Usuario u : resultados) {
            System.out.println("Encontrado: " + u.getUsuario());
        }

        // ASSERT: Validar se a lista contém o usuário
        assertFalse(resultados.isEmpty(), "A lista não deveria estar vazia.");

        // Verifica se algum dos nomes na lista começa com a letra buscada
        boolean encontrou = resultados.stream()
                .anyMatch(u -> u.getUsuario().startsWith(letraBusca));

        assertTrue(encontrou, "Deveria ter encontrado um usuário começando com " + letraBusca);
    }
}
