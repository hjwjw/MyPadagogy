/*
Demo codes for https://github.com/newghost/bootstrap-jquery-plugin
*/



//tree
(function() {

  window.treeDataArr = [
      {
          id:         "android"
        , text:       "Android"
        , attr: { yourfield: "your value" }
        , nodes: [
              {
                  id:         "tool"
                , text:       "Tool"
                , href:       "http://www.baidu.com", 
              }
            , {
                  id:         "users"
                , text:       "Users"
                , active:      false
                , nodes:   [
                      {text: "Kris"}
                    , {text: "Tom"}
                    , {text: "Jerry"}
                    , {text: "Dna"}
                  ]
              }
          ]

      }
    , {
          id:         "ios"
        , text:       "IOS"
        , attr: { yourfield: "your value" }
        , nodes: [
              {
                  id:         "tool"
                , text:       "Tool"
              }
            , {
                  id:         "users"
                , text:       "Users"
                , active:      false
                , nodes:   [
                      {text: "Kris"}
                    , {text: "Tom"}
                    , {text: "Jerry"}
                    , {text: "Dna"}
                  ]
              }
          ]

      }
    , {
          id:         "admin"
        , text:       "Admin"

      }
  ];

  $('#folder').tree({data: treeDataArr});

})();