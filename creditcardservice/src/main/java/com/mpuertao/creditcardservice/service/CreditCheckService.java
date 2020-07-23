package com.mpuertao.creditcardservice.service;

import com.mpuertao.creditcardservice.controller.ApplyForCreditCardRequest;
import com.mpuertao.creditcardservice.controller.ApplyForCreditCardResponse;
import com.mpuertao.creditcardservice.gateway.CreditCheckGateway;
import com.mpuertao.creditcardservice.gateway.CreditCheckResponse;
import org.springframework.stereotype.Component;

@Component
public class CreditCheckService {

    private final CreditCheckGateway creditCheckGateway;

    public CreditCheckService(CreditCheckGateway creditCheckGateway) {
        this.creditCheckGateway = creditCheckGateway;
    }

    public ApplyForCreditCardResponse doCheckForCitizen(ApplyForCreditCardRequest applyForCreditCardRequest) {

        final CreditCheckResponse.Score score = creditCheckGateway.doCreditCheckForCitizen(applyForCreditCardRequest.getCitizenNumber());

        if (score == CreditCheckResponse.Score.HIGH && applyForCreditCardRequest.getCardType() == ApplyForCreditCardRequest.CardType.GOLD) {
            return new ApplyForCreditCardResponse(ApplyForCreditCardResponse.Status.GRANTED);
        }
        throw new RuntimeException("Card and score not yet implemented");
    }
}
