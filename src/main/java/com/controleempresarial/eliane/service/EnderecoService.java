package com.controleempresarial.eliane.service;

import com.controleempresarial.eliane.model.Endereco;
import com.controleempresarial.eliane.repository.EnderecoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoService {

    private EnderecoRepository enderecoRepository;

    public EnderecoService(EnderecoRepository enderecoRepository){
        this.enderecoRepository = enderecoRepository;
    }

    public Endereco salvar(Endereco endereco){
        return enderecoRepository.save(endereco);
    }

    public List<Endereco> listar(){
        return (List<Endereco>) enderecoRepository.findAll();
    }

    public Endereco buscarPorId(Long id){
        return enderecoRepository.findById(id).orElseThrow(() -> new IllegalArgumentException());
    }

    public Endereco atualizar(Endereco endereco, Long id){
        Endereco enderecoFound = enderecoRepository.findById(id).orElse(null);

        enderecoFound.setCep(endereco.getCep());
        enderecoFound.setEstado(endereco.getEstado());
        enderecoFound.setCidade(endereco.getCidade());
        enderecoFound.setBairro(endereco.getBairro());
        enderecoFound.setLogradouro(endereco.getLogradouro());
        enderecoFound.setNumero(endereco.getNumero());

        enderecoRepository.save(enderecoFound);

        return enderecoFound;
    }

    public void deletarPorId(Long id){
        enderecoRepository.deleteById(id);
    }

}
