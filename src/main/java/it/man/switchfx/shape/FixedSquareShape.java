package it.man.switchfx.shape;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class FixedSquareShape extends SwitchButtonShape<Rectangle> {


    protected FixedSquareShape(Color borderColor,
                               double borderWidthFactor, double shapeSizeFactor, double positionXFactor) {
        this(Color.WHITE, borderColor, 0, borderWidthFactor, shapeSizeFactor, positionXFactor);
    }

    public FixedSquareShape(double borderWidthFactor, double shapeSizeFactor, double positionXFactor) {
        this(Color.WHITE, 0, borderWidthFactor, shapeSizeFactor, positionXFactor);
    }

    protected FixedSquareShape(Color shapeColor, double backgroundRadius, double borderWidthFactor, double shapeSizeFactor, double positionXFactor) {
        super(new Rectangle(), backgroundRadius, shapeColor, borderWidthFactor, shapeSizeFactor, positionXFactor);
    }

    protected FixedSquareShape(Color shapeColor, Color borderColor, double backgroundRadius, double borderWidthFactor, double shapeSizeFactor, double positionXFactor) {
        super(new Rectangle(), backgroundRadius, shapeColor, borderColor, borderWidthFactor, shapeSizeFactor, positionXFactor);
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
        getShape().setWidth(calculateSize(mini));
        getShape().setHeight(calculateSize(mini));
        if (this.isBordered())
            getShape().setStrokeWidth(calculateBorderWidth(mini));
        setPositionX(calculatePositionX(width));
    }

}
