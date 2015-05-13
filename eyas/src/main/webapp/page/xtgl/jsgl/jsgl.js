$(function() {
  /**
   * 页面合法访问限制方法。
   */
  if (top.location == location) {
    alert("请合法访问页面，谢谢！");
    window.location.replace('/' + YMLib.projectName + '/index.jsp');
    return;
  }

});
/**
 * 跳转待审批任务
 */
function loactionDsprw() {
  window.location=('dsprw/dsprw.jsp');
}
/**
 * 跳转进行中任务
 */
function loactionJxzrw() {
  window.location=('jxzrw/jxzrw.jsp');
}
/**
 * 跳转已完结任务
 */
function loactionYwjrw() {
  window.location=('ywjrw/ywjrw.jsp');
}