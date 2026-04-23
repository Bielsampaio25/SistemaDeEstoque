package util;

import org.mindrot.jbcrypt.BCrypt;

public class SenhaUtil {

    public static String gerarHash(String senha) {

        return BCrypt.hashpw(senha, BCrypt.gensalt()); //faz a criptografia da senha
    }
    
    public static boolean verificarSenha(String senhaDigitada, String hash) {
        return BCrypt.checkpw(senhaDigitada, hash); //verifia a senha digitada pelo usario
    }
}
