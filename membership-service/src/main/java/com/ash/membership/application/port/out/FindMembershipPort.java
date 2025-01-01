package com.ash.membership.application.port.out;

import com.ash.membership.adapter.out.persistence.MembershipJpaEntity;
import com.ash.membership.domain.Membership;

public interface FindMembershipPort {
    MembershipJpaEntity findMembershipById(Membership.MembershipId membershipId);
}
