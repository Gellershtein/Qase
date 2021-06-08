package models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Project {
    String projectName, projectCode, description, accessType, membersAccessType;
}
