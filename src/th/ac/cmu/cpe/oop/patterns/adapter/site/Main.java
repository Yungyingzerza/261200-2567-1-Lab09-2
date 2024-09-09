package th.ac.cmu.cpe.oop.patterns.adapter.site;

import th.ac.cmu.cpe.oop.patterns.adapter.payd.PayD;
import th.ac.cmu.cpe.oop.patterns.adapter.xpay.XPay;

public class Main {

    public static void testPayD(PayD payD) {
        System.out.println(payD.getCardOwnerName());
        System.out.println(payD.getCreditCardNo());
        System.out.println(payD.getCardExpMonthYear());
        System.out.println(payD.getCVVNo());
        System.out.println(payD.getTotalAmount());
    }

    public static void main(String[] args) {
        XPay xpay = new XPayImpl();
        xpay.setCreditCardNo("1234567890123456");
        xpay.setCustomerName("Champoo CGM48");
        xpay.setCardExpMonth("09");
        xpay.setCardExpYear("25");
        xpay.setCardCVVNo((short) 235);
        xpay.setAmount(2565.23);

        PayD payD = new XPayToPaDAdapter(xpay);
        testPayD(payD);
    }


}