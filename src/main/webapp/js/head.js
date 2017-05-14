
window.typeList = [];

$(document)
		.ready(
				function() {

	var rootType = queryByparent(0);

	if (rootType.length != 0) {
		for (var i = 0; i < rootType.length; i++) {
			$("#mymenu")
					.append(
							"<li class='dropdown' ><a href='javascript:void(0)' class='dropdown-toggle' data-toggle='dropdown' data-value="
									+ rootType[i].typeId
									+ ">"
									+ rootType[i].name
									+ "<span class='fa fa-arrow-down'></span></a></li>");
		}
	}

	$("#mymenu")
			.on(
					'mouseover',
					'li',
					function() {
						var parentId = $(this).children()[0].dataset.value;
						var subType = queryByparent(parentId);
						var str = '';
						for (var i = 0; i < subType.length; i++) {
							str += '<li><a href="type/queryByType/'+subType[i].typeId+'" data-value="'
									+ subType[i].typeId
									+ '"><span class="glyphicon glyphicon-asterisk"></span>'
									+ subType[i].name
									+ '</a></li>';
						}
						$(this).append(
								'<ul class="dropdown-menu" role="menu" id="menuSub">'
										+ str + '</ul>');
						console.log(subType);
					});

    $("#mymenu")
            .on(
                    'mouseout',
                    '>li:first',
                    function() {
                        $("#menuSub").remove();
                    });


				});

function queryByparent(parentId) {
	var s = [];
	$.ajax({
		url : 'appTypeRest/queryParentId',
		data : {
			parentId : parentId
		},
		async : false,
		type : 'GET',
		success : function(result) {
			s = result;
		},
		error : function(result) {
			console.error("出错了");
		}
	});
	return s;
}
