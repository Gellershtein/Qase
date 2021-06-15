package models;

import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;

import java.util.Locale;

public class ProjectFactory {
    public static Project get() {
        Faker faker = new Faker();
        FakeValuesService fakeValuesService = new FakeValuesService(
                new Locale("en-GB"), new RandomService());
        String randomCode = fakeValuesService.regexify("[A-Z]{10}");

        return Project.builder()
                .title(faker.company().name())
                .code(randomCode)
                .description("Test project creation")
                .access("Private")
                .group("None")
                .build();
    }


}
