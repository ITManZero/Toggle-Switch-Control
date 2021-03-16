package it.man.switchfx.shape;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class FixedCircleShape extends SwitchButtonShape<Circle> {

    protected FixedCircleShape(Color borderColor,
                               double borderWidthFactor, double shapeSizeFactor, double positionXFactor) {
        this(Color.WHITE, borderColor, 50, borderWidthFactor, shapeSizeFactor, positionXFactor);
    }

    public FixedCircleShape(double borderWidthFactor, double shapeSizeFactor, double positionXFactor) {
        this(Color.WHITE, 50, borderWidthFactor, shapeSizeFactor, positionXFactor);
    }

    protected FixedCircleShape(Color shapeColor, double backgroundRadius, double borderWidthFactor, double shapeSizeFactor, double positionXFactor) {
        super(new Circle(), backgroundRadius, shapeColor, borderWidthFactor, shapeSizeFactor, positionXFactor);
    }

    protected FixedCircleShape(Color shapeColor, Color borderColor, double backgroundRadius, double borderWidthFactor, double shapeSizeFactor, double positionXFactor) {
        super(new Circle(), backgroundRadius, shapeColor, borderColor, borderWidthFactor, shapeSizeFactor, positionXFactor);
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
        return (width / 2) - (getShape().getRadius() + (getBorderWidth() / 2)) - (width * getPositionXFactor());
    }

    @Override
    public void setPrefSize(double width, double height) {
        double mini = Math.min(width, height);
        getShape().setRadius(calculateSize(mini));
        if (this.isBordered())
            getShape().setStrokeWidth(calculateBorderWidth(mini));
        setPositionX(calculatePositionX(width));
    }

}
