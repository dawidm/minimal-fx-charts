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
import java.util.Arrays;

import javafx.scene.canvas.Canvas;
import javafx.scene.effect.Effect;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class MinimalFxChart extends Region {

    private final Canvas canvas;
    private double[] values;
    private Paint chartPaint = Color.RED;
    private Effect chartEffect = null;
    private double marginsHorizontalPercent = 0;
    private double marginsVerticalPercent = 0;

    public MinimalFxChart(double[] values) {
        this.values = values;
        widthProperty().addListener(o -> paint());
        heightProperty().addListener(o -> paint());
        canvas = new Canvas();
        getChildren().add(canvas);
    }

    public void repaint(double[] values) {
        this.values = values;
        paint();
    }

    public void setMarginsHorizontalPercent(double marginsHorizontalPercent) {
        this.marginsHorizontalPercent = marginsHorizontalPercent;
    }

    public void setMarginsVerticalPercent(double marginsVerticalPercent) {
        this.marginsVerticalPercent = marginsVerticalPercent;
    }

    public void setChartPaint(Paint chartPaint) {
        this.chartPaint = chartPaint;
    }

    public void setChartEffect(Effect chartEffect) {
        this.chartEffect = chartEffect;
    }

    public Paint getChartPaint() {
        return chartPaint;
    }

    public Effect getChartEffect() {
        return chartEffect;
    }

    public double getMarginsHorizontalPercent() {
        return marginsHorizontalPercent;
    }

    public double getMarginsVerticalPercent() {
        return marginsVerticalPercent;
    }

    private void paint() {
        canvas.setWidth(getWidth());
        canvas.setHeight(getHeight());
        double[][] rescaledValues = rescaleValues(values, getWidth(), getHeight());
        double[] arguments = rescaledValues[0];
        double[] values = rescaledValues[1];
        var gc = canvas.getGraphicsContext2D();

        gc.setStroke(chartPaint);
        gc.setEffect(chartEffect);
        gc.clearRect(0,0,getWidth(),getHeight());
        gc.beginPath();
        gc.moveTo(arguments[0],getHeight()-values[0]);
        for(int i=1; i<arguments.length;i++)
            gc.lineTo(arguments[i], getHeight()-values[i]);
        gc.stroke();
    }

    private double[][] rescaleValues(double[] values, double width, double height) {
        width -= 2*marginsHorizontalPercent*width;
        height -= 2*marginsVerticalPercent*height;
        int marginHorizontalPx = (int)(marginsHorizontalPercent*width);
        int marginVerticalPx = (int)(marginsVerticalPercent*height);
        double oldToNewRatio = (values.length-1) / width;
        double[] arguments;
        if (values.length>width) {
            var valuesNew = new double[(int) width];
            arguments = new double[(int)width];
            for (int i = 0; i < valuesNew.length; i++) {
                valuesNew[i] = values[(int) (i * oldToNewRatio)];
                arguments[i] = i + marginHorizontalPx;
            }
            values = valuesNew;
        } else if (values.length<width) {
            var argsList = new ArrayList<Double>();
            var valList = new ArrayList<Double>();
            for(int i=0; i < values.length; i++) {
                valList.add(values[i]);
                argsList.add(i/oldToNewRatio + marginHorizontalPx);
            }
            arguments = argsList.stream().mapToDouble(a -> a).toArray();
            values = valList.stream().mapToDouble(v -> v).toArray();
        } else {
            arguments = new double[(int)width];
            for (int i = 0; i < arguments.length; i++)
                arguments[i] = i + marginHorizontalPx;
        }
        double valuesMin = Arrays.stream(values).min().getAsDouble();
        double valuesMax = Arrays.stream(values).max().getAsDouble();
        double minMax = Math.abs(valuesMin-valuesMax);
        values = Arrays.stream(values).map(v -> v-valuesMin).toArray();
        for(int i=0; i<values.length; i++) {
            values[i] = values[i]*height/minMax + marginVerticalPx;
        }
        return new double[][] {arguments, values};
    }
}
