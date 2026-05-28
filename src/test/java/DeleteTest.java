import dao.UsuarioDAO;
import model.Usuario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DeleteTest {
    private UsuarioDAO usuarioDAO;

    @BeforeEach
    public void setUp() {
        usuarioDAO = new UsuarioDAO();
    }

    @Test
    public void deveDeletarUsuarioComSucesso() {
        // 1. Arrange (Preparar): Cria um usuário temporário para deletar
        String nomeTeste = "usuario_deletar";
        Usuario usuarioTemp = new Usuario();
        usuarioTemp.setUsuario(nomeTeste);
        usuarioTemp.setSenha("senha123");

        usuarioDAO.create(usuarioTemp);

        // Busca o usuário criado para pegar o ID gerado pelo banco
        List<Usuario> usuarios = usuarioDAO.buscarPorLetra(nomeTeste);
        assertFalse(usuarios.isEmpty(), "O usuário de teste deveria ter sido criado.");

        Usuario usuarioCriado = usuarios.get(0);
        int idDeletar = usuarioCriado.getId();

               usuarioDAO.delete(idDeletar);

        // 3. Assert (Verificar): Tenta buscar novamente pelo mesmo critério
        List<Usuario> resultadoPosDelecao = usuarioDAO.buscarPorLetra(nomeTeste);

        // Verifica se a lista voltou vazia (significa que foi deletado com sucesso)
        assertTrue(resultadoPosDelecao.isEmpty(), "O usuário deveria ter sido removido do banco de dados.");
    }
}