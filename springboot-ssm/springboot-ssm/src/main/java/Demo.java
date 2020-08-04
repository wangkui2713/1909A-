public class Demo {
    public static void main(String[] args) {
        System.out.println(test());
    }
    public static String 
test(){
        int[] array = new int[2];
        try{
            array[3] = 0;
            return "This is try";
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println(e);
            return "This is catch 1";
        }catch (Exception e){
            System.out.println(e);
            return "This is catch 2";
        }finally {
            System.out.println("This is finally");
            //return "This is finally's return";
        }
    }
}
