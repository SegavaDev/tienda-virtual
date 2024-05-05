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

import com.segavaDev.tiendaVirtual.repositories.entities.Persona;
import com.segavaDev.tiendaVirtual.repositories.interfaces.UsuarioRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class JWTUserDetailService implements UserDetailsService {

	private final UsuarioRepository usuarioRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Optional<Persona> persona = this.usuarioRepository.findByEmail(username);

		if(persona.isPresent()) {
			return persona
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
			throw new UsernameNotFoundException("Usuario no encontrado con username: " + username);
		}
	}
}
