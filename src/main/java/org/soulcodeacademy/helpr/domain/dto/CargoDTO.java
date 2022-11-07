package org.soulcodeacademy.helpr.domain.dto;

/*AULA DIA 07 DE NOV DE 2022*/

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

//DTO = Objeto de transferência de Dados
//É útil para validarmo as informações transferidas pelo Cliente
public class CargoDTO { //vai ser usado para estruturar os dados
    //Vai ser feito validações
    @NotBlank(message = "O campo nome é obrigatório") //impede que o valor de nome seja "" (String vazia).
    //Message é p texto de validação. Essa anotação só serve para String
    private String nome;
    @NotBlank(message = "O campo descrição é obrigatório")
    private String descricao;
    @NotNull(message = "O campo salário é obrigatório") //Impede que o valor seja Nulo
    @Min(value = 500, message = "Campo salário inválido")
    @Max(value = 100000, message = "Campo salário inválido")
    private Double salario;


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }
}