package guessnum2;

public class RowNumDto {
	private Integer startRow = 1;
	private Integer endRow = 10;
	private Integer rn;
	private boolean isPrev;
	private boolean isNext;
	
	public RowNumDto() {
		super();
	}

	public RowNumDto(Integer startRow, Integer endRow, Integer rn, boolean isPrev, boolean isNext) {
		super();
		this.startRow = startRow;
		this.endRow = endRow;
		this.rn = rn;
		this.isPrev = isPrev;
		this.isNext = isNext;
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
	

	public Integer getRn() {
		return rn;
	}

	public void setRn(Integer rn) {
		this.rn = rn;
	}

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

	@Override
	public String toString() {
		return "RowNumDto [startRow=" + startRow + ", endRow=" + endRow + ", rn=" + rn + ", isPrev=" + isPrev
				+ ", isNext=" + isNext + "]";
	}
	
}
