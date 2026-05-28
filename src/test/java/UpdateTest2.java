import dao.UsuarioDAO;
import model.Usuario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UpdateTest2 {

    private UsuarioDAO usuarioDAO;

    @BeforeEach
    public void setUp() {
        usuarioDAO = new UsuarioDAO();
    }

    @Test
    public void naoDeveAlterarUsuarioComDadosInvalidos() {
        // Arrange
        Usuario usuarioInvalido = new Usuario();// se o seu id for Integer, pode usar null
        usuarioInvalido.setUsuario("");
        usuarioInvalido.setSenha(null);

        // Act & Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            usuarioDAO.update(usuarioInvalido);
        });

        assertEquals("Nome e senha são obrigatórios.", exception.getMessage(),
                "A mensagem da exceção veio diferente do esperado.");
    }
}
