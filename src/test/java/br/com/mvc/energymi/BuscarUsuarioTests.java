package br.com.mvc.energymi;

import br.com.mvc.energymi.model.Usuario;
import br.com.mvc.energymi.repository.UsuarioRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class BuscarUsuarioTests {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Test
    void testBuscarUsuarioPorUsername() {
        // Criando e salvando um novo usuário no banco de dados
        Usuario usuario = new Usuario("usuarioBusca", "senha123");
        usuarioRepository.save(usuario);

        // Recuperando o usuário pelo nome de usuário
        Usuario usuarioEncontrado = usuarioRepository.findByUsername("usuarioBusca");

        // Validando que o usuário foi encontrado e os dados estão corretos
        assertThat(usuarioEncontrado).isNotNull();
        assertThat(usuarioEncontrado.getUsername()).isEqualTo("usuarioBusca");
    }
}
