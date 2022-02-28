package cuoiki;

import java.util.ArrayList;
import java.util.List;

public class danhsach {
	private ArrayList<hinhvuong> ds;
	public danhsach() {
		this.ds =new ArrayList<hinhvuong>();
	}
	public void setDs(ArrayList<hinhvuong> ds) {
		this.ds = ds;
	}
	public void add(hinhvuong hv) {
		ds.add(hv);
	}
	public void xoa(String ten) {
		for (int i = 0; i < ds.size(); i++) {
			String a = ds.get(i).getTen();
			if (ten.equals(a)) {
				ds.remove(i);
			}
		}
	}
	public hinhvuong get (int i) {
		return this.ds.get(i);
	}
	public int size() {
		return ds.size();
	}
}
