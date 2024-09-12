package com.sl.excel;

public class Product {

	String codigo;
	String nome;
	String ncm;
	String cfop;
	String cest;
	String cst_csosn;
	String icms_aliq;
	String pis_cod;
	String pis_aliq;
	String cofins_cod;
	String cofins_aliq;

	public Product() {
	}

	public Product(String codigo, String nome, String ncm, String cfop, String cest, String cst_csosn, String icms_aliq,
			String pis_cod, String pis_aliq, String cofins_cod, String cofins_aliq) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.ncm = ncm;
		this.cfop = cfop;
		this.cest = cest;
		this.cst_csosn = cst_csosn;
		this.icms_aliq = icms_aliq;
		this.pis_cod = pis_cod;
		this.pis_aliq = pis_aliq;
		this.cofins_cod = cofins_cod;
		this.cofins_aliq = cofins_aliq;
	}

	@Override
	public String toString() {
//		return "Product [codigo=" + codigo + ", nome=" + nome + ", ncm=" + ncm + ", cfop=" + cfop + ", cest=" + cest
//				+ ", cst_csosn=" + cst_csosn + ", icms_aliq=" + icms_aliq + ", pis_cod=" + pis_cod + ", pis_aliq="
//				+ pis_aliq + ", cofins_cod=" + cofins_cod + ", cofins_aliq=" + cofins_aliq + "]";
		return String.format("UDATE db000.product SET %s=\'%s\',%s=\'%s\',%s=\'%s\',%s=\'%s\',%s=\'%s\',%s=\'%s\',%s=\'%s\',%s=\'%s\',%s=\'%s\' WHERE codigo=%s;",
				"ncm", ncm, "cfop", cfop, "cest", cest, "cst_csosn", cst_csosn, "icms_aliq", icms_aliq, "pis_cod", pis_cod, "pis_aliq", pis_aliq,"cofins_cod", cofins_cod, "cofins_aliq", cofins_aliq, codigo);		

	}
}
