package ru.netology.test;

import org.junit.jupiter.api.Test;
import ru.netology.data.DataHelper;
import ru.netology.data.SqlHelper;
import ru.netology.page.LoginPage;
import org.junit.jupiter.api.AfterAll;

import static ru.netology.data.SqlHelper.cleanDb;
import static com.codeborne.selenide.Selenide.open;

public class LogIntoAccountTest {

    @AfterAll
    static void clearDb() {
        cleanDb();
    }

    @Test
    void shouldLogIntoAccount()
    {
        open("http://localhost:9999");
        var loginPage = new LoginPage();
        var verificationPage = loginPage.validLogin(DataHelper.getAuthInfo());
        var dashboard = verificationPage.validVerify(SqlHelper.getVerificationCode());
    }
}
