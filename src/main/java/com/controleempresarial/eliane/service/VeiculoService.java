package com.controleempresarial.eliane.service;

import com.controleempresarial.eliane.model.Veiculo;
import com.controleempresarial.eliane.repository.VeiculoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VeiculoService {

    private VeiculoRepository veiculoRepository;

    public VeiculoService(VeiculoRepository veiculoRepository){
        this.veiculoRepository = veiculoRepository;
    }

    public Veiculo salvar(Veiculo veiculo){

        return veiculoRepository.save(veiculo);
    }

    public List<Veiculo> listar(){

        return (List<Veiculo>) veiculoRepository.findAll();
    }

    public Veiculo buscarPorId(Long id){
        return veiculoRepository.findById(id).orElseThrow(() -> new IllegalArgumentException());
    }

    public Veiculo atualizar(Veiculo veiculo, Long id){
        Veiculo veiculoFound = veiculoRepository.findById(id).orElse(null);

        veiculoFound.setDescricao(veiculo.getDescricao());
        veiculoFound.setTipo(veiculo.getTipo());
        veiculoFound.setPlaca(veiculo.getPlaca());
        veiculoFound.setMarca(veiculo.getMarca());
        veiculoFound.setAnoFabricacao(veiculo.getAnoFabricacao());
        veiculoFound.setAnoModelo(veiculo.getAnoModelo());
        veiculoFound.setDataCompra(veiculo.getDataCompra());
        veiculoFound.setIpvaVencido(veiculo.getIpvaVencido());
        veiculoFound.setEndereco(veiculo.getEndereco());

        veiculoRepository.save(veiculoFound);

        return veiculoFound;
    }

    public void deletarPorId(Long id){
        veiculoRepository.deleteById(id);
    }

    public List<Veiculo> buscarPorAno(String ano) {
        Iterable<Veiculo> listaVeiculo = veiculoRepository.findAll();
        List<Veiculo> veiculos = new ArrayList<>();

        listaVeiculo.forEach(veiculo -> {
                    if(veiculo.getAnoFabricacao().equals(ano) || veiculo.getAnoModelo().equals(ano)){
                       veiculos.add(veiculo);
                    }
        });
        return veiculos;
    }
}
