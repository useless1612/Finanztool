package ase.finanzplaner.ui;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import ase.finanzplaner.ui.exceptions.UnregisteredUiControllerException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UiControllerProviderTest {

    class MockUiController implements UiController {

        public Integer accDestroy(String account) {
            return -1;
        }
        public Integer add(String account, String date, String amount, String description) {
            return -2;
        }
        public Integer delete(String account, Integer transactionId) {
            return -3;
        }
        public Integer overview(String account) {
            return -4;
        }
        public Integer show(String account) {
            return -5;
        }
        public Integer showAcc() {
            return -6;
        }
        public Integer showDiff(String account) {
            return -7;
        }
        public Integer sum(String account) {
            return -8;
        }
    }

    @BeforeEach
    public void registerUiControllerProvider() {
        UiControllerProvider.registerUiController(null);
    }

    @Test
    public void testSuccesfulProvider() throws UnregisteredUiControllerException {
        UiController uiController = new MockUiController();
        UiControllerProvider.registerUiController(uiController);

        assertTrue(UiControllerProvider.getUiController() != null);
        assertTrue(UiControllerProvider.getUiController() instanceof UiController);
        assertTrue(UiControllerProvider.getUiController() instanceof MockUiController);
    }

    @Test
    public void testSuccesfulProvidedControllerCalls() throws UnregisteredUiControllerException {
        UiController uiController = new MockUiController();
        UiControllerProvider.registerUiController(uiController);

        UiController providedUiController = UiControllerProvider.getUiController();

        String account = null;
        String date = null;
        String amount = null;
        String description = null;
        Integer transactionId = null;
    
        assertEquals(providedUiController.accDestroy(account), -1);
        
        assertEquals(providedUiController.add(account, date, amount, description), -2);
        
        assertEquals(providedUiController.delete(account, transactionId), -3);
        
        assertEquals(providedUiController.overview(account),-4);
        
        assertEquals(providedUiController.show(account), -5);
        
        assertEquals(providedUiController.showAcc(), -6);
        
        assertEquals(providedUiController.showDiff(account), -7);
        
        assertEquals(providedUiController.sum(account), -8);
        
    }

    @Test
    public void testExceptionOnUnregisteredUiController() throws UnregisteredUiControllerException {
        assertThrows(UnregisteredUiControllerException.class, () -> {
            UiController providedUiController = UiControllerProvider.getUiController();
        });
    }
}