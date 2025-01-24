package com.ash.money.application.port.in;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class IncreaseMoneyRequestCommand {

    public String targetMembershipId;
    private int changingMoneyAmount;

}
