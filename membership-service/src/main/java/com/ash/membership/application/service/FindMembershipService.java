package com.ash.membership.application.service;

import com.ash.membership.adapter.out.persistence.MembershipJpaEntity;
import com.ash.membership.adapter.out.persistence.MembershipMapper;
import com.ash.membership.application.port.in.FindMembershipCommand;
import com.ash.membership.application.port.in.FindMembershipUseCase;
import com.ash.membership.application.port.out.FindMembershipPort;
import com.ash.membership.domain.Membership;
import com.ash.common.UserCase;
import lombok.RequiredArgsConstructor;

@UserCase
@RequiredArgsConstructor
public class FindMembershipService implements FindMembershipUseCase {

    private final FindMembershipPort findMembershipById;
    private final MembershipMapper membershipMapper;

    @Override
    public Membership findMembership(FindMembershipCommand command) {
        MembershipJpaEntity membershipJpaEntity = findMembershipById.findMembershipById(
                new Membership.MembershipId(command.getMembershipId())
        );

        return membershipMapper.mapToDomainEntity(membershipJpaEntity);
    }
}
