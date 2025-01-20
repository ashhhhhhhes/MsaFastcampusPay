package com.ash.banking.adapter.out.external.bank;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class GetBankAccountInfoRequest {

    private String bankName;
    private String bankAccountNumber;

}
