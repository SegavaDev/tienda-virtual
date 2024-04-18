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

import com.segavaDev.tiendaVirtual.repositories.entities.Personal;
import com.segavaDev.tiendaVirtual.repositories.interfaces.PersonalRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class JWTUserDetailService implements UserDetailsService {

	private final PersonalRepository personalRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Personal> personal = this.personalRepository.findByEmail(username);
		if(personal.isPresent()) {
			return personal
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
