package com.works.polling_app.controller;

import com.works.polling_app.domain.Member;
import com.works.polling_app.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequiredArgsConstructor
@RequestMapping("/api")
public class MemberController {

    private final MemberService memberService;

    @PostMapping("login")
    public ResponseEntity login(@RequestBody Member member){
        Member res = memberService.login(member.getUserName(), member.getPassWord());

        if(res == null){
            return new ResponseEntity(-1, HttpStatus.ACCEPTED);
        }
        else{
            return new ResponseEntity(res, HttpStatus.ACCEPTED);
        }
    }

    @PostMapping("register")
    public ResponseEntity register(@RequestBody Member member){

        Long res = memberService.join(member);

        if(res == null){
            return new ResponseEntity(-1, HttpStatus.BAD_REQUEST);
        }
        else{
            return new ResponseEntity(res, HttpStatus.ACCEPTED);
        }
    }


}
