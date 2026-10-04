class BookingRequest {
    private final String userId;
    private final String movieId;
    private final String seatNumber;
    private final String userEmail;
    private final double amount;
    private final String paymentMethod;

    private BookingRequest(Builder builder) {
        this.userId = builder.userId;
        this.movieId = builder.movieId;
        this.seatNumber = builder.seatNumber;
        this.userEmail = builder.userEmail;
        this.amount = builder.amount;
        this.paymentMethod = builder.paymentMethod;
    }

    public static class Builder {
        private String userId;
        private String movieId;
        private String seatNumber;
        private String userEmail;
        private double amount;
        private String paymentMethod;

        public Builder setUserId(String userId) {
            this.userId = userId;
            return this;
        }

        public Builder setMovieId(String movieId) {
            this.movieId = movieId;
            return this;
        }

        public Builder setSeatNumber(String seatNumber) {
            this.seatNumber = seatNumber;
            return this;
        }

        public Builder setUserEmail(String userEmail) {
            this.userEmail = userEmail;
            return this;
        }

        public Builder setAmount(double amount) {
            this.amount = amount;
            return this;
        }

        public Builder setPaymentMethod(String paymentMethod) {
            this.paymentMethod = paymentMethod;
            return this;
        }

        public BookingRequest build() {
            return new BookingRequest(this);
        }

        
    }
    public String getUserId() {
            return userId;
        }

        public String getMovieId() {
            return movieId;
        }

    public String getSeatNumber() {
        return seatNumber;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public double getAmount() {
        return amount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }
}

//SubSystem Services

class PaymentService {
    public void processPayment(String paymentMethod,double amount) {
        System.out.println("Processing payment of " + amount + " using " + paymentMethod);
    }
}

class SeatService {
    public void reserveSeat(String movieId, String seatNumber) {
        System.out.println("Reserving seat " + seatNumber + " for movie " + movieId);
    }
}

class GenerateTicket {
    public void generateTicket(String movieId, String seatNumber,String userEmail) {
        System.out.println("Generating ticket for " + userEmail);
        System.out.println("Movie : " + movieId);
        System.out.println("Seat Number : " + seatNumber);
        System.out.println("Ticket Generated Successfully");
    }
}


class NotificationService {

    public void sendConfirmation(String email) {
        System.out.println(
            "Confirmation sent to " + email
        );
    }
}


class LoyaltyService {

    public void addPoints(String userId, int points) {
        System.out.println(
            points + " loyalty points added for user " +
            userId
        );
    }
}

class MovieBookingFacade {
    private PaymentService paymentService;
    private SeatService seatService;
    private GenerateTicket generateTicket;
    private NotificationService notificationService;
    private LoyaltyService loyaltyService;

    MovieBookingFacade() {
        this.paymentService = new PaymentService();
        this.seatService = new SeatService();
        this.generateTicket = new GenerateTicket();
        this.notificationService = new NotificationService();
        this.loyaltyService = new LoyaltyService();
    }

    public void bookMovie(BookingRequest request) {
        paymentService.processPayment(
            request.getPaymentMethod(),
            request.getAmount()
        );

        // 2. Reserve Seat
        seatService.reserveSeat(
            request.getMovieId(),
            request.getSeatNumber()
        );

        // 3. Generate Ticket
        generateTicket.generateTicket(
            request.getMovieId(),
            request.getSeatNumber(),
            request.getUserEmail()
        );

        // 4. Add Loyalty Points
        loyaltyService.addPoints(
            request.getUserId(),
            50
        );

        // 5. Send Confirmation
        notificationService.sendConfirmation(
            request.getUserEmail()
        );
    }

    
}

public class Facade {
    public static void main(String[] args) {
        BookingRequest request = new BookingRequest.Builder().setUserId("user123")
                .setMovieId("movie456")
                .setSeatNumber("A10")
                .setUserEmail("user@example.com")
                .setAmount(500)
                .setPaymentMethod("UPI")
                .build();

        MovieBookingFacade facade = new MovieBookingFacade();
        facade.bookMovie(request);
    }
}
