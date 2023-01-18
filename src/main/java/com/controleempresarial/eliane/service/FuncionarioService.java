package com.controleempresarial.eliane.service;

import com.controleempresarial.eliane.model.Funcionario;
import com.controleempresarial.eliane.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public FuncionarioService(FuncionarioRepository funcionarioRepository){
        this.funcionarioRepository = funcionarioRepository;
    }

    public Funcionario salvar(Funcionario funcionario){
        return funcionarioRepository.save(funcionario);
    }

    public List<Funcionario> listar(){
        return (List<Funcionario>) funcionarioRepository.findAll();
    }

    public Funcionario buscarPorId(Long id){
        return funcionarioRepository.findById(id).orElseThrow(() -> new IllegalArgumentException());
    }

    public Funcionario atualizar(Funcionario funcionario, Long id){
        Funcionario funcionarioFound = funcionarioRepository.findById(id).orElse(null);

        funcionarioFound.setNome(funcionario.getNome());
        funcionarioFound.setTelefone(funcionario.getTelefone());
        funcionarioFound.setCpf(funcionario.getCpf());
        funcionarioFound.setEmail(funcionario.getEmail());
        funcionarioFound.setDataContratacao(funcionario.getDataContratacao());
        funcionarioFound.setEndereco(funcionario.getEndereco());

        funcionarioRepository.save(funcionarioFound);

        return funcionarioFound;
    }

    public void deletarPorId(Long id){
        funcionarioRepository.deleteById(id);
    }


}
