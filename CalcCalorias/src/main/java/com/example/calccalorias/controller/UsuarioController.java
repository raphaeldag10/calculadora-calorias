package com.example.calccalorias.controller;

import com.example.calccalorias.dto.UsuarioCadastroDTO;
import com.example.calccalorias.dto.UsuarioExibicaoDTO;
import com.example.calccalorias.model.Usuario;
import com.example.calccalorias.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Aqui está falando para o Spring que a classe é um controller
@RequestMapping("/api") // Esse é o caminho para acessar o controller

public class UsuarioController {

    @Autowired // Recurso do Spring usado para injeção de dependências automáticas
    private UsuarioService usuarioService; // Aqui trago a classe UsuarioService com usuarioService

    // Metodo para criar usuário
    @PostMapping("/usuarios") // Quando o cliente enviar uma requisição Post para a url /api/usuarios ele irá acessar esse metodo
    @ResponseStatus(HttpStatus.CREATED) // Resposta do servidor ao cliente se a requisição for bem sucedida Código 201
    public UsuarioExibicaoDTO salvar(@RequestBody UsuarioCadastroDTO usuarioCadastroDTO) { //@RequestBody quer dizer que o spring irá receber um arquivo JSON e precisa transformar ele em objeto para utilizar no metodo
        return usuarioService.salvarUsuario(usuarioCadastroDTO);
    }

    // Metodo para listar usuários
    @GetMapping("/usuarios") // Quando o cliente enviar uma requisição Get para a url /api/usuarios ele irá acessar esse metodo
    @ResponseStatus(HttpStatus.OK) // Resposta do servidor ao cliente se a requisição for bem sucedida código 200
    public List<UsuarioExibicaoDTO> listarTodos(){
        return usuarioService.buscarTodos();
    } // Irá devolver uma lista e enviar para o buscarTodos da classe UsuarioService

    // Metodo para visualizar um usuário
    @GetMapping("/usuarios/{id}") //http://localhost:8080/api/usuario/12
    @ResponseStatus(HttpStatus.OK) // Resposta do servidor ao cliente se a requisição for bem sucedida código 200
    public ResponseEntity <UsuarioExibicaoDTO> buscarPorId(@PathVariable Long id){ //@PathVariable quer dizer que ele irá pegar a variável que está no caminho da requisição no caso {id}
        try{
            return ResponseEntity.ok(usuarioService.buscarPorId(id));

        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Metodo para deletar um usuário
    @DeleteMapping("/usuarios/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT) // Resposta do servidor ao cliente se a requisição for bem sucedida código 204
    public void excluir(@PathVariable Long id){
        usuarioService.excluir(id);
    } // Não irá devolver nada pois foi excluir, mas irá enviar o ID do usuário que é pra ser excluído para o UsuarioService

    // Metodo para atualizar um usuário
    @PutMapping("/usuarios")
    @ResponseStatus(HttpStatus.OK) // Resposta do servidor ao cliente se a requisição for bem sucedida código 200
    public Usuario atualizar(@RequestBody Usuario usuario) { //@RequestBody quer dizer que o spring irá receber um arquivo JSON e precisa transformar ele em objeto para utilizar no metodo
        return usuarioService.atualizar(usuario);
    }
}

