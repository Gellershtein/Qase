package pages;

import lombok.extern.log4j.Log4j2;
import pages.base.BasePage;

import static com.codeborne.selenide.Selenide.$;

@Log4j2
public class ProjectsDetailsPage extends BasePage {

    @Override
    public boolean isPageOpened() {
        return isExist($(userMenuAvatar));
    }
}
