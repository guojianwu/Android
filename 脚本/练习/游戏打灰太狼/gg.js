/**
 * Created by Administrator on 2016/12/16.
 */
var start=document.getElementsByClassName("start")[0];
var pros=document.getElementsByClassName("pro")[0];
var over=document.getElementsByClassName("over")[0];
var restart=document.getElementsByClassName("restart")[0];
var rules=document.getElementsByClassName("rules")[0];
var rule=document.getElementsByClassName("rule")[0];


start.onclick=function()
{
    //开始按钮消除
    this.remove();
   // this.style.display="none";
    //进度条
    var proLeft=0;
    var time_pro=setInterval(function(){
        proLeft-=0.045;
        pros.style.backgroundPositionX=proLeft+"px";

        if(proLeft<=-270){
            clearInterval(time_pro);

            over.style.display="block";
            restart.style.display="block";
        }

    },5);





}

rules.onclick=function(){
    rule.style.display="block";
}