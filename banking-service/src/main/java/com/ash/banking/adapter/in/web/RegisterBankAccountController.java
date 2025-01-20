package com.ash.banking.adapter.in.web;

import com.ash.banking.application.port.in.RegisterBankAccountCommand;
import com.ash.banking.application.port.in.RegisterBankAccountUserCase;
import com.ash.banking.domain.RegisteredBankAccount;
import com.ash.common.WebAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequiredArgsConstructor
public class RegisterBankAccountController {

    private final RegisterBankAccountUserCase registerBankAccountUserCase;

    @PostMapping("/membership/register")
    RegisteredBankAccount registerMembership(@RequestBody RegisterBankAccountRequest request) {
        // Req -> Cmd
        RegisterBankAccountCommand command = RegisterBankAccountCommand.builder()
                .membershipId(request.getMembershipId())
                .bankName(request.getBankName())
                .bankAccountNumber(request.getBankAccountNumber())
                .isValid(request.isValid())
                .build();

        // UserCase
        return registerBankAccountUserCase.registerMembership(command);
    }

}