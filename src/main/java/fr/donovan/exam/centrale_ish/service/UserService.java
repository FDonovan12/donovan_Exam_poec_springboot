package fr.donovan.exam.centrale_ish.service;

import fr.donovan.exam.centrale_ish.entity.User;
import fr.donovan.exam.centrale_ish.repository.UserRepository;
import fr.donovan.exam.centrale_ish.DTO.UserDTO;
import fr.donovan.exam.centrale_ish.exception.NotFoundCentraleIshException;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class UserService implements DAOServiceInterface<User>, UserDetailsService {

    private UserRepository userRepository;

    private BCryptPasswordEncoder passwordEncoder;

    public List<User> findAll() {
        return this.userRepository.findAll();
    }

    public User getByField(String field) {
        try {
            Long id = Long.parseLong(field);
            return getObjectById(id);
        } catch (NumberFormatException e) {
            throw  new NotFoundCentraleIshException("User", "field", field);
        }
    }

    public User getObjectById(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        optionalUser.orElseThrow(() -> new NotFoundCentraleIshException("User", "id", id));
        return optionalUser.get();
    }

    public User persist(UserDTO userDTO) {
        return persist(userDTO, null);
    }

    public User persist(UserDTO userDTO, Long id) {
        User user = new User();
        if (id != null) {
            user = getObjectById(id);
        }
        user.setEmail(userDTO.getEmail());
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));

        return userRepository.saveAndFlush(user);
    }

    public UserDTO getDTOById(Long id) {
        User user = getObjectById(id);
        UserDTO dto = new UserDTO();
        // dto.setName(user.getName());
        return dto;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> optionalUser = userRepository.findByEmail(username);
        optionalUser.orElseThrow(() -> new UsernameNotFoundException("User not found"));
        User user = optionalUser.get();

        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPassword(),
                userGrantedAuthority(user.getRoles())
        );
    }

    private List<GrantedAuthority> userGrantedAuthority(String role) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        List<String> roles = Collections.singletonList(role);
        roles.forEach(r -> {
            authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
            if (r.contains("ADMIN")) {
                authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
            }
        });
        return authorities;
    }
}
