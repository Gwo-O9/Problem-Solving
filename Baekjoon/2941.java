import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        str = str.replaceAll("c=","t");
        str = str.replaceAll("c-","t");
        str = str.replaceAll("dz=","t");
        str = str.replaceAll("d-","t");
        str = str.replaceAll("lj","t");
        str = str.replaceAll("nj","t");
        str = str.replaceAll("s=","t");
        str = str.replaceAll("z=","t");
        //str = str.replaceAll(" ","");
        System.out.println(str.length());
    }
}
