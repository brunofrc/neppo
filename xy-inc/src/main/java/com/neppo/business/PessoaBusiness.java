package com.neppo.business;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.neppo.dao.DAOException;
import com.neppo.dao.PessoaDAO;
import com.neppo.dto.DistanciaRequest;
import com.neppo.entity.Pessoa;
/**
 * Classe onde estao implementados metodos especificos disponibilizados pela
 * camada de negocio, para manipulacao de objetos {@link Pessoa}.
 *
 * @author bruno
 */
@Component
@Transactional
public class PessoaBusiness extends GenericBusiness<Pessoa, PessoaDAO>
		implements IPessoaBusiness {
	
	//Aplicacao das regras de negocio para criacao de um Pessoa sobre o metodo generico
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Pessoa create(Pessoa entity) throws BusinessException {
		if (entity.getNome() ==null ) {
			throw new BusinessException("nome obrigatório");
		}
		if (entity.getIdade() <= 0) {
			throw new BusinessException("idade obrigatória");
		}
		if (entity.getSexo() == null) {
			throw new BusinessException("sexo obrigatório");
		}
		return super.create(entity);
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.xy.inc.business.IPessoaBusiness#readAllPessoa()
	 */
	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public List<Pessoa> readAllPessoa() throws BusinessException {
		try {
			return getDAO().readAllPessoa();
		} catch (DAOException ex) {
			throw new BusinessException(ex);
		}
	}

}
