package com.example.calccalorias.service;

import com.example.calccalorias.dto.UsuarioCadastroDTO;
import com.example.calccalorias.dto.UsuarioExibicaoDTO;
import com.example.calccalorias.model.Usuario;
import com.example.calccalorias.repository.UsuarioRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service // Avisa o Spring que ele precisará instânciar essa classe no momento da aplicação
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public UsuarioExibicaoDTO salvarUsuario(UsuarioCadastroDTO usuarioDTO){

        Usuario usuario = new Usuario();
        BeanUtils.copyProperties(usuarioDTO, usuario);
        Usuario usuarioSalvo = usuarioRepository.save(usuario);
        return new UsuarioExibicaoDTO(usuarioSalvo);
    }

    public UsuarioExibicaoDTO buscarPorId(Long id){
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);

        if(usuarioOptional.isPresent()){
            return new  UsuarioExibicaoDTO(usuarioOptional.get());
        } else{
            throw new RuntimeException("Usuário não existe!");
        }

    }

    public List<UsuarioExibicaoDTO> buscarTodos(){
        return usuarioRepository
                .findAll()
                .stream()
                .map(UsuarioExibicaoDTO::new)
                .toList();
    }

    public void excluir(Long id){
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);

        if (usuarioOptional.isPresent()){
            usuarioRepository.delete(usuarioOptional.get());
        } else {
            throw new RuntimeException("Usuário não encontrado!");
        }
    }

    public Usuario atualizar (Usuario usuario){
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(usuario.getUsuarioId());

        if(usuarioOptional.isPresent()){
            return usuarioRepository.save(usuario);
        } else{
            throw new RuntimeException("Usuário não encontrado!");
        }
    }

}
