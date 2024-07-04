package com.board.vo.util;

import lombok.ToString;

@ToString
public class Criteria {

	private int page;

	private int amount;

	private int rowStart;

	private int rowEnd;

	public Criteria() {
		this.page = 1;
		this.amount = 10;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		if (page < 0) {
			page = 1;
		}

		this.page = page;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		if (amount <= 0 || amount > 10) {
			amount = 10;
		}

		this.amount = amount;
	}

	public int getRowStart() {
		return (this.page - 1) * this.amount + 1;
	}

	public void setRowStart(int rowStart) {
		this.rowStart = rowStart;
	}

	public int getRowEnd() {
		return this.rowStart + this.amount - 1;
	}

	public void setRowEnd(int rowEnd) {
		this.rowEnd = rowEnd;
	}

}
