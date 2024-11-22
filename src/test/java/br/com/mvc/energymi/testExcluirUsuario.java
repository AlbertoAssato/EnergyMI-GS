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
    void testExcluirUsuario() {
        // Criando e salvando um usuário para teste
        Usuario usuario = new Usuario("usuarioExcluir", "senha123");
        usuarioRepository.save(usuario);

        // Excluindo o usuário do banco
        usuarioRepository.delete(usuario);

        // Tentando recuperar o usuário após exclusão
        Usuario usuarioEncontrado = usuarioRepository.findByUsername("usuarioExcluir");

        // Verificando se o usuário foi excluído corretamente
        assertThat(usuarioEncontrado).isNull();
    }
}
