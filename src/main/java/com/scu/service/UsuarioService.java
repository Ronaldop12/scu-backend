package com.scu.service;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.scu.dto.UsuarioDTO;

import com.scu.model.Usuario;
import com.scu.repositories.UsuarioRepository;
import com.scu.service.execption.ObjectNotFoundException;



@Service
public class UsuarioService {
	
	
	@Autowired
	private UsuarioRepository repo;
			
		public Usuario find(Integer id) {
		Optional<Usuario> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Usuario.class.getName()));
	}
		public Usuario salvar(Usuario obj) {
			obj.setId(null);
			return repo.save(obj);
			
		}
			
				
		public Usuario update(Usuario obj) {
			Usuario newObj = find(obj.getId());
			updateData(newObj, obj);
			return repo.save(newObj);
		}
		
		public List<Usuario> findAll() {
			return repo.findAll();
		}
		
		public Usuario fromDTO(UsuarioDTO objDto) {
			return new Usuario(objDto.getId(), objDto.getNome(), objDto.getLogin(), objDto.getSenha());
		}
		
		private void updateData(Usuario newObj, Usuario obj) {
			newObj.setNome(obj.getNome());
		}
}
