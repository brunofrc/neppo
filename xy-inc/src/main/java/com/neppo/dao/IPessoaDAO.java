package com.neppo.dao;

import java.util.List;

import com.neppo.dto.DistanciaRequest;
import com.neppo.entity.Pessoa;
/**
 * Interface de acesso a Base de dados, onde estao definidos metodos especificos
 * para manipulacao de objetos do tipo {@link Pessoa}.
 *
 * @author bruno
 */
public interface IPessoaDAO extends IGenericDAO<Pessoa> {
	/**
	 * Metodo responsavel por recuperar todos os objetos do tipo Pessoa da
	 * camada DAO
	 * 
	 * @return
	 * @throws DAOException
	 */
	public List<Pessoa> readAllPessoa() throws DAOException;

}
