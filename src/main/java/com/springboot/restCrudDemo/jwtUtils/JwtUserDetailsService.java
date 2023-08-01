package com.springboot.restCrudDemo.jwtUtils;



import java.util.ArrayList;

import com.springboot.restCrudDemo.dao.MemberRepository;
import com.springboot.restCrudDemo.entity.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    private final MemberRepository memberRepository;

    @Autowired
    public JwtUserDetailsService(MemberRepository userRepository) {
        this.memberRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Member member = memberRepository.findByUserName(username);
        if (member != null) {
            return new User(member.getUserName(), member.getPassword(), new ArrayList<>());
        } else {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }
}
