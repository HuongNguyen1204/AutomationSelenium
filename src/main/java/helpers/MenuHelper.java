package helpers;

import page.objects.BasePage;

public class MenuHelper {

    public static void clickToItemMenu(String listMenuItem){
        String[] listItems = listMenuItem.split(">");
        switch (listItems.length){
            case 1:
                BasePage.clickMenuItem(listItems[0]);
                break;
            case 2:
                BasePage.clickMenuItem(listItems[0]);
                BasePage.clickMenuItem(listItems[1]);
                break;
            case 3:
                BasePage.clickMenuItem(listItems[0]);
                BasePage.clickMenuItem(listItems[1]);
                BasePage.clickToSubMenu(listItems[2]);
                break;
            default:
                break;
        }
    }
}
