package proj3;

public class BHTree{
	public double Theta = 1.5;
	
	private Body body;
	private Quad quad;
	private BHTree NW;
	private BHTree NE;
	private BHTree SW;
	private BHTree SE;
	
	public BHTree(Quad q) {
		this.quad = q;
		this.body = null;
		this.NW = null;
		this.NE = null;
		this.SW = null;
		this.SE = null;
	}
	
	public boolean isExternal(BHTree Tree) {
		if(NE == null && NW == null && SE == null && SW == null) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void insert(Body z) {
		if(this.body == null) {
			this.body = z;
			return;
		}
		
		else if (!isExternal(this)){
			this.body = this.body.plus(z); 
			
			if (z.in(quad.NW()) == true) {
				NW.insert(z);
			}
			else if (z.in(quad.NE()) == true) {
				NE.insert(z);
			}
			else if (z.in(quad.SW()) == true) {
			
				SW.insert(z);
			}
			else {
				SE.insert(z);
			}
		}

		else {
			NW = new BHTree(quad.NW());
			NE = new BHTree(quad.NE());
			SW = new BHTree(quad.SW());
			SE = new BHTree(quad.SE());
			
			toBody(this.body);
			this.insert(z);
		}
		
	}
	
	public void updateForce(Body z) {
		if(body == null || z.equals(body)) {
			return;
		}
		if(isExternal(this)) {
			z.addForce(body);
		}
		else {
			double q = quad.length();
			double b = body.distanceTo(z);
		if((q / b) < Theta) {
			z.addForce(body);
		}
		else {
			NW.updateForce(z);
			NE.updateForce(z);
			SW.updateForce(z);
			SE.updateForce(z);
		}
	}
}
	
	private void toBody(Body z) {
		if(z.in(quad.NW())) {
			NW.insert(z);
		}
		else if(z.in(quad.NE())) {
			NE.insert(z);
		}
		else if(z.in(quad.SE())) {
			SE.insert(z);
		}
		else if(z.in(quad.SW())) {
			SW.insert(z);
		}
	}
	
	public String toString() {
		if(isExternal(this)) {
			return " " + body + "\n";
		}
		else {
			return "*" + body + "\n" + NW + NE + SW+ SE;
		}
	}
}
		