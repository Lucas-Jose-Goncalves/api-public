package br.com.ilab.ilab.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.ilab.ilab.entities.Usuario;
import br.com.ilab.ilab.repositories.UsuarioRepository;

@Service
public class UsuarioDetalheImpl implements UserDetailsService {
	
	//Aqui será a comunicação com o banco para a consulta do usuário
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = usuarioRepository.findByEmail(username);
		if (usuario == null) {
			return null;			
		}
		return new UsuarioDetalhe(usuario);
	}

}
