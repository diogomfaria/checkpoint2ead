package br.com.fiap.check.main;

import br.com.fiap.check.entity.Acessorio;
import br.com.fiap.check.entity.Carro;
import br.com.fiap.check.entity.Modelo;
import br.com.fiap.check.service.impl.AcessorioServiceImpl;
import br.com.fiap.check.service.impl.CarroServiceImpl;
import br.com.fiap.check.service.impl.ModeloServiceImpl;

public class App {
	
    public static void main(String[] args) {
     
    	CarroServiceImpl carroService = CarroServiceImpl.getInstance();
    	ModeloServiceImpl modeloService = ModeloServiceImpl.getInstance();
    	AcessorioServiceImpl acessorioService = AcessorioServiceImpl.getInstance();
    	
    	Carro carro = new Carro("NJG8594", "Azul", "9BWHE21JX24060960");
    	Modelo modelo = new Modelo("Gol 1.6 Sedan");
    	Acessorio acessorio1 = new Acessorio ("Farol Xenon");
    	Acessorio acessorio2 = new Acessorio ("Central multimidia");
    	
    	carroService.cadastrar(carro);
    	
    	acessorioService.cadastrar(acessorio1);
    	acessorioService.cadastrar(acessorio2);

    	modeloService.cadastrar(modelo);
    	
    	acessorio1.setCarro(carro);
    	acessorio2.setCarro(carro);
    	
    	modelo.setCarro(carro);
    	
    	carroService.listar().forEach(System.out::println);
    }
}
