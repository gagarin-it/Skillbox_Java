public class GeometryCalculator {
    // метод должен использовать абсолютное значение radius
    public static double getCircleSquare(double radius)
    {
        if (radius > 0) {
            double s = Math.pow(radius, 2) * Math.PI;
            return s;
        }
        return 0;
    }

    // метод должен использовать абсолютное значение radius
    public static double getSphereVolume(double radius)
    {
        if (radius > 0)
        {
            double v = Math.PI * Math.pow(radius, 3) * 4 / 3;
            return v;
        }
        return 0;
    }

    public static boolean isTriangleRightAngled(double a, double b, double c)
    {
        if(a + b > c || a + c > b || c + b > a)
        {
            return true;
        }
        return false;
    }

    // перед расчетом площади рекомендуется проверить возможен ли такой треугольник
    // методом isTriangleRightAngled, если невозможен вернуть -1.0
    public static double getTriangleSquare(double a, double b, double c)
    {
        if (isTriangleRightAngled(a,b,c))
        {
            double p = (a +b +c) / 2;
            double s = Math.sqrt(p * (p - a) * (p - b) * (p - c));
            return s;
        }
        return -1.0;
    }
}
