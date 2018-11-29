//1定义控制器View1Controller,并注入$rootScope、$scope和$http。
actionApp.controller('View1Controller', [ '$rootScope', '$scope', '$http',
		function($rootScope, $scope, $http) {
			// 2使用$scope.$on监听$viewContentLoaded事件，可以在页面内容加载完成后进行一些操作。
			$scope.$on('$viewContentLoaded', function() {
				console.log('页面加载完成');
			});
			// 3
			$scope.search = function() {// 3.1在scope内定义一个方法search,在页面上通过ng-click调用
				personName = $scope.personName;// 3.2获取页面定义的ng-model="personName"的值
				$http.get('search', {// 3.3使用$http.get向服务端地址search发送get请求。
					params : {
						personName : personName
					}
				// 3.4使用params增加请求参数
				}).success(function(data) {// 3.5用success方法作为请求成功后的回调
					$scope.person = data;// 3.6将服务端返回的数据data通过$scope.person赋给模型person
				});
				;

			};
		} ]);

actionApp.controller('View2Controller', [ '$rootScope', '$scope',
		function($rootScope, $scope) {
			$scope.$on('$viewContentLoaded', function() {
				console.log('页面加载完成');
			});
		} ]);