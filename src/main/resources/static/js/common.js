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

