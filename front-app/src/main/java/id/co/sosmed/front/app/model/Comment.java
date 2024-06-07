package id.co.sosmed.front.app.model;

import id.co.sosmed.front.app.model.meta.MetaData;
import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity(name = "trx_comment")
public class Comment extends MetaData implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String commentId;

    @Column(length = 100)
    @NotBlank
    private String content;

    @OneToMany(mappedBy = "parent")
    private List<Comment> comments;

    @ManyToOne
    @JoinColumn(name = "parent_id", referencedColumnName = "commentId")
    private Comment parent;

    @ManyToOne
    @JoinColumn(name = "posting_id", referencedColumnName = "postingId")
    private Post post;
}
