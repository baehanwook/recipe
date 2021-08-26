/**
 * レシピ詳細
 */
$(document).ready(function() {
	$('#update_btn').click(function(){
		if (!valCheck($('#name').val())) {
			alert("英語名を選択してください");
			return false;
		}
		
		if (!valCheck($('#nameJp').val())) {
			alert("日本語名を選択してください");
			return false;
		}
		
		if (!confirm("修正しますか？")) {
			return false;
		}
	});
});