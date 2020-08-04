public class Demp2 {
    public static void main(String[] args) {
        int a=520;
        int b=0;
        int c;
        try {
            System.out.println("这是一个被除数为0的式子");
            c = a / b;
        }catch (ArithmeticException e){
            System.out.println("被除数不能为0");
        }
    }
}
