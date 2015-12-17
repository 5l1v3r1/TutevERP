package org.tutev.web.erp.entity.genel;

public enum KodluListeTip {

	  PARA_BIRIM(101, "Para Birimi")
	, OLCU_BIRIMI(102, "Ölçü Birimi")
	, UYRUK(103, "Uyruğu")
	, URETIM_TIP(109, "Üretim Tipi")
	, IRSALIYE_TIP(110, "İrsaliye Tipi")
	, YERLESIM_TIP(111, "Yerleşim Tip")
	, DEPO_TURU(112, "Depo Türü")
	;

	private KodluListeTip(int no, String label) {
		this.no = no;
		this.label = label;
	}

	int no;
	String label;

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

}
