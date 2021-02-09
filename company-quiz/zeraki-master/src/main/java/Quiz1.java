import java.util.Arrays;
import java.util.Comparator;

public class Quiz1 {


  public static void main(String[] args){

    Quiz1 q = new Quiz1();

    System.out.println("answer is "+ q.missingArray(new int[]{1, 2, 3, 5}));

   System.out.println("answer is "+ q.missingArray(new int[]{1, 2, 3,4,6}));
    System.out.println("answer is "+ q.missingArray(new int[]{1,2,4}));
    System.out.println("answer is "+ q.missingArray(new int[]{1,3,4}));
    System.out.println("answer is "+ q.missingArray(new int[]{1,3,4,5}));

  }
  int missingArray(int[] list){
    Arrays.sort(list);
    for(int a : list){
      System.out.println(a);
    }
    System.out.println("----------------------");
    return missing(list,list.length+1);
  }
  int missing(int[] arr,int top){
    //divide and conquer
    int ans = -1;
    int low;
     while(ans<0){
      int center = arr.length/2-1;


      System.out.println("center "+center);
       int bottom = top - (arr.length);

      if(arr[center]>=top-(center+1)){
        arr = Arrays.copyOfRange(arr,0,center+1);
        top = top - (arr.length);
      }else{
        arr = Arrays.copyOfRange(arr,center+1,arr.length);
        bottom = top - (arr.length);
      }
       System.out.print("selected arr: ");
       for(int a : arr){
         System.out.print(a);
       }  System.out.println();

       if(bottom<arr[0]){//go lower
         ans= bottom;
       }else if(top>arr[arr.length-1]){//go lower
        ans= top;
      }else if(top-arr.length>arr[0]){
        ans= top-arr.length;
      }else if(arr.length==1){
      ans= top-1;
    }else{
        //split
        return missing(arr,arr[arr.length-1]);
      }

    }
    return ans;
  }
}
