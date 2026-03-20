
/**
 * Write a description of class JumpIt here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class JumpIt
{
    
    public static int jumpIt(int[] arr)
    {
      if(arr.length == 2)
      {
          return arr[1] + arr[0];
      }
      if(arr.length == 1)
      {
          return arr[0];
      }
      int[] sArr = new int[arr.length - 1];
      for(int i = 0; i < sArr.length; i++)
      {
          sArr[i] = arr[i + 1];
      }
      int[] bArr = new int[arr.length - 2];
      for(int i = 0; i < bArr.length; i++)
      {
          bArr[i] = arr[i + 2];
      }
      int bJump = jumpIt(bArr);
      int sJump = jumpIt(sArr);
      if(bJump < sJump)
      {
        return arr[0] + bJump;
      }
      else
      {
        return arr[0] + sJump;
      }
    }
    
    public static void main(String[] args){
        System.out.println(jumpIt(new int[]{0,1,2,4,3,5,6,8,5,7,30,25,8,1,2,3,7,5,6,1}));
    }
    
}
