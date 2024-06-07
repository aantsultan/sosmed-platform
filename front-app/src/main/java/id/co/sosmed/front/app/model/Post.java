package id.co.sosmed.front.app.model;

import id.co.sosmed.front.app.model.meta.MetaData;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity(name = "trx_post")
public class Post extends MetaData implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String postingId;
    private String content;
    private Boolean isPublic;
    private Boolean onlyFriend;

    @OneToMany(mappedBy = "post")
    private List<Comment> comments;

}
