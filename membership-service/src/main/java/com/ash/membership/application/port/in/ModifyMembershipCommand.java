package com.ash.membership.application.port.in;

import jakarta.validation.constraints.AssertTrue;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;

@Builder
@Data
@EqualsAndHashCode(callSuper = false)
public class ModifyMembershipCommand {

    @NonNull
    private final String membershipId;

    @NonNull
    private final String name;

    @NonNull
    private final String email;

    @NonNull
    private final String address;

    @AssertTrue
    private final boolean isValid;

    private final boolean isCorp;

}
