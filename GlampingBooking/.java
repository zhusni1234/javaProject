@Entity
public class GlampingSite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String location;
    private double pricePerNight;

    // Getters and Setters
}

@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long glampingSiteId;
    private String customerName;
    private LocalDate startDate;
    private LocalDate endDate;

    // Getters and Setters
}

@Entity
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String serviceName;
    private double price;

    // Getters and Setters
}
