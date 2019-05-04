package week14.exercises;

public class DrawTriangles {

    public void drawTriangle1(int count) {

        for (int i = 1; i <= count; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public void drawTriangle2(int count) {
        for (int i = 1; i <= count; i++) {
            for (int j = count - i; j >= 1; j--) {
                System.out.print(" ");
            }

            for (int j =1; j<=i; j++) {
                System.out.print("*");
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {
        DrawTriangles drawTriangles = new DrawTriangles();

        int count = 7;

        drawTriangles.drawTriangle1(count);
        drawTriangles.drawTriangle2(count);
    }

}
