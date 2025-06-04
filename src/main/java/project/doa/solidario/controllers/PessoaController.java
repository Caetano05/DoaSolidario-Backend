package project.doa.solidario.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.doa.solidario.modals.Pessoa;
import project.doa.solidario.services.PessoaService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("api/pessoa")
public class PessoaController {

    @Autowired
    private PessoaService servicePessoa;

    @PostMapping
    public ResponseEntity create(@RequestBody Pessoa entity){
        Pessoa save = servicePessoa.salvar(entity);
        return ResponseEntity.created(URI.create("/api/pessoa/" + entity.getId())).body(save);
    }

    @GetMapping
    public  ResponseEntity findAll(){
        List<Pessoa> pessoas = servicePessoa.listarTodos();
        return ResponseEntity.ok(pessoas);
    }

    @GetMapping("/{id}")
    public  ResponseEntity findById(@PathVariable("id") Long id){
        Pessoa pessoa = servicePessoa.listarPorId(id);
        return ResponseEntity.ok().body(pessoa);
    }
    @DeleteMapping("/{id}")
    public  ResponseEntity remove(@PathVariable("id") Long id){
        servicePessoa.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public  ResponseEntity update(@PathVariable("id") Long id, @RequestBody Pessoa entity){
        Pessoa PessoaAlterado = servicePessoa.alterarPessoa(id, entity);
        return  ResponseEntity.ok().body(PessoaAlterado);
    }
}
