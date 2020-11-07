package nero.springbootstudy.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class User {
    private String name;
    private Integer age;
    private Integer score;
}
