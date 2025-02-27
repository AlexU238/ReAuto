package u238.reauto.datamodel.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import u238.reauto.datamodel.advertisement.Advertisement;

import java.util.Collection;

@Entity
@Table(name = "users")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @NotBlank(message = "Username is empty")
    private String username;

    @ToString.Exclude
    @JsonIgnore
    @NotBlank(message = "Password is empty")
    private String password;

    @Email(message = "Invalid format of email")
    @NotBlank(message = "Email is empty")
    private String email;

    @NotBlank(message = "First name is empty")
    private String firstName;

    @NotBlank(message = "Last name is empty")
    private String lastName;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private Collection<Advertisement> advertisements;
}
