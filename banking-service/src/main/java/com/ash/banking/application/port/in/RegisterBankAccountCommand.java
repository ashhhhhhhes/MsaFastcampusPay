package com.ash.banking.application.port.in;

import com.ash.common.SelfValidating;
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


    public RegisterBankAccountCommand(String membershipId, String bankName, String bankAccountNumber) {
        this.membershipId = membershipId;
        this.bankName = bankName;
        this.bankAccountNumber = bankAccountNumber;
        this.validateSelf();
    }
}
