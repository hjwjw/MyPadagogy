var Article = React.createClass({
	getInitialState:function(){
		return {
			dataState:false,
			data:[]
		};
	},
	componentDidMount:function(){
		$.ajax({
			url:"appItemRest/queryById/",
			data:{
				id:<%=request.getParameter("id")%>
			}
			type:"GET",
			success:function(result){
				console.log(result);
			},
			erroe:function(){
				console.log("出错");
			}
		});
	},
	render:function(){
		return(
				<span>进来</span>
			);
	}
});


ReactDOM.render(<Article />,document.getElementById("main-content"));