package ver10;

public class PhoneBook {
	private PhoneInfo[] storage = new PhoneInfo[10];
	private int index = 0;
	
	// 저장 용량이 꽉 찼을 때
	public void addInfo(PhoneInfo info) throws ArrayIndexOutOfBoundsException {
		storage[index] = info;
		index++;
	}
	
	// 용량이 부족하면 2배로 늘리기
	public void expansionInfo(PhoneInfo info) {
		PhoneInfo[] newStorage = new PhoneInfo[20];
		storage = newStorage;
	}
	
	// 전체 보여주기
	public void showAll() {
		for (int i = 0; i < index; i++) {
			if (storage[i] instanceof PhoneInfoSchool) {
				PhoneInfoSchool infoSchool = (PhoneInfoSchool)storage[i];
				infoSchool.showInfoSchool();
			} else if (storage[i] instanceof PhoneInfoCompany) {
				PhoneInfoCompany infoCompany = (PhoneInfoCompany)storage[i];
				infoCompany.showInfoCompany();
			}
		}
	}
	
	// 이름으로 검색하기
	public void searchByName(String searchName) {
		for(int i = 0; i < index; i++) {
			PhoneInfo info = storage[i];
			String name = info.getName();
			if(searchName.equals(name)) {
				if(info instanceof PhoneInfoSchool) {
					PhoneInfoSchool pis = (PhoneInfoSchool)info;
					pis.showInfoSchool();
				} else if(info instanceof PhoneInfoCompany) {
					PhoneInfoCompany pic = (PhoneInfoCompany)info;
					pic.showInfoCompany();
				}
				return;
			}
		}
		
		System.out.println(searchName + "을(를) 찾지 못하였습니다.");
		
	}
	
	// 이름 중복 확인
	public boolean isNameDup(String searchName) {
		for(int i = 0; i < index; i++) {
			PhoneInfo info = storage[i];
			String name = info.getName();
			if(name.equals(searchName)) {
				return true;
			}
		}
		return false;
	}
	
	// 입력된 이름 존재 여부 확인
	public PhoneInfo isExist(String name) {
		for(int i = 0; i < index; i++) {
			PhoneInfo info = storage[i];
			String saveName = info.getName();
			if(name.equals(saveName)) {
				return info;
			}
		} 
		return null;
	}
	
	// 입력된 이름 정보 수정
	public void modify(PhoneInfo info) {
		for(int i = 0; i < index; i++) {
			if (storage[i].getName().equals(info.getName())) {
				storage[i] = info;
			}
		}
	}
	
	// 입력된 이름 정보 삭제
	public boolean delete(String name) {
		for(int i = 0; i < index; i++) {
			String savedName = storage[i].getName();
			if(name.equals(savedName)) {
				storage[i] = null;
				for (int j = i; j < index; j++) {
					storage[j] = storage[j+1]; 
				}
				storage[index-1] = null;
				index--;
				return true;
			}
		}
		return false;
	}
	
}