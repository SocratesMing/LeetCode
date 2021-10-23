import org.junit.Test;

public class Test111 {
    public static void main(String[] args) {
        Thread t =new Thread(){
            @Override
            public void run() {
                pong();
            }
        };

        t.run();
        System.out.println("Ping");
    }

    public static void pong() {
        System.out.println("Pong");
    }


    @Test
    public void test01() {
        String ss = "abcdefg";
        System.out.println(new StringBuilder(ss).reverse());
    }
}
