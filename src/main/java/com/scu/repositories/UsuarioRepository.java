package com.scu.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.scu.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
	
	@Transactional(readOnly=true)
	Usuario findByLoginAndNome (String login, String nome );
	
	
}
