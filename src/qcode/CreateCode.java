package qcode;
import java.util.UUID;
public class CreateCode {
	/*����һ��uuid*/
	public String getUUID() {
		return UUID.randomUUID().toString().replace("-", "");
	}
	
	/*����ָ��������uuid*/
	public String[] getUUID(int n) {
		String[] UUIDs=new String[n];
		for(int i=0;i<n;i++) {
			UUIDs[i]=UUID.randomUUID().toString().replace("-", "");
		}
		return UUIDs;
	}
	
}


