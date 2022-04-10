import java.util.HashMap;
import java.util.Map;

public class Interpolation {
    int x [] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
    int y [] = {5, 6, 8, 10, 12, 13, 12, 10, 8, 10, 8, 11, 7, 9, 11, 10, 9, 12, 11, 6};
    Map<Double, Double> interpolated_x = new HashMap<Double, Double>();
    public void lagrange_polinomial()
    {   int startpoint; int endpoint;
        for (double x_to_interp = 1; x_to_interp<=20; x_to_interp=x_to_interp+0.25) {
            double lagr_pol = 0;
            startpoint = (int) Math.floor(x_to_interp)-2;
            endpoint = (int) Math.floor(x_to_interp)+3;
            if (x_to_interp<=4) {startpoint = 1; endpoint=6;}
            if (x_to_interp>=17) {startpoint = 15; endpoint=20;}
            for (int i = startpoint-1; i <= endpoint-1; i++) {
                double lagr = 1;
                for (int j = startpoint-1; j <= endpoint-1; j++) {
                    if (i != j) {
                        lagr = lagr * (x_to_interp - x[j])/(x[i] - x[j]);
                    }
                }
                lagr_pol = lagr_pol + lagr * y[i];
            }
            interpolated_x.put(x_to_interp, lagr_pol);
        }
    }

    public static void main(String [] args) {
        Interpolation a = new Interpolation();
        a.lagrange_polinomial();
        for(Map.Entry<Double, Double> pair : a.interpolated_x.entrySet())
        {
            System.out.print(pair.getKey() + ": ");
            System.out.println(pair.getValue());
        }
    }
}
