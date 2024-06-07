package id.co.sosmed.front.app.model;

import id.co.sosmed.front.app.model.meta.MetaData;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity(name = "m_user")
public class User extends MetaData implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(length = 100)
    private String userId;

    @NotBlank
    private String name;

    @Column(unique = true, length = 100)
    @NotBlank
    private String username;

    @NotBlank
    private String password;

    @Column(unique = true, length = 100)
    private String email;

    @Column(unique = true, length = 20)
    private String phone;

    @OneToMany(mappedBy = "user")
    private List<UserFriendList> users;

    @OneToMany(mappedBy = "friend")
    private List<UserFriendList> friends;
}
