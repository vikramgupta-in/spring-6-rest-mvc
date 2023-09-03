package guru.springframework.spring6restmvc.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Builder
@Data
public class Customer {
    private String customerName;
    private int Id;
    private int version;
    private LocalDateTime createdDate;
    private LocalDateTime lastModifiedDate;

}
