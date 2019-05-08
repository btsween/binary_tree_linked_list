package btll;

public class Trial {
	
	public void recurse(int i) {
		if(i < 2) {
			System.out.println(i);
			return;
		}
		System.out.println(i);
		recurse(i-1);
	}

	public static void main(String[] args) {

		int i = 0;
		while (i < 10) {
			System.out.println(i);
			i++;
		}
		
		Trial t = new Trial();
		t.recurse(10);
		
	}

}
