package br.com.mvc.energymi;

import br.com.mvc.energymi.model.Usuario;
import br.com.mvc.energymi.repository.UsuarioRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class UsuarioRepositoryTests {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Test
    void testCadastrarUsuario() {
        // Criação de um usuário para teste
        Usuario usuario = new Usuario("usuarioTeste", "senha123");

        // Salvando o usuário no banco de dados
        Usuario usuarioSalvo = usuarioRepository.save(usuario);

        // Verificando se o usuário foi salvo corretamente
        assertThat(usuarioSalvo).isNotNull();
        assertThat(usuarioSalvo.getId()).isGreaterThan(0);
        assertThat(usuarioSalvo.getUsername()).isEqualTo("usuarioTeste");
    }
}
