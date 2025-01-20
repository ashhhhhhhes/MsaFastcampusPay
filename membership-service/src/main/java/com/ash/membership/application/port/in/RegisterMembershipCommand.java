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
public class RegisterMembershipCommand extends SelfValidating<RegisterMembershipCommand> {

    @NonNull
    private final String name;

    @NonNull
    private final String email;

    @NonNull
    private final String address;

    @AssertTrue
    private final boolean isValid;

    private final boolean isCorp;

    public RegisterMembershipCommand(@NonNull String name, @NonNull String email, @NonNull String address, boolean isValid, boolean isCorp) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.isValid = isValid;
        this.isCorp = isCorp;
        this.validateSelf();
    }

}
