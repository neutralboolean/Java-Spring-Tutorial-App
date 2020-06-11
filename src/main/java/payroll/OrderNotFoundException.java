package payroll;

public class OrderNotFoundException extends RuntimeException{
    private Long id;

    OrderNotFoundException(Long id) {
        super("Could not find order " + id);
    }
}
