import org.app.logistics.LogisticsProvider;
import org.app.service.ShipmentOrderServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;


@ExtendWith(MockitoExtension.class)
public class ShipmentServiceTest {
    @Mock
    private LogisticsProvider logisticsProvider;
    @InjectMocks
    private ShipmentOrderServiceImpl shipmentService;
    public ShipmentServiceTest() {
        MockitoAnnotations.openMocks(this);
    // logisticsProvider=new LogisticsProviderImpl();
    }
    @Test
    void testGetEstimatedDeliveryTime() {
    // Given
        String trackingNumber = "ABC123";
    // Stubbing: Assume that the logistics provider returns a fixed delivery time.
        when(logisticsProvider.getDaysToDeliver(trackingNumber)).thenReturn(2);
    // When
        String estimatedDeliveryTime = shipmentService.getEstimatedDeliveryTime(trackingNumber);
    // Then
    // Perform assertions based on the expected behavior
        assertEquals("Estimated delivery in 2 days", estimatedDeliveryTime);
    }
}