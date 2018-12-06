package com.deva.foody.service;

import com.deva.foody.entity.Member;
import com.deva.foody.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import static java.util.Collections.emptyList;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private MemberRepository memberRepository;

    public UserDetailsServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Member member = memberRepository.findByUsername(username);
        if (member == null) {
            throw new UsernameNotFoundException(username);
        }
        return new User(member.getUsername(), member.getPassword(), emptyList());
    }
}
