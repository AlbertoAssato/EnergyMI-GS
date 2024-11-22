package br.com.mvc.energymi;

import br.com.mvc.energymi.model.Usuario;
import br.com.mvc.energymi.repository.UsuarioRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class CadastrarUsuarioTests {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Test
    void testCadastrarUsuario() {
        // Criando um usuário para teste
        Usuario usuario = new Usuario("usuarioTeste", "senha123");

        // Salvando o usuário no banco de dados
        Usuario usuarioSalvo = usuarioRepository.save(usuario);

        // Validando que o usuário foi salvo corretamente
        assertThat(usuarioSalvo).isNotNull();
        assertThat(usuarioSalvo.getId()).isNotNull(); // Verifica se o ID foi gerado
        assertThat(usuarioSalvo.getUsername()).isEqualTo("usuarioTeste");
    }
}
