package tn.iit.spring.tp2.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import tn.iit.spring.tp2.dao.LangueDAO;
import tn.iit.spring.tp2.entites.Langue;


@Controller
@RequestMapping("api/language")
public class LangueController {

	@Autowired
	private LangueDAO dao;

	@GetMapping
	@ResponseBody
	public List<Langue> list() {
		return dao.findAll();
	}

	@GetMapping("/{id}")
	@ResponseBody
	public Langue show(@PathVariable Long id) {
		return dao.findOne(id);
	}

	//
	// @DeleteMapping("/{id}")
	// public void delete(@PathVariable Long id) {
	// dao.delete(id);
	// }
	/*
	 * /
	 * 
	 * @PutMapping("/{id}{nom}") public void update(@PathVariable Long
	 * id,@PathVariable String nom) { Langue l = new Langue(); l.setNom(nom);
	 * dao.save(l); }
	 */

	@PostMapping
	public void add(@RequestBody Langue langue) {
		// Langue l = new Langue();
		// l.setNom(nom);
		dao.save(langue);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		dao.delete(id);
	}

	@PutMapping("/{id}")
	@ResponseBody
	public void update(@PathVariable Long id, @RequestBody Langue langue) {
		Langue langueDB = dao.findOne(id);

		if (langueDB == null) {
			throw new RuntimeException("Langue not found");
			
		}

		if (langue.getNom() != null) {
			langueDB.setNom(langue.getNom());
			
		} else {
			throw new RuntimeException("Nom can not be null");
			
		}

		if (langue.getAbreviation() != null) {
			langueDB.setAbreviation(langue.getAbreviation());
			
		} else {
			throw new RuntimeException("Abreviation can not be null");
			
		}

		dao.save(langueDB);
	}

}
