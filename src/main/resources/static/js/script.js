function checkFrm() {
	const frm = document.inoutFrm;
	
	if(frm.product_code.value == "") {
		alert("제품코드가 입력되지 않았습니다!");
		frm.product_code.focus();
		return;
	}
	if(frm.t_count.value == "") {
		alert("수량이 입력되지 않았습니다!");
		frm.t_count.focus();
		return;
	}
	if(frm.t_date.value == "") {
		alert("거래일자가 입력되지 않았습니다!");
		frm.t_date.focus();
		return;
	}
	if(frm.company_code.value == "") {
		alert("거래처를 선택하세요!");
		frm.company_code.focus();
		return;
	}
	alert("입출고등록이 정상적으로 등록되었습니다!");
	frm.submit();
}