package mx.foodstack.spring;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by eecheverria on 10/22/2016.
 */

public class MenuServiceTests {
    @Test
    public void CanRetrieveMenusFromServer() throws Exception {
        // Arrange
        MenuService menuService = new MenuService();

        // Act
        Menu[] menus = menuService.getMenus();

        // Assert
        assertNotNull(menus);
        assertEquals(1, menus.length);
        System.out.println("Success...");
    }
}
