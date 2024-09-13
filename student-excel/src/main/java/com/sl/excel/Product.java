package com.sl.excel;

public class Product {

//	select id,barcode, name, category_id, price, type, print_production, price, 
//	ncm, cfop, tax4_code, tax1_code, tax1, tax2_code, tax2, tax3_code, tax3 from product where internal_code = 100;

	String internal_code;
	String name;
	String ncm;
	String cfop;
	String tax4_code;
	String tax1_code;
	String tax1;
	String tax2_code;
	String tax2;
	String tax3_code;
	String tax3;

	public Product() {
	}

	public Product(String internal_code, String name, String ncm, String cfop, String tax4_code, String tax1_code,
			String tax1, String tax2_code, String tax2, String tax3_code, String tax3) {
		super();
		this.internal_code = internal_code;
		this.name = name;
		this.ncm = ncm;
		this.cfop = cfop;
		this.tax4_code = tax4_code;
		this.tax1_code = tax1_code;
		this.tax1 = tax1;
		this.tax2_code = tax2_code;
		this.tax2 = tax2;
		this.tax3_code = tax3_code;
		this.tax3 = tax3;
	}

	public String toStringDDL() {
		return String.format("UPDATE db000.product SET %s='%s',%s='%s',%s='%s',%s='%s',%s='%s',%s='%s',%s='%s',%s='%s', WHERE internal_code=%s;", 
				"ncm",ncm,
				"cfop", cfop,
				"tax4_code", tax4_code,
				"tax1_code", tax1_code,
				"tax1", tax1,
				"tax2_code", tax2_code,
				"tax3_code", tax3_code,
				"tax3", tax3,
				internal_code);

	}

	@Override
	public String toString() {
		return "Product [internal_code=" + internal_code + ", name=" + name + ", ncm=" + ncm + ", cfop=" + cfop
				+ ", tax4_code=" + tax4_code + ", tax1_code=" + tax1_code + ", tax1=" + tax1 + ", tax2_code="
				+ tax2_code + ", tax2=" + tax2 + ", tax3_code=" + tax3_code + ", tax3=" + tax3 + "]";
	}
	
}
