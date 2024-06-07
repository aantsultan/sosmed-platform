package id.co.sosmed.front.app.model.meta;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MetaData {

    private Boolean isDeleted = false;
    private LocalDateTime createdDate = LocalDateTime.now();
    private String createdBy;
    private LocalDateTime modifiedDate;
    private String modifiedBy;

}
