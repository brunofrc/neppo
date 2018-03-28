package com.neppo.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.neppo.dto.DistanciaRequest;
import com.neppo.entity.Pessoa;
/**
 * Classe de acesso a Base de dados, onde estao implementados metodos
 * especificos para manipulacao de objetos do tipo {@link Pessoa}.
 *
 * @author bruno
 */
@Repository
@Transactional
public class PessoaDAO extends GenericDAO<Pessoa> implements IPessoaDAO {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.xy.inc.dao.IPessoaDAO#readAllPessoa()
	 */
	@Override
	@Transactional(readOnly = true)
	public List<Pessoa> readAllPessoa() throws DAOException {
		try {
			Criteria criteria = getCurrentSession().createCriteria(Pessoa.class);
			return criteria.list();
		} catch (HibernateException ex) {
			throw new DAOException(ex);
		} catch (Exception ex) {
			throw new DAOException(ex);
		}

	}

}
