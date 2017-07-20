<template>
	<div id="dialog_form">
                <el-dialog title="提示" :visible.sync="dialogVisible" size="tiny" :modal="false"  :before-close="handleClose">
                    <span>确认支付{{zongMoeny}}元</span>
                 <span slot="footer" class="dialog-footer">
                    <el-button @click="cance">取 消</el-button>
                    <el-button type="primary" @click="cance">
                        <span :plain="true" @click="open6">确 定</span>
                    </el-button>
                </span>
                </el-dialog>
            </div>
</template>
<script>
	export default{

		computed:{
			dialogVisible(){
				return this.$store.state.dialogVisible1;
			},
			zongMoeny(){
				return this.$store.state.zongMoeny;
			}
		},
		methods:{
			handleClose(){
				this.$store.state.dialogVisible1=false;
			},
			 cance(){
				 this.$store.state.dialogVisible1=false;
			 },
			 open6() {
                var _this=this;
                this.$store.state.disform=0;
                this.$message({
                	
                    showClose: true,
                    message: '恭喜你，支付成功',
                    type: 'success',
                    onClose(){
                    	_this.$store.state.tijiao=false;
		                _this.$store.state.num=0;
		                _this.$store.state.jiesuan='15元起送';
		             	_this.$store.state.disform=1;
                        _this.$store.state.zongJia=0;
                         _this.$store.state.zongJia=0;
                         _this.$store.state.zongMoeny=0;
                        _this.initMaiCount( _this.$store.state.foodData.rexiao[0].list);
                        _this.initMaiCount( _this.$store.state.foodData.banjia[0].list);
                        _this.initMaiCount( _this.$store.state.foodData.fushi[0].list);
                        _this.initMaiCount( _this.$store.state.foodData.xiaochi[0].list);
                        _this.initMaiCount( _this.$store.state.foodData.yinliao[0].list);
                        _this.initMaiCount( _this.$store.state.foodData.zhushi[0].list);
                        _this.initMaiCount( _this.$store.state.foodData.zhekou[0].list);
                         
                        // _this.zhonCount=0;
                        // _this.peiSong='免费配送';
                        // _this.back();

                    }

                });

            },
            initMaiCount(arr){
                arr.forEach(function(value){
                    value.maiCount=0;
                })
            }
		}
		 
	}
</script>