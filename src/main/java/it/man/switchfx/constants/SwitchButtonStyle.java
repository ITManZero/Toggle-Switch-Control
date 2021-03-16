package it.man.switchfx.constants;

import it.man.switchfx.shape.SwitchButtonShape;
import it.man.switchfx.shape.FixedCircleShape;
import it.man.switchfx.shape.FixedRectangleShape;
import it.man.switchfx.shape.FixedSquareShape;
import it.man.switchfx.shape.SwitchButtonShape;

public enum SwitchButtonStyle {
    APPLE {
        @Override
        public double getDefaultWidth() {
            return 40;
        }

        @Override
        public double getDefaultHeight() {
            return 23.2;
        }

        @Override
        public double getFixWidthFactor() {
            return 0.58;
        }

        @Override
        public SwitchButtonShape getShape() {
            return new FixedCircleShape(0.06666666666666666666666666666667, 0.4, 0.0625);
        }
    }, ANDROID {
        @Override
        public double getDefaultWidth() {
            return 40;
        }

        @Override
        public double getDefaultHeight() {
            return 20;
        }

        @Override
        public double getFixWidthFactor() {
            return 0.5;
        }

        @Override
        public SwitchButtonShape getShape() {
            return new FixedCircleShape(0.06666666666666666666666666666667, 0.55, 0.00);
        }
    }, RECTANGLE {
        @Override
        public double getDefaultWidth() {
            return 40;
        }

        @Override
        public double getDefaultHeight() {
            return 25;
        }

        @Override
        public double getFixWidthFactor() {
            return 0.4;
        }

        @Override
        public SwitchButtonShape getShape() {
            return new FixedRectangleShape(0.06666666666666666666666666666667, 0.75, 0.0425);
        }
    },SQUARE {
        @Override
        public double getDefaultWidth() {
            return 40;
        }

        @Override
        public double getDefaultHeight() {
            return 25;
        }

        @Override
        public double getFixWidthFactor() {
            return 0.5;
        }

        @Override
        public SwitchButtonShape getShape() {
            return new FixedSquareShape(0.06666666666666666666666666666667, 0.8, 0.0625);
        }
    };


    public abstract double getDefaultWidth();

    public abstract double getDefaultHeight();

    public abstract double getFixWidthFactor();

    public abstract SwitchButtonShape getShape();
}