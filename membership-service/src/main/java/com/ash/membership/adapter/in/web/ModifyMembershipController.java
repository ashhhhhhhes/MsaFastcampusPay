package com.ash.membership.adapter.in.web;

import com.ash.membership.application.port.in.*;
import com.ash.membership.domain.Membership;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ModifyMembershipController {

    private final ModifyMembershipUseCase modifyMembershipUseCase;

    @PostMapping("/membership/modify/{membershipId}")
    public Membership findMembership(@RequestBody ModifyMembershipRequest request) {
        // Req -> Cmd
        ModifyMembershipCommand command = ModifyMembershipCommand.builder()
                .membershipId(request.getMembershipId())
                .name(request.getName())
                .address(request.getAddress())
                .email(request.getEmail())
                .isValid(request.isValid())
                .isCorp(request.isCorp())
                .isValid(true)
                .build();

        // UserCase
        return modifyMembershipUseCase.modifyMembership(command);
    }
}
