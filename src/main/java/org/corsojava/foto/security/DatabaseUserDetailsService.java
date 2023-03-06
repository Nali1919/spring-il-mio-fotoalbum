package org.corsojava.foto.security;

import java.util.Optional;

import org.corsojava.foto.model.User;
import org.corsojava.foto.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


public class DatabaseUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
    public UserDetails loadUserByUsername(String username)throws UsernameNotFoundException{

    Optional<User> utente = userRepository.findByUsername(username);

    if(utente.isPresent())
    	return new DatabaseUserDetails(utente.get());
    else
    	throw new UsernameNotFoundException("non esite");

    }

}
