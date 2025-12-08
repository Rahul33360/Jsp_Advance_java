public class permutation {
	public static void main(String []args) {
		String s = "abcd";
		permutation(s,0,s.length()-1);
	}
	public static void permutation(String s,int st,int end) {
		if(st == end) {
			System.out.println(s);
			return;
		}
		for(int i=st; i<= end; i++) {
			String str = swap(s,st,i);
			permutation(s,st+1,end);
		}
	}	
	public static String swap(String s,int st,int i) {
		char [] arr = s.toCharArray();
		char temp = arr[st];
		arr[st] = arr[i];
		arr[i]	= temp;
		return new String(arr);
	}
}
