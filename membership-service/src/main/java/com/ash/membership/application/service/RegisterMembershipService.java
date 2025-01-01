package com.ash.membership.application.service;

import common.UserCase;
import com.ash.membership.adapter.out.persistence.MembershipJpaEntity;
import com.ash.membership.adapter.out.persistence.MembershipMapper;
import com.ash.membership.application.port.in.RegisterMembershipCommand;
import com.ash.membership.application.port.in.RegisterMembershipUserCase;
import com.ash.membership.application.port.out.RegisterMembershipPort;
import com.ash.membership.domain.Membership;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;


@UserCase
@Transactional
@RequiredArgsConstructor
public class RegisterMembershipService implements RegisterMembershipUserCase {

    private final RegisterMembershipPort membershipPort;
    private final MembershipMapper membershipMapper;

    @Override
    public Membership registerMembership(RegisterMembershipCommand command) {
        MembershipJpaEntity jpaEntity = membershipPort.createMembership(
                new Membership.MembershipName(command.getName()),
                new Membership.MembershipEmail(command.getEmail()),
                new Membership.MembershipAddress(command.getAddress()),
                new Membership.MembershipIsValid(command.isValid()),
                new Membership.MembershipIsIsCorp(command.isCorp())
        );

        // entity -> domain
        return membershipMapper.mapToDomainEntity(jpaEntity);
    }
}
