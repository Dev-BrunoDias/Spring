package org.soulcodeacademy.helpr.services;

import jdk.dynalink.linker.LinkerServices;
import org.soulcodeacademy.helpr.domain.Chamado;
import org.soulcodeacademy.helpr.domain.Cliente;
import org.soulcodeacademy.helpr.domain.dto.ChamadoDTO;
import org.soulcodeacademy.helpr.repositories.ChamadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChamadoService {
    @Autowired
    private ChamadoRepository chamadoRepository;

    @Autowired
    private ClienteService clienteService;

    public List<Chamado> listarChamados() {
        return this.chamadoRepository.findAll();
    }

    public Chamado getChamado(Integer idChamado) {
        return this.chamadoRepository.findById(idChamado)
                .orElseThrow(() -> new RuntimeException("Chamado não encontrado"));
    }

    public Chamado salvar(ChamadoDTO dto) {
        // Verificar se existe um cliente com este ID
        Cliente cliente = this.clienteService.getCliente(dto.getIdCliente());
        Chamado chamado = new Chamado(null, dto.getTitulo(), dto.getDescricao());
        chamado.setCliente(cliente); // associa o cliente ao chamado

        return this.chamadoRepository.save(chamado);
    }

    public Chamado atualizar(Integer idChamado, ChamadoDTO dto) {
        Chamado chamadoAtual = this.getChamado(idChamado);

        chamadoAtual.setTitulo(dto.getTitulo());
        chamadoAtual.setDescricao(dto.getDescricao());
        Chamado atualizado = this.chamadoRepository.save(chamadoAtual);
        return atualizado;
    }
}
