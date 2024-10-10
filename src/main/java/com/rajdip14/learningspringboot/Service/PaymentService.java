package com.rajdip14.learningspringboot.Service;

import com.rajdip14.learningspringboot.DTO.PaymentRequest;
import com.rajdip14.learningspringboot.DTO.PaymentResponse;
import com.rajdip14.learningspringboot.Entity.PaymentEntity;
import com.rajdip14.learningspringboot.Repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    @Autowired
    PaymentRepository paymentRepository;

    public PaymentResponse getPaymentDetailsById(PaymentRequest internalRequestObj) {
        PaymentEntity paymentModel = paymentRepository.getPaymentById(internalRequestObj);

        //map the response model to response DTO obj
        PaymentResponse paymentResponse = mapModelToResponseDTO(paymentModel);
        return paymentResponse;
    }

    private PaymentResponse mapModelToResponseDTO(PaymentEntity paymentEntity) {

        PaymentResponse response = new PaymentResponse();
        response.setPaymentId(paymentEntity.getId());
        response.setAmount(paymentEntity.getPaymentAmount());
        response.setCurrency(paymentEntity.getPaymentCurrency());

        return response;
    }
}
