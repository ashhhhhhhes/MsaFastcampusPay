package com.ash.membership.application.service;

import com.ash.membership.adapter.out.persistence.MembershipJpaEntity;
import com.ash.membership.adapter.out.persistence.MembershipMapper;
import com.ash.membership.application.port.in.ModifyMembershipCommand;
import com.ash.membership.application.port.in.ModifyMembershipUseCase;
import com.ash.membership.application.port.out.ModifyMembershipPort;
import com.ash.membership.domain.Membership;
import com.ash.common.UserCase;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@UserCase
@RequiredArgsConstructor
@Transactional
public class ModifyMembershipService implements ModifyMembershipUseCase {

    private final ModifyMembershipPort modifyMembershipPort;
    private final MembershipMapper membershipMapper;


    @Override
    public Membership modifyMembership(ModifyMembershipCommand command) {
        MembershipJpaEntity entity =  modifyMembershipPort.modifyMembership(
                new Membership.MembershipId(command.getMembershipId()),
                new Membership.MembershipName(command.getName()),
                new Membership.MembershipEmail(command.getEmail()),
                new Membership.MembershipAddress(command.getAddress()),
                new Membership.MembershipIsValid(command.isValid()),
                new Membership.MembershipIsIsCorp(command.isCorp())
        );

        return membershipMapper.mapToDomainEntity(entity);
    }

}
