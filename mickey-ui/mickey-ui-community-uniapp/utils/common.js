 /**
 * 校验当前社区信息
 */
const checkCommunity = (toastObject, isIndex, hasCommunity, currentOwner) => {
    if (!hasCommunity) {
        toastObject.show({
            message: isIndex? '请先选择社区' : '请先在首页选择社区',// 显示文本
            type: 'warning'
        });
        return false;
    }
    // 当前业主
    //console.log(JSON.parse(currentOwner));
    if (currentOwner && !currentOwner.authenticated) {
        toastObject.show({
            message: '请先实名认证,再进行操作',// 显示文本
            type: 'warning'
        });
        return false;
    }
    return true;
};


export default {
    checkCommunity
}
	
