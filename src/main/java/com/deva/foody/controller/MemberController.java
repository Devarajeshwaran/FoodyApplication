package com.deva.foody.controller;

import com.deva.foody.entity.Member;
import com.deva.foody.repository.MemberRepository;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value="MemberController", description="Operations pertaining to Member in Foody App")
public class MemberController {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @PostMapping("/members/sign-up")
    public void signUp(@RequestBody Member member){
        member.setPassword(bCryptPasswordEncoder.encode(member.getPassword()));
        memberRepository.save(member);
    }
}
