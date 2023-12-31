package ver14;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Vector;

public class PhoneBook {
	private static PhoneBook instance = new PhoneBook();
	private PhoneBook() { /* singleton */ }
	
	public static PhoneBook getInstance() {
		return instance;
	}
	// --------------------------------------------------
	
	private Vector<PhoneInfo> vec = new Vector<>();
	private static final String SCHOOL_NUM = "1";
	private static final String COMPANY_NUM = "2";
	
	// 정보 추가
	public boolean addInfo(PhoneInfo info) {
		return vec.add(info);
	}
	
	// 모든 정보
	public Vector<PhoneInfo> getAll() {
		return vec;
	}
	
	// 이름 검색
	public PhoneInfo searchByName(String searchName) {
		for (int i = 0; i < vec.size(); i++) {
			PhoneInfo info = vec.get(i);
			String name = info.getName();
			if (searchName.equals(name)) {
				
				return info;
			}
		}
		return null;
	}
	
	// 이름 중복 확인
	public boolean isNameDup(String searchName) {
		for (int i = 0; i < vec.size(); i++) {
			PhoneInfo info = vec.get(i);
			String name = info.getName();
			if (name.equals(searchName)) {
				return true;
			}
		}
		return false;
	}
	
	// 이름 존재 여부
	public PhoneInfo isExist(String name) {
		for (int i = 0; i < vec.size(); i++) {
			PhoneInfo info = vec.get(i);
			String savedName = info.getName();
			if (name.equals(savedName)) {
				return info;
			}
		}
		return null;
	}
	
	// 업데이트
	public boolean modify(PhoneInfo info) {
		for (int i = 0; i < vec.size(); i++) {
			if (vec.get(i).getName().equals(info.getName())) {
				vec.remove(i);
				vec.add(i, info);
				return true;
			}
		}
		return false;
	}
	
	// 삭제
	public boolean delete(String name) {
		for (int i = 0; i < vec.size(); i++) {
			String savedName = vec.get(i).getName();
			if (name.equals(savedName)) {
				vec.remove(i);
				return true;
			}
		}
		return false;
		
	}
	
	// 데이터 불러오기
	public void load(String path) {
		File f = new File(path);
		try {
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			while (true) {
				String data = br.readLine();
				if(data == null) {
					break;
				}
				StringTokenizer tokenizer = new StringTokenizer(data, ",");
				String name = tokenizer.nextToken();
				String phoneNumber = tokenizer.nextToken();
				String birthDay = tokenizer.nextToken();
				String scName = tokenizer.nextToken();
				String scNum = tokenizer.nextToken();
				PhoneInfo info = null;
				if (scNum.equals(SCHOOL_NUM)) {
					info = new PhoneInfoSchool(name, phoneNumber, birthDay, scName);
				} else if (scNum.equals(COMPANY_NUM)) {
					info = new PhoneInfoCompany(name, phoneNumber, birthDay, scName);
				}
				vec.add(info);
			}
			br.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void save(String path) {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(path));
			StringBuffer sb = new StringBuffer();
			for (PhoneInfo info : vec) {
				String name = info.getName();
				String phoneNumber = info.getPhoneNumber();
				String birthDay = info.getBirthDay();
				String scName = null;
				String scNum = null;
				if (info instanceof PhoneInfoSchool) {
					scName = ((PhoneInfoSchool)info).getSchool();
					scNum = SCHOOL_NUM;
				} else if (info instanceof PhoneInfoCompany) {
					scName = ((PhoneInfoCompany)info).getCompany();
					scNum = COMPANY_NUM;
				}
				
				sb.append(name);
				sb.append(",");
				sb.append(phoneNumber);
				sb.append(",");
				sb.append(birthDay);
				sb.append(",");
				sb.append(scName);
				sb.append(",");
				sb.append(scNum);
				sb.append("\n");
			}
			
			bw.write(sb.toString());
			bw.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
} // class