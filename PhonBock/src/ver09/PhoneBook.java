package ver09;

public class PhoneBook {
	private PhoneInfo[] storage = new PhoneInfo[10];
	private int index = 0;
	
	// 입력된 정보
	public void addInfo(PhoneInfo info) throws ArrayIndexOutOfBoundsException {
		storage[index] = info;
		index++;
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
		} // for
		return false;
	} // isNameDup
	
	// 입력된 이름 존재 여부 확인
	public PhoneInfo isExist(String name) {
		for(int i = 0; i < index; i++) {
			PhoneInfo info = storage[i];
			String saveName = info.getName();
			if(name.equals(saveName)) {
				return info;
			}
		} // for
		return null;
	} // isExist
	
	// 정보 수정
	public void modify(PhoneInfo info) {
		for(int i = 0; i < index; i++) {
			if (storage[i].getName().equals(info.getName())) {
				storage[i] = info;
			}
		}
	}
	
	
	// 입력된 정보 삭제
	public void delete() {
		
	}
	
}