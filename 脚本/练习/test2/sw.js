/**
 * Created by Administrator on 2016/11/7.
 */
// var week="星期一";
function showif(){
    // var week=document.mys.src.value ;
    var week=document.mys.stc.value
    switch (week)
    {
        case "星期一":
            alert("新的一周才刚刚开始，努力工作哦！")
            break;
        case "星期五":
            alert("明天就可以休息了！");
            break;
        case "星期六":
        case "星期日":
            alert("可以休息了！")
            break;
        default:
            alert("工作日，要好好工作哦！");
            break;

    }
}