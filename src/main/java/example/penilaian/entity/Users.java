package example.penilaian.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class Users {
    @Id
    private int users_id;

    private String username;

    @Column(unique = true, nullable = false)
    @Pattern(regexp="[0-9\\-]+", message="NIP harus terdiri dari angka atau tanda - saja")
    private String nip;

    private String password;

    private String role;


}
