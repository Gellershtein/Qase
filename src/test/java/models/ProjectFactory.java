package models;

import com.github.javafaker.Faker;
import utils.RandomString;

public class ProjectFactory {
    public static Project get() {
        Faker faker = new Faker();
        RandomString randomString = new RandomString(6);
        return Project.builder()
                .projectName(faker.company().name())
                .projectCode(randomString.nextString())
                .description("Test project creation")
                .accessType("Private")
                .membersAccessType("None")
                .build();
    }
}
