public class ExceptionTest {
    public static void main(String[] args) {
        try {
            throw new RuntimeException();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } catch (StackOverflowError e) {
            System.out.println("Hello, world!");
        }
    }
}
