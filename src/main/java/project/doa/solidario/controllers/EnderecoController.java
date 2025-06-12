package project.doa.solidario.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import project.doa.solidario.modals.Endereco;
import project.doa.solidario.modals.Pessoa;
import project.doa.solidario.services.EnderecoService;
import project.doa.solidario.services.PessoaService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("api/endereco")
public class EnderecoController {

    @Autowired
    private EnderecoService serviceEndereco;

    @PostMapping
    public ResponseEntity create(@RequestBody Endereco entity){
        Endereco save = serviceEndereco.salvar(entity);
        return ResponseEntity.created(URI.create("/api/endereco/" + entity.getId())).body(save);
    }

    @GetMapping
    public  ResponseEntity findAll(){
        List<Endereco> enderecos = serviceEndereco.listarTodos();
        return ResponseEntity.ok(enderecos);
    }

    @GetMapping("/{id}")
    public  ResponseEntity findById(@PathVariable("id") Long id){
        Endereco endereco = serviceEndereco.listarPorId(id);
        return ResponseEntity.ok().body(endereco);
    }
    @DeleteMapping("/{id}")
    public  ResponseEntity remove(@PathVariable("id") Long id){
        serviceEndereco.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public  ResponseEntity update(@PathVariable("id") Long id, @RequestBody Endereco entity){
        Endereco EnderecoAlterado = serviceEndereco.alterarEndereco(id, entity);
        return  ResponseEntity.ok().body(EnderecoAlterado);
    }
}
