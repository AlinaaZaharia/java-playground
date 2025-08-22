package app.test.mockito;

import static org.junit.jupiter.api.Assertions.*;
import org.app.model.ShipmentItem;
import org.app.service.ShipmentWeightCalculatorService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class ShipmentItemTest
{
    @Mock
    ShipmentWeightCalculatorService shipmentService;
    @Test
    public void testShipmentItemWeightCalculatorUsingMockAnnotation() {
        List<ShipmentItem> listOfItems=List.of(new
                ShipmentItem("Television",25.0),new ShipmentItem("AC",30.0),new
                ShipmentItem("Fridge",80));
        Mockito.when(shipmentService.calculateTotalWeight(listOfItems)).thenReturn(135.0);
        assertEquals(shipmentService.calculateTotalWeight(listOfItems),135.0);
    }
}
