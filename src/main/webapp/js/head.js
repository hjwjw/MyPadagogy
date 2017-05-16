
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
        var a=$("#mymenu").children();
        for(var i=0;i<a.length;i++){
            $(a[i]).on('click',function(){
               $(this).children('ul').remove();
                    var parentId = $(this).children()[0].dataset.value;
                        var subType = queryByparent(parentId);
                        
                            var str = '';
                        for (var i = 0; i < subType.length; i++) {
                            str += '<li id="subli"><a href="type/queryByType/'+subType[i].typeId+'" data-value="'
                                    + subType[i].typeId
                                    + '"><span class="glyphicon glyphicon-asterisk"></span>'
                                    + subType[i].name
                                    + '</a></li>';
                        }         
                        $(this).append(
                                '<ul class="dropdown-menu" role="menu" id="menuSub">'
                                        + str + '</ul>');
                        console.log(subType);
                $("#subli").on('mouseover',function(){
        console.log('11111111111111111111111111111111')
            var parentId = $(this).children()[0].dataset.value;
        console.log("parentId");
        console.log(parentId);
        var subType = queryByparent(parentId);
                           if(flag){
                             var str = '';
                        for (var i = 0; i < subType.length; i++) {
                            str += '<li id="subsubli"><a href="type/queryByType/'+subType[i].typeId+'" data-value="'
                                    + subType[i].typeId
                                    + '"><span class="glyphicon glyphicon-asterisk"></span>'
                                    + subType[i].name
                                    + '</a></li>';
                        }
                        $(this).after(str);
                        console.log(subType);
                        flag=false;
                           }            
                    });
            var flag=true;
                        
            })
        }
        
   $("#mymenu")
            .on(
                    'mouseleave',
                    '>li',
                    function() {
                        $("#menuSub").remove().delay(1000);
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
