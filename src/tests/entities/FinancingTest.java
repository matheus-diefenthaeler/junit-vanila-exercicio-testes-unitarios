package tests.entities;

import entities.Financing;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class FinancingTest {

    @Test
    public void entryShouldReturn20PercentageOfTotalAmount() {

        double expectedValue = 200.0;

        Financing fin = new Financing(1000.0, 500.0,10);

        double entry = fin.entry();

        Assertions.assertEquals(expectedValue,entry);
    }

    @Test
    public void quoteShouldReturn80PercentageOfTotalamountByMonths() {

        double expectedValue = 80;
        Financing fin = new Financing(1000.0, 500.0,10);

        double quote = fin.quota();

        Assertions.assertEquals(expectedValue,quote);

    }

    @Test
    public void constructorShouldThrowExceptionWhenQuotaIsGreaterThanHalfOfIncome(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> {

            Financing fin = new Financing(1000.0, 500.0,1);

        });
    }

    @Test
    public void setTotalAmountShouldThrowExceptionWhenQuotaIsGreaterThanHalfOfIncome(){

        Assertions.assertThrows(IllegalArgumentException.class, () -> {

            Financing fin = new Financing(1000.0,500.0,31);

            fin.setTotalAmount(10000.0);

        });
    }

    @Test
    public void setIncomeShouldThrowExceptionWhenQuotaIsGreaterThanHalfOfIncome(){

        Assertions.assertThrows(IllegalArgumentException.class, () -> {

            Financing fin = new Financing(1000.0,500.0,10);

            fin.setIncome(159.0);

        });
    }

    @Test
    public void setMonthsShouldThrowExceptionWhenQuotaIsGreaterThanHalfOfIncome(){

        Assertions.assertThrows(IllegalArgumentException.class, () -> {

            Financing fin = new Financing(1000.0,500.0,10);

            fin.setMonths(3);

        });
    }

    @Test
    public void constructorShouldSetValuesWhenValidData(){
        double expectedTotalAmount = 1000.0;
        double expectedIncome = 500.0;
        int expectedMonths = 10;

        Financing fin = new Financing(1000.0,500.0,10);

        Assertions.assertEquals(expectedTotalAmount,fin.getTotalAmount());
        Assertions.assertEquals(expectedIncome,fin.getIncome());
        Assertions.assertEquals(expectedMonths,fin.getMonths());
    }

    @Test
    public void setTotalAmountShouldSetValueWhenValidData(){

        double expectedTotalAmount = 500.0;

        Financing fin = new Financing(1000.0,500.0,10);

        fin.setTotalAmount(500.0);

        Assertions.assertEquals(expectedTotalAmount, fin.getTotalAmount());

    }

    @Test
    public void setIncomeShouldSetValueWhenValidData(){

        double expectedIncome = 1000.0;

        Financing fin = new Financing(1000.0,500.0,10);

        fin.setIncome(1000.0);

        Assertions.assertEquals(expectedIncome, fin.getIncome());

    }

    @Test
    public void setMonthShouldSetValueWhenValidData(){

        int expectedMonths = 7;

        Financing fin = new Financing(1000.0,500.0,10);

        fin.setMonths(7);

        Assertions.assertEquals(expectedMonths, fin.getMonths());

    }
}