package dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import model.CadastroUsuarioModel;
import util.SenhaUtil;

public class CadastroUsersDAO {

    public boolean cadastrar(CadastroUsuarioModel user) {
        // Corrigido: adicionado VALUES (...) e mapeamento correto de todos os campos
        String sql =
            "INSERT INTO users " +
            "(username, psw, nome, sobrenome, matricula, cpf, sexo, data_nasc, email, telefone, funcao, cep, estado, cidade, endereco, bairro, numero, complemento) " +
            "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection con = ConnectionFactory.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            String senhaHash = SenhaUtil.gerarHash(user.getSenha());

            stmt.setString(1,  user.getNomeUsuario());
            stmt.setString(2,  senhaHash);
            stmt.setString(3,  user.getNome());
            stmt.setString(4,  user.getSobrenome());
            stmt.setString(5,  user.getMatricula());
            stmt.setString(6,  user.getCpf());
            stmt.setString(7,  user.getSexo());
            stmt.setString(8,  user.getDtaNascimento());
            stmt.setString(9,  user.getEmail());
            stmt.setString(10, user.getTelefone());
            stmt.setString(11, user.getFuncao());
            stmt.setString(12, user.getCep());
            stmt.setString(13, user.getEstado());
            stmt.setString(14, user.getCidade());
            stmt.setString(15, user.getEndereco());
            stmt.setString(16, user.getBairro());
            stmt.setString(17, user.getNumero());
            stmt.setString(18, user.getComplemento());

            stmt.executeUpdate();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
