package com.bolsadeideas.springboot.web.app.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bolsadeideas.springboot.web.app.models.Usuario;

@Controller
@RequestMapping("/app")
public class IndexController {
	
	@RequestMapping(value = {"/", "/index"}, method=RequestMethod.GET)
	public String index(Model model) {
		model.addAttribute("titulo", "Spring con Thymeleaf 2");
		return "index";
	}
	
	@RequestMapping("/perfil")
	public String perfil(Model model) {
		Usuario usuario = new Usuario();
		usuario.setNombre("Juan");
		usuario.setApellido("Diaz");
		usuario.setEmail("juan@correo.com");
		model.addAttribute("usuario", usuario);
		model.addAttribute("titulo", "Perfil del usuario " + usuario.getNombre());
		return "perfil";
	}
	
	@RequestMapping("/listar")
	public String listar(Model model) {
		List<Usuario> usuarios = getUsers();
		
		model.addAttribute("titulo", "Listado de usuarios");
		
		return "listar";
	}
	
	/*
	 * Los métodos anotados con ModelAttribute son comunes a todo el controlador
	 */
	@ModelAttribute("usuarios")
	public List<Usuario> getUsers(){
		List<Usuario> usuarios = new ArrayList<>();
		Usuario user1 = new Usuario("Pedro", "Jimenez");
		Usuario user2 = new Usuario("Jacinto", "Benavente");
		Usuario user3 = new Usuario("Rosamaría", "Prado");
		
		usuarios.add(user1);
		usuarios.add(user2);
		usuarios.add(user3);
		
		return usuarios;		
	}

}
