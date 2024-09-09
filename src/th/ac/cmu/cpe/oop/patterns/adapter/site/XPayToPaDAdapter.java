package th.ac.cmu.cpe.oop.patterns.adapter.site;

import th.ac.cmu.cpe.oop.patterns.adapter.payd.PayD;
import th.ac.cmu.cpe.oop.patterns.adapter.xpay.XPay;

public class XPayToPaDAdapter implements PayD {
    private final XPay xPay;

    public XPayToPaDAdapter(XPay xPay) {
        this.xPay = xPay;
    }

    @Override
    public String getCreditCardNo() {
        return xPay.getCreditCardNo();
    }

    @Override
    public String getCardOwnerName() {
        return xPay.getCustomerName();
    }

    @Override
    public String getCardExpMonthYear() {
        return xPay.getCardExpMonth() + xPay.getCardExpYear();
    }

    @Override
    public Integer getCVVNo() {
        return (int) xPay.getCardCVVNo();
    }

    @Override
    public Double getTotalAmount() {
        return xPay.getAmount();
    }

    @Override
    public void setCreditCardNo(String creditCardNo) {
        xPay.setCreditCardNo(creditCardNo);
    }

    @Override
    public void setCardOwnerName(String cardOwnerName) {
        xPay.setCustomerName(cardOwnerName);
    }

    @Override
    public void setCardExpMonthYear(String cardExpMonthYear) {
        xPay.setCardExpMonth(cardExpMonthYear.substring(0, 2));
        xPay.setCardExpYear(cardExpMonthYear.substring(2));
    }

    @Override
    public void setCVVNo(Integer cVVNo) {
        xPay.setCardCVVNo(cVVNo.shortValue());
    }

    @Override
    public void setTotalAmount(Double totalAmount) {
        xPay.setAmount(totalAmount);
    }
}
