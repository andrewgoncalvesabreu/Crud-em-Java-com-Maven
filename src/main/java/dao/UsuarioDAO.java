package dao;

import factory.ConnectionFactory;
import model.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {
    public void create(Usuario usuario) { //insere um usuario
        String sql = "INSERT INTO Usuario (usuario, senha) VALUES (?,?)";//o comando SQL

        try (Connection conn = ConnectionFactory.fazConexao();
             PreparedStatement statement = conn.prepareStatement(sql)) {

            statement.setString(1, usuario.getUsuario());
            statement.setString(2, usuario.getSenha());
            statement.execute();

            System.out.println("Criado com Sucesso!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Usuario> read() {
        String sql = "SELECT * FROM Usuario";
        List<Usuario> usuarios = new ArrayList<>();

        try (Connection conn = ConnectionFactory.fazConexao();
             PreparedStatement statement = conn.prepareStatement(sql);
             ResultSet rs = statement.executeQuery()) {

            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setId(rs.getInt("id"));
                usuario.setUsuario(rs.getString("usuario"));
                usuario.setSenha(rs.getString("senha"));

                usuarios.add(usuario);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return usuarios;

    } //read vai me retornar todos os usuarios do sistema.

    public void update(Usuario usuario) { //updatar um usuario especifico
        String sql = "UPDATE Usuario SET usuario = ?, senha = ? WHERE id = ?";

        try (Connection conn = ConnectionFactory.fazConexao();
            PreparedStatement statement = conn.prepareStatement(sql)) {

            statement.setString(1, usuario.getUsuario());
            statement.setString(2, usuario.getSenha());
            statement.setInt(3, usuario.getId());
            statement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        String sql = "DELETE FROM Usuario WHERE id = ?";

        try( Connection conn = ConnectionFactory.fazConexao();
            PreparedStatement statement = conn.prepareStatement(sql)) {

            statement.setInt(1, id);

            int linhasAfetadas = statement.executeUpdate();

            if (linhasAfetadas == 0) {
                System.out.println("Nenhum usuário encontrado com esse ID");
            } else {
                System.out.println("Usuário deletado!");
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Usuario> buscarPorLetra(String letra) {
        String sql = "SELECT * FROM Usuario WHERE usuario LIKE ?";
        List<Usuario> usuariosEspecificos = new ArrayList<>();

        try (Connection conn = ConnectionFactory.fazConexao();
             PreparedStatement statement = conn.prepareStatement(sql);) {

            statement.setString(1,letra + "%");
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setId(rs.getInt("id"));
                usuario.setUsuario(rs.getString("usuario"));
                usuario.setSenha(rs.getString("senha"));

                usuariosEspecificos.add(usuario);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return usuariosEspecificos;
    }
}
