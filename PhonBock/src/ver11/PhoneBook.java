package ver11;

import java.util.Vector;

public class PhoneBook {
	
	private Vector<PhoneInfo> vec = new Vector<>();
	
	/*
	private PhoneInfo[] storage = new PhoneInfo[10];
	private int index = 0;
	*/
	
	// 저장 용량이 꽉 찼을 때
	public void addInfo(PhoneInfo info) throws ArrayIndexOutOfBoundsException {
		vec.add(info);
	}
	
	
	// 전체 보여주기
	public void showAll() {
		for(PhoneInfo info : vec) {
			info.showInfo();
		}
	}
	
	// 이름으로 검색하기
	public void searchByName(String searchName) {
		for(int i = 0; i < vec.size(); i++) {
			PhoneInfo info = vec.get(i);
			String name = info.getName();
			if(searchName.equals(name)) {
				info.showInfo();
				return;
			}
		}
		
		System.out.println(searchName + "을(를) 찾지 못하였습니다.");
		
	}
	
	// 이름 중복 확인
	public boolean isNameDup(String searchName) {
		for(int i = 0; i < vec.size(); i++) {
			PhoneInfo info = vec.get(i);
			String name = info.getName();
			if(name.equals(searchName)) {
				return true;
			}
		}
		return false;
	}
	
	// 입력된 이름 존재 여부 확인
	public PhoneInfo isExist(String name) {
		for(int i = 0; i < vec.size(); i++) {
			PhoneInfo info = vec.get(i);
			if(name.equals(info.getName())) {
				return info;
			}
		} 
		return null;
	}
	
	// 입력된 이름 정보 수정
	public void modify(PhoneInfo info) {
		for(int i = 0; i < vec.size(); i++) {
			PhoneInfo vecInfo = vec.get(i);
			String vecName = vecInfo.getName();
			if (vecName.equals(info.getName())) {
				vecInfo = info;
				vec.remove(i);
				vec.add(vecInfo);
				break;
			}
		}
	}
	
	// 입력된 이름 정보 삭제
	public boolean delete(String name) {
		for(int i = 0; i < vec.size(); i++) {
			PhoneInfo info = vec.get(i);
			if(name.equals(info.getName())) {
				return true;
			}
		}
		return false;
	}
	
}