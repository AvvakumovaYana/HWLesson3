package pages.components;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {
    public CalendarComponent setDate(String year, String month, String day) {
        $(".react-datepicker__year-select").find("[value='"+year+"']").click();
        $(".react-datepicker__month-select").find("[value='"+month+"']").click();
        $(".react-datepicker__day--0"+day).click();

        return this;
    }
}
