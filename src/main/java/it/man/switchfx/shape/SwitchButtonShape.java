package it.man.switchfx.shape;


import javafx.animation.TranslateTransition;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;
import javafx.util.Duration;

public abstract class SwitchButtonShape<T extends Shape> {

    private final TranslateTransition translateTransition;
    private final T shape;
    private final double defaultBackgroundRadius;
    private final double positionXFactor;

    private boolean bordered;
    private double positionX;
    private double borderWidthFactor;
    private double shapeSizeFactor;


    public SwitchButtonShape(T shape, double backgroundRadius, Color shapeColor, Color borderColor,
                             double borderWidthFactor, double shapeSizeFactor, double positionXFactor) {
        this(shape, backgroundRadius, shapeColor, borderWidthFactor, shapeSizeFactor, positionXFactor);
        this.shape.setStroke(borderColor);
        this.bordered = true;
    }

    protected SwitchButtonShape(T shape, double backgroundRadius, Color shapeColor,
                                double borderWidthFactor, double shapeSizeFactor, double positionXFactor) {
        this.translateTransition = new TranslateTransition(Duration.millis(400.0D), shape);
        this.translateTransition.setRate(2.5);
        this.shape = shape;
        this.defaultBackgroundRadius = backgroundRadius;
        this.shapeSizeFactor = shapeSizeFactor;
        this.borderWidthFactor = borderWidthFactor;
        //this.shape.setFill(shapeColor);
        this.positionXFactor = positionXFactor;
        this.bordered = false;
    }


    protected abstract double calculateBorderWidth(double mini);

    protected abstract double calculateSize(double mini);

    protected abstract double calculatePositionX(double width);

    public abstract void setPrefSize(double width, double Double);


    public final void translateOnX(int direction) {
        if (direction < -1 || direction > 1)
            throw new IllegalArgumentException("UnDefined direction");
        getTranslateTransition().stop();
        getTranslateTransition().setToX(direction * getPositionX());
        getTranslateTransition().play();
    }

    public final void setBorderWidthFactor(double borderWidthFactor) {
        this.borderWidthFactor = borderWidthFactor;
    }

    public final void setShapeSizeFactor(double shapeSizeFactor) {
        this.shapeSizeFactor = shapeSizeFactor;
    }

    public final double getBorderWidthFactor() {
        return borderWidthFactor;
    }

    public final double getShapeSizeFactor() {
        return shapeSizeFactor;
    }

    public final void setPositionX(double positionX) {
        this.positionX = positionX;
    }

    public final void setBorderColor(Color borderColor) {
        shape.setStroke(borderColor);
    }

    public final void setShapeColor(Color shapeColor) {
        shape.setFill(shapeColor);
    }

    public final TranslateTransition getTranslateTransition() {
        return translateTransition;
    }

    public final void setBorderWidth(float borderWidth) {
        shape.setStrokeWidth(borderWidth);
    }

    public final double getBorderWidth() {
        return shape.getStrokeWidth();
    }

    public final boolean isBordered() {
        return bordered;
    }

    public final double getPositionXFactor() {
        return positionXFactor;
    }

    public double getDefaultBackgroundRadius() {
        return defaultBackgroundRadius;
    }

    public final Color getBorderColor() {
        return (Color) shape.getStroke();
    }

    public final Color getShapeColor() {
        return (Color) shape.getFill();
    }

    public final double getPositionX() {
        return positionX;
    }

    public final T getShape() {
        return shape;
    }

}
