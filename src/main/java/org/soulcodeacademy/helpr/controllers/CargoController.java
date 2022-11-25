package org.soulcodeacademy.helpr.controllers;

import org.soulcodeacademy.helpr.domain.Cargo;
import org.soulcodeacademy.helpr.domain.dto.CargoDTO;
import org.soulcodeacademy.helpr.services.CargoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController // retornos de dados
public class CargoController {

    @GetMapping("/oi") // com base em localhost:8080/oi retorna String
    public String dizOla(){
        return "Batata!";
    }

    @GetMapping("/batata")
    public  Integer valor() {
        return 1000;
    }

    @Autowired
    private CargoService cargoService;
@PreAuthorize("hasRole('ROLE_ADMIN', ROLE_FUNCIONARIO)")
    @GetMapping("/cargos")
    public List<Cargo> listar() {
        // Requisição -> Controller -> Service -> Repository -> SELECT * FROM cargo;
        return this.cargoService.listar(); // JSON = JAVASCRIPT OBJECT NOTATION
    }
    @PreAuthorize("hasRole('ROLE_ADMIN', ROLE_FUNCIONARIO)")
@GetMapping("/cargos/{idCargo}") // indica que o valor após a barra é dinâmico
    public Cargo getCargo(@PathVariable Integer idCargo) {
        return this.cargoService.getCargo(idCargo);
}

@PreAuthorize("hasRole('ROLE_ADMIN')") // Apenas os admins podem acessar este endpoint
@PostMapping("/cargos")
    public Cargo salvar(@Valid @RequestBody CargoDTO cargo) {
        //@RequestBody - extrair o JSON do corpo e converte para cargo (deserialização)
    Cargo salvo = this.cargoService.salvar(cargo);
        return salvo; // A resposta será o cargo inserido
}
//Mapea requisição do verbo PUT
    @PreAuthorize("hasRole('ROLE_ADMIN')")
@PutMapping("/cargos/{idCargo}")
    public Cargo atualizar(@PathVariable Integer idCargo,@Valid @RequestBody CargoDTO cargo) {
        Cargo atualizado = this.cargoService.atualizar(idCargo, cargo);
        return atualizado;
}
@PreAuthorize("hasRole('ROLE_ADMIN')")
@DeleteMapping("/cargos/{idCargo}") // Verbo DELETE no /cargos/1
    public  void  deletar(@PathVariable Integer idCargo) {
        this.cargoService.deletar(idCargo);
}

}
