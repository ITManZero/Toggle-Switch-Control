package it.man.switchfx.shape;

import org.junit.Before;
import org.junit.Test;
import it.man.switchfx.constants.SwitchButtonStyle;
import static org.junit.Assert.assertEquals;

public class FixedCircleShapeTest {

    private FixedCircleShape fixedCircleShape;

    @Before
    public void setup() {
        fixedCircleShape = (FixedCircleShape) SwitchButtonStyle.ANDROID.getShape();
    }


    @Test
    public void calculateBorderWidth() {
        if (fixedCircleShape.getBorderWidth() > 0) {
            double mini = Math.min(SwitchButtonStyle.ANDROID.getDefaultHeight(), SwitchButtonStyle.ANDROID.getDefaultWidth());
            assertEquals(fixedCircleShape.getBorderWidthFactor() * mini, fixedCircleShape.calculateBorderWidth(mini), 0);

        }
    }

    @Test
    public void calculateSize() {
        double mini = Math.min(SwitchButtonStyle.ANDROID.getDefaultHeight(), SwitchButtonStyle.ANDROID.getDefaultWidth());
        assertEquals(fixedCircleShape.getShapeSizeFactor() * mini, fixedCircleShape.calculateSize(mini), 0);
    }

    @Test
    public void calculatePositionX() {

    }

    @Test
    public void setPrefSize() {

    }
}