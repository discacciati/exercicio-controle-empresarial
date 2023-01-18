package com.controleempresarial.eliane.controller;

import com.controleempresarial.eliane.model.Funcionario;
import com.controleempresarial.eliane.service.FuncionarioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {

    private final FuncionarioService funcionarioService;


    public FuncionarioController(FuncionarioService funcionarioService) {
        this.funcionarioService = funcionarioService;
    }

    @PostMapping
    public Funcionario salvar(@RequestBody Funcionario funcionario){
        return funcionarioService.salvar(funcionario);
    }

    @GetMapping
    public List<Funcionario> listar(){
        return funcionarioService.listar();
    }

    @GetMapping("/{id}")
    public Funcionario buscarPorId(@PathVariable Long id){
        return funcionarioService.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public Funcionario atualizarPorId(@RequestBody Funcionario funcionario, @PathVariable Long id){
        return funcionarioService.atualizar(funcionario, id);
    }

    @DeleteMapping("/{id}")
    public void deletarPorId(@PathVariable Long id){
        funcionarioService.deletarPorId(id);
    }


}
