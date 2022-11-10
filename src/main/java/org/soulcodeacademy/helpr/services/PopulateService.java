package org.soulcodeacademy.helpr.services;

import org.soulcodeacademy.helpr.domain.Cargo;
import org.soulcodeacademy.helpr.domain.Cliente;
import org.soulcodeacademy.helpr.domain.Funcionario;
import org.soulcodeacademy.helpr.repositories.CargoRepository;
import org.soulcodeacademy.helpr.repositories.ClienteRepository;
import org.soulcodeacademy.helpr.repositories.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service // Indica para o spring que esta classe será gerenciada por ele
public class PopulateService {
    @Autowired // injetar o objeto direto na classe
    private CargoRepository cargoRepository;

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    public void populate() {
        Cargo c1 = new Cargo(null, "Diretor Geral", "Gerenciar a empresa", 30000.0);
        Cargo c2 = new Cargo(null, "Diretor de setor", "Gerencia um setor da empresa", 18000.0);
        Cargo c3 = new Cargo(null, " Técnico Geral", "Resolve os chamados urgentes", 12000.0);
        Funcionario f1 = new Funcionario(null, "Renato Pereira", "renato.pereira@gmail.com", "55627145587", "12345", null, c1);
        Funcionario f2 = new Funcionario(null, "Victor Icoma", "victor.icoma@gmail.com", "51127383671", "12345", null, c2);
        Cliente cliente1 = new Cliente(null, "Fernando Silva", "fernando.silva@gmail.com", "39823783209", "12345", "99-13456789");
        Cliente cliente2 = new Cliente(null, "Luiz Silva", "luiz.silva@gmail.com", "41181155819", "12345", "99-65748390");
        // vamos persistir as entidades = salvar no banco
        this.cargoRepository.save(c1); // INSERT INTO
        this.cargoRepository.save(c2);
        this.cargoRepository.save(c3);

        this.funcionarioRepository.save(f1);
        this.funcionarioRepository.save(f2);

        this.clienteRepository.save(cliente1);
        this.clienteRepository.save(cliente2);
    }
}

// O objetivo dessa classe é inserir no banco de dados fictícios (de teste)
// IOC = Inversion of Control = Inversão de Controle
//Container = é o local onde o Spring guarda os objetos anotados
// @Service = indica que a classe é um serviço

// Injeção de Dependências = quando o Spring injeta os objetos na classe
