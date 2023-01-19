package com.example.kcalog.service;

import com.example.kcalog.domain.Member;
import com.example.kcalog.dto.MemberDTO;
import com.example.kcalog.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public void save(MemberDTO memberDTO) {
        memberRepository.save(memberDTO.toMember());
    }

    public MemberDTO login(MemberDTO memberDTO) {
        /*
            1. 회원이 입력한 이메일로 DB에서 조회를 함
            2. DB에서 조회한 비밀번호와 사용자가 입력한 비밀번호가 일치하는지 판단
         */
        Optional<Member> byMemberEmail = memberRepository.findByEmail(memberDTO.getEmail());
        if (byMemberEmail.isPresent()) {
            //조회 결과가 있다.(해당 이메일을 가진 회원 정보가 있다.)
            Member member = byMemberEmail.get();
            if (member.getPassword().equals(memberDTO.getPassword())) {
                // 비밀번호 일치
                // entity -> dto 변환 후 리턴
                MemberDTO dto = MemberDTO.toMemberDTO(member);
                return dto;
            } else {
                // 비밀번호 불일치(로그인 실패)
                return null;
            }

        } else {
            //조회 결과가 없음.
            return null;
        }
    }

    public List<MemberDTO> findAll() {

        List<Member> memberEntityList = memberRepository.findAll();
        List<MemberDTO> memberDTOList = new ArrayList<>();

        for (Member member : memberEntityList) {
            memberDTOList.add(MemberDTO.toMemberDTO(member));
        }
        return memberDTOList;
    }

    public MemberDTO findById(Long id) {
        Optional<Member> optionalMemberEntity = memberRepository.findById(id);
        if (optionalMemberEntity.isPresent()) {
            return MemberDTO.toMemberDTO(optionalMemberEntity.get());
        } else {
            return null;
        }
    }
    public MemberDTO updateForm(String myEmail) {
        Optional<Member> optionalMember = memberRepository.findByEmail(myEmail);
        if (optionalMember.isPresent()) {
            return MemberDTO.toMemberDTO(optionalMember.get());
        } else {
            return null;
        }
    }

    public void update(MemberDTO memberDTO) {
        memberRepository.save(memberDTO.toMember());
    }
}
