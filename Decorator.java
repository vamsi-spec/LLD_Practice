// interface Pizza {
//     public String getDescription();
//     public double getCost();
// }

// class PlanePizza implements Pizza {
//     public String getDescription() {
//         return "Plain Pizza";
//     }
//     public double getCost() {
//         return 150.0;
//     }
// }

// class MargheritaPizza implements Pizza {
//     public String getDescription() {
//         return "Margherita Pizza";
//     }
//     public double getCost() {
//         return 200.0;
//     }
// }

// abstract class PizzaDecorator implements Pizza {
//     protected Pizza pizza;

//     public PizzaDecorator(Pizza pizza) {
//         this.pizza = pizza;
//     }

// }

// class ExtraChesse extends PizzaDecorator {
//     public ExtraChesse(Pizza pizza) {
//         super(pizza);
//     }

//     public String getDescription() {
//         return pizza.getDescription() + "," + "Extra chesse";
//     }

//     public double getCost() {
//         return pizza.getCost() + 50.00;
//     }
// }

// class Olives extends PizzaDecorator {
//     public Olives(Pizza pizza) {
//         super(pizza);
//     }

//     public String getDescription() {
//         return pizza.getDescription() + "," + "Olives";
//     }

//     public double getCost() {
//         return pizza.getCost() + 40.00;
//     }
// }

// class Mushrooms extends PizzaDecorator {
//     public Mushrooms(Pizza pizza) {
//         super(pizza);
//     }

//     public String getDescription() {
//         return pizza.getDescription() + "," + "Mushrooms";
//     }

//     public double getCost() {
//         return pizza.getCost() + 30.00;
//     }
// }


// public class Decorator {
//     public static void main(String[] args) {
//         Pizza pizza = new PlanePizza();
//         pizza = new ExtraChesse(pizza);

//         pizza = new Olives(pizza);

//         System.out.println(pizza.getDescription() + "cost" + pizza.getCost());

//         Pizza pizza2 = new MargheritaPizza();
//         pizza2 = new Mushrooms(pizza2);

//         System.out.println(pizza2.getDescription() + "cost" + pizza2.getCost());
//     }
// }


interface Order {
    public double getCost();
    public String getDescription();
}

class BasicOrder implements Order {
    public double getCost() {
        return 200;
    }
    public String getDescription() {
        return "Food : Burger";
    }
}

abstract class OrderDecorator implements Order {
    protected Order order;
    public OrderDecorator(Order order) {
        this.order = order;
    }
}

class Delivery extends OrderDecorator {
    public Delivery(Order order) {
        super(order);
    }

    public double getCost() {
        return order.getCost() + 50;
    }

    public String getDescription() {
        return order.getDescription() + "," + "Delivery charges";
    }
}

class Coupon extends OrderDecorator {
    public Coupon(Order order) {
        super(order);
    }

    public double getCost() {
        double cost = order.getCost();
        return cost * 0.9;
    }
    public String getDescription() {
        return order.getDescription() + "," + "coupon Discount";
    }
} 

class Packaging extends OrderDecorator {
    public Packaging(Order order) {
        super(order);
    }
    public double getCost() {
        double cost = order.getCost();
        return cost + 20.0;
    }
    public String getDescription() {
        return order.getDescription() + "," + "Packaging charges";
    }
}

public class Decorator {
    public static void main(String[] args) {
        Order order = new BasicOrder();
        order = new Delivery(order);
        order = new Coupon(order);
        order = new Packaging(order);
        System.out.println(order.getDescription());
        System.out.println(order.getCost());
    }
}
