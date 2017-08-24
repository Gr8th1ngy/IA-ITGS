package tester;

public class Test {
	private boolean result=true;
	public void setResult(boolean result) {
		this.result = result;
	}
	private String caseNo="1";
public Test() {
}
public boolean next() {
	return result;
}
public String getCaseNo() {
	return caseNo;
}
public void setCaseNo(String caseNo) {
	this.caseNo = caseNo;
}

}
