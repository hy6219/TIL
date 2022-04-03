package com.example.ocp.service;

import com.example.ocp.repository.JdbcMemberRepositoryImpl;
import com.example.ocp.repository.MemberRepository;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {

    private MemberRepository memberRepository = new JdbcMemberRepositoryImpl();
}
