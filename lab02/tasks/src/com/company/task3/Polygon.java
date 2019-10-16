package com.company.task3;

import java.util.Arrays;

public class Polygon {
    private Point[] points;

    public Polygon(int n) {
        points = new Point[n];
    }

    public Polygon(float[] points) {
        this(points.length / 2);

        for(int i = 0, pointIndex = 0; i < this.points.length; i++, pointIndex += 2) {
            this.points[i] = new Point(points[pointIndex], points[pointIndex + 1]);
        }

        /**
         * Echivalent cu for (int i = 0; i < poins.length; i++) { points[i].showPoint();}
         */
        Arrays.stream(this.points).forEach(point -> point.showPoint());
    }
}
