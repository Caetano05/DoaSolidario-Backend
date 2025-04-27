package project.doa.solidario.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.doa.solidario.modals.SubCategoria;
import project.doa.solidario.services.SubCategoriaService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("api/sub")
public class SubCategoriaController {

    @Autowired
    private SubCategoriaService serviceSubCategoria;

    @PostMapping
    public ResponseEntity create(@RequestBody SubCategoria entity){
        SubCategoria save = serviceSubCategoria.salvar(entity);
        return ResponseEntity.created(URI.create("/api/sub/" + entity.getId())).body(save);
    }



    @GetMapping
    public  ResponseEntity findAll(){
        List<SubCategoria> subCategorias = serviceSubCategoria.listarTodos();
        return ResponseEntity.ok(subCategorias);
    }

    @GetMapping("/{id}")
    public  ResponseEntity findById(@PathVariable("id") Long id){
        SubCategoria subCategoria = serviceSubCategoria.listarPorId(id);
        return ResponseEntity.ok().body(subCategoria);
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity remove(@PathVariable("id") Long id){
        serviceSubCategoria.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public  ResponseEntity update(@PathVariable("id") Long id, @RequestBody SubCategoria entity){
        SubCategoria SubCategoriaAlterado = serviceSubCategoria.alterarSubCategoria(id, entity);
        return  ResponseEntity.ok().body(SubCategoriaAlterado);
    }
}

