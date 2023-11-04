//package main.java.model.product;
package model.product;

public class CategoryDO {

		private int categoryNum;
		private String categoryName;
		private String categoryImg;
		
		CategoryDO(){
			
		}

		public int getCategoryNum() {
			return categoryNum;
		}

		public void setCategoryNum(int categoryNum) {
			this.categoryNum = categoryNum;
		}

		public String getCategoryImg() {
			return categoryImg;
		}

		public void setCategoryImg(String categoryImg) {
			this.categoryImg = categoryImg;
		}

		public String getCategoryName() {
			return categoryName;
		}

		public void setCategoryName(String categoryName) {
			this.categoryName = categoryName;
		}
		
		
}
