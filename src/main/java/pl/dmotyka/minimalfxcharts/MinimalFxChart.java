package pl.dmotyka.minimalfxcharts;

import javafx.scene.canvas.Canvas;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;

public class MinimalFxChart extends Region {

    private Canvas canvas;

    public MinimalFxChart(double values[]) {
        widthProperty().addListener(o -> paint());
        heightProperty().addListener(o -> paint());
    }

    private void paint() {
        canvas = new Canvas(getWidth(),getHeight());
        getChildren().clear();
        getChildren().add(canvas);
        var gc = canvas.getGraphicsContext2D();
        System.out.println(canvas.getWidth());
        gc.setStroke(Color.RED);
        gc.beginPath();
        gc.moveTo(0,0);
        gc.lineTo(getWidth(), getHeight());
        gc.stroke();
    }
}
