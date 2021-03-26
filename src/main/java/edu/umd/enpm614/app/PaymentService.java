package edu.umd.enpm614.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PaymentService {
    private Atm atm;

    @Autowired
    public PaymentService(Atm atm) {
        this.atm = atm;
    }

    public boolean mobilePay(String account, int amount) {
        if (atm.withdraw(account, amount)) {
            System.out.println("Money withdrawn");
            return true;
        } else {
            System.out.println("Money could not be withdrawn");
            return false;
        }
    }
}
