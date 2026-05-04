import dao.UsuarioDAO;
import model.Usuario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CreateTest2 {
    private UsuarioDAO usuarioDAO;

    @BeforeEach
    public void setUp() {
        usuarioDAO = new UsuarioDAO();
    }
    @Test
    public void naoDeveCadastrarUsuarioComDadosInvalidos() {
        // Arrange
        Usuario usuarioInvalido = new Usuario();
        usuarioInvalido.setUsuario(""); // Nome vazio
        usuarioInvalido.setSenha(null); // Senha nula

        // Act & Assert
        // Verifica se o método lança uma exceção ao tentar salvar um usuário inválido
        // Obs: Para esse teste passar, você precisa implementar a validação (IllegalArgumentException) no seu método create()
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            usuarioDAO.create(usuarioInvalido);
        });

        assertEquals("Nome e senha são obrigatórios.", exception.getMessage());

        System.out.println(exception.getMessage());
    }
}
