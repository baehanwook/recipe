/**
 * レシピ作成
 */
$(document).ready(function() {
	$('#create_btn').click(function(){
		if (!valCheck($('#categoryId').val)) {
			alert("カテゴリーを選択してください");
			return false;
		}
		
		if (!valCheck($('#smallCategoryId').val)) {
			alert("小カテゴリーを選択してください");
			return false;
		}

		if (!valCheck($('#title').val)) {
			alert("タイトルを入力してください");
			return false;
		}

		if (!valCheck($('#content').val)) {
			alert("レシピ内容を入力してください");
			return false;
		}
		
		if (!confirm("作成しますか？")) {
			return false;
		}
	});

	function valCheck(val) {
		if (val == null) {
			return false;
		}
		
		if (typeof val == 'string' && val == '') {
			return false;
		}
		
		if (typeof val == 'undefined') {
			return false;
		}
		return true;
	}	

});