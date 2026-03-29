package main;

import dao.UsuarioDAO;
import model.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TesteBanco {
    static void main() {
        Scanner teclado = new Scanner(System.in);
        int opcao = -1;
        int continua;
        UsuarioDAO operacoes = new UsuarioDAO();

        while (opcao != 0) {
            System.out.println("---SISTEMA DE USUÁRIOS---");
            System.out.println("1. CADASTRAR USUÁRIO");
            System.out.println("2. VER USUÁRIOS CADASTRADOS");
            System.out.println("3. ALTERAR UM USUÁRIO");
            System.out.println("4. DELETAR UM USUÁRIO");
            System.out.println("5. BUSCAR POR LETRA ESPECÍFICA");
            System.out.println("0. SAIR");
            System.out.println("ESCOLHA UMA OPÇÃO: ");
            opcao = teclado.nextInt();
            teclado.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("Nome do Usuário: ");
                    String nome = teclado.nextLine();
                    System.out.println("Senha: ");
                    String senha = teclado.nextLine();
                    Usuario novo = new Usuario(nome, senha);
                    operacoes.create(novo);
                    System.out.println("Continuar? (s/n)");
                    continua = TesteBanco.confirmacao(teclado.nextLine());
                    if (continua == 0) {
                        opcao = 0;
                    }

                    break;
                case 2:
                    System.out.println("---Lista de Usuários---");
                    List<Usuario> usuarios = operacoes.read();
                    for (Usuario u : usuarios) {
                        System.out.println(u);
                    }
                    System.out.println("Continuar? (s/n)");
                    continua = TesteBanco.confirmacao(teclado.nextLine());
                    if (continua == 0) {
                        opcao = 0;
                    }
                    break;
                case 3:
                    System.out.println("ID do usuário a ser alterado: ");
                    int id = teclado.nextInt();
                    teclado.nextLine();
                    System.out.println("Novo Nome: ");
                    String novoNome = teclado.nextLine();
                    System.out.println("Nova Senha: ");
                    String novaSenha = teclado.nextLine();

                    Usuario editado = new Usuario(novoNome, novaSenha);
                    editado.setId(id);
                    operacoes.update(editado);
                    System.out.println("Usuário Atualizado!");
                    System.out.println("Continuar? (s/n)");
                    continua = TesteBanco.confirmacao(teclado.nextLine());
                    if (continua == 0) {
                        opcao = 0;
                    }
                    break;
                case 4:
                    System.out.println("Digite o ID do usuário a ser deletado: ");
                    int idASerExcluido = teclado.nextInt();
                    teclado.nextLine();

                    System.out.println("Tem certeza que deseja deletar? (s/n)");
                    String confirmacao = teclado.nextLine();

                    if (confirmacao.equalsIgnoreCase("s")){
                        operacoes.delete(idASerExcluido);
                    } else {
                        System.out.println("Operação encerrada.");
                    }
                    System.out.println("Continuar? (s/n)");
                    continua = TesteBanco.confirmacao(teclado.nextLine());
                    if (continua == 0) {
                        opcao = 0;
                    }
                    break;
                case 5:
                    System.out.println("Digite a letra inicial que você busca");
                    String letra = teclado.nextLine();

                    List<Usuario> usuariosPorLetra = operacoes.buscarPorLetra(letra);

                    if (usuariosPorLetra.isEmpty()) {
                        System.out.println("Nenhum usuário encontrado.");
                    } else {
                        System.out.println("--Usuários Encontrados--");
                        for (Usuario u : usuariosPorLetra) {
                            System.out.println(u);
                        }
                    }

                    System.out.println("Continuar? (s/n)");
                    continua = TesteBanco.confirmacao(teclado.nextLine());
                    if (continua == 0) {
                        opcao = 0;
                    }
                    break;
                case 0:
                    opcao = 0;
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }
    }

    public static int confirmacao(String sOUn) {
        if (sOUn.equalsIgnoreCase("s")) {
            return -1;
        } else {
            return 0;
        }
    }
}
