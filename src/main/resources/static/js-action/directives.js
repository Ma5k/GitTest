actionApp.directive('datePicker',function(){//1定义一个指令名为datePicker
    return {
        restrict: 'AC',//2限制为属性指令和样式指令
        link:function(scope,elem,attrs){//3使用link方法来定义指令，在link方法内可使用当前scope、当前元素及元素属性。
           // scope.treeObj = $.fn.zTree.init(elem, scope.settings);

            elem.datepicker();//4初始化jqueryui的datePicker(jquery的写法是$(‘#id’).datePicker()).
        }
    };
});