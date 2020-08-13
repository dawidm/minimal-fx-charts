package pl.dmotyka.minimalfxcharts;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Example extends Application {

    @Override
    public void start(Stage stage) {
        MinimalFxChart minimalFxChart = new MinimalFxChart(new double[]{1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 9, 8, 5, 4, 3, 2, 1, 2, 3, 4, 5, 6, 1, 1, 1, 1, 1, 2, 3, 8, 1, 1, 1, 7, 6, 5, 4, 3, 2, 1, 3, 4, 5, 6, 7, 8, 7, 6, 4, 3, 1, 2, 3, 4, 5, 6, 8, 6, 5, 2});
        minimalFxChart.setMarginsHorizontalPercent(0.05);
        minimalFxChart.setMarginsVerticalPercent(0.05);
        minimalFxChart.setChartPaint(Color.BLUE);
        DropShadow dropShadow = new DropShadow();
        dropShadow.setOffsetX(3);
        dropShadow.setOffsetY(3);
        minimalFxChart.setEffect(dropShadow);
        Scene scene = new Scene(minimalFxChart);
        stage.setScene(scene);
        stage.show();
    }
}
