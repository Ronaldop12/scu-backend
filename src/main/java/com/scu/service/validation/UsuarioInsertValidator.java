package com.scu.service.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.scu.dto.UsuarioDTO;
import com.scu.model.Usuario;
import com.scu.repositories.UsuarioRepository;
import com.scu.resources.exception.FieldMessage;


public class UsuarioInsertValidator implements ConstraintValidator<UsuarioInsert, UsuarioDTO> {
	
	@Autowired
	private UsuarioRepository repo;
	
	@Override
	public void initialize(UsuarioInsert ann) {
	}
	
	
	@Override
	public boolean isValid(UsuarioDTO objDto, ConstraintValidatorContext context) {

		List<FieldMessage> list = new ArrayList<>();
		
		
		Usuario aux = repo.findByLoginAndNome(objDto.getLogin(), objDto.getNome());
		if (aux != null) {
			list.add(new FieldMessage("login", "Login já existente"));
		}

		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}
}
