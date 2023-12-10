package br.com.ilab.ilab.services;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.ilab.ilab.dto.UsuarioDTO;
import br.com.ilab.ilab.dto.UsuarioInserirDTO;
import br.com.ilab.ilab.entities.Perfil;
import br.com.ilab.ilab.entities.Usuario;
import br.com.ilab.ilab.entities.UsuarioPerfil;
import br.com.ilab.ilab.exceptions.EmailException;
import br.com.ilab.ilab.exceptions.SenhaException;
import br.com.ilab.ilab.exceptions.UnprocessableEntityException;
import br.com.ilab.ilab.repositories.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private PerfilService perfilService;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

//	@Autowired
//	private MailConfig mailConfig; //Aqui é a configuração para enviar os Email

	// Get
	public List<UsuarioDTO> findAll() {
		List<Usuario> usuarios = usuarioRepository.findAll();
		List<UsuarioDTO> usuariosDTO = usuarios.stream().map(usuario -> new UsuarioDTO(usuario))
				.collect(Collectors.toList());
		return usuariosDTO;
	}

	// Get ID
	public UsuarioDTO findById(Long id) {
		Optional<Usuario> usuarioOpt = usuarioRepository.findById(id);
		if (usuarioOpt.isEmpty()) {
			return null;
		}
		UsuarioDTO usuarioDTO = new UsuarioDTO(usuarioOpt.get());
		return usuarioDTO;
	}

	@Transactional
	public UsuarioDTO inserir(UsuarioInserirDTO usuarioInserirDTO) throws EmailException {
		if (!usuarioInserirDTO.getSenha().equalsIgnoreCase(usuarioInserirDTO.getConfirmaSenha())) {
			throw new SenhaException("Senha e Confirma Senha devem ser iguais");
		}

		Usuario usuarioEmailExistente = usuarioRepository.findByEmail(usuarioInserirDTO.getEmail());
		if (usuarioEmailExistente != null) {
			throw new EmailException("Email já cadastrado.");
		}

		Usuario usuario = new Usuario();
		usuario.setNome(usuarioInserirDTO.getNome());
		usuario.setEmail(usuarioInserirDTO.getEmail());
		usuario.setSenha(bCryptPasswordEncoder.encode(usuarioInserirDTO.getSenha()));

		Set<UsuarioPerfil> usuarioPerfis = new HashSet<>();
		for (Perfil perfil : usuarioInserirDTO.getPerfis()) {
			perfil = perfilService.buscar(perfil.getId());
			UsuarioPerfil usuarioPerfil = new UsuarioPerfil(usuario, perfil);
			usuarioPerfis.add(usuarioPerfil);
		}

		usuario.setUsuarioPerfis(usuarioPerfis);

		usuario = usuarioRepository.save(usuario);

//		mailConfig.sendEmail(usuario.getEmail(), "Cadastro de Usuario", usuario.toString()); //Aqui seria enviado o email do user para confirmação

		UsuarioDTO usuarioDTO = new UsuarioDTO(usuario);
		return usuarioDTO;

	}
}
