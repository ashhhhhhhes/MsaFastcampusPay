package com.ash.banking.application.port.in;

import com.ash.common.SelfValidating;
import jakarta.validation.constraints.AssertTrue;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;

@Builder
@Data
@EqualsAndHashCode(callSuper = false)
public class RegisterBankAccountCommand extends SelfValidating<RegisterBankAccountCommand> {

    @NonNull
    private String membershipId;

    @NonNull
    private String bankName;

    @NonNull
    private String bankAccountNumber;

    @AssertTrue
    private boolean isValid;

    public RegisterBankAccountCommand(String membershipId, String bankName, String bankAccountNumber, boolean isValid) {
        this.membershipId = membershipId;
        this.bankName = bankName;
        this.bankAccountNumber = bankAccountNumber;
        this.isValid = isValid;
        this.validateSelf();
    }
}
