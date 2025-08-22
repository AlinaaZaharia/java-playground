package shipmentOrderTest;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class ShipmentOrderServiceTest {
    String shipmentOrder;

    @Test
    public void testUpdateOrderStatus() {
        ShipmentOrderService service = new ShipmentOrderServiceImpl();
        ShipmentOrder order = new ShipmentOrder("1001", "Pune",
                "Bangalore",10,"Processing");
        service.addShipmentOrder(order);
        // Test updating the order status
        service.updateOrderStatus(shipmentOrder, "Shipped");
        ShipmentOrder retrievedOrder = service.getShipmentOrder("1001");
        assertEquals("Shipped", retrievedOrder.getStatus());
    }

    //Additional Assertion methods assertEquals,assertNotNull etc
    @Test
    public void testAddAndGetShipmentOrder() {
        ShipmentOrderService service = new
                ShipmentOrderServiceImpl();
        ShipmentOrder order = new ShipmentOrder("123", "Source",
                "Destination", 50,"Pending");
        // Test adding and getting a shipment order
        service.addShipmentOrder(order);
        ShipmentOrder retrievedOrder =
                service.getShipmentOrder("123");
        assertNotNull(retrievedOrder);
        assertEquals(order, retrievedOrder);
    }

    @Test
    public void testUpdateShipmentOrder() {
        ShipmentOrderService service = new ShipmentOrderServiceImpl();
        ShipmentOrder order = new ShipmentOrder("456", "Source",
                "Destination", 30,"Pending");
        service.addShipmentOrder(order);
        // Test updating a shipment order
        ShipmentOrder updatedOrder = new ShipmentOrder("456", "Source",
                "Destination", 30,"Shipped");
        service.updateShipmentOrder(updatedOrder);
        ShipmentOrder retrievedOrder = service.getShipmentOrder("456");
        assertNotNull(retrievedOrder);
        assertEquals(updatedOrder, retrievedOrder);
    }

    @Test
    public void testDeleteShipmentOrder() {
        ShipmentOrderService service = new ShipmentOrderServiceImpl();
        ShipmentOrder order = new ShipmentOrder("789", "Source", "Destination",
                20,"Pending");
        service.addShipmentOrder(order);
        // Test deleting a shipment order
        service.deleteShipmentOrder("789");
        ShipmentOrder retrievedOrder = service.getShipmentOrder("789");
        assertNull(retrievedOrder);
    }

    @Test
    void testAddAndFindShipmentOrder() {
        ShipmentOrderRepository repository = new
                ShipmentOrderRepository();
        ShipmentOrder order = new ShipmentOrder("123", "Source",
                "Destination",50, "Pending");
        // Test adding and finding a shipment order
        repository.addShipmentOrder(order);
        ShipmentOrder retrievedOrder =
                repository.findShipmentOrderById("123");
        assertSame(order, retrievedOrder, "Expected the same object reference");
    }
}
