package mca.apimiel.Servicios;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import mca.apimiel.Entidades.Usuario;
import mca.apimiel.Repositorios.UsuariosRepositorio;

@Service
public class UserService implements UserDetailsService{
	
	@Autowired
	private UsuariosRepositorio usuariosRepositorio;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario us =  usuariosRepositorio.findByNombreUsuario(username);
		
		List<GrantedAuthority> roles = new ArrayList<>();
		//roles.add(new SimpleGrantedAuthority("ADMIN"));
		roles.add(new SimpleGrantedAuthority(us.getRolUsuario().getNombreRol()));
		
		UserDetails userDetail = new User(us.getNombreUsuario(), us.getContrasenia(), roles);
		return userDetail;
	}
}
