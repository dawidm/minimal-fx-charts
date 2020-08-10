package pl.dmotyka.minimalfxcharts;

import javafx.scene.canvas.Canvas;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;

public class MinimalFxChart extends Region {

    private Canvas canvas;

    public MinimalFxChart(double values[]) {
        widthProperty().addListener(o -> paint());
        heightProperty().addListener(o -> paint());
        canvas = new Canvas();
        getChildren().add(canvas);
    }

    private void paint() {
        canvas.setWidth(getWidth());
        canvas.setHeight(getHeight());
        var gc = canvas.getGraphicsContext2D();
        gc.clearRect(0,0,getWidth(),getHeight());
        gc.setStroke(Color.RED);
        gc.beginPath();
        gc.moveTo(0,0);
        gc.lineTo(getWidth(), getHeight());
        gc.stroke();
    }
}
