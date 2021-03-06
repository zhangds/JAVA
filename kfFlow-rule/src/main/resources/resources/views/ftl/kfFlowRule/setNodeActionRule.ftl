<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="renderer" content="webkit|ie-comp|ie-stand">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
	<meta http-equiv="Cache-Control" content="no-siteapp" />
	<link rel="Bookmark" href="${mvcPath}/resources/images/favicon.ico" />
	<link rel="Shortcut Icon" href="${mvcPath}/resources/images/favicon.ico" />
	<link rel="stylesheet" type="text/css" href="${mvcPath}/resources/kfFlowResources/css/flowPublic.css"/>
    <link rel="stylesheet" type="text/css" href="${mvcPath}/resources/kfFlowRule/css/setNodeActionRule.css"/>
	<title>行为设置</title>
</head>

<body>
    <div class="setNodeActionRule wrap">
    	<div class="row" style="margin-top: 0px;">
    		<div class="spanTitle" style="text-align:left;width: 100%;padding-right:0px;background-color: #00B7FF;color: #FFF;text-indent: 2em;font-size: 14px;">
				行为设置
			</div>
    	</div>
	    <div class="row">
	    	<div class="spanTitle" style="text-align:right;margin-right:10px;width: 15%;">
				行为类型
			</div>
			<div class="spanEle" style="width: 40%;">
				<#if selectEle??>
					<#list selectEle?keys as key>
						<label>
							<input type="radio" name="actionType" value="${key}">
								<span>${selectEle[key]!''}</span>
						</label>
					</#list>
				</#if>
			</div>
	    </div>
	    <div class="row" style="height: 105px;">
	    	<div class="spanTitle" style="text-align: right;margin-right:10px;width: 15%;">
	    		表达式
	    	</div>
	    	<div class="spanEle" style="width: 80%;">
				<textarea id="paramKey" name="paramKey"></textarea>
			</div>
	    </div>
	    <div class="row" style="height: 105px;">
	    	<div class="spanTitle" style="text-align: right;margin-right:10px;width: 15%;">
	    		顺序
	    	</div>
	    	<div class="spanEle" style="width: 80%;">
				<input type="text" id="orderNu" name="orderNu" style="width: 90%;">
			</div>
	    </div>
	    <div class="row">
	    	<div class="spanTitle" style="width: 100%;overflow: unset;padding-right: 0px;">
				<div class="searh"><div class="buttonCls saveBtn" >保存</div></div>
			</div>
	    </div>
	</div>
</body>

<script type="text/javascript">
    var setAction = {
        staffno: "${staffno!''}",
        flowId: "${flowId!''}",
        nodeId: "${nodeId!''}",
        lineId: "${lineId!''}",
        ruleId: "${ruleId!''}",
        ruleType: "${ruleType!''}",
        opType: "${opType!''}",
        paramTypes : {<#if selectEle??><#list selectEle?keys as key>'${key}':"${selectEle[key]!''}",</#list></#if>},
        node : ${currentNode!"{}"}
    };
</script>
	<script type="text/javascript" src="${mvcPath}/webjarslocator/jquery/jquery.min.js"></script>
	<script type="text/javascript" src="${mvcPath}/resources/kfFlowResources/layer/2.4/layer.js"></script>
	<script type="text/javascript" src="${mvcPath}/resources/kfFlowResources/laypage/laypage.js"></script>
	<script type="text/javascript" src="${mvcPath}/resources/kfFlowResources/js/template.js"></script>
	<script type="text/javascript" src="${mvcPath}/resources/kfFlowResources/js/work.js"></script>
	<script type="text/javascript" src="${mvcPath}/resources/kfFlowRule/js/setNodeActionRule.js"></script>
</html>