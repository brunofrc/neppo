package com.neppo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;



/**
 * Classe responsavel pelo mapeamento do objeto Pessoa
 * 
 * @author bruno
 *
 */
@Entity
@Table(name = "TB_PESSOA", uniqueConstraints = {
		@UniqueConstraint(name = "UNQ_NOM_PESSOA", columnNames = { "NOM_PESSOA" }) })
@SequenceGenerator(name = "SQ_PESSOA", sequenceName = "SQ_PESSOA", allocationSize = 1, initialValue = 1)
public class Pessoa {

	@Column(name = "COD_PESSOA")
	@Id
	@GeneratedValue(generator = "SQ_PESSOA", strategy = GenerationType.SEQUENCE)
	private Integer codigo;

	@Column(name = "NOM_PESSOA", length = 100, nullable = false)
	private String nome;

	@Column(name = "IDADE", length = 100, nullable = false)
	private Integer idade;
	
	@Column(name = "SEXO", length = 100, nullable = false)
	private String sexo;


	/**
	 * Metodo responsavel por recuperar a propriedade nome
	 * 
	 * @return nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Metodo responsavel por alterar a propriedade nome
	 * 
	 * @param nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	/**
	 * Metodo responsavel por recuperar a propriedade codigo
	 * 
	 * @return codigo
	 */
	public Integer getCodigo() {
		return codigo;
	}
	/**
	 * Metodo responsavel por alterar a propriedade codigo
	 * 
	 * @param codigo
	 */
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	/**
	 * Metodo responsavel por recuperar a propriedade idade
	 * 
	 * @return idade
	 */
	public Integer getIdade() {
		return idade;
	}
	/**
	 * Metodo responsavel por alterar a propriedade idade
	 * 
	 * @param idade
	 */
	public void setIdade(Integer idade) {
		this.idade = idade;
	}
	/**
	 * Metodo responsavel por recuperar a propriedade sexo
	 * 
	 * @return sexo
	 */
	public String getSexo() {
		return sexo;
	}
	/**
	 * Metodo responsavel por alterar a propriedade sexo
	 * 
	 * @param sexo
	 */
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
}