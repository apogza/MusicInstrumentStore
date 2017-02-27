package Instruments;

public abstract class Guitar extends Strings {

	protected String caseIncluded;
	protected String neckMaterial; 
	
	public Guitar(String manufacturer, String model) {
		super(manufacturer, model);
	}
	
	public String getCaseIncluded(){
		return caseIncluded;
	}
	
	public String getNeckMaterial(){
		return neckMaterial;
	}
	
	public void setCaseIncluded(String caseIncluded){
		this.caseIncluded = caseIncluded;
	}
	
	public void setNeckMaterial(String neckMaterial){
		this.neckMaterial = neckMaterial;
	}

}
