package member.view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import member.model.vo.Member;

public class MemberView {
	// 에러 처리용 뷰
	public void error(String msg) {
		switch(msg) {
		case "insert" : System.out.println("멤버 정보 삽입 실패!"); break;
		case "selectAll" : System.out.println("전체 회원 조회 실패!"); break;
		case "selectId" : System.out.println("아이디로 회원 조회 실패!"); break;
		case "updateEmail" : System.out.println("이메일 업데이트 실패!"); break;
		case "updatePhone" : System.out.println("번호 업데이트 실패!"); break;
		case "updateAddress" : System.out.println("주소 변경 실패!"); break;
		case "deleteMember" : System.out.println("멤버 삭제 실패!"); break;
		default: System.out.println("알 수 없는 오류가 발생했습니다."); break;
		}
	}
	
	// 전체 회원 출력용 뷰
	public void displayAll(ArrayList<Member> mList) {
		for(Member m : mList) {
			System.out.println(m);
		}
	}
	
	public void displayAll(HashMap<String, Member> mList) {
		if(mList.isEmpty()) {
			System.out.println("해당하는 회원이 없습니다.");
		}else {
			Iterator<String> iter = mList.keySet().iterator();
			while(iter.hasNext()) {
				System.out.println(mList.get(iter.next()));
			}
		}
	}
	
	// 한명 회원 출력용 뷰
	public void displayOne(ArrayList<Member> mList, String mId) {
		for(Member m : mList) {
			if(m.getMember_id() == mId) {
				System.out.println(m);
				break;
			}
		}
	}
}
