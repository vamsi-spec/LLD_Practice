interface TaxCalculator {
    public double calculateTax(double amount);
}

class IndiaTaxCalc implements TaxCalculator {
    @java.lang.Override
    public void calculateTax(double amount) {
        return 0.18 * amount;
    }
}

class USTaxCalculator implements TaxCalculator {
    @java.lang.Override
    public void calculateTax(double amount) {
        return 0.8 * amount;
    }
}

class Invoice {
    private double amount;
    private TaxCalculator taxCalculator;

    Invoice(double amount,TaxCalculator taxCalculator) {
        this.amount = amount;
        this.taxCalculator = taxCalculator;
    }

    public double getAmount() {
        return taxCalculator.calculateTax(amount);
    }
}

class OCP {
    public static void main(String[] args) {
        double amount = 1000.00;
        Invoice indiaInvoice = new Invoice(amount,new IndiaTaxCalc());
        System.out.println("Total (india): " + indiaInvoice.getAmount());
        Invoice usInvoice = new Invoice(amount,new USTaxCalculator());
        System.out.println("Total (us): " + usInvoice.getAmount());

    }
}