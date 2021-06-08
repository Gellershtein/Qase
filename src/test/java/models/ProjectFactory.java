package models;

import com.github.javafaker.Faker;

public class ProjectFactory {
    public static Project get() {
        Faker faker = new Faker();
        return Project.builder()
                .projectName(faker.name().name())
                .projectCode(faker.code().isbn13())
                .description("Test project creation")
                .accessType("Private")
                .membersAccessType("None")
                .build();
    }
}
