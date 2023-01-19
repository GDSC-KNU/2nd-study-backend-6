package com.example.kcalog.dto;

import com.example.kcalog.domain.Gender;
import com.example.kcalog.domain.Member;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class MemberDTO {
    private Long id;
    private String email;
    private String password;
    private String name;
    private float height;
    private float weight;
    private Gender gender;
    private float dayKcal;

    public Member toMember() {
        return new Member(email, password, name, height, weight, gender, dayKcal);
    }

    public static MemberDTO toMemberDTO(Member member) {
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setId(member.getId());
        memberDTO.setEmail(member.getEmail());
        memberDTO.setPassword(member.getPassword());
        memberDTO.setName(member.getName());
        memberDTO.setGender(member.getGender());
        memberDTO.setHeight(member.getHeight());
        memberDTO.setWeight(member.getWeight());
        return memberDTO;
    }

}
