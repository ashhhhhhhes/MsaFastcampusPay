package com.ash.money.adapter.out.persistence;

import com.ash.common.PersistenceAdapter;
import com.ash.money.application.port.out.IncreaseMemberMoneyPort;
import com.ash.money.application.port.out.ChangingMoneyRequestPort;
import com.ash.money.domain.MemberMoney;
import com.ash.money.domain.MoneyChangingRequest;
import lombok.RequiredArgsConstructor;

import java.sql.Timestamp;
import java.util.UUID;

@PersistenceAdapter
@RequiredArgsConstructor
public class IncreaseMoneyAdapter implements ChangingMoneyRequestPort<MoneyChangingRequestJpaEntity>, IncreaseMemberMoneyPort<MemberMoneyJpaEntity> {

    private final SpringJpaMoneyChangingRequestRepository moneyChangingRequestRepository;
    private final SpringJpaMemberMoneyRepository memberMoneyRepository;

    @Override
    public MoneyChangingRequestJpaEntity createChangingMoneyRequest(
            MoneyChangingRequest.TargetMembershipId targetMembershipId,
            MoneyChangingRequest.ChangingType changingType,
            MoneyChangingRequest.ChangingMoneyAmount changingMoneyAmount,
            MoneyChangingRequest.ChangingMoneyStatus changingMoneyStatus,
            UUID uuid
    ) {

        return moneyChangingRequestRepository.save(
                new MoneyChangingRequestJpaEntity(
                        targetMembershipId.value(),
                        changingType.ordinal(),
                        changingMoneyAmount.value(),
                        changingMoneyStatus.ordinal(),
                        new Timestamp(System.currentTimeMillis()), // TODO : 2021-08-17 00:00:00
                        uuid
                )
        );
    }

    @Override
    public MemberMoneyJpaEntity increaseMoney(MemberMoney.MembershipId memberMoneyId, int increasingMoneyAmount) {

        MemberMoneyJpaEntity entity = memberMoneyRepository.findByMembershipId(memberMoneyId.value())
                .orElse(
                        new MemberMoneyJpaEntity(
                                memberMoneyId.value(),
                                0
                        )
                );

        entity.setBalance(
                entity.getBalance() + increasingMoneyAmount
        );

        return memberMoneyRepository.save(
                entity
        );
    }
}
