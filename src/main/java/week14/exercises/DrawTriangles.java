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

            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }

            System.out.println();
        }
    }

    public void drawTriangle3(int count) {
        System.out.println();
        for (int i = count; i >= 1; i--) {
            for (int j = i; j >= 1; j--) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public void drawTriangle4(int count) {
        System.out.println();

        for (int i = count; i >= 1; i--) {
            for (int j = count - i; j >= 1; j--) {
                System.out.print(" ");
            }

            for (int j = i; j>= 1; j--) {
                System.out.print("*");
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {
        DrawTriangles drawTriangles = new DrawTriangles();

        int count = 5;

        drawTriangles.drawTriangle1(count);
        drawTriangles.drawTriangle2(count);
        drawTriangles.drawTriangle3(count);
        drawTriangles.drawTriangle4(count);
    }

}
