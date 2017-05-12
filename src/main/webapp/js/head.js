  	

var TypeData = React.createClass({
	componentDidMount:function(){
		$.ajax({
        url:'appTypeRest/queryAll',
        type:'GET',
        success:function(result){
            console.info("appTypeRest");
            console.info(result);
        },
        error:function(result){
            console.error("出错了");
        }
        });
	},
	render:function(){
		return(
				<span>这里</span>
			);
	}
});    	

var QueryParentId = React.createClass({
	getInitialState: function() {
    return {
    	parentId:this.props.parentId,
        dataState:false,
        subState:false,
        data:[],
        subdata:[]
    	};
  	},
	componentWillMount:function(){
		var that =this;
		$.ajax({
        url:'appTypeRest/queryParentId',
        data:{
        	parentId:this.props.parentId
        },
        type:'GET',
        success:function(result){
            console.info("TypeParent");
            console.info(result);
            that.setState({
            	data:result
            });
        },
        error:function(result){
            console.error("出错了");
        }
        });
	},
    getsubData:function(type){
        var that =this;
        console.log("here");
        console.log(type);
        $.ajax({
        url:'appTypeRest/queryParentId',
        data:{
            parentId:type.typeId
        },
        type:'GET',
        success:function(result){
            console.info("TypeParent");
            console.info(result);
            that.setState({
                subState:true,
                subdata:result
            });
        },
        error:function(result){
            console.error("出错了");
        }
        });
    },
	render:function(){
        var that = this;
        var typeList = this.state.data.map(function(type){
        return(
            <li className="dropdown">
              <a href="javascript:void(0)" className="dropdown-toggle" data-toggle="dropdown" onMouseOver={that.getsubData.bind(type,type)} >{type.name}<span className="fa fa-arrow-down"></span></a>
              <ul className="dropdown-menu" role="menu">
                <li>{that.state.subdata}</li>
              </ul>
            </li>
            );
        });
		return(
            <span>
			<ul className="nav navbar-nav">
                {typeList}
            </ul>
            <NavRight />
            </span>
			);
	}
});

var NavRight = React.createClass({
    render:function(){
        return(
              <ul className="nav navbar-nav navbar-right">
                <li><a href="index.jsp"><span className="fa fa-home"></span> Home</a></li>
                <li><a href="login.html"><span className="fa fa-user"></span> Login</a></li>
              </ul>
            );
    }
});
ReactDOM.render(
	<QueryParentId parentId="0" />,
	document.getElementById("bs-example-navbar-collapse-1"));    