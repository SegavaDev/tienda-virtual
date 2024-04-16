package com.segavaDev.tiendaVirtual.services.jwt;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.segavaDev.tiendaVirtual.repositories.entities.Administrador;
import com.segavaDev.tiendaVirtual.repositories.interfaces.AdministradorRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class JWTUserDetailService implements UserDetailsService {

	private final AdministradorRepository administradorRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Administrador> admin = this.administradorRepository.findByEmail(username);
		if(admin.isPresent()) {
			return admin
				.map(usuario -> {
					System.out.println("Rol " + usuario.getRol().getNombre().name());
					Set<GrantedAuthority> authorities = new HashSet<>();
					authorities.add(new SimpleGrantedAuthority(
					usuario.getRol().getNombre().name()));
					return new User(usuario.getEmail(), usuario.getPassWord(), authorities);
				})
				.orElseThrow(() -> new UsernameNotFoundException("User not exist"));
		}

		else {
			return null;
		}
	}
}
