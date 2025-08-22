
import org.app.service.*;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.app.model.ShipmentOrder;
import org.app.repository.ShipmentOrderRepository;


public class ShipmentOrderTest {
    @Spy
    private ShipmentOrderRepository realShipmentOrderRepository;
    @InjectMocks
    private ShipmentOrderServiceImpl shipmentOrderService;
    public ShipmentOrderTest() {
        MockitoAnnotations.openMocks(this);
    }
    @Test
    void testProcessShipmentOrder() {
        doReturn(new ShipmentOrder("1001","Mangalore","Mumbai",8,"InProcess")).when(realShipmentOrderRepository).addShipmentOrder(any(ShipmentOrder.class));
        ShipmentOrder order=new ShipmentOrder("1001","Mangalore","Mumbai",8,"InProcess");
        ShipmentOrder processedOrder = shipmentOrderService.processShipmentOrder(order);
        verify(realShipmentOrderRepository).addShipmentOrder(order);
        verify(realShipmentOrderRepository).findShipmentOrderById("1001");
        assertNotNull(processedOrder);
        assertEquals("1001", processedOrder.getOrderId());
    }
}