/**
 * 将数组中的ID拼接成字符串，以逗号隔开
 * @param array
 * @returns
 */
function arrayToIDString(array){
	var result = "";
	if(!array || array.length == 0){
		return result;
	}else{
		for(var i=0; i<array.length; i++){
			result += array[i].id + ",";
		}
		return result.substring(0, result.length - 1);
	}
}
