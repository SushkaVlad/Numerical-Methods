import java.util.ArrayList;
import java.util.Scanner;
public class Newton {

    public static double F1(double x, double y,double z)
    {
        return 9*x*Math.pow(z,2) + y*z + 2*Math.pow(y,2)*Math.pow(x,3)+175;
    }

    public static double F2(double x, double y,double z)
    {
        return 0.5*Math.pow(y,3)*Math.pow(z,2) - 0.8*Math.pow(x,2)*y - 1.3;
    }

    public static double F3(double y, double z)
    {
        return 0.7*Math.pow(z,3) - 6.3*Math.pow(y,3) - 12.6;
    }

    public static ArrayList<Double> F1Derivatives(double x,double y, double z)
    {   ArrayList<Double> F1Der = new ArrayList<>();
        F1Der.add(9*Math.pow(z,2) + 6*Math.pow(y,2)*Math.pow(x,2));
        F1Der.add(z + 4*y*Math.pow(x,3));
        F1Der.add(18*x*z + y);
        return F1Der;
    }

    public static ArrayList<Double> F2Derivatives(double x,double y, double z)
    {   ArrayList<Double> F2Der = new ArrayList<>();
        F2Der.add(-1.6*x*y);
        F2Der.add(1.5*Math.pow(y,2)*Math.pow(z,2) - 0.8*Math.pow(x,2));
        F2Der.add(z*Math.pow(y,3));
        return F2Der;
    }

    public static ArrayList<Double> F3Derivatives(double y, double z)
    {   ArrayList<Double> F3Der = new ArrayList<>();
        F3Der.add(0.0);
        F3Der.add(-18.9*Math.pow(y,2));
        F3Der.add(2.1*Math.pow(z,2));
        return F3Der;
    }

    public static ArrayList<Double> Deltas(double a [][] , double b [])
    {
        ArrayList<Double> deltas = new ArrayList<>();
        /* Метод Гаусса */
        for (int p = 0; p < 3; p++) {
            int max = p;
            for (int i = p + 1; i < 3; i++) {
                if (Math.abs(a[i][p]) > Math.abs(a[max][p])) {
                    max = i;
                }
            }
            double[] temp = a[p]; a[p] = a[max]; a[max] = temp;
            double   t    = b[p]; b[p] = b[max]; b[max] = t;


            for (int i = p + 1; i < 3; i++) {
                double alpha = a[i][p] / a[p][p];
                b[i] -= alpha * b[p];
                for (int j = p; j < 3; j++) {
                    a[i][j] -= alpha * a[p][j];
                }
            }
        }

        // Обратный проход

        double[] x = new double[3];
        for (int i = 3 - 1; i >= 0; i--) {
            double sum = 0.0;
            for (int j = i + 1; j < 3; j++) {
                sum += a[i][j] * x[j];
            }
            x[i] = (b[i] - sum) / a[i][i];
        }

            deltas.add(x[0]);
            deltas.add(x[1]);
            deltas.add(x[2]);
            return deltas;
        }

    public static void main (String [] args)
    {   double x0, y0, z0, eps;
        double a [][]; double b [];
        Scanner in = new Scanner(System.in);
        System.out.println("Введите через пробел приближенные значения x y z для системы уравнений \n 9xz^2+yz+2y^2x^3+175=0 \n 0.5y^3z^2-0.8x^2y-1.3=0 \n 0.7z^3-6.3y^3-12.6=0");
        x0 = in.nextDouble();
        y0 = in.nextDouble();
        z0 = in.nextDouble();
        System.out.println("Введите необходимую точность");
        eps = in.nextDouble();
        int k=0;
        do {
            k++;
            a = new double[][]{
                    { F1Derivatives(x0, y0, z0).get(0), F1Derivatives(x0, y0, z0).get(1), F1Derivatives(x0, y0, z0).get(2)},
                    { F2Derivatives(x0, y0, z0).get(0), F2Derivatives(x0, y0, z0).get(1), F2Derivatives(x0, y0, z0).get(2)},
                    { F3Derivatives(y0, z0).get(0), F3Derivatives(y0, z0).get(1), F3Derivatives(y0, z0).get(2)}};
            b = new double[]{-F1(x0, y0, z0), -F2(x0, y0, z0), -F3(y0, z0)};
            x0 = x0 + Deltas(a, b).get(0);
            y0 = y0 + Deltas(a, b).get(1);
            z0 = z0 + Deltas(a, b).get(2);
            System.out.println("x -  " + x0);
            System.out.println("y -  " + y0);
            System.out.println("z -  " + z0 + "\n");
        } while (Math.abs(Deltas(a, b).get(0))>eps||Math.abs(Deltas(a, b).get(1))>eps||Math.abs(Deltas(a, b).get(2))>eps);

        System.out.println("Окончательное решение: ");
        System.out.println("x -  " + x0);
        System.out.println("y -  " + y0);
        System.out.println("z -  " + z0);
        System.out.println("Количество итераций - " + k);
    }
}
