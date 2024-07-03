package sn.masterclass.servicecostumer.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;


@NoArgsConstructor @AllArgsConstructor @Getter @Setter @ToString @Builder
public class CustomerDTO {

    private Long id;
    @NotEmpty
    @Size(min =2, max = 50)
    private String firstname;
    @NotEmpty
    @Size(min =2, max = 50)
    private String lastname;
    @NotEmpty
    @Size(min =2, max = 50)
    private String email;
}
