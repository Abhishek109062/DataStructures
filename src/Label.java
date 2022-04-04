public class Label {
    public static void main(String[] args) {

        for(int x=0;x<5;x++)
        {
            up:
            for(int y=0;y<5;y++)
            {
                System.out.println(y);
                if(y==2)
                break up;
            }
        }
    }
}
