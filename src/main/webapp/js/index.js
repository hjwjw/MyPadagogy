
var ArticleData = React.createClass({
  getInitialState: function() {
    return {
        pageNum:1,
        pageSize:6,
        dataState:false,
        page:[],
        data:[]
    };
  },
  handlePage:function(event){
    console.log(this);
    this.setState({
        pageNum:event.target.value
    });
    event.stopPropagation();//停止向上冒泡
    event.preventDefault(); //阻止事件默认行为
    {this.changeData(event.target.value)}
  },
  changeData:function(pageNum){
    var that =this;
        $.ajax({
        url:'appItemRest/queryAll',
        data:{
            pageNum:pageNum,
            pageSize:that.state.pageSize
        },
        type:'GET',
        success:function(result){
            console.info("result");
            console.info(result);
            that.setState({
                dataState:true,
                page:result,
                data:result.list,
            });
        },
        error:function(result){
            console.error("出错了")
        }
        });
  },
  componentDidMount: function() {
    {this.changeData(this.state.pageNum)}
  },
  render: function() {
    var pageInfo = this.state.page;
    console.log("pageInfo");
    console.log(pageInfo);
    var art = this.state.data.map(function(appItem){
        return(
            <article>
                <div className ='art-header'>
                    <ArtTitle href={appItem.appId} name={appItem.name} />
                    <ArtInfo userName={appItem.userName} createTime={appItem.createtime}
                     count={appItem.count} dislike={appItem.dislike} support={appItem.support} />
                </div>
                <ArtContent logo={appItem.logo} donwLink={appItem.downLink} introduce={appItem.introduce}/>
                <hr />
            </article>
            );
    });
    return (
      <div id='main-content'>
          {art}
          
          {this.state.dataState ? <PageNum navigatepageNums = {pageInfo.navigatepageNums} 
                    firstPage ='1' lastPage = {pageInfo.pages} 
                    isFirstPage = {pageInfo.isFirstPage} isLastPage = {pageInfo.isLastPage} 
                    handlePage = {this.handlePage} /> :""}
      </div>
    );
  }
});


    var ArtTitle = React.createClass({
        render:function(){
            return(
                <a href={"appItem/select/" + this.props.href}><h2>{this.props.name}</h2></a>
            );
        }
        
    });

    var ArtInfo = React.createClass({
        render:function(){
            return(
                <div className='info'>
                   <span > By {this.props.userName} -- <i>浏览量：：{this.props.count} 人  </i></span>
                </div>
                );
         }
    });

    var ArtContent = React.createClass({
        render:function(){
            var that = this;
            var s = this.props.introduce;
            s=s.substr(0,200);
            return(
                <div className='art-content'>
                    <img src={this.props.logo} />

                    <div dangerouslySetInnerHTML={{__html: s}} />
                    <br /><br />
    				<a href={this.props.donwLink} className="btn btn-skin "><i className="fa-shopping-bag"></i> <span>下载链接</span></a>
                </div>
            );
        } 
    });

    var PageNum = React.createClass({
        render:function(){
            console.log("handlePage");
            console.log(this.props.handlePage);
            
            var that = this;
            var liTemp = that.props.navigatepageNums.map(function(num){
                return(
                        <li><a href="javascript:void(0)"  onClick={that.props.handlePage} value={num}>{num}</a></li>
                    );
            });
            return(
                <center>
                    <ul className="pagination">
                        <li>
                          <a href="javascript:void(0)" aria-label="Previous" onClick={that.props.handlePage} value={this.props.firstPage}>
                            <span aria-hidden="true">&laquo;</span>
                          </a>
                        </li>
                        {liTemp}
                        <li>
                          <a href="javascript:void(0)" aria-label="Next" onClick={that.props.handlePage} value={this.props.lastPage}>
                            <span aria-hidden="true">&raquo;</span>
                          </a>
                        </li>
                    </ul>
                </center>
                );
        }

    });


    var Keyword = React.createClass({
        getInitialState:function(){
            return({
                dataState:false,
                keyword:[]
            });
        },
        componentDidMount:function(){
            var that = this;
            $.ajax({
                url:'keywordRest/queryAll',
                type:'GET',
                success:function(result){
                    that.setState({
                        dataState:true,
                        keyword:result
                    });
                }
            });
        },
        render:function(){
            console.log("这是标签");
            console.log(this.state.keyword);
            var keywords = this.state.keyword;
            var keywordList = keywords.map(function(k){
                return(
                    <li><a href="#" value={k.keyId} alt={k.description}>{k.name}</a></li>
                    );
            });
            return(
                <ul>
                    {keywordList}
                </ul>
                );
        }
    });


ReactDOM.render(
  <ArticleData />,
  document.getElementById('main-container')
);


