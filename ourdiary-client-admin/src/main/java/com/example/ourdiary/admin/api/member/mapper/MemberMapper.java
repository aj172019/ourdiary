package com.example.ourdiary.admin.api.member.mapper;

import com.example.ourdiary.admin.api.member.dto.*;
import com.example.ourdiary.member.entity.Member;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MemberMapper {

    @Mapping(target = "id", ignore = true)
    Member toMember(RegisterMemberRequest registerMemberRequest);

    RegisterMemberResponse toRegisterMemberResponse(Member member);

    List<MemberAutocompleteResponse> toMemberAutocompleteResponse(List<Member> members);

    MemberSearchResponse toMemberSearchResponse(Member member);
    
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "password", ignore = true)
    @Mapping(target = "profilePic", ignore = true)
    Member toMember(MemberSearchRequest memberSearchRequest);
}