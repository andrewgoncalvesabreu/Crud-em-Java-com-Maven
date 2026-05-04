import dao.UsuarioDAO;
import model.Usuario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CreateTest1 {
    private UsuarioDAO usuarioDAO;

    @BeforeEach
    public void setUp() {
        usuarioDAO = new UsuarioDAO();
    }

    //O sistema deve salvar corretamente no banco de dados. - CA2
    @Test
    public void deveCadastrarUsuarioComSucesso() {
        // Arrange (Preparar)
        String nomeTeste = "Andrew2178";
        Usuario novoUsuario = new Usuario();
        novoUsuario.setUsuario(nomeTeste);
        novoUsuario.setSenha("senha09018");

        //CRIANDO O USER NO BANCO
        usuarioDAO.create(novoUsuario);


        // Busca o usuário para ver se salvou mesmo
        List<Usuario> usuariosEncontrados = usuarioDAO.buscarPorLetra(nomeTeste);

        assertFalse(usuariosEncontrados.isEmpty(), "O usuário deveria ter sido salvo no banco e retornado na busca.");
        assertEquals(nomeTeste, usuariosEncontrados.get(0).getUsuario(), "O nome do usuário salvo deve bater com o enviado.");
    }


}
