package com.ash.membership.adapter.out.persistence;

import com.ash.membership.application.port.out.FindMembershipPort;
import com.ash.membership.application.port.out.ModifyMembershipPort;
import com.ash.membership.application.port.out.RegisterMembershipPort;
import com.ash.membership.domain.Membership;
import com.ash.common.PersistenceAdapter;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@PersistenceAdapter
@RequiredArgsConstructor
public class MembershipPersistenceAdapter implements RegisterMembershipPort, FindMembershipPort, ModifyMembershipPort {

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
        return membershipRepository.findById(Long.valueOf(membershipId.getMembershipId())).get();
    }

    @Override
    public MembershipJpaEntity modifyMembership(Membership.MembershipId membershipId, Membership.MembershipName membershipName, Membership.MembershipEmail membershipEmail, Membership.MembershipAddress membershipAddress, Membership.MembershipIsValid membershipIsValid, Membership.MembershipIsIsCorp membershipIsIsCorp) {

        Optional<MembershipJpaEntity> opt = membershipRepository.findById(Long.valueOf(membershipId.getMembershipId()));

        if (opt.isEmpty()) throw new RuntimeException("Membership not found");

        MembershipJpaEntity entity = opt.get();
        entity.setName(membershipName.getName());
        entity.setEmail(membershipEmail.getEmail());
        entity.setAddress(membershipAddress.getAddress());
        entity.setValid(membershipIsValid.isValid());
        entity.setCorp(membershipIsIsCorp.isCorp());
        membershipRepository.save(entity);

        return entity;

    }
}
