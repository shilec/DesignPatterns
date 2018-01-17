package com.shilec.createpatterns;

import com.shilec.createpatterns.Operanner3.Builder;

public class BuilderPatters {
	
	public static void main(String[] args) {
		new Builder()
		.setContent("123")
		.build()
		.oper("");
		
		new Builder()
		.setContent("456")
		.build()
		.oper("");
	}
}

class Operanner3 extends Operanner1 {
	
	private Builder builder;
	public void oper(Object obj) {
		System.out.println("oper3 content = " + builder.content);
	}
	
	static class Builder {
		private String content;
		public Builder setContent(String content) {
			this.content = content;
			return this;
		}
		
		public ICommonOper build() {
			Operanner3 oper3  = new Operanner3();
			oper3.builder = this;
			return oper3;
		}
	}
}