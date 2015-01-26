package dfs;
import java.util.Scanner;
public class PaiLie{
 int n;
 boolean u[]; //u[i]标识数字i是否被使用过
 int ans[]; //ans排列的结果
 
 public PaiLie(int n){
   this.n=n;
   u=new  boolean[n+1];
   ans=new int[n+1];
 }
   
 private void print(){
    for (int i=0 ;i< n ;++i) 
      System.out.print(ans[i]+" ");
   System.out.println();
 }
  //递归实现深度优先搜索  
  void dfs(int d){
    if (d == n) {
        print();
        return;
    }    
    for (int i=1 ; i<=n; ++i)//当前顶点的所有可能邻接点
        if (!u[i]){//是邻接点
            ans[d] = i;
            u[i] = true;
            dfs(d+1);
            u[i] = false; //恢复现场
        }    
 }   
    public static void main(String args[]){
      Scanner in=new Scanner(System.in);
      int n=in.nextInt();
      PaiLie p=new PaiLie(n);
      p.dfs(0);
  }
} 