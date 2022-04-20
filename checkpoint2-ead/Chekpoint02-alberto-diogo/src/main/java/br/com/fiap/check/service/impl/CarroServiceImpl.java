package br.com.fiap.check.service.impl;

import java.util.List;

import br.com.fiap.check.DAO.impl.AcessorioDAOImpl;
import br.com.fiap.check.DAO.impl.CarroDAOImpl;
import br.com.fiap.check.DAO.impl.ModeloDAOImpl;
import br.com.fiap.check.entity.Acessorio;
import br.com.fiap.check.entity.Carro;
import br.com.fiap.check.entity.Modelo;
import br.com.fiap.check.service.GenericService;


public class CarroServiceImpl extends GenericService<Carro, Long>{

private static CarroServiceImpl instance = null;
	
	private CarroDAOImpl carroDAO;
	private ModeloDAOImpl modeloDAO;
	private AcessorioDAOImpl acessorioDAO;
	
	private CarroServiceImpl() {
		carroDAO = CarroDAOImpl.getInstance();
		modeloDAO = ModeloDAOImpl.getInstance();
		acessorioDAO = AcessorioDAOImpl.getInstance();
	}
	
	public static CarroServiceImpl getInstance() {
		
		if (instance == null) {
			instance = new CarroServiceImpl();
		}
		
		return instance;
	}
	
	@Override
	public void cadastrar(Carro carro) {
		try {
			carroDAO.salvar(carro, getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
			getEntityManager().getTransaction().rollback();
		} finally {
			closeEntityManager();
		}
	}
	
	public void cadComModeloAcessorio(Carro carro, Modelo modelo, Acessorio acessorio ) {
		try {
			carroDAO.salvar(carro, getEntityManager());
			
			modelo.setCarro(carro);
			modeloDAO.salvar(modelo, getEntityManager());
			
			acessorio.setCarro(carro);
			acessorioDAO.salvar(acessorio, getEntityManager());
			
			acessorio.setCarro(carro);
			acessorioDAO.salvar(acessorio, getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
			getEntityManager().getTransaction().rollback();
		} finally {
			closeEntityManager();
		}
	}

	@Override
	public void atualizar(Carro carro) {
		try {
			carroDAO.atualizar(carro, getEntityManager());
		} catch (Exception e) {
			getEntityManager().getTransaction().rollback();
		} finally {
			closeEntityManager();
		}
	}

	@Override
	public void remover(Long id) {
		try {
			carroDAO.remover(id, getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
			getEntityManager().getTransaction().rollback();
		} finally {
			closeEntityManager();
		}
		
	}

	@Override
	public Carro obter(Long id) {
		Carro carro = null;
		
		try {
			carro = carroDAO.obterPorId(id, getEntityManager());
		} catch (Exception e) {
		} finally {
			closeEntityManager();
		}
		
		return carro;
	}

	@Override
	public List<Carro> listar() {
		List<Carro> carros = null;
		
		try {
			carros = carroDAO.listar(getEntityManager());
		} catch (Exception e) {
		} finally {
			closeEntityManager();
		}
		
		return carros;
	}

}
