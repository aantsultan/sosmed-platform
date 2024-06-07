package id.co.sosmed.front.app.model;

import id.co.sosmed.front.app.helper.ApprovalStatus;
import id.co.sosmed.front.app.helper.ApprovalType;
import id.co.sosmed.front.app.model.meta.MetaData;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.io.Serializable;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity(name = "trx_approval")
public class Approval extends MetaData implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String approvalId;

    @Column(length = 20)
    @NotBlank
    private ApprovalType type;

    @Column(length = 20)
    @NotBlank
    private ApprovalStatus status;

    @NotBlank
    private String data;

    @Column(length = 100)
    @NotBlank
    private String assignTo;
}
