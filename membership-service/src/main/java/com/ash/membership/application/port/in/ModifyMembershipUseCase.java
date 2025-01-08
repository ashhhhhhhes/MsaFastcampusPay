package com.ash.membership.application.port.in;

import com.ash.membership.domain.Membership;

public interface ModifyMembershipUseCase {

    Membership modifyMembership(ModifyMembershipCommand command);

}
