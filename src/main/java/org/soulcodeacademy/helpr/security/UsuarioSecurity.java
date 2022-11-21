package org.soulcodeacademy.helpr.security;

import org.soulcodeacademy.helpr.domain.enums.Perfil;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

// Esta classe serve de ponte para a comunicação entre a persistência e o framework Spring Secutity
public class UsuarioSecurity implements UserDetails {

    // Dados de autenticação
    private String email;
    private String senha;

    // Dados de autenticação
    private Perfil perfil;
    private ArrayList<SimpleGrantedAuthority> authorities = new ArrayList<>(); // Armazena as permissões/autoridades do usuário

    public UsuarioSecurity(String email, String senha, Perfil perfil) {
        this.email = email;
        this.senha = senha;
        this.perfil = perfil;
        // Adiciona a descrição do perfil como uma role do usuário
        this.authorities.add(new SimpleGrantedAuthority(perfil.getDescricao()));
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities; // Indicar para o Security as permissões/papeis do meu usuário
    }

    @Override
    public String getPassword() {
        // Indica para o Security que nosso usuário possui uma senha abaixo
        return this.senha;
    }

    @Override
    public String getUsername() {
        // Indica para o Security que nosso usuário possui o email abaixo
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        // Flag que indica que a conta é válida
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        // Flag que indica que a conta está desbloqueada
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // Flag que indica se as credenciais estão válidas
        return true;
    }

    @Override
    public boolean isEnabled() {
        // Flag que indica se usuário está habilitado
        return true;
    }

    // Indicamos por meio dos getters o estado de autenticação/autorização dos nossos usuários salvos no banco de dados.
}
