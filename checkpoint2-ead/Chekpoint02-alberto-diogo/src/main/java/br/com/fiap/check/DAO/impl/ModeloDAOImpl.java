package br.com.fiap.check.DAO.impl;

import br.com.fiap.check.entity.Modelo;

public class ModeloDAOImpl extends HibernateGenericDAO<Modelo, Long> {
	
	private static ModeloDAOImpl instance = null;
	
	public static ModeloDAOImpl getInstance() {
		if (instance == null) {
			instance = new ModeloDAOImpl();
		}
		
		return instance;
	}
	
	private ModeloDAOImpl() {
		super(Modelo.class);
	}

}
