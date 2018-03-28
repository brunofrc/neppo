package com.neppo.business;

import java.util.List;

import com.neppo.dao.PessoaDAO;
import com.neppo.dto.DistanciaRequest;
import com.neppo.entity.Pessoa;
/**
 * Interface de Negocio, onde estao definidos metodos especificos para
 * manipulacao de objetos do tipo @Link{Pessoa}.
 *
 * @author bruno
 */
public interface IPessoaBusiness extends IGenericBusiness<Pessoa,PessoaDAO>{
	
	/**
	 * Metodo responsavel por solicitar
	 * a camada de acesso a dados que recupere todos os pontos de interesse
	 * 
	 * @return 
	 * @throws BusinessException
	 */
	public List<Pessoa> readAllPessoa() throws BusinessException;
}
