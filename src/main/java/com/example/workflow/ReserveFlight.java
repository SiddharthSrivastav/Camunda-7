package com.example.workflow;

import jakarta.inject.Named;
import org.camunda.bpm.engine.delegate.BpmnError;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
@Named
public class ReserveFlight implements JavaDelegate {
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        String money = "0.0";
        String ticketType = "Coach";

        money = (String) delegateExecution.getVariable("money");
        double moneyDouble = Double.parseDouble(money);

        if (moneyDouble >= 10000) {
            ticketType = "First Class";
        } else if (moneyDouble >= 5000) {
            ticketType = "Business Class";
        }
     else if (moneyDouble <= 10) {
        ticketType = "Stowaway Class";
        throw new BpmnError("Fall_Overboard","Price is very less to travel");
    }


        delegateExecution.setVariable("ticketType", ticketType);
    }
    }

