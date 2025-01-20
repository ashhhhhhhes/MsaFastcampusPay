package com.ash.membership.application.port.in;

import com.ash.common.SelfValidating;
import lombok.*;

@Builder
@Data
@EqualsAndHashCode(callSuper = false)
public class FindMembershipCommand extends SelfValidating<FindMembershipCommand> {

    @NonNull
    private final String membershipId;

    public FindMembershipCommand(@NonNull String membershipId) {
        this.membershipId = membershipId;
        this.validateSelf();
    }
}
