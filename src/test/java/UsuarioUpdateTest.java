

import dao.UsuarioDAO;
import model.Usuario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class UsuarioUpdateTest {

    private UsuarioDAO usuarioDAO;

    @BeforeEach
    public void setup() {
        usuarioDAO = new UsuarioDAO();
    }

    @Test
    public void deveAlterarUsuarioComSucesso() {

        // Arrange (Preparar o cenário)

        Usuario usuario = new Usuario();
        usuario.setUsuario("Andrew2178");
        usuario.setSenha("senha09018");

        // Cria o utilizador no banco
        usuarioDAO.create(usuario);

        // Busca o utilizador criado para pegar o ID
        List<Usuario> usuariosCriados =
                usuarioDAO.buscarPorLetra("Andrew2178");

        usuario.setId(usuariosCriados.get(0).getId());

        // Alteração dos dados
        usuario.setUsuario("AndrewModificado");
        usuario.setSenha("novaSenha123");

        // Act (Executar update)
        usuarioDAO.update(usuario);

        // Busca para verificar se alterou realmente
        List<Usuario> usuarios =
                usuarioDAO.buscarPorLetra("AndrewModificado");

        // Assert (Validar resultado)

        assertFalse(
                usuarios.isEmpty(),
                "O utilizador deveria ter sido encontrado após a alteração."
        );

        assertEquals(
                "AndrewModificado",
                usuarios.get(0).getUsuario()
        );

        assertEquals(
                "novaSenha123",
                usuarios.get(0).getSenha()
        );
    }
}