package com.ash.banking.adapter.out.external.bank;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BankAccountInfo {
    private String bankName;
    private String bankAccountNumber;
    private boolean isValid;
}
