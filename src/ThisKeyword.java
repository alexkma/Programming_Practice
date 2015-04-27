/**
 * Created by Alex on 3/28/2015.
 */
public class ThisKeyword {
    public int x = 0;
    public int y = 0;

    public ThisKeyword(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public static void main(String[] args) {
        ThisKeyword keyword = new ThisKeyword(4, 5);
        System.out.println(keyword.getX());
        System.out.println(keyword.getY());
    }
}
