package it.man.switchfx.shape;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class FixedRectangleShape extends SwitchButtonShape<Rectangle> {


    protected FixedRectangleShape(Color borderColor,
                                  double borderWidthFactor, double shapeSizeFactor, double positionXFactor) {
        this(Color.WHITE, borderColor, 0, borderWidthFactor, shapeSizeFactor, positionXFactor);
    }

    public FixedRectangleShape(double borderWidthFactor, double shapeSizeFactor, double positionXFactor) {
        this(Color.WHITE, 0, borderWidthFactor, shapeSizeFactor, positionXFactor);
    }

    protected FixedRectangleShape(Color shapeColor, double cornerStyle, double borderWidthFactor, double shapeSizeFactor, double positionXFactor) {
        super(new Rectangle(), cornerStyle, shapeColor, borderWidthFactor, shapeSizeFactor, positionXFactor);
    }

    protected FixedRectangleShape(Color shapeColor, Color borderColor, double cornerStyle, double borderWidthFactor, double shapeSizeFactor, double positionXFactor) {
        super(new Rectangle(), cornerStyle, shapeColor, borderColor, borderWidthFactor, shapeSizeFactor, positionXFactor);

    }

    @Override
    protected double calculateBorderWidth(double mini) {
        return mini * getBorderWidthFactor();
    }

    @Override
    protected double calculateSize(double mini) {
        return mini * getShapeSizeFactor();
    }

    @Override
    protected double calculatePositionX(double width) {
        return (width / 2) - ((getShape().getWidth() / 2) + (getBorderWidth() / 2)) - (width * getPositionXFactor());
    }

    @Override
    public void setPrefSize(double width, double height) {
        double mini = Math.min(width, height);
        getShape().setWidth((Math.max(width, height) - (width * getPositionXFactor()) * 2) * 0.5);
        getShape().setHeight(calculateSize(mini));
        if (this.isBordered())
            getShape().setStrokeWidth(calculateBorderWidth(mini));
        setPositionX(calculatePositionX(width));
    }

}
