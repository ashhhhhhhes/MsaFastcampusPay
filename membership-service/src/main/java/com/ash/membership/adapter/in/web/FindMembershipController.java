package com.ash.membership.adapter.in.web;

import com.ash.membership.application.port.in.FindMembershipCommand;
import com.ash.membership.application.port.in.FindMembershipUseCase;
import com.ash.membership.domain.Membership;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class FindMembershipController {

    private final FindMembershipUseCase findMembershipUserCase;

    @GetMapping("/membership/{membershipId}")
    public Membership findMembership(@PathVariable String membershipId) {
        return findMembershipUserCase.findMembership(FindMembershipCommand.builder().membershipId(membershipId).build());
    }
}
