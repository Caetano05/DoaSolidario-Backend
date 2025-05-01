package project.doa.solidario.controllers;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import project.doa.solidario.modals.Usuario;
import project.doa.solidario.services.UsuarioService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("api/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService serviceUsuario;

    @PostMapping
    public ResponseEntity create(@RequestBody Usuario entity){
        Usuario save = serviceUsuario.salvar(entity);
        return ResponseEntity.created(URI.create("api/usuario" + entity.getId())).body(save);
    }

    @GetMapping
    public ResponseEntity findAll(){
        List<Usuario> usuarios = serviceUsuario.listarTodos();
        return ResponseEntity.ok(usuarios);
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable("id") Long id){
        Usuario usuario = serviceUsuario.listarPorId(id);
        return ResponseEntity.ok().body(usuario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity remove(@PathVariable("id") Long id){
        serviceUsuario.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable("id") Long id, @RequestBody Usuario entity){
        Usuario usuarioAlterado = serviceUsuario.alterarUsuario(id, entity);
        return ResponseEntity.ok().body(usuarioAlterado);

    }
}
