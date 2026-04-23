/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connection.ConnectionFactory;
import java.sql.PreparedStatement;
import model.CadastroUsuarioModel;
import util.SenhaUtil;

/**
 *
 * @author 232.004662
 */
public class CadastroUsersDAO {
 
    
    public boolean cadastrar(CadastroUsuarioModel user){
        String sql = 
                "INSERT INTO users" +
                "(username, psw, nome, sobrenome, matricula, cpf, sexo, dtaNascimento, email, telefone, funcao, cep, estado, cidade, endereco, bairro, numero, complemento)" +
                "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? ";
        
        try (var con = ConnectionFactory.getConnection()){
            
            
            PreparedStatement stmt = 
                    con.prepareStatement(sql);
            
            String senhaHash = SenhaUtil.gerarHash(user.getSenha());
            
            stmt.setString(1, user.getNome());
            stmt.setString(2, user.getSobrenome());
            stmt.setString(3, user.getCpf());
            stmt.setString(4, user.getFuncao());
            stmt.setString(5, user.getCep());
            stmt.setString(6, user.getEstado());
            stmt.setString(7, user.getCidade());
            stmt.setString(8, user.getEndereco());
            stmt.setString(9, user.getBairro());
            stmt.setString(10, user.getNumero());
            stmt.setString(11, user.getComplemento());
            stmt.setString(12, user.getNomeUsuario());
            stmt.setString(12, senhaHash);
            stmt.setString(12, user.getDtaNascimento());
            
            
            stmt.executeUpdate();
                  
            return true;

        } catch (Exception e) {
           e.printStackTrace();
    return false;
}
    }
}

