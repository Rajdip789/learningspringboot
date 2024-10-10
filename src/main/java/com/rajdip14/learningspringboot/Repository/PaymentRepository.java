package com.rajdip14.learningspringboot.Repository;

import com.rajdip14.learningspringboot.DTO.PaymentRequest;
import com.rajdip14.learningspringboot.Entity.PaymentEntity;
import org.springframework.stereotype.Repository;

@Repository
public class PaymentRepository {

    public PaymentEntity getPaymentById(PaymentRequest request) {
        PaymentEntity paymentModel = executeQuery(request);
        return paymentModel;
    }

    public PaymentEntity executeQuery(PaymentRequest request) {
        PaymentEntity payment = new PaymentEntity();

        payment.setId(request.getPaymentId());
        payment.setPaymentCurrency("INR");
        payment.setPaymentAmount(100.00);

        return payment;
    }
}
