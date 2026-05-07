import dao.UsuarioDAO;
import model.Usuario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class ReadTest {

    private UsuarioDAO usuarioDAO;

    @BeforeEach
    public void setUp() {
        // Inicializa o DAO antes de cada teste para evitar erro de NullPointerException
        usuarioDAO = new UsuarioDAO();
    }

    @Test
    public void deveRetornarListaDeUsuariosEExibirNoConsole() {
        // 1. ARRANGE (Preparar os dados no banco)
        String nomeParaTeste = "Andrew2178";
        Usuario novoUsuario = new Usuario();
        novoUsuario.setUsuario(nomeParaTeste);
        novoUsuario.setSenha("senha09018");
        usuarioDAO.create(novoUsuario);

        // 2. ACT (Ler os dados do banco)
        List<Usuario> usuariosEncontrados = usuarioDAO.buscarPorLetra(nomeParaTeste);

        // 3. EXIBIR NO CONSOLE (O que você pediu)
        System.out.println("\n========================================");
        System.out.println("LOG: INICIANDO LEITURA DO BANCO DE DADOS");
        if (usuariosEncontrados.isEmpty()) {
            System.out.println("Aviso: Nenhum usuário encontrado.");
        } else {
            System.out.println("Usuários encontrados no banco:");
            for (Usuario u : usuariosEncontrados) {
                System.out.println(" -> Nome: " + u.getUsuario());
            }
        }
        System.out.println("========================================\n");

        // 4. ASSERT (Garantir que o teste passou)
        assertFalse(usuariosEncontrados.isEmpty(), "A lista não deveria estar vazia.");
        assertEquals(nomeParaTeste, usuariosEncontrados.get(0).getUsuario(), "O nome lido deve ser igual ao salvo.");
    }
}