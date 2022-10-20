package com.indocyber.penjualan.service.implementation;

import com.indocyber.penjualan.dto.users.RegisterDTO;
import com.indocyber.penjualan.entity.Users;
import com.indocyber.penjualan.repository.UsersRepository;
import com.indocyber.penjualan.service.abstraction.UsersService;
import com.indocyber.penjualan.utility.ApplicationUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsersServiceImpl implements UsersService , UserDetailsService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Users> nullableEntity = usersRepository.findById(username);
        Users users = nullableEntity.get();
        return new ApplicationUserDetails(users);
    }

    @Override
    public boolean checkExistingAccount(String username) {
        Long totalUser = usersRepository.count(username);
        return (totalUser > 0) ? true : false;
    }

    @Override
    public void registerAccount(RegisterDTO dto) {
        String hashPassword = passwordEncoder.encode(dto.getPassword());
        Users user = new Users(
                dto.getUsername(),
                hashPassword);
        usersRepository.save(user);
    }
}
