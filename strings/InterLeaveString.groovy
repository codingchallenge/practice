package amazon.practise.strings

class InterLeaveString {

	
	public void pILS(String s1, String s2){
		if (s1== null && s2== null){
			return;
		} else if(s2 == null){
		   println s1;
		   return;
		} else if (s1 == null){
		   println s2;
		   return;
		} 
		
		else {
		  pILSR(s1,s2,"");
		}
	}
	public void pILSR(String s1, String s2, String s3){
		if ((s1 == null || s1.isEmpty()) && (s2 == null || s2.isEmpty()) ){
			println s3;
		} else if (s1 == null || s1.isEmpty()){
		   if (s3 != null){
			   println s3+s2;
		   }else {
		      println s2;
		   }
		} else if (s2 == null || s2.isEmpty()){
		   if (s3 != null){
			   println s3+s1;
		   } else {
		    println s1;
		   }
		} else if (s1.size() == 1 && s2.size() == 1){
		   println s3 + s1 + s2;
		   println s3 + s2 + s1;
		} else {
		    char c1 = s1.charAt(0);
			char c2 = s2.charAt(0);
		    pILSR(s1.substring(1,s1.length()), s2,s3+new String(c1)) 
			pILSR(s1, s2.substring(1,s2.length()), s3 + new String(c2));
		
		}
	}
	
	public static void main(String[] args){
		InterLeaveString s = new InterLeaveString();
		s.pILS("AB", "CD");
		s.pILS("AB", "C");
		
	}

}
