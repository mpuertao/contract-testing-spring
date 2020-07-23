package com.mpuertao.creditcardservice.service;

import com.mpuertao.creditcardservice.controller.ApplyForCreditCardRequest;
import com.mpuertao.creditcardservice.controller.ApplyForCreditCardResponse;
import com.mpuertao.creditcardservice.gateway.CreditCheckGateway;
import com.mpuertao.creditcardservice.gateway.CreditCheckResponse;
import org.springframework.stereotype.Component;

import static com.mpuertao.creditcardservice.controller.ApplyForCreditCardRequest.CardType.GOLD;
import static com.mpuertao.creditcardservice.controller.ApplyForCreditCardResponse.Status.DENIED;
import static com.mpuertao.creditcardservice.controller.ApplyForCreditCardResponse.Status.GRANTED;
import static com.mpuertao.creditcardservice.gateway.CreditCheckResponse.Score.HIGH;

@Component
public class CreditCheckService {

    private final CreditCheckGateway creditCheckGateway;

    public CreditCheckService(CreditCheckGateway creditCheckGateway) {
        this.creditCheckGateway = creditCheckGateway;
    }

    public ApplyForCreditCardResponse doCheckForCitizen(ApplyForCreditCardRequest applyForCreditCardRequest) {

        final CreditCheckResponse.Score score = creditCheckGateway.doCreditCheckForCitizen(applyForCreditCardRequest.getCitizenNumber());

        if (applyForCreditCardRequest.getCardType() == GOLD) {
            if (score == HIGH) {
                return new ApplyForCreditCardResponse(GRANTED);
            } else {
                return new ApplyForCreditCardResponse(DENIED);
            }
        }
        throw new RuntimeException("Card and score not yet implemented");
    }
}
