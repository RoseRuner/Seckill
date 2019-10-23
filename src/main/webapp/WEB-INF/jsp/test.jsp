<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<%-- 引入jstl--%>
<%@include file="common/tag.jsp"%>

<!DOCTYPE html>
<html>
<head>
<%@include file="common/head.jsp"%>
<title>表格</title>

</head>

<body>
	<div class="panel-group">
		<div class="panel panel-primary">
			<div class="panel-heading">列表</div>
			<div class="panel-body">
				<div class="list-op" id="list_op">
					<button type="button" class="btn btn-default btn-sm">
						<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>新增
					</button>
					<button type="button" class="btn btn-default btn-sm">
						<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>修改
					</button>
					<button type="button" class="btn btn-default btn-sm">
						<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>删除
					</button>
				</div>
			</div>
			<table class="table table-bordered table-hover">
				<thead>
					<tr class="success">
						<th>类别编号</th>
						<th>类别名称</th>
						<th>类别组</th>
						<th>状态</th>
						<th>说明</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>C00001</td>
						<td>机车</td>
						<td>机车</td>
						<td>有效</td>
						<td>机车头</td>
					</tr>
					<tr>
						<td>C00002</td>
						<td>车厢</td>
						<td>机车</td>
						<td>有效</td>
						<td>载客车厢</td>
					</tr>
				</tbody>
			</table>
			<div class="panel-footer">
				<nav>
					<ul class="pagination pagination-sm">
						<li class="disabled"><a href="#" aria-label="Previous"> <span
								aria-hidden="true">«</span>
						</a></li>
						<li class="active"><a href="#">1</a></li>
						<li><a href="#">2</a></li>
						<li><a href="#">3</a></li>
						<li><a href="#">4</a></li>
						<li><a href="#">5</a></li>
						<li><a href="#" aria-label="Next"> <span
								aria-hidden="true">»</span>
						</a></li>
					</ul>
				</nav>
			</div>
			<!-- end of panel-footer -->
		</div>
		<!-- end of panel -->
	</div>
	<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
	<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script>
		$(function() {
			function initTableCheckbox() {
				var $thr = $('table thead tr');
				var $checkAllTh = $('<th><input type="checkbox" id="checkAll" name="checkAll" /></th>');
				/*将全选/反选复选框添加到表头最前，即增加一列*/
				$thr.prepend($checkAllTh);
				/*“全选/反选”复选框*/
				var $checkAll = $thr.find('input');
				$checkAll
						.click(function(event) {
							/*将所有行的选中状态设成全选框的选中状态*/
							$tbr.find('input').prop('checked',
									$(this).prop('checked'));
							/*并调整所有选中行的CSS样式*/
							if ($(this).prop('checked')) {
								$tbr.find('input').parent().parent().addClass(
										'warning');
							} else {
								$tbr.find('input').parent().parent()
										.removeClass('warning');
							}
							/*阻止向上冒泡，以防再次触发点击操作*/
							event.stopPropagation();
						});
				/*点击全选框所在单元格时也触发全选框的点击操作*/
				$checkAllTh.click(function() {
					$(this).find('input').click();
				});
				var $tbr = $('table tbody tr');
				var $checkItemTd = $('<td><input type="checkbox" name="checkItem" /></td>');
				/*每一行都在最前面插入一个选中复选框的单元格*/
				$tbr.prepend($checkItemTd);
				/*点击每一行的选中复选框时*/
				$tbr
						.find('input')
						.click(
								function(event) {
									/*调整选中行的CSS样式*/
									$(this).parent().parent().toggleClass(
											'warning');
									/*如果已经被选中行的行数等于表格的数据行数，将全选框设为选中状态，否则设为未选中状态*/
									$checkAll
											.prop(
													'checked',
													$tbr.find('input:checked').length == $tbr.length ? true
															: false);
									/*阻止向上冒泡，以防再次触发点击操作*/
									event.stopPropagation();
								});
				/*点击每一行时也触发该行的选中操作*/
				$tbr.click(function() {
					$(this).find('input').click();
				});
			}
			initTableCheckbox();
		});
		/* 获取第二列的数据并相加*/
		var allCost = 0;
		$('#selTd tr td input:checked').parent().parent().each(function() {
			//如果是小数点的，则可以通过parseFloat
			allCost = allCost + parseFloat($(this).find("td").eq(2).text())
		});
	</script>
</body>
</html>