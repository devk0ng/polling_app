package com.works.polling_app.service;

import com.works.polling_app.domain.Member;
import com.works.polling_app.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@Rollback(value = false)
class MemberServiceTest {

    @Autowired MemberService memberService;
    @Autowired MemberRepository memberRepository;

    @Test
    void join() {
        //given
        Member member = new Member();
        member.setUserName("sungbin");
        member.setPassWord("123456");

        //when
        Long saveId = memberService.join(member);

        //then
        assertEquals(member,memberRepository.findOne(saveId));
    }

    @Test
    void login() {
        //given
        String userName = "sungbin";
        String passWord = "1234567";

        Member res = memberService.login(userName, passWord);

        if (res == null) {
            System.out.println("success!!");
            return;
        }
        fail();
//        if(res.getId() == 1)
//            System.out.println("success!!");
    }
}