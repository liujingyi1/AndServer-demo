$(document).ready(function(){

      var

      $.get("/user/login",
      {
        account:name,
        password:password
      },
      function(data,status){
        alert("Data: " + data + "\nStatus: " + status);
      });

  $("#submit").click(function(){

      var name = $("#input_account").val();
      var password = $("#input_password").val();

      if (name == '') {
        alert("name");
      }

        if (password == '' || password == undefined || password == null) {
          alert("password");
        }

      $.get("/user/login",
      {
        account:name,
        password:password
      },
      function(data,status){
        alert("Data: " + data + "\nStatus: " + status);
      });

      return false;
  });



});