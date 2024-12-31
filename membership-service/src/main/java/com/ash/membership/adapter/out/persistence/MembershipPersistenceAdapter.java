package com.ash.membership.adapter.out.persistence;

import common.PersistenceAdapter;
import com.ash.membership.application.port.out.MembershipPort;
import com.ash.membership.domain.Membership;
import lombok.RequiredArgsConstructor;

@PersistenceAdapter
@RequiredArgsConstructor
public class MembershipPersistenceAdapter implements MembershipPort {

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
}
