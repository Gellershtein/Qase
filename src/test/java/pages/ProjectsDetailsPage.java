package pages;

import lombok.extern.log4j.Log4j2;
import pages.base.BasePage;

@Log4j2
public class ProjectsDetailsPage extends BasePage {

    @Override
    public boolean isPageOpened() {
        return isExist(USER_MENU_AVATAR);
    }
}
