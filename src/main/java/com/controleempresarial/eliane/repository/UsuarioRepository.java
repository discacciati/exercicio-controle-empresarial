package com.controleempresarial.eliane.repository;

import com.controleempresarial.eliane.model.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
}
