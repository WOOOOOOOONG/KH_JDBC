package member.controller;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;

import common.JDBCTemplate;
import member.model.service.MemberService;
import member.model.vo.Member;
import member.view.MemberMenu;
import member.view.MemberView;

public class MemberController {
	MemberView mv = new MemberView();
	
	public void insertMember(Member inputMember) {
		MemberService ms = new MemberService();
		int result = ms.memberInsert(inputMember);
		
		if(result > 0) {
			System.out.println("도서 정보 입력 완료");
		}else {
			mv.error("insert");
		}
	}
	
	public void selectAll() {
		MemberService ms = new MemberService();
		ArrayList<Member> result = ms.seletAll();
		
		if(result.isEmpty()) {
			mv.error("selectAll");
		}else {
			mv.displayAll(result);
		}
	}
	
	public void selectMember(String mID) {
		MemberService ms = new MemberService();
		ArrayList<Member> result = ms.SelectId(mID);
		
		if(result.isEmpty()) {
			mv.error("selectID");
		}else {
			mv.displayAll(result);
		}
	}

	// 성별별로 조회 요청 처리용
	public void selectGender(String inputGender) {
		MemberService mService = new MemberService();
		HashMap<String, Member> hmap = mService.selectGender(inputGender);
		
		mv.displayAll(hmap);
	}

	// 비밀번호 업데이트
	public void updatePassword(String inputMemberId, String inputPassword) {
		MemberService mService = new MemberService();
		int result = mService.updatePassword(inputMemberId, inputPassword);
		
		if(result <= 0) {
			mv.error("updatePassword");
		}else {
			System.out.println("비밀번호가 업데이트되었습니다.");
		}
	}

	public void updateEmail(String inputMemberId, String inputEmail) {
		MemberService ms = new MemberService();
		int result = ms.updateEmail(inputMemberId, inputEmail);
		
		if(result <= 0) {
			mv.error("updateEmail");
		}else {
			System.out.println("이메일이 업데이트되었습니다.");
		}
		
	}

	public void updatePhone(String inputMemberId, String inputPhone) {
		MemberService ms = new MemberService();
		int result = ms.updatePhone(inputMemberId, inputPhone);
		
		if(result <= 0) {
			mv.error("updatePhone");
		}else {
			System.out.println("전화번호가 업데이트되었습니다.");
		}
		
	}

	public void updateAddress(String inputMemberId, String inputAddress) {
		MemberService ms = new MemberService();
		int result = ms.updateAddress(inputMemberId, inputAddress);
		
		if(result <= 0) {
			mv.error("updateAddress");
		}else {
			System.out.println("주소가 업데이트되었습니다.");
		}
	}

	public void deleteMember(String inputMemberId) {
		MemberService ms = new MemberService();
		int result = ms.deleteMember(inputMemberId);
		
		if(result <= 0) {
			mv.error("deleteMember");
		}else {
			System.out.println("멤버를 삭제했습니다.");
		}
	}
}


