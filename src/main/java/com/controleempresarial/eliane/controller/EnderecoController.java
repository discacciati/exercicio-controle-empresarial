package com.controleempresarial.eliane.controller;

import com.controleempresarial.eliane.model.Endereco;
import com.controleempresarial.eliane.service.EnderecoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {

    private final EnderecoService enderecoService;

    public EnderecoController(EnderecoService enderecoService) {
        this.enderecoService = enderecoService;
    }

    @PostMapping
    public Endereco salvar(@RequestBody Endereco endereco){
        return enderecoService.salvar(endereco);
    }

    @GetMapping
    public List<Endereco> listar(){
        return enderecoService.listar();
    }

    @GetMapping("/{id}")
    public Endereco buscarPorId(@PathVariable Long id){
        return enderecoService.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public Endereco atualizarPorId(@RequestBody Endereco endereco, @PathVariable Long id){
        return enderecoService.atualizar(endereco, id);
    }

    @DeleteMapping("/{id}")
    public void deletarPorId(@PathVariable Long id){
        enderecoService.deletarPorId(id);
    }




}
