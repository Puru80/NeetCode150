public class Outer {
    private int x = 10;

    class Inner {
        private int x = 20;

        void printX() {
            System.out.println(x + " " + this.x + " " + Outer.this.x);
        }
    }

    public static void main(String[] args) {
        Outer outer = new Outer();
        Inner inner = outer.new Inner();
        inner.printX();
    }
}