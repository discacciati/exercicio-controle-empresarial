package com.controleempresarial.eliane.controller;

import com.controleempresarial.eliane.model.Veiculo;
import com.controleempresarial.eliane.service.VeiculoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/veiculo")
public class VeiculoController {

    private final VeiculoService veiculoService;

    public VeiculoController(VeiculoService veiculoService) {
        this.veiculoService = veiculoService;
    }

    @PostMapping
    public Veiculo salvar(@RequestBody Veiculo veiculo){
        return veiculoService.salvar(veiculo);
    }

    @GetMapping
    public List<Veiculo> listar(){
        return veiculoService.listar();
    }

    @GetMapping("/{id}")
    public Veiculo buscarPorId(@PathVariable Long id){

        return veiculoService.buscarPorId(id);
    }

    @GetMapping("/{ano}")
    public List<Veiculo> buscarPorAno(@PathVariable String ano){

        return veiculoService.buscarPorAno(ano);
    }

    @PutMapping("/{id}")
    public Veiculo atualizarPorId(@RequestBody Veiculo veiculo, @PathVariable Long id){
        return veiculoService.atualizar(veiculo, id);
    }

    @DeleteMapping("/{id}")
    public void deletarPorId(@PathVariable Long id){
        veiculoService.deletarPorId(id);
    }


}
