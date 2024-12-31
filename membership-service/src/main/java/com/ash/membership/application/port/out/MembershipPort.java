package com.ash.membership.application.port.out;

import com.ash.membership.adapter.out.persistence.MembershipJpaEntity;
import com.ash.membership.domain.Membership;

public interface MembershipPort {

    MembershipJpaEntity createMembership(
            Membership.MembershipName membershipName,
            Membership.MembershipEmail membershipEmail,
            Membership.MembershipAddress membershipAddress,
            Membership.MembershipIsValid membershipIsValid,
            Membership.MembershipIsIsCorp membershipIsIsCorp
    );
}
