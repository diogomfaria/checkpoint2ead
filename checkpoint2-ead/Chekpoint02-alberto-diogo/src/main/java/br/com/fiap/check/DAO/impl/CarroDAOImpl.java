package br.com.fiap.check.DAO.impl;

import br.com.fiap.check.entity.Carro;


public class CarroDAOImpl extends HibernateGenericDAO<Carro, Long> {

	private static CarroDAOImpl instance = null;
	
	public static CarroDAOImpl getInstance() {
		if (instance == null) {
			instance = new CarroDAOImpl();
		}
		
		return instance;
	}
	
	private CarroDAOImpl() {
		super(Carro.class);
	}

}
