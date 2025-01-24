package com.ash.money.adapter.in.web;

import com.ash.common.WebAdapter;
import com.ash.money.adapter.in.web.request.DecreaseMoneyRequest;
import com.ash.money.adapter.in.web.request.IncreaseMoneyRequest;
import com.ash.money.adapter.in.web.response.MoneyChangeResultDetail;
import com.ash.money.application.port.in.IncreaseMoneyRequestCommand;
import com.ash.money.application.port.in.IncreaseMoneyRequestUseCase;
import com.ash.money.domain.MoneyChangingRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequiredArgsConstructor
public class RequestMoneyChangingController {

    private final IncreaseMoneyRequestUseCase increaseMoneyRequestUseCase;
    private final MoneyChangingResultMapper moneyChangingResultMapper;

    @PostMapping("/money/increase")
    MoneyChangeResultDetail increase(@RequestBody IncreaseMoneyRequest request) {

        MoneyChangingRequest d = increaseMoneyRequestUseCase.increaseRequestMoneyChanging(
                IncreaseMoneyRequestCommand.builder()
                        .targetMembershipId(request.getTargetMembershipId())
                        .changingMoneyAmount(request.getAmount())
                        .build());

        // MoneyChangingRequest -> MoneyChangeResultDetail 로 변환

        moneyChangingResultMapper.mapToMoneyChangingResult(d);

        return null;
    }

    @PostMapping("/money/decrease")
    MoneyChangeResultDetail decrease(@RequestBody DecreaseMoneyRequest request) {

//        MoneyChangingRequest d = requestMoneyChangingUseCase.increaseRequestMoneyChanging(
//                IncreaseMoneyRequestCommand.builder()
//                        .targetMembershipId(request.getTargetMembershipId())
//                        .changingMoneyAmount(request.getAmount())
//                        .uuid(null) //  ?
//                        .build());

        // MoneyChangingRequest -> MoneyChangeResultDetail 로 변환

        return null;
    }

}