package com.controleempresarial.eliane.service;

import com.controleempresarial.eliane.model.Usuario;
import com.controleempresarial.eliane.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario salvar(Usuario usuario){

        return usuarioRepository.save(usuario);
    }

    public List<Usuario> listar(){

        return (List<Usuario>) usuarioRepository.findAll();
    }

    public Usuario buscarPorId(Long id){
        return usuarioRepository.findById(id).orElseThrow(() -> new IllegalArgumentException());
    }

    public Usuario atualizar(Usuario usuario, Long id){
        Usuario usuarioFound = usuarioRepository.findById(id).orElse(null);

        usuarioFound.setNome(usuario.getNome());
        usuarioFound.setTelefone(usuario.getTelefone());
        usuarioFound.setCpf(usuario.getCpf());
        usuarioFound.setEmail(usuario.getEmail());

        usuarioRepository.save(usuarioFound);

        return usuarioFound;
    }

    public void deletarPorId(Long id){
        usuarioRepository.deleteById(id);
    }


}
