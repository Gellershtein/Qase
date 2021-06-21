package models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseProject {
    boolean status;
    Project result;
}
