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
    void testBuscarUsuarioPorUsername() {
        // Supondo que um usuário foi previamente criado e salvo no banco
        Usuario usuario = new Usuario("usuarioBusca", "senha123");
        usuarioRepository.save(usuario);

        // Recuperando o usuário pelo nome de usuário
        Usuario usuarioEncontrado = usuarioRepository.findByUsername("usuarioBusca");

        // Verificando se o usuário foi encontrado corretamente
        assertThat(usuarioEncontrado).isNotNull();
        assertThat(usuarioEncontrado.getUsername()).isEqualTo("usuarioBusca");
    }
}
