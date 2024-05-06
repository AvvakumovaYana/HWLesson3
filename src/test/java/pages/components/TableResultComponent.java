package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class TableResultComponent {
    public static SelenideElement tableResponsive = $(".table-responsive");
    public static SelenideElement table = $("#example-modal-sizes-title-lg");

    public TableResultComponent checkRow(String key, String value) {
        tableResponsive.$(byText(key)).parent().shouldHave(text(value));
        return this;
    }

    public TableResultComponent checkTableNotVisible() {
        table.shouldNotBe(visible);
        return this;
    }
}
