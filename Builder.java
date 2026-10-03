class Order {
    private final int id;
    private final String customerName;
    private final String product;
    private final double amount;
    private final String address;
    private final String paymentMethod;
    private final String giftWrap;

    public Order(OrderBuilder builder) {
        this.id = builder.id;
        this.customerName = builder.customerName;
        this.product = builder.product;
        this.amount = builder.amount;
        this.address = builder.address;
        this.paymentMethod = builder.paymentMethod;
        this.giftWrap = builder.giftWrap;
    }

    public int getId() { return id; }
    public String getCustomerName() { return customerName; }
    public String getProduct() { return product; }
    public double getAmount() { return amount; }
    public String getAddress() { return address; }
    public String getPaymentMethod() { return paymentMethod; }
    public String getGiftWrap() { return giftWrap; }

    public static class OrderBuilder {
        private int id;
        private String customerName;
        private String product;
        private double amount;
        private String address;
        private String paymentMethod;
        private String giftWrap;

        public OrderBuilder setId(int id) {
            this.id = id;
            return this;
        }

        public OrderBuilder setCustomerName(String customerName) {
            this.customerName = customerName;
            return this;
        }

        public OrderBuilder setProduct(String product) {
            this.product = product;
            return this;
        }

        public OrderBuilder setAmount(double amount) {
            this.amount = amount;
            return this;
        }

        public OrderBuilder setAddress(String address) {
            this.address = address;
            return this;
        }

        public OrderBuilder setPaymentMethod(String paymentMethod) {
            this.paymentMethod = paymentMethod;
            return this;
        }

        public OrderBuilder setGiftWrap(String giftWrap) {
            this.giftWrap = giftWrap;
            return this;
        }

        public Order build() {
            return new Order(this);
        }
    }
}

class Builder {
    public static void main(String args[]) {
        Order o1 = new Order.OrderBuilder()
                .setId(101)
                .setCustomerName("vamsi")
                .setProduct("Laptop")
                .setAddress("123 main st")
                .setPaymentMethod("Credit Card")
                .setGiftWrap("Yes")
                .build();

        System.out.println(o1.getId());
        System.out.println(o1.getCustomerName());
        System.out.println(o1.getProduct());
        System.out.println(o1.getAddress());
        System.out.println(o1.getPaymentMethod());
        System.out.println(o1.getGiftWrap());
    }
}

