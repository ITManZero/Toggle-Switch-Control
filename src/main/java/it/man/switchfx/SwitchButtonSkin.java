package it.man.switchfx;

import it.man.switchfx.shape.SwitchButtonShape;
import javafx.scene.control.Label;
import javafx.scene.control.SkinBase;
import it.man.switchfx.constants.SwitchButtonStyle;

public class SwitchButtonSkin extends SkinBase<SwitchButton> {


    private final SwitchButtonShape switchButtonShape;
    private final Label buttonBackground;
    private final double fixWidthFactor;

    /**
     * Constructor for all SkinBase instances.
     *
     * @param control The control for which this Skin should attach to.
     */
    protected SwitchButtonSkin(SwitchButton control, SwitchButtonStyle switchButtonStyle) {
        super(control);

        this.buttonBackground = new Label();
        this.switchButtonShape = switchButtonStyle.getShape();
        this.fixWidthFactor = switchButtonStyle.getFixWidthFactor();

        this.switchButtonShape.getShape().getStyleClass().setAll("shape");

        this.buttonBackground.getStyleClass().setAll("background");

        this.buttonBackground.setStyle("-fx-background-radius:" + switchButtonStyle.getShape().getDefaultBackgroundRadius() + "px");

        this.getChildren().addAll(buttonBackground, switchButtonShape.getShape());

        this.switchButtonShape.getShape().setOnMouseClicked(event -> {
            getSkinnable().setSwitchedOn(!getSkinnable().isSwitchedOn());
        });
        this.buttonBackground.setOnMouseClicked(event -> {
            getSkinnable().setSwitchedOn(!getSkinnable().isSwitchedOn());
        });

        control.switchedOnProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.booleanValue() != oldValue.booleanValue()) {
                if (getSkinnable().isSwitchedOn())
                    this.switchButtonShape.translateOnX(1);
                else
                    this.switchButtonShape.translateOnX(-1);
            }
        });

    }

    public double getFixWidthFactor() {
        return fixWidthFactor;
    }

    public SwitchButtonShape getSwitchButtonShape() {
        return switchButtonShape;
    }

    public Label getButtonBackground() {
        return buttonBackground;
    }

//    @Override
//    protected double computePrefWidth(double height, double topInset, double rightInset, double bottomInset, double leftInset) {
//        return height + topInset + bottomInset;
//    }

}
