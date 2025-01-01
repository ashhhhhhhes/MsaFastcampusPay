package com.ash.membership.adapter.out.persistence;

import com.ash.membership.application.port.out.FindMembershipPort;
import common.PersistenceAdapter;
import com.ash.membership.application.port.out.RegisterMembershipPort;
import com.ash.membership.domain.Membership;
import lombok.RequiredArgsConstructor;

@PersistenceAdapter
@RequiredArgsConstructor
public class MembershipPersistenceAdapter implements RegisterMembershipPort, FindMembershipPort {

    private final SpringJpaMembershipRepository membershipRepository;

    @Override
    public MembershipJpaEntity createMembership(Membership.MembershipName membershipName, Membership.MembershipEmail membershipEmail, Membership.MembershipAddress membershipAddress, Membership.MembershipIsValid membershipIsValid, Membership.MembershipIsIsCorp membershipIsIsCorp) {
        return membershipRepository.save(new MembershipJpaEntity(
                membershipName.getName(),
                membershipEmail.getEmail(),
                membershipAddress.getAddress(),
                membershipIsValid.isValid(),
                membershipIsIsCorp.isCorp()
        ));
    }

    @Override
    public MembershipJpaEntity findMembershipById(Membership.MembershipId membershipId) {
        return membershipRepository.findById(Long.valueOf(membershipId.getMembershipId())).get() ;
    }
}
