package project.doa.solidario.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.doa.solidario.modals.Item;
import project.doa.solidario.services.ItemService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("api/item")
public class ItemController {

    @Autowired
    private ItemService serviceItem;

    @PostMapping
    public ResponseEntity create(@RequestBody Item entity){
        Item save = serviceItem.salvar(entity);
        return ResponseEntity.created(URI.create("/api/item/" + entity.getId())).body(save);
    }

    @GetMapping
    public  ResponseEntity findAll(){
        List<Item> itens = serviceItem.buscaTodos();
        return ResponseEntity.ok(itens);
    }
    @GetMapping("/{id}")
    public  ResponseEntity findById(@PathVariable("id") Long id){
        Item iten = serviceItem.buscarPorId(id);
        return ResponseEntity.ok().body(iten);
    }
    @DeleteMapping("/{id}")
    public  ResponseEntity remove(@PathVariable("id") Long id){
        serviceItem.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public  ResponseEntity update(@PathVariable("id") Long id, @RequestBody Item entity){
        Item ItemAlterado = serviceItem.alterarItem(id, entity);
        return  ResponseEntity.ok().body(ItemAlterado);
    }


}
