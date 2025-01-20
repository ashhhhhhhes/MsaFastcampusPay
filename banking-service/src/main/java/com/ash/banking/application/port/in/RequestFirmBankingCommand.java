package com.ash.banking.application.port.in;

import com.ash.common.SelfValidating;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Positive;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;

@Builder
@Data
@EqualsAndHashCode(callSuper = false)
public class RequestFirmBankingCommand extends SelfValidating<RequestFirmBankingUserCase> {

    @NonNull
    private String fromBankName;

    @NonNull
    private String fromBankAccountNumber;

    @NonNull
    private String toBankName;

    @NonNull
    private String toBankAccountNumber;

    @Positive
    @Min(1)
    private int moneyAmount;

    public RequestFirmBankingCommand(@NonNull String fromBankName, @NonNull String fromBankAccountNumber, @NonNull String toBankName, @NonNull String toBankAccountNumber, int moneyAmount) {
        this.fromBankName = fromBankName;
        this.fromBankAccountNumber = fromBankAccountNumber;
        this.toBankName = toBankName;
        this.toBankAccountNumber = toBankAccountNumber;
        this.moneyAmount = moneyAmount;
        this.validateSelf();
    }
}
