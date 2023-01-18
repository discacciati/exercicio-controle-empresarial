package com.controleempresarial.eliane.controller;

import com.controleempresarial.eliane.model.Despesa;
import com.controleempresarial.eliane.service.DespesaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/despesa")
public class DespesaController {

    private final DespesaService despesaService;

    public DespesaController(DespesaService despesaService) {
        this.despesaService = despesaService;
    }

    @PostMapping
    public Despesa salvar(@RequestBody Despesa despesa){
        return despesaService.salvar(despesa);
    }

    @GetMapping
    public List<Despesa> listar(){
        return despesaService.listar();
    }

    @GetMapping("/{id}")
    public Despesa buscarPorId(@PathVariable Long id){
        return despesaService.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public Despesa atualizarPorId(@RequestBody Despesa despesa, @PathVariable Long id){
        return despesaService.atualizar(despesa, id);
    }

    @DeleteMapping("/{id}")
    public void deletarPorId(@PathVariable Long id){
        despesaService.deletarPorId(id);
    }


}
