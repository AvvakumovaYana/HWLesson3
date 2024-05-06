package pages;

import static com.codeborne.selenide.Selenide.executeJavaScript;

public class PageBase {
   protected void removeBanners(){
    executeJavaScript("$('#fixedban').remove()");
    executeJavaScript("$('footer').remove()");
   }
}
