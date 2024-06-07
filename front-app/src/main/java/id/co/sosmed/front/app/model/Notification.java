package id.co.sosmed.front.app.model;

import id.co.sosmed.front.app.model.meta.MetaData;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity(name = "trx_notification")
public class Notification extends MetaData implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String notificationId;

    private String type;

    @Column(length = 100)
    private String content;

    @Column(length = 100)
    private String assignTo;

    private Boolean isRead = false;
}
