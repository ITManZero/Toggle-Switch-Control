package it.man.switchfx;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.BooleanPropertyBase;
import javafx.css.PseudoClass;
import javafx.scene.control.Labeled;
import javafx.scene.control.Skin;
import it.man.switchfx.constants.SwitchButtonStyle;


public class SwitchButton extends Labeled {


    private BooleanProperty switchedOn;
    private SwitchButtonSkin switchButtonSkin;


    private static final PseudoClass PSEUDO_ACTIVE = PseudoClass.getPseudoClass("selected");

    public SwitchButton(SwitchButtonStyle switchButtonStyle) {
        this(switchButtonStyle, null);
    }

    public SwitchButton(SwitchButtonStyle switchButtonStyle, String text) {
        super(text);
        this.switchButtonSkin = new SwitchButtonSkin(this, switchButtonStyle);
        this.setPrefSize(switchButtonStyle.getDefaultWidth(), switchButtonStyle.getDefaultHeight());
        getStyleClass().setAll("switch-button");
    }


    public void setSwitchedOn(boolean switchedOn) {
        switchedOnProperty().set(switchedOn);
    }

    public boolean isSwitchedOn() {
        return switchedOn == null ? false : switchedOn.get();
    }

    public final BooleanProperty switchedOnProperty() {
        if (switchedOn == null) {
            switchedOn = new BooleanPropertyBase() {
                @Override
                protected void invalidated() {
                    final Boolean v = get();
                    pseudoClassStateChanged(PSEUDO_ACTIVE, v);
                }

                @Override
                public Object getBean() {
                    return this;
                }

                @Override
                public String getName() {
                    return "selected";
                }
            };
        }
        return switchedOn;
    }

    @Override
    protected Skin<?> createDefaultSkin() {
        return switchButtonSkin;
    }

    @Override
    public String getUserAgentStylesheet() {
        return getClass().getResource("/switch-button.css").toExternalForm();
    }

    @Override
    public void setPrefSize(double v, double v1) {
        if (v * switchButtonSkin.getFixWidthFactor() != v1) {
            v1 = Math.min(v, v1);
            v = v1 / switchButtonSkin.getFixWidthFactor();
        }
        switchButtonSkin.getSwitchButtonShape().setPrefSize(v, v1);
        switchButtonSkin.getSwitchButtonShape().translateOnX(-1);
        switchButtonSkin.getButtonBackground().setPrefSize(v, v1);
        super.setPrefSize(v * 1.05, v1 * 1.05);
    }


}
