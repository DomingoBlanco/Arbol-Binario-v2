package com.arbolbinario.co.controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.arbolbinario.co.models.business.Arbol;
import com.arbolbinario.co.models.entity.Nodo;


@RestController
@RequestMapping("/api")
public class ArbolController {
	
	
	@Autowired
	private Arbol clienteService;

	@GetMapping("/arbol")
	public Nodo index() {
	        
	        Nodo padre = new Nodo();
	        padre.setDerecha(new Nodo(44));
	        padre.setIzquierda(new Nodo(85));
	        System.out.println("Arbol::"+clienteService.lowestCommonAncestor(padre, padre.getIzquierda(), padre.getDerecha()));
		return clienteService.lowestCommonAncestor(padre, padre.getIzquierda(), padre.getDerecha());
	}
	
	
	@GetMapping("/arbol/{izquierda}/{derecha}")
	public int index(@PathVariable Integer izquierda, @PathVariable Integer derecha ) {
		Nodo padre = new Nodo();
        padre.setDerecha(new Nodo(derecha));
        padre.setIzquierda(new Nodo(izquierda));
        System.out.println("Arbol::"+clienteService.lowestCommonAncestor(padre, padre.getIzquierda(), padre.getDerecha()));
	return clienteService.lowestCommonAncestor(padre, padre.getIzquierda(), padre.getDerecha()).getDato();
	}
	
	
	@PostMapping("/arbol")
	public ResponseEntity<?> create(@RequestBody int intArray[]) {
		
		
		Map<String, Object> response = new HashMap<>();
		
		
		
		try {
			if(intArray.length > 0) {
				
				for (int i = 0; i < intArray.length; i++) {
					clienteService.insertar(intArray[i]);
				}
				
			}else {
				response.put("mensaje", "No Ingreso datos al arbol");
				response.put("arbol", "datos vacios");
			}
			
		} catch(DataAccessException e) {
			response.put("mensaje", "Error al realizar el insert en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "Los hijos del arbol han sido creado con éxito!");
		response.put("arbol", "Creación Arbol Exitosa");
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	
}
