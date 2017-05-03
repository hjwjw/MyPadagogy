var setting = {
            
			view: {
                addHoverDom: addHoverDom,
                removeHoverDom: removeHoverDom,
                selectedMulti: false
            },
            edit: {
                enable: true,
                editNameSelectAll: true,
                showRemoveBtn: showRemoveBtn,
                showRenameBtn: showRenameBtn
            },
            data: {
                simpleData: {
                    enable: true
                }
            },
            callback: {
                
                beforeRemove: beforeRemove,
                beforeRename: beforeRename,
                onRemove: onRemove,
                onRename: onRename
            }
		};

		var zNodes;

        var log, className = "dark";
        
        
        function beforeRemove(treeId, treeNode) {
            className = (className === "dark" ? "":"dark");
            var zTree = $.fn.zTree.getZTreeObj("tree");
            zTree.selectNode(treeNode);
            return confirm("确认删除 节点 -- " + treeNode.name + "以及其它子节点 吗？");
        }
        function onRemove(e, treeId, treeNode) {
        	$.ajax({
                url: "type/del/" + treeNode.id,
                type:"GET",
                error : function(data) {
                    alert("删除失败");
                    console.log(data);
                },
                success : function(data) {
                    console.log(data);
                }
            });
            return false;
        }
        function beforeRename(treeId, treeNode, newName, isCancel) {
            className = (className === "dark" ? "":"dark");
            
            if (newName.length == 0) {
                setTimeout(function() {
                    var zTree = $.fn.zTree.getZTreeObj("tree");
                    zTree.cancelEditName();
                    alert("节点名称不能为空.");
                }, 0);
                return false;
            }
            return true;
        }
        function onRename(e, treeId, treeNode, isCancel) {
            $.ajax({
                    url: "type/updateById",
                    type:"POST",
                    data:{
                        typeId:treeNode.id,
                        name:treeNode.name,
                        parentId:treeNode.pId
                    },
                    error : function(data) {
                        alert("修改失败");
                        console.log(data);
                    },
                    success : function(data) {
                        console.log(data);
                    }
                });
            return false;
        }
        function showRemoveBtn(treeId, treeNode) {
            return true;
        }
        function showRenameBtn(treeId, treeNode) {
            return true;
        }

        var newCount = 1;
        function addHoverDom(treeId, treeNode) {
            var sObj = $("#" + treeNode.tId + "_span");
            if (treeNode.editNameFlag || $("#addBtn_"+treeNode.tId).length>0) return;
            var addStr = "<span class='button add' id='addBtn_" + treeNode.tId
                + "' title='add node' onfocus='this.blur();'></span>";
            sObj.after(addStr);
            var btn = $("#addBtn_"+treeNode.tId);
            if (btn) btn.bind("click", function(){
                var zTree = $.fn.zTree.getZTreeObj("tree");
                zTree.addNodes(treeNode, {id:(100 + newCount), pId:treeNode.id, name:"new node" + (newCount++)});
                $.ajax({
                    url: "type/insert",
                    type:"POST",
                    data:{
                        name:"new node",
                        parentId:treeNode.id
                    },
                    error : function(data) {
                        alert("新增失败");
                        console.log(data);
                    },
                    success : function(data) {
                        console.log(data);
                    }
                });
                return false;
            });
        };
        function removeHoverDom(treeId, treeNode) {
            $("#addBtn_"+treeNode.tId).unbind().remove();
        };
        function selectAll() {
            var zTree = $.fn.zTree.getZTreeObj("tree");
            zTree.setting.edit.editNameSelectAll =  $("#selectAll").attr("checked");
        }

        /*添加顶级分类*/
        function addRoot(){
            var treeObj = $.fn.zTree.getZTreeObj("tree");
            var nodeName = $("#nodeName").val();
            var newNode = {name:nodeName};
            $.ajax({
                    url: "type/insert",
                    type:"POST",
                    data:{
                        name:nodeName
                    },
                    error : function(data) {
                        alert("新增失败");
                        console.log(data);
                    },
                    success : function(data) {
                        console.log(data);
                    }
                });
            newNode = treeObj.addNodes(null, newNode);
            $("#nodeName").val('');
        }


		$(document).ready(function() {
			$.ajax({
				url : 'type/typeIteration',
				type : 'GET',
				error : function(data) {
					console.log(data);
				},
				success : function(data) {
					zNodes = data;
					$.fn.zTree.init($("#tree"), setting, zNodes);
                    $("#selectAll").bind("click", selectAll);
				}
			});

		});