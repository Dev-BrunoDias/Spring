package org.soulcodeacademy.helpr.services;

import org.soulcodeacademy.helpr.domain.Cargo;
import org.soulcodeacademy.helpr.repositories.CargoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service // Indica para o spring que esta classe será gerenciada por ele
public class PopulateService {
    @Autowired // injetar o objeto direto na classe
    private CargoRepository cargoRepository;

    public void populate() {
        Cargo c1 = new Cargo(null, "Diretor Geral", "Gerenciar a empresa", 30000.0);
        Cargo c2 = new Cargo(null, "Diretor de setor", "Gerencia um setor da empresa", 18000.0);
        Cargo c3 = new Cargo(null, " Técnico Geral", "Resolve os chamados urgentes", 12000.0);
        // vamos persistir as entidades = salvar no banco
        this.cargoRepository.save(c1); // INSERT INTO
        this.cargoRepository.save(c2);
        this.cargoRepository.save(c3);
    }
}

// O objetivo dessa classe é inserir no banco de dados fictícios (de teste)
// IOC = Inversion of Control = Inversão de Controle
//Container = é o local onde o Spring guarda os objetos anotados
// @Service = indica que a classe é um serviço

// Injeção de Dependências = quando o Spring injeta os objetos na classe
