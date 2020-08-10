package pl.dmotyka.minimalfxcharts;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Test extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        MinimalFxChart minimalFxChart = new MinimalFxChart(new double[] {1, 2});
        Scene scene = new Scene(minimalFxChart);
        stage.setScene(scene);
        stage.show();
    }
}
