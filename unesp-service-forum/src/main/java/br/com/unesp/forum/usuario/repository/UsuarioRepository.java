package br.com.unesp.forum.usuario.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.unesp.forum.usuario.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Serializable>{

}
