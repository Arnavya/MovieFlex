package com.sst.movieflex.models;

import com.sst.movieflex.models.enums.PaymentMode;
import com.sst.movieflex.models.enums.PaymentStatus;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Payment extends BaseModel{

    private String referenceId;

    private double amount;

    private PaymentMode paymentMode;

    private PaymentStatus paymentStatus;
}
