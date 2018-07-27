package br.com.unesp.forum.usuario.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.unesp.forum.usuario.model.Usuario;
import br.com.unesp.forum.usuario.service.UsuarioService;

@RestController
@RequestMapping("usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService service;
	
	
	@PostMapping()
	@ResponseStatus(code = HttpStatus.OK)
	public Usuario save(@RequestBody Usuario usuario) {
		return service.salvar(usuario);
	}
}
