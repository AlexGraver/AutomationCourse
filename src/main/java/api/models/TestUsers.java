package api.models;

public class TestUsers {

    public static final User MY_USER = User.builder()
            .id(101)
            .username("Alex21")
            .firstName("Alexander")
            .lastName("The great")
            .email("alex@macedonia.com")
            .password("qwe123")
            .phone("+26752330")
            .userStatus(12)
            .build();
}
