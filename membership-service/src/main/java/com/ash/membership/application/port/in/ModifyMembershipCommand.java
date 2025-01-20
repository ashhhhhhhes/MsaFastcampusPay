package com.ash.membership.application.port.in;

import com.ash.common.SelfValidating;
import jakarta.validation.constraints.AssertTrue;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;

@Builder
@Data
@EqualsAndHashCode(callSuper = false)
public class ModifyMembershipCommand extends SelfValidating<ModifyMembershipCommand> {

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

    public ModifyMembershipCommand(@NonNull String membershipId, @NonNull String name, @NonNull String email, @NonNull String address, boolean isValid, boolean isCorp) {
        this.membershipId = membershipId;
        this.name = name;
        this.email = email;
        this.address = address;
        this.isValid = isValid;
        this.isCorp = isCorp;
        this.validateSelf();
    }
}
