package cuoiki;

public class hinhvuong extends hinh{
	private double dodaicanh, dientich;

	public double getDodaicanh() {
		return dodaicanh;
	}

	public void setDodaicanh(double dodaicanh) {
		this.dodaicanh = dodaicanh;
	}

	public double getDientich() {
		return dientich;
	}

	public void setDientich(double dodaicanh) {
		dientich = dodaicanh*dodaicanh;
	}

	@Override
	public String toString() {
		return "hinhvuong [ten = " + getTen()+", Mausac = " + getMausac() +
				", dodaicanh =" + getDodaicanh() + ", Dientich = " + getDientich() +  "]";
	}

	
}
