window.onload = function () {
//


    var selectedTotal = document.getElementById('selectedTotal'); //已选商品数目容器
    var priceTotal = document.getElementById('priceTotal'); //总计
    //总计
    function getTotal()
    {
        var seleted = 0;
        var price = 0;
       for(var i= 0,len=tr.length;i<len;i++){
           if(tr[i].getElementsByTagName("input")[0].checked)
           {
               seleted +=parseInt(tr[i].getElementsByTagName("input")[1].value);
               price += parseFloat(tr[i].getElementsByClassName("subtotal")[0].innerHTML);
           }
       }
        selectedTotal.innerHTML = seleted;
        //保留两位小数
        priceTotal.innerHTML = price.toFixed(2);
    }

    // 单行总价
    function getSubtotal(tr)
    {
        var price =tr.getElementsByClassName("price")[0];
        var subtotal=tr.getElementsByClassName("subtotal")[0];
        var countInput = tr.getElementsByTagName('input')[1]; //数目input
        var span = tr.getElementsByTagName('span')[1]; //-号
        //写入HTML
        //将数量与单价乘积   并保留两位小数
        subtotal.innerHTML = (parseInt(countInput.value) * parseFloat(price.innerHTML)).toFixed(2);
        //如果数目只有一个，把-号去掉
        if (countInput.value == 1) {
            span.innerHTML = '';
        }else{
            span.innerHTML = '-';
        }
    }



//点击选择框
    var selectInputs = document.getElementsByClassName('check'); // 所有勾选框
    var checkAllInputs = document.getElementsByClassName('check-all check') // 全选框

    for(var i=0;i< selectInputs.length;i++)
    {
        selectInputs[i].onclick=function(){
            //if(this.className.indexOf("check-all") >=0)
            if(this.className=="check-all check")
            {
                for (var j = 0; j < selectInputs.length; j++) {
                    selectInputs[j].checked = this.checked;
                }
            }
            if(!this.checked){
                for (var i = 0; i < checkAllInputs.length; i++) {
                    checkAllInputs[i].checked = false;
                }
            }
            getTotal();
        }

    }



///为每行元素添加事件
    var table = document.getElementById('cartTable'); // 购物车表格
   // var tr = table.children[1].rows; //行

    //var tr = table.children[0].rows;

    //指的是tbody下面的tr
    var tr=table.children[1].rows;

   // 如果是下面的列
   //  td=table.children[1].rows.cell

   // var tr =document.getElementsByTagName("tr");

    for(var i=0;i<tr.length;i++){
        //将点击事件绑定到tr元素
         tr[i].onclick= function (e) {
             var e=e || window.event;
             var el = e.target || e.srcElement;
             //通过事件对象的target获取触发元素
             var cls =el.className;  //获取触发元素的classname
             var countInout =this.getElementsByTagName("input")[1];//数目input
             var value=parseInt(countInout.value);// 数目
             //通过判读触发元素的class确定用户点击了哪个元素
             switch(cls){
                 case 'add'://点击了加号
                     countInout.value=value+1;
                     //单行数据总价也跟着变
                     getSubtotal(this);
                 break;
                 case 'reduce'://点击了减号
                     if(value >1)
                     {
                         countInout.value=value-1;
                         // //单行数据总价也跟着变
                         //getSubtotal(this);
                     }
                     break;
                 case 'delete'://点击了删除
                     var conf=confirm("确定删除此商品吗？");
                     if(conf){
                         this.parentNode.removeChild(this);
                     }
                     break;
             }
             //更新总价
             getTotal();
         }

        // 给数目输入框绑定keyup事件
        tr[i].getElementsByTagName("input")[1].onkeyup=function()
        {
            var val =parseInt(this.value);
            if(isNaN(val) || val <=0)
            {
                val=1;
            }
            if(this.value !=val)
            {
                this.value=val;
            }
            getSubtotal(this.parentNode.parentNode); //更新小计
            getTotal(); //更新总数
        }

    }

    //点击全部删除
    // 点击全部删除

    var deleteAll = document.getElementById('deleteAll'); // 删除全部按钮
    deleteAll.onclick = function () {
        if (selectedTotal.innerHTML != 0) {
            var con = confirm('确定删除所选商品吗？'); //弹出确认框
            if (con) {
                for (var i = 0; i < tr.length; i++) {
                    // 如果被选中，就删除相应的行
                    if (tr[i].getElementsByTagName('input')[0].checked) {
                        tr[i].parentNode.removeChild(tr[i]); // 删除相应节点
                        i--; //回退下标位置
                    }
                }
            }
        } else {
            alert('请选择商品！');
        }
        getTotal(); //更新总数
    }





}