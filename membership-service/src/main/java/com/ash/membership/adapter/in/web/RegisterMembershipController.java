package com.ash.membership.adapter.in.web;

import com.ash.common.WebAdapter;
import com.ash.membership.application.port.in.RegisterMembershipCommand;
import com.ash.membership.application.port.in.RegisterMembershipUserCase;
import com.ash.membership.domain.Membership;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequiredArgsConstructor
public class RegisterMembershipController {

    private final RegisterMembershipUserCase registerMembershipUserCase;

    @PostMapping("/membership/register")
    Membership registerMembership(@RequestBody RegisterMembershipRequest request) {
        // Req -> Cmd
        RegisterMembershipCommand command = RegisterMembershipCommand.builder()
                .name(request.getName())
                .address(request.getAddress())
                .email(request.getEmail())
                .isCorp(request.isCorp())
                .isValid(true)
                .build();

        // UserCase
        return registerMembershipUserCase.registerMembership(command);
    }

}