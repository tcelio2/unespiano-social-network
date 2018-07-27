package br.com.unesp.forum.usuario.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.unesp.forum.usuario.model.Usuario;
import br.com.unesp.forum.usuario.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repository;
	
	public Usuario salvar(Usuario user) {
		return this.repository.save(user);
	}
}
