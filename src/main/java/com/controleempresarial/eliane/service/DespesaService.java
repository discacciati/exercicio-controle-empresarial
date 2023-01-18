package com.controleempresarial.eliane.service;

import com.controleempresarial.eliane.model.Despesa;
import com.controleempresarial.eliane.model.Endereco;
import com.controleempresarial.eliane.repository.DespesaRepository;
import com.controleempresarial.eliane.repository.EnderecoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DespesaService {

    private DespesaRepository despesaRepository;

    public DespesaService(DespesaRepository despesaRepository){
        this.despesaRepository = despesaRepository;
    }

    public Despesa salvar(Despesa despesa){

        return despesaRepository.save(despesa);
    }

    public List<Despesa> listar(){

        return (List<Despesa>) despesaRepository.findAll();
    }

    public Despesa buscarPorId(Long id){
        return despesaRepository.findById(id).orElseThrow(() -> new IllegalArgumentException());
    }

    public Despesa atualizar(Despesa despesa, Long id){
        Despesa despesaFound = despesaRepository.findById(id).orElse(null);

        despesaFound.setFornecedor(despesa.getFornecedor());
        despesaFound.setCategoria(despesa.getCategoria());
        despesaFound.setNumeroNF(despesa.getNumeroNF());
        despesaFound.setValorNF(despesa.getValorNF());
        despesaFound.setDataVencimento(despesa.getDataVencimento());
        despesaFound.setPago(despesa.getPago());

        despesaRepository.save(despesaFound);

        return despesaFound;
    }

    public void deletarPorId(Long id){
        despesaRepository.deleteById(id);
    }

}
