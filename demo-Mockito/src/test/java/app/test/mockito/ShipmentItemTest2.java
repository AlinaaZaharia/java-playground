package app.test.mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import org.app.model.ShipmentItem;
import org.app.service.ShipmentWeightCalculatorService;
import org.app.service.ShipmentWeightCalculatorServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

public class ShipmentItemTest2 {
    ShipmentWeightCalculatorService shipmentService;
    @Test
    public void testShipmentItemWeightCalculatorUsingMockMethod() {
        List<ShipmentItem> listOfItems=List.of(new
                ShipmentItem("Television",25.0),new ShipmentItem("AC",30.0),new
                ShipmentItem("Fridge",80));
        shipmentService=Mockito.mock(ShipmentWeightCalculatorService.class
        );
        when(shipmentService.calculateTotalWeight(listOfItems)).thenReturn(135.0);
        ShipmentWeightCalculatorService fin=new ShipmentWeightCalculatorServiceImpl();
        Double totalWeight=fin.calculateTotalWeight(listOfItems);
        assertEquals(totalWeight,135.0);
    }
}
