/**
 * レシピ詳細
 */
$(document).ready(function() {
	$('#delete_btn').click(function(){
		if (!confirm("削除しますか？")) {
			return false;
		}
	});
});