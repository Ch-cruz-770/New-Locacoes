package br.com.Locacoes.Service;

import br.com.Locacoes.DTO.UsuarioCreationDTO;
import br.com.Locacoes.DTO.UsuarioResponseDTO;
import br.com.Locacoes.Entity.Usuario;
import br.com.Locacoes.Exception.UsuarioNotFound;
import br.com.Locacoes.Mapper.UsuarioMapper;
import br.com.Locacoes.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private UsuarioMapper usuarioMapper;

    public UsuarioResponseDTO adicionarUsuario(UsuarioCreationDTO dto) {
        Usuario usuario = usuarioMapper.toEntity(dto);

        Usuario savedUsuario = usuarioRepository.save(usuario);
        return usuarioMapper.toResponseDTO(savedUsuario);
    }

    public UsuarioResponseDTO buscarUsuario(Long id) {
        Optional<Usuario> usuarioOp = usuarioRepository.findById(id);
        Usuario usuario = usuarioOp.orElseThrow(()-> new UsuarioNotFound("Usuario com o ID" +id+" não encontrado"));
        return usuarioMapper.toResponseDTO(usuario);
    }

    public List<UsuarioResponseDTO> listarUsuarios() {
       return usuarioRepository.findAll().stream()
               .map(usuarioMapper::toResponseDTO)
               .toList();
    }

    public UsuarioResponseDTO atualizarUsuario(Long id, UsuarioCreationDTO dto) {
        Optional <Usuario> usuarioOp = usuarioRepository.findById(id);

        if (usuarioOp.isPresent()){
           Usuario usuarioToUpdate = usuarioOp.get();
           Usuario usuarioNewData = usuarioMapper.toEntity(dto);

           usuarioNewData.setId(id);
           usuarioNewData.setDataCriacao(usuarioToUpdate.getDataCriacao());

           Usuario savedUsuario = usuarioRepository.save(usuarioNewData);
           return usuarioMapper.toResponseDTO(savedUsuario);
        }
        throw new UsuarioNotFound("Cliente com o ID "+id+" não encontrado");
    }

    public void deletarUsuario(Long id) {
        if (!usuarioRepository.existsById(id)){
            throw new UsuarioNotFound("Usuário com o ID "+id+" não encontrado");
        }
        usuarioRepository.deleteById(id);
    }
}
