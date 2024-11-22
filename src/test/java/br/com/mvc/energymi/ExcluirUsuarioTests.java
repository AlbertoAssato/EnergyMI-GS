package br.com.mvc.energymi;

import br.com.mvc.energymi.model.Usuario;
import br.com.mvc.energymi.repository.UsuarioRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class ExcluirUsuarioTests {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Test
    void testExcluirUsuario() {
        // Criando e salvando um usuário para teste
        Usuario usuario = new Usuario("usuarioExcluir", "senha123");
        Usuario usuarioSalvo = usuarioRepository.save(usuario);

        // Verificando se o usuário foi salvo corretamente antes de excluir
        assertThat(usuarioSalvo).isNotNull();
        assertThat(usuarioSalvo.getId()).isNotNull();

        // Excluindo o usuário do banco
        usuarioRepository.delete(usuarioSalvo);

        // Tentando recuperar o usuário após exclusão
        Usuario usuarioEncontrado = usuarioRepository.findByUsername("usuarioExcluir");

        // Verificando se o usuário foi excluído corretamente
        assertThat(usuarioEncontrado).isNull();
    }
}
