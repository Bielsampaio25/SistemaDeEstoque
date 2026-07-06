package controller;

import dao.CadastroUsersDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import model.CadastroUsuarioModel;

@WebServlet("/cadastro")
public class CadastroController extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        CadastroUsuarioModel user = new CadastroUsuarioModel();

        user.setNome(request.getParameter("nameFirst"));
        user.setSobrenome(request.getParameter("sobrenome"));
        user.setMatricula(request.getParameter("matricula"));
        user.setCpf(request.getParameter("cpf"));
        user.setSexo(request.getParameter("sexo"));
        user.setDtaNascimento(request.getParameter("dtaNascimento"));
        user.setEmail(request.getParameter("email"));
        user.setTelefone(request.getParameter("telefone"));
        user.setNomeUsuario(request.getParameter("nomeUsuario"));
        user.setSenha(request.getParameter("senha"));
        user.setFuncao(request.getParameter("funcao"));
        user.setCep(request.getParameter("cep"));
        user.setEstado(request.getParameter("estado"));
        user.setCidade(request.getParameter("cidade"));
        user.setEndereco(request.getParameter("endereco"));
        user.setBairro(request.getParameter("bairro"));
        user.setNumero(request.getParameter("numero"));
        user.setComplemento(request.getParameter("complemento"));

        CadastroUsersDAO dao = new CadastroUsersDAO();

        // Corrigido: usar getContextPath() para caminhos relativos corretos
        if (dao.cadastrar(user)) {
            response.sendRedirect(request.getContextPath() + "/pages/dashboard.html");
        } else {
            response.sendRedirect(request.getContextPath() + "/pages/cadastro.html");
        }
    }
}
