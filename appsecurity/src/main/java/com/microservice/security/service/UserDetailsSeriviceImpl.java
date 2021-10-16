package com.microservice.security.service;

import com.microservice.security.model.UserDetailEntity;
import com.microservice.security.repository.UserRepository;
import com.microservice.security.vo.UserDetailsVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsSeriviceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<UserDetailEntity> userEntity = userRepository.findByUserName(userName);
        userEntity.orElseThrow(() -> new UsernameNotFoundException("Not found : " + userName));
        return userEntity.map(UserDetailsVO::new).get();
    }
}
