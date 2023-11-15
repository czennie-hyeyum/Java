package guessnum2;

public class RowNumDto {
	private Integer startRow = 1;
	private Integer endRow = 10;
	private boolean isPrev = false;
	private boolean isNext = false;
	
	public boolean isPrev() {
		return isPrev;
	}

	public void setPrev(boolean isPrev) {
		this.isPrev = isPrev;
	}

	public boolean isNext() {
		return isNext;
	}

	public void setNext(boolean isNext) {
		this.isNext = isNext;
	}

	public RowNumDto() {
		super();
	}

	public RowNumDto(Integer startRow, Integer endRow) {
		super();
		this.startRow = startRow;
		this.endRow = endRow;
	}

	public Integer getStartRow() {
		return startRow;
	}

	public void setStartRow(Integer startRow) {
		this.startRow = startRow;
	}

	public Integer getEndRow() {
		return endRow;
	}

	public void setEndRow(Integer endRow) {
		this.endRow = endRow;
	}
	
	public void setStartEndRow(int page) {
		this.endRow = page * 10;
		this.startRow = this.endRow - 9;
	}
	
	
	@Override
	public String toString() {
		return "RowNumDto [startRow=" + startRow + ", endRow=" + endRow + "]";
	}
	
}
