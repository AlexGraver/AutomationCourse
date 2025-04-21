package builders;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class User {
    private String username;
    private String email;
    private int age;
}
