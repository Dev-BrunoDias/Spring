package org.soulcodeacademy.helpr.services;

import net.bytebuddy.implementation.auxiliary.AuxiliaryType;
import org.soulcodeacademy.helpr.domain.Cargo;
import org.soulcodeacademy.helpr.domain.Cliente;
import org.soulcodeacademy.helpr.domain.dto.ClienteDTO;
import org.soulcodeacademy.helpr.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    public ClienteRepository clienteRepository;

    @Autowired
    private CargoService cargoService;

    public List<Cliente> listar() {
        return this.clienteRepository.findAll();
    }

    public Cliente getCliente(Integer idCliente) {
        Optional<Cliente> cliente = this.clienteRepository.findById(idCliente);
        if(cliente.isEmpty()) {
            throw  new RuntimeException("O cliente não foi encontrado");
        }else {
            return cliente.get();
        }

    }

    public Cliente salvar(ClienteDTO dto){
        Cargo cargo = this.cargoService.getCargo(dto.getIdCargo());

        Cliente cliente = new Cliente(null, dto.getNome(), dto.getEmail(), dto.getCpf(), dto.getSenha(), dto.getTelefone(), cargo);
        Cliente salvo = this.clienteRepository.save(cliente);
        return salvo;
    }

    public Cliente atualizar(Integer idCliente, ClienteDTO dto) {
        Cliente clienteAtual = this.getCliente(idCliente);
        Cargo cargo = this.cargoService.getCargo(dto.getIdCargo());

        clienteAtual.setNome(dto.getNome());
        clienteAtual.setEmail(dto.getEmail());
        clienteAtual.setCpf(dto.getCpf());
        clienteAtual.setSenha(dto.getSenha());
        clienteAtual.setTelefone(dto.getTelefone());
        clienteAtual.setCargo(cargo);

        Cliente atualizado = this.clienteRepository.save(clienteAtual);
        return atualizado;
    }

    public void deletar( Integer idCliente) {
        Cliente cliente = this.getCliente(idCliente);
        this.clienteRepository.delete(cliente);
    }
}
