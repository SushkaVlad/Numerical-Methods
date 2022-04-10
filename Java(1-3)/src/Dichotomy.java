import java.util.Scanner;

public class Dichotomy {
    static double f(double x){
        double res = 0.93*Math.pow(x,5) - 0.71*Math.pow(x,4) - 0.53*Math.pow(x,3) + 2.1*Math.pow(x,2) - 10.5;
        return res;
    }
    public static void main(String [] args) {
        double a,b,c,eps;
        Scanner in = new Scanner(System.in);
        System.out.println("Найти корень уравнения 0.93*x^5 - 0.71*x^4 - 0.53*x^3 + 2.1*x^2 - 10.5 = 0 \nЗадайте точность:");
        eps = in.nextDouble();
        do {
            System.out.println("Введите значение левого конца отрезка: ");
             a = in.nextDouble();
            System.out.println("Введите значение правого конца отрезка: ");
             b = in.nextDouble();
            if (f(a)*f(b)<=0) {break;}
            System.out.println("На концах отрезка совпадают знаки значений функции!");
           } while (true);

        while (Math.abs(b-a)> eps)
        {
            c = (a+b)/2;
            if (f(a)*f(c)<=0) {b=c;}
            else {a=c;}
            System.out.println("x - " + c + " F(x) = " + f(c));
        }
    }
}
