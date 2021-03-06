/*
 * minimal-fx-charts
 *
 * Copyright © 2019-2020 Dawid Motyka
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 *
 */

package pl.dmotyka.minimalfxcharts;

import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Example extends Application {

    @Override
    public void start(Stage stage) {
        MinimalFxChart minimalFxChart = new MinimalFxChart(randVals(30));
        minimalFxChart.setMarginsHorizontalPercent(0.05);
        minimalFxChart.setMarginsVerticalPercent(0.05);
        minimalFxChart.setChartPaint(Color.BLUE);
        DropShadow dropShadow = new DropShadow();
        dropShadow.setOffsetX(3);
        dropShadow.setOffsetY(3);
        minimalFxChart.setEffect(dropShadow);
        minimalFxChart.setOnMouseClicked(e -> {
            minimalFxChart.repaint(randVals(30));
        });
        Scene scene = new Scene(minimalFxChart);
        stage.setScene(scene);
        stage.show();
    }

    private double[] randVals(int nVals) {
        double[] vals = new double[nVals];
        for (int i=0; i<nVals; i++)
            vals[i] = Math.random();
        return vals;
    }
}
