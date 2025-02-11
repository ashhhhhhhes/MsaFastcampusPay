package com.ash.money.application.service;

import com.ash.common.UserCase;
import com.ash.money.adapter.out.persistence.MemberMoneyJpaEntity;
import com.ash.money.adapter.out.persistence.MoneyChangingRequestJpaEntity;
import com.ash.money.adapter.out.persistence.MoneyChangingRequestMapper;
import com.ash.money.application.port.in.IncreaseMoneyRequestCommand;
import com.ash.money.application.port.in.IncreaseMoneyRequestUseCase;
import com.ash.money.application.port.out.ChangingMoneyRequestPort;
import com.ash.money.application.port.out.IncreaseMemberMoneyPort;
import com.ash.money.domain.MemberMoney;
import com.ash.money.domain.MoneyChangingRequest;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@UserCase
@RequiredArgsConstructor
public class IncreaseMoneyRequestService implements IncreaseMoneyRequestUseCase {

    private final ChangingMoneyRequestPort<MoneyChangingRequestJpaEntity> changingMoneyRequestPort;
    private final IncreaseMemberMoneyPort<MemberMoneyJpaEntity> increaseMemberMoneyPort;
    private final MoneyChangingRequestMapper mapper;

    @Override
    public MoneyChangingRequest increaseRequestMoneyChanging(IncreaseMoneyRequestCommand command) {
        // 머니 충전/증액 과정
        // 1. 고객 정보가 정상인지 확인 (멤버)

        // 2. 고객의 연동된 계좌가 있는지, 고객의 연동된 계좌의 잔액이 충분한지도 확인 (뱅킹)

        // 3. 법인 계좌 상태도 정상인지 확인 (뱅킹)
        UUID uuid = UUID.randomUUID();

        // 4. 증액을 위한 "기록". 요청 상태로 MoneyChangingRequest 를 생성한다. (머니)
        changingMoneyRequestPort.createChangingMoneyRequest(
                new MoneyChangingRequest.TargetMembershipId(command.getTargetMembershipId()),
                MoneyChangingRequest.ChangingType.INCREASE,
                new MoneyChangingRequest.ChangingMoneyAmount(command.getChangingMoneyAmount()),
                MoneyChangingRequest.ChangingMoneyStatus.REQUESTED,
                uuid
        );

        // 5. 펌뱅킹을 수행하고 (고객의 영된된 계좌 -> 패캠페이 법인계좌) (뱅킹)

        // 6-1. 결과가 정상이라면, 성공적으로 MoneyChangingRequest 상태값을 변동 후 리턴
        MemberMoneyJpaEntity memberMoneyJpaEntity =  increaseMemberMoneyPort.increaseMoney(
                new MemberMoney.MembershipId(command.getTargetMembershipId()),
                command.getChangingMoneyAmount()
        );

        if (memberMoneyJpaEntity == null) return null; // 실패

        // 6-2. 결과가 실패라면, 실패라고 MoneyChangingRequest 상태값을 변동 후 리턴
        return mapper.mapToMoneyChangingRequest(changingMoneyRequestPort.createChangingMoneyRequest(
                new MoneyChangingRequest.TargetMembershipId(command.getTargetMembershipId()),
                MoneyChangingRequest.ChangingType.INCREASE,
                new MoneyChangingRequest.ChangingMoneyAmount(command.getChangingMoneyAmount()),
                MoneyChangingRequest.ChangingMoneyStatus.SUCCESS,
                uuid
        ));
    }

}
