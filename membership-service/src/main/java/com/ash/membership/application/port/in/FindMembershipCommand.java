package com.ash.membership.application.port.in;

import common.SelfValidating;
import lombok.*;

@Builder
@Data
@EqualsAndHashCode(callSuper = false)
public class FindMembershipCommand extends SelfValidating<FindMembershipCommand> {

    @NonNull
    private final String membershipId;

}
