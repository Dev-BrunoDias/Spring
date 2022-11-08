package org.soulcodeacademy.helpr.controllers;

import org.soulcodeacademy.helpr.domain.Funcionario;
import org.soulcodeacademy.helpr.domain.dto.FuncionarioDTO;
import org.soulcodeacademy.helpr.services.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @GetMapping("/funcionarios")
    public List<Funcionario> listar(){
        return this.funcionarioService.listar();
    }

    @GetMapping("/funcionarios/{idFuncionario}")
    public Funcionario getFuncionario(@PathVariable Integer idFuncionario) {
        return this.funcionarioService.getFuncionario(idFuncionario);
    }

}
