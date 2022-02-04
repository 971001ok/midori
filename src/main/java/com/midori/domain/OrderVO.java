package com.midori.domain;

import lombok.Data;

@Data 
public class OrderVO {

	private int odseq;
	private int oseq;
	private String id;
	private String indate;
	private String mname;
	private String zipNum;
	private String address1;
	private String address2;
	private String phone;
	private int pseq;
	private String pname;
	private int quantity;
	private int price1;
	private int price2;
	private int price3;
	private int status;
	
	
}
