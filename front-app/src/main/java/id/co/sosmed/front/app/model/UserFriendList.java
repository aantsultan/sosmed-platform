package id.co.sosmed.front.app.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity(name = "trx_user_friendlist")
public class UserFriendList implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String friendlistId;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "userId")
    private User user;

    @ManyToOne
    @JoinColumn(name = "friend_id", referencedColumnName = "userId")
    private User friend;

}
