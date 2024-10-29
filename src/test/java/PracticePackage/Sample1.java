package PracticePackage;

import java.util.LinkedHashSet;

public class Sample1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       String[] s={"D","F","D","D","A","B","C","C","F","D","G"};
       LinkedHashSet<String> set=new LinkedHashSet<String>();
       for(int i=0;i<s.length;i++)
       {
    	   set.add(s[i]);
       }
       for (String str : set) 
       {
		 int count =0;
		 for(int i=0;i<s.length;i++)
		 {
			 if(str.equals(s[i]))
			 {
				 count++;
			 }
		 }
		 if(count>1)
		 {
			 System.out.print(str+count);
		 }
       
		 if(count==1)
		 {
			 System.out.print(str);
		 }
	}
       
}
       
       
       
	}


