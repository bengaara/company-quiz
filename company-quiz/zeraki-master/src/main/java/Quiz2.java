import java.util.Arrays;

public class Quiz2 {


  public static void main(String[] args){

    Quiz2 q = new Quiz2();

   System.out.println(q.reverseFours("abc".toCharArray()));
   System.out.println( q.reverseFours("abcd".toCharArray()));
   System.out.println(q.reverseFours("abcdef".toCharArray()));
    System.out.println( q.reverseFours("abcdefgh".toCharArray()));
    System.out.println( q.reverseFours("abcdefghi".toCharArray()));

  }
  String reverseFours(char[] s){


    char[] reversed = new char[s.length] ;
    //abcdefgh
    //01234567
    //3210 7654
    int x =0;
    for(x=0;x<s.length-1;x+=4){

      int len = 4+x<s.length?4+x:s.length;
      for(int y=x,z=len;(y<len);y++,z--){
        reversed[y]= s[z-1];
      }
    //  System.out.print("reversing: "+ String.valueOf(reversed));
    }
    //remainders: //abcd ef
    if(s.length >x)
    for(int a =x,b=s.length-1;a<s.length;a++,b--){
      reversed[a]= s[b];
    }

     System.out.print("\nreversing "+String.valueOf(s) + " ");
    return String.valueOf(reversed);
  }

}

