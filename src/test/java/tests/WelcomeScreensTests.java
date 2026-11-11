package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WelcomeScreensTests extends TestBase {

    @Test
    @DisplayName("Прохождение начальных экранов")
    void navigateOnBoardScreenTest() {
        welcomeScreen.skipFirstOnBoardPage()
                .skipSecondOnBoardPage()
                .skipThirdOnBoardPage()
                .skipFourthOnBoardPage();
        mainScreen.checkHomeScreenIsOpen();
    }

}
