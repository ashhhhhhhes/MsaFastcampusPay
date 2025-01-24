package com.ash.money.adapter.out.persistence;

import com.ash.money.domain.MoneyChangingRequest;
import org.springframework.stereotype.Component;

@Component
public class MoneyChangingRequestMapper {

    public MoneyChangingRequest mapToMoneyChangingRequest(MoneyChangingRequestJpaEntity moneyChangingRequestEntity) {
        return MoneyChangingRequest.generateMoneyChangingRequest(
                new MoneyChangingRequest.MoneyChangingRequestId(moneyChangingRequestEntity.getMoneyChangingRequestId() + ""),
                new MoneyChangingRequest.TargetMembershipId(moneyChangingRequestEntity.getTargetMembershipId()),
                MoneyChangingRequest.ChangingType.fromInt(moneyChangingRequestEntity.getChangingType()),
                new MoneyChangingRequest.ChangingMoneyAmount(moneyChangingRequestEntity.getMoneyAmount()),
                MoneyChangingRequest.ChangingMoneyStatus.fromInt(moneyChangingRequestEntity.getChangingMoneyStatus()),
                moneyChangingRequestEntity.getUuid()
        );
    }

}
