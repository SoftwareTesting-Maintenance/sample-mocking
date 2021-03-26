package edu.umd.enpm614.app;

import mockit.Expectations;
import mockit.Mocked;
import mockit.Tested;
import mockit.Verifications;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PaymentServiceTest {
    PaymentService paymentService;
    @Mocked Atm mockAtm;

    @BeforeEach
    void setUp() {
        paymentService = new PaymentService(mockAtm);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testWithdraw() {
        new Expectations() {{
            mockAtm.withdraw(anyString, anyInt);
            minTimes = 1;
            result = true;
        }};

        assertFalse(paymentService.mobilePay("account", 100));

        new Verifications() {{
            mockAtm.withdraw(withEqual("account"), 100);
            times = 1;
        }};
    }
}