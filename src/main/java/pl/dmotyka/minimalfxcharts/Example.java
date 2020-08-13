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
