package com.neppo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.neppo.business.BusinessException;
import com.neppo.business.IPessoaBusiness;
import com.neppo.entity.Pessoa;


/**
 * RestController 
 * @author bruno
 *
 */
@RestController
@CrossOrigin(origins = "*")
public class PessoaRestController {
	
	@Autowired
	private IPessoaBusiness business;
	 
	
	@RequestMapping(value = "/api/pessoa/create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> createPessoa(@RequestBody Pessoa pessoa)
			throws BusinessException {

		try {
			business.create(pessoa);

			return new ResponseEntity<Object[]>(new Object[] { pessoa, "registro salvo com sucesso!" },
					HttpStatus.OK);
		} catch (Exception ex) {
			throw new BusinessException(ex);
		}
	}
	@RequestMapping(value = "/api/pessoa/readAll", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> readAllPessoas()
			throws BusinessException {
		
		try {
			List<Pessoa> pessoa = business.readAllPessoa();
			
			return new ResponseEntity<List<Pessoa>>(pessoa,
					HttpStatus.OK);
		} catch (Exception ex) {
			throw new BusinessException(ex);
		}
	}
	@RequestMapping(value = "/api/pessoa/update", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> updatePessoa(@RequestBody Pessoa pessoa)
			throws BusinessException {

		try {
			business.update(pessoa);

			return new ResponseEntity<Object[]>(new Object[] { pessoa, "registro atualizado com sucesso!" },
					HttpStatus.OK);
		} catch (Exception ex) {
			throw new BusinessException(ex);
		}
	}
	@RequestMapping(value = "/api/pessoa/delete", method = RequestMethod.DELETE)
	public ResponseEntity<?> deletePessoa(@RequestBody Pessoa pessoa)
			throws BusinessException {

		try {
			business.delete(pessoa);

			return new ResponseEntity<String>("registro excluído com sucesso!",
					HttpStatus.OK);
		} catch (Exception ex) {
			throw new BusinessException(ex);
		}
	}
}
