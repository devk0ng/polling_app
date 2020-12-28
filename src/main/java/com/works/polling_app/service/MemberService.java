package com.works.polling_app.service;

import com.works.polling_app.domain.Member;
import com.works.polling_app.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    //Register
    @Transactional
    public Long join(Member member){
        memberRepository.save(member);
        return member.getId();
    }


    //login
    public Member login(String userName, String password){
        Member res=null;

        List<Member> findMembers = memberRepository.findByName(userName);

        if(findMembers.isEmpty()){
            //throw new IllegalStateException("존재하지 않는 회원입니다.");
            return res;
        }
        for(Member m : findMembers){
            if(m.getPassWord().equals(password)){
                res = m;
                break;
            }
        }
        return res;
    }
}
